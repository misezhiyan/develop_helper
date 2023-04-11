package media.pic.recognize.train.service.impl;

import media.pic.recognize.service.*;
import media.pic.recognize.service.impl.cut.CutGrid;
import media.pic.recognize.service.impl.dealarea.DealAreaCarCard;
import media.pic.recognize.service.impl.grayscal.GrayScalAVG;
import media.pic.recognize.service.impl.polarization.BinaryzationBW;
import media.pic.recognize.service.impl.rectify.PerspectiveRectify;
import media.pic.recognize.service.impl.removenoise.RmoveNoiseMedian;
import media.pic.recognize.service.impl.zoom.ZoomSquare;
import media.pic.recognize.train.controller.domain.response.LogDelResponse;
import media.pic.recognize.train.controller.domain.response.RecognizeResponse;
import media.pic.recognize.train.entity.*;
import media.pic.recognize.train.mapper.*;
import media.pic.recognize.train.service.PicRecognizeLogService;
import media.pic.util.PicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import util.FileUtil;
import util.PathUtil;
import util.StringUtil;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @discription 图片识别记录
 * @author kimmy
 * @date ${date}
 */
@Service
public class PicRecognizeLogServiceImpl implements PicRecognizeLogService {

    @Autowired
    PicRecognizeLogMapper picRecognizeLogMapper;
    @Autowired
    PicRecognizeStepMapper picRecognizeStepMapper;
    @Autowired
    PicRecognizeStepPicMapper picRecognizeStepPicMapper;
    @Autowired
    PicRecognizeFeatureCharMapper picRecognizeFeatureCharMapper;
    @Autowired
    PicRecognizeFeatureLogMapper picRecognizeFeatureLogMapper;

    @Override
    public List<PicRecognizeLog> list() {
        List<PicRecognizeLog> list = picRecognizeLogMapper.list(null);
        return list;
    }

    @Override
    public RecognizeResponse recognize(MultipartFile file) {

        File crecognizePackage = new File("helper/src/main/resources/static/picrecognize");
        String basePath = crecognizePackage.getAbsolutePath();
        String fileName = file.getOriginalFilename();

        // 1.记录日志
        String sourcePath = PathUtil.combineLinePath(basePath, "source");
        PicRecognizeLog picRecognizeLog = new PicRecognizeLog();
        byte[] bytes;
        try {
            bytes = file.getBytes();
            FileUtil.writeIntoFileByPath(PathUtil.filePath(fileName, sourcePath), bytes);
            picRecognizeLog.setPicName(fileName);
            picRecognizeLog.setPicUrl(PathUtil.filePath(fileName, sourcePath));
            picRecognizeLog.setPicRecog(false);
            picRecognizeLogMapper.insert(picRecognizeLog);
        } catch (Exception e) {
            e.printStackTrace();
            return RecognizeResponse.fail("识别记录异常");
        }

        try {
            // 灰度处理
            GrayScal grayScal = new GrayScalAVG();

            // 去噪
            // RemoveNoise removeNoise = new RmoveNoiseGaosi();
            RemoveNoise removeNoise = new RmoveNoiseMedian();
            // 二值化
            Binaryzation binaryzation = new BinaryzationBW();
            // 纠偏
            Rectify rectify = new PerspectiveRectify();
            // 特征匹配，提取操作区域
            DealArea dealArea = new DealAreaCarCard();
            // 切割字符
            Cut cut = new CutGrid();
            // 缩放
            Zoom zoom = new ZoomSquare();
            // 根据特征点匹配结果
            // FeatureResult zoom = new ZoomSquare();

            // rgb矩阵
            int[][] sourceRgbSquare = PicUtil.toRgbSquare(bytes);

            // 灰度处理
            int[][] grayScalSquare = grayScal.grayScal(sourceRgbSquare);
            logStep(picRecognizeLog, PathUtil.combineLinePath(basePath, "gray"), "灰度", grayScalSquare);

            // 去噪
            int[][] disnoizeSquare = removeNoise.removeNoise(grayScalSquare);
            logStep(picRecognizeLog, PathUtil.combineLinePath(basePath, "disnoize"), "去噪", disnoizeSquare);

            // 二值化
            // int threshold = 255 / 2;
            int threshold = 100;
            int[][] colorToBWSquare = binaryzation.binaryzation(disnoizeSquare, threshold);
            logStep(picRecognizeLog, PathUtil.combineLinePath(basePath, "BW"), "二值化", colorToBWSquare);

            // 取盘
            int[][] dealAreaSquare = dealArea.dealAreaByFreature(colorToBWSquare);
            logStep(picRecognizeLog, PathUtil.combineLinePath(basePath, "deal"), "取盘", dealAreaSquare);

            // 纠偏
            // int[][] perspectiveBSquare = rectify.rectify(disnoizeSquare);
            // PicUtil.saveRgbToFile(perspectiveBSquare, outFileName);

            // 切割
            int[][][] cutSquares = cut.cut(dealAreaSquare);
            logStep(picRecognizeLog, PathUtil.combineLinePath(basePath, "cut"), "切割", cutSquares);

            String result = Arrays.stream(cutSquares).map(cutSquare -> {
                // 缩放
                int[][] zoomSquare = zoom.zoom(cutSquare);
                try {
                    logStep(picRecognizeLog, PathUtil.combineLinePath(basePath, "zoom"), "缩放", zoomSquare);
                } catch (IOException e) {
                    System.out.println("缩放异常");
                    e.printStackTrace();
                }

                String recognizeResult = matchRecognize(zoomSquare);
                return StringUtil.isEmpty(recognizeResult) ? "" : recognizeResult;
            }).collect(Collectors.joining());

            return RecognizeResponse.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            return RecognizeResponse.fail("识别异常");
        }
    }

    /**
     * @description: 匹配识别结果
     * @author: liyq
     * @createtime: 2023-04-11 17:09:41
     * @param: square
     */
    private String matchRecognize(int[][] square) {

        int length = square.length;

        String feature = Arrays.stream(square).map(row -> {
            return Arrays.stream(row).mapToObj(field -> {
                return field == 0 ? "0" : "1";
            }).collect(Collectors.joining());
        }).collect(Collectors.joining());

        PicRecognizeFeatureChar picRecognizeFeatureChar = picRecognizeFeatureCharMapper.selectByFeature(feature);
        if (null == picRecognizeFeatureChar) {
            PicRecognizeFeatureLog picRecognizeFeatureLog = picRecognizeFeatureLogMapper.selectByFeature(feature);
            if (null == picRecognizeFeatureLog) {
                picRecognizeFeatureLog = new PicRecognizeFeatureLog();
                picRecognizeFeatureLog.setFeature(feature);
                picRecognizeFeatureLog.setFeatureSize(length);
                picRecognizeFeatureLogMapper.insert(picRecognizeFeatureLog);
            }
            return null;
        }

        return picRecognizeFeatureChar.getCharac();
    }

    /**
     * @description: 记录识别步骤
     * @author: liyq
     * @createtime: 2023-04-11 16:08:51
     * @param: grayScalSquare
     * @param: picRecognizeLog
     * @param: grayScal
     * @param: 灰度
     *
     */
    private void logStep(PicRecognizeLog picRecognizeLog, String packagePath, String stepName, int[][]... squares) throws IOException {

        PicRecognizeStep picRecognizeStep = new PicRecognizeStep();
        picRecognizeStep.setStepName(stepName);
        picRecognizeStep.setPicRecognizeLogId(picRecognizeLog.getId());
        picRecognizeStepMapper.insert(picRecognizeStep);

        String fileName = FileUtil.fileNameNoSuffix(picRecognizeLog.getPicName());
        String fileSuffix = FileUtil.fileSuffix(picRecognizeLog.getPicName());

        for (int i = 0; i < squares.length; i++) {
            String picPath = PathUtil.filePath(fileName + i + PathUtil.PATH_POINT_SPLIT + fileSuffix, packagePath);
            try {
                PicUtil.saveRgbToFile(squares[i], picPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PicRecognizeStepPic picRecognizeStepPic = new PicRecognizeStepPic();
            picRecognizeStepPic.setPicRecognizeStepId(picRecognizeStep.getId());
            picRecognizeStepPic.setPicUrl(picPath);
            picRecognizeStepPicMapper.insert(picRecognizeStepPic);
        }
    }

    @Override
    public LogDelResponse delLog(Integer id) {

        PicRecognizeLog picRecognizeLog = picRecognizeLogMapper.selectById(id);
        if (null != picRecognizeLog) {
            picRecognizeLogMapper.delById(id);
            File file = new File(picRecognizeLog.getPicUrl());
            file.delete();

            PicRecognizeStep picRecognizeStep = new PicRecognizeStep();
            List<PicRecognizeStep> stepList = picRecognizeStepMapper.list(picRecognizeStep);

            stepList.forEach(step ->{
                PicRecognizeStepPic picRecognizeStepPic = new PicRecognizeStepPic();
                picRecognizeStepPic.setPicRecognizeStepId(step.getId());
                List<PicRecognizeStepPic> list = picRecognizeStepPicMapper.list(picRecognizeStepPic);
                list.forEach(stepPic -> {
                    File stepPicFile = new File(stepPic.getPicUrl());
                    stepPicFile.delete();
                });

                picRecognizeStepPicMapper.delByStepId(step.getId());
            });

            picRecognizeStepMapper.delByLogId(id);
        }

        return LogDelResponse.success();
    }
}
