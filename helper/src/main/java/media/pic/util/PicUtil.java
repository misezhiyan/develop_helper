package media.pic.util;

import util.ArrayUtil;
import util.FileUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;

/**
 * @description: 图片工具
 * @author: liyq
 * @createtime: 2023-03-27 20:08
 */
public class PicUtil {

    /**
     * @description: rgb写入输出流
     * @author: liyq
     * @createtime: 2023-04-12 10:08:31
     * @param: square
     * @param: fileName
     */
    public static void saveRgbToOutPutStream(int[][] square, String fileName, OutputStream outputStream) throws IOException {
        String fileType = FileUtil.fileSuffix(fileName);
        BufferedImage image = new BufferedImage(square.length, square[0].length, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                image.setRGB(i, j, square[i][j]);
            }
        }
        ImageIO.write(image, fileType, outputStream);
        outputStream.flush();
    }

    /**
     * @description: 保存图片
     * @author: liyq
     * @createtime: 2023-03-27 20:49:27
     * @param: square
     * @param: fileName
     */
    public static void saveRgbToFile(int[][] square, String fileName) throws IOException {

        BufferedImage image = new BufferedImage(square.length, square[0].length, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                image.setRGB(i, j, square[i][j]);
            }
        }
        saveImgToFile(image, fileName);
    }

    /**
     * @description: 保存图片
     * @author: liyq
     * @createtime: 2023-03-28 15:38:03
     * @param: image
     * @param: outFileName
     */
    public static void saveImgToFile(BufferedImage image, String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        if (!file.exists())
            file.createNewFile();
        ImageIO.write(image, "jpg", file);
    }

    /**
     * @description: 图片转二维RGB数组
     * @author: liyq
     * @createtime: 2023-03-27 20:51:27
     * @param: fileName
     * @return int[][]
     */
    public static int[][] toRgbSquare(String fileName) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(fileName));
        int[][] square = new int[bufferedImage.getWidth()][bufferedImage.getHeight()];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                // System.out.println(bufferedImage.getRGB(i, j));
                square[i][j] = bufferedImage.getRGB(i, j);
            }
        }
        return square;
    }

    /**
     * @description: 图片转二维RGB数组
     * @author: liyq
     * @createtime: 2023-04-11 16:01:02
     * @param: bytes
     * @return int[][]
     */
    public static int[][] toRgbSquare(byte[] bytes) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));
        int[][] square = new int[bufferedImage.getWidth()][bufferedImage.getHeight()];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                // System.out.println(bufferedImage.getRGB(i, j));
                square[i][j] = bufferedImage.getRGB(i, j);
            }
        }
        return square;
    }

    /**
     * @description: 二值化
     * @author: liyq
     * @createtime: 2023-03-27 20:53:46
     * @param: sourceRgbSquare
     * @return int[][]
     */
    public static int[][] colorToBlack(int[][] sourceRgbSquare, int threshold) {

        int[][] colorToBSquare = new int[sourceRgbSquare.length][sourceRgbSquare[1].length];
        int rToB = 255 / 2;
        int gToB = 255 / 2;
        int bToB = 255 / 2;
        for (int i = 0; i < sourceRgbSquare.length; i++) {
            for (int j = 0; j < sourceRgbSquare[i].length; j++) {
                int rgb = sourceRgbSquare[i][j];
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                // colorToBSquare[i][j] = new Double(r * 0.3 + g * 0.59 + b * 0.11).intValue();
                int averag = (r + g + b) / 3;
                // int rgbT = averag << 16 | averag << 8 | averag;
                colorToBSquare[i][j] = averag > threshold ? (255 << 16 | 255 << 8 | 255) : 0;
            }
        }

        return colorToBSquare;
    }

    /**
     * @description: 处理区
     * @author: liyq
     * @createtime: 2023-03-28 16:51:11
     * @param: disnoizeSquare
     * @return int[][]
     */
    public static int[][] getDealArea(int[][] square) {
        return square;
    }

    /**
     * @description: 透视变换
     * @author: liyq
     * @createtime: 2023-03-28 16:56:02
     * @param: disnoizeSquare
     * @return int[][]
     */
    public static int[][] perspectiveToRectangle(int[][] square) {
        return square;
    }

    /**
     * @description: X轴切割
     * @author: liyq
     * @createtime: 2023-04-03 11:45:28
     * @param: square
     * @param: end
     * @param: startXPoint
     * @return int[][]
     */
    public static int[][] cutX(int[][] square, int start, int end) {

        return ArrayUtil.cutX(square, start, end);
    }

    /**
     * @description: 图片缩放
     * @author: liyq
     * @createtime: 2023-04-03 13:46:43
     * @param: squareZoom
     * @param: i
     * @param: i1
     * @return int[][]
     */
    public static int[][] zoom(int[][] square, int width, int height) {

        int[][] dst = new int[width][height];

        BigDecimal rateX = new BigDecimal(square.length).divide(new BigDecimal(width), 10, BigDecimal.ROUND_HALF_UP);
        BigDecimal rateY = new BigDecimal(square[0].length).divide(new BigDecimal(height), 10, BigDecimal.ROUND_HALF_UP);

        for (int i = 0; i < dst.length; i++) {
            for (int j = 0; j < dst[i].length; j++) {
                dst[i][j] = square[new BigDecimal(i).multiply(rateX).intValue()][new BigDecimal(j).multiply(rateY).intValue()];
            }
        }

        return dst;
    }

}
