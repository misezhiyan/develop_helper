package media.pic.recognize.service.impl.convolution;

import media.pic.recognize.service.Convolution;
import media.pic.recognize.service.impl.convolution.entity.ConvoWindowEntity;

import java.math.BigDecimal;

/**
 * @description: 卷积计算
 * @author: liyq
 * @createtime: 2023-03-28 20:24
 */
public class ConvolutionBlock implements Convolution {

    /**
     * @description: 卷积
     * @author: liyq
     * @createtime: 2023-03-28 20:29:42
     * @param: src
     * @param: juanjiWindow
     * @return int[][]
     */
    public int[][] convolution(int[][] src, ConvoWindowEntity convoWindow) {

        BigDecimal[][] convolutionWindow = convoWindow.getWindow();

        int windowRadius = convoWindow.getWindowRadius();

        int[][] dst = new int[src.length][src[0].length];

        for (int x = 0; x < src.length; x++) {
            for (int y = 0; y < src[x].length; y++) {

                if (x < windowRadius || y < windowRadius || x + windowRadius * 2 + 1 >= src.length || y + windowRadius * 2 + 1 >= src[x].length) {
                    dst[x][y] = src[x][y];
                    continue;
                }

                int pixel = src[x][y];
                int a = (pixel & 0xff000000) >> 24;

                BigDecimal rSum = new BigDecimal(0), gSum = new BigDecimal(0), bSum = new BigDecimal(0);
                for (int winY = 0; winY < convolutionWindow.length; winY++) {
                    for (int winX = 0; winX < convolutionWindow[winY].length; winX++) {

                        // 实际坐标
                        int realX = x - windowRadius + winX;
                        int realY = y - windowRadius + winY;

                        // 像素点
                        int pixelXY = src[realX][realY];
                        // 权重
                        BigDecimal quanzhong = convolutionWindow[winX][winY];

                        int rXY = (pixelXY & 0xff0000) >> 16;
                        int gXY = (pixelXY & 0xff00) >> 8;
                        int bXY = pixelXY & 0xff;

                        rSum = rSum.add(quanzhong.multiply(new BigDecimal(rXY)));
                        gSum = gSum.add(quanzhong.multiply(new BigDecimal(gXY)));
                        bSum = bSum.add(quanzhong.multiply(new BigDecimal(bXY)));
                    }
                }

                dst[x][y] = (a << 24) + (rSum.intValue() << 16) + (gSum.intValue() << 8) + (bSum.intValue());
            }
        }

        return dst;
    }

}
