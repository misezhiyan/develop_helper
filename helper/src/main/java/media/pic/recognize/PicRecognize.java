package media.pic.recognize;

import media.pic.recognize.service.*;
import media.pic.recognize.service.impl.cut.CutGrid;
import media.pic.recognize.service.impl.dealarea.DealAreaCarCard;
import media.pic.recognize.service.impl.grayscal.GrayScalAVG;
import media.pic.recognize.service.impl.removenoise.RmoveNoiseMedian;
import media.pic.recognize.service.impl.zoom.ZoomSquare;
import media.pic.util.PicUtil;
import media.pic.recognize.service.impl.polarization.BinaryzationBW;
import media.pic.recognize.service.impl.rectify.PerspectiveRectify;
import util.StringUtil;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 * @description: TODO
 * @author: liyq
 * @createtime: 2023-03-27 19:19
 */
public class PicRecognize {

    static String fileName = "C:\\Users\\kimmy\\Desktop\\图像识别\\切割.jpg";
    // String outFileName = "C:\\Users\\kimmy\\Desktop\\图像识别\\识别\\" + new SimpleDateFormat("yyyyMMddHHmmsss").format(Calendar.getInstance().getTime()) + ".jpg";
    static String outFileBaseDir = "C:\\Users\\kimmy\\Desktop\\图像识别\\识别\\";

    public static void main(String[] args) throws IOException {

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
        int[][] sourceRgbSquare = PicUtil.toRgbSquare(fileName);

        // 灰度处理
        int[][] grayScalSquare = grayScal.grayScal(sourceRgbSquare);

        // 去噪
        int[][] disnoizeSquare = removeNoise.removeNoise(grayScalSquare);

        // 二值化
        // int threshold = 255 / 2;
        int threshold = 100;
        int[][] colorToBWSquare = binaryzation.binaryzation(disnoizeSquare, threshold);
        // saveAndOpen(colorToBWSquare, "二值化");

        // 取盘
        int[][] dealAreaSquare = dealArea.dealAreaByFreature(colorToBWSquare);
        // saveAndOpen(dealAreaSquare, "取盘");

        // 纠偏
        // int[][] perspectiveBSquare = rectify.rectify(disnoizeSquare);
        // PicUtil.saveRgbToFile(perspectiveBSquare, outFileName);

        // 切割
        int[][][] cutSquares = cut.cut(dealAreaSquare);
        // saveAndOpen(cutSquare, "切割");

        // 缩放
        Arrays.stream(cutSquares).forEach(cutSquare -> {
            int[][] zoomSquare = zoom.zoom(cutSquare);
            // saveAndOpen(zoomSquare, "缩放");

            // // 特征点提取入库，并训练
            // int[][] zoomSquare = zoom.zoom(zoomSquare);
            // saveAndOpen(zoomSquare, "缩放");

            // 图像边缘检测算法例举
            // 图像纠偏算法例举
            // 图像噪点处理例举
            // 图像分割算法例举

            // // Hough 变换
            // BorderCheck borderCheck = new BorderCheck();
            // borderCheck.houghChange(colorToBWSquare);
        });

    }

    public static void exit(int[][] square, String name) throws IOException {
        saveAndOpen(square, name);
        // Runtime.getRuntime().exec("explorer /select, \"" + coverFile(name) + "\"");
        System.exit(1);
    }

    public static void saveAndOpen(int[][] square, String name) throws IOException {
        PicUtil.saveRgbToFile(square, coverFile(name));
        Desktop.getDesktop().open(new File(coverFile(name)));
    }

    public static String coverFile(String name) {
        return StringUtil.combine(outFileBaseDir, name, ".jpg");
    }

    private static String newSaveFile(String prefix) {
        return StringUtil.combine(outFileBaseDir, prefix + new SimpleDateFormat("yyyyMMddHHmmsss").format(Calendar.getInstance().getTime()), ".jpg");
    }

}
