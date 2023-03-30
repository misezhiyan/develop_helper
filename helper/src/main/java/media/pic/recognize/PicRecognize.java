package media.pic.recognize;

import media.pic.recognize.service.*;
import media.pic.recognize.service.impl.grayscal.GrayScalAVG;
import media.pic.recognize.service.impl.removenoise.RmoveNoiseMedian;
import media.pic.util.PicUtil;
import media.pic.recognize.service.impl.polarization.BinaryzationBW;
import media.pic.recognize.service.impl.rectify.PerspectiveRectify;
import media.pic.recognize.service.impl.removenoise.RmoveNoiseGaosi;
import util.StringUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @description: TODO
 * @author: liyq
 * @createtime: 2023-03-27 19:19
 */
public class PicRecognize {

    static String fileName = "C:\\Users\\kimmy\\Desktop\\图像识别\\识别.jpg";
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

        // rgb矩阵
        int[][] sourceRgbSquare = PicUtil.toRgbSquare(fileName);
        PicUtil.saveRgbToFile(sourceRgbSquare, coverFile("原图"));

        // 灰度处理
        int[][] grayScalSquare = grayScal.grayScal(sourceRgbSquare);
        PicUtil.saveRgbToFile(grayScalSquare, coverFile("灰度"));

        // 去噪
        int[][] disnoizeSquare = removeNoise.removeNoise(grayScalSquare);
        PicUtil.saveRgbToFile(disnoizeSquare, coverFile("去噪"));
        System.exit(1);

        // 二值化
        int threshold = 255 / 2;
        int[][] colorToBWSquare = binaryzation.binaryzation(disnoizeSquare, threshold);

        // 取盘
        // int[][] dealAreaSquare = PicUtil.getDealArea(disnoizeSquare);
        // PicUtil.saveRgbToFile(dealAreaSquare, outFileName);

        // 纠偏
        int[][] perspectiveBSquare = rectify.rectify(disnoizeSquare);
        // PicUtil.saveRgbToFile(perspectiveBSquare, outFileName);

        // 图像边缘检测算法例举
        // 图像纠偏算法例举
        // 图像噪点处理例举
        // 图像分割算法例举

        // Hough 变换
        BorderCheck borderCheck = new BorderCheck();
        borderCheck.houghChange(colorToBWSquare);

    }

    private static String coverFile(String name) {
        return StringUtil.combine(outFileBaseDir, name, ".jpg");
    }

    private static String newSaveFile(String prefix) {
        return StringUtil.combine(outFileBaseDir, prefix + new SimpleDateFormat("yyyyMMddHHmmsss").format(Calendar.getInstance().getTime()), ".jpg");
    }

}
