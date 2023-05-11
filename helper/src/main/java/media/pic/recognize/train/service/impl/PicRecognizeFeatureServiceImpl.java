package media.pic.recognize.train.service.impl;

import media.pic.recognize.entity.Color;
import media.pic.recognize.service.*;
import media.pic.recognize.service.impl.cut.CutGrid;
import media.pic.recognize.service.impl.dealarea.DealAreaCarCard;
import media.pic.recognize.service.impl.grayscal.GrayScalAVG;
import media.pic.recognize.service.impl.polarization.BinaryzationBW;
import media.pic.recognize.service.impl.rectify.PerspectiveRectify;
import media.pic.recognize.service.impl.removenoise.RmoveNoiseMedian;
import media.pic.recognize.service.impl.zoom.ZoomSquare;
import media.pic.recognize.train.controller.domain.dto.FeatureLogDto;
import media.pic.recognize.train.controller.domain.request.FeatureListRequest;
import media.pic.recognize.train.controller.domain.request.FeatureLogDelRequest;
import media.pic.recognize.train.controller.domain.request.FeatureMatchRequest;
import media.pic.recognize.train.controller.domain.request.FeatureToPicRequest;
import media.pic.recognize.train.controller.domain.response.*;
import media.pic.recognize.train.entity.*;
import media.pic.recognize.train.mapper.*;
import media.pic.recognize.train.service.PicRecognizeFeatureService;
import media.pic.recognize.train.service.PicRecognizeLogService;
import media.pic.util.PicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import util.FileUtil;
import util.PathUtil;
import util.StringUtil;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @discription 特征点训练
 * @author kimmy
 * @date ${date}
 */
@Service
public class PicRecognizeFeatureServiceImpl implements PicRecognizeFeatureService {

    @Autowired
    PicRecognizeFeatureCharMapper picRecognizeFeatureCharMapper;
    @Autowired
    PicRecognizeFeatureLogMapper picRecognizeFeatureLogMapper;

    @Override
    public FeatureListResponse unmatchFeatureList(FeatureListRequest request) {
        List<PicRecognizeFeatureLog> list = picRecognizeFeatureLogMapper.list(request);
        List<FeatureLogDto> dtoList = list.stream().map(log -> new FeatureLogDto(log)).collect(Collectors.toList());
        return FeatureListResponse.success(dtoList);
    }

    @Override
    public FeatureMatchResponse matchFeature(FeatureMatchRequest request) {

        String feature = request.getFeature();
        PicRecognizeFeatureChar picRecognizeFeatureChar = picRecognizeFeatureCharMapper.selectByFeature(feature);
        if (null != picRecognizeFeatureChar) {
            return FeatureMatchResponse.fail("特征点已匹配，不能继续匹配");
        }

        PicRecognizeFeatureChar insert = new PicRecognizeFeatureChar();
        insert.setFeature(feature);
        insert.setFeatureSize(new Double(Math.pow(feature.length(), 2)).intValue());
        insert.setCharac(request.getCharc());
        picRecognizeFeatureCharMapper.insert(insert);

        picRecognizeFeatureLogMapper.delById(request.getId());

        return FeatureMatchResponse.success();
    }

    @Override
    public void featureToPic(String feature, Integer featureSize, HttpServletResponse response) {
        // String feature = request.getFeature();
        // Integer featureSize = request.getFeatureSize();

        int[][] square = new int[featureSize][featureSize];

        for (int i = 0; i < feature.toCharArray().length; i++) {
            if (String.valueOf(feature.toCharArray()[i]).equals("1")) {
                fillSquare(square, i, Color.white);
            }
        }

        try {
            PicUtil.saveRgbToOutPutStream(square, "临时图片.jpg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public FeatureLogDelResponse delLog(FeatureLogDelRequest request) {
        picRecognizeFeatureLogMapper.delById(request.getId());
        return FeatureLogDelResponse.success();
    }

    private void fillSquare(int[][] square, int i, int color) {
        int x = i / square.length;
        int y = i % square.length;
        square[x][y] = color;
    }

}
