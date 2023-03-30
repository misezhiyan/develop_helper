package media.pic.recognize.service.impl.grayscal;

import media.pic.recognize.service.GrayScal;

/**
 * @description: 三原色平均值灰度处理
 * @author: liyq
 * @createtime: 2023-03-28 20:21
 */
public class GrayScalAVG implements GrayScal {

    @Override
    public int[][] grayScal(int[][] square) {

        int[][] graySquare = new int[square.length][square[0].length];

        for (int x = 0; x < square.length; x++) {
            for (int y = 0; y < square[x].length; y++) {

                int pixel = square[x][y];

                int a = pixel >> 24; // 符号位
                // int r = pixel >> 16 & 0xff;
                // int g = pixel >> 8 & 0xff;
                // int b = pixel & 0xff;
                // int rgb_average = (r + g + b) / 3;

                int rgb_average = (pixel >> 16 & 0xff + pixel >> 8 & 0xff + pixel & 0xff) / 3;

                graySquare[x][y] = a << 24 | rgb_average << 16 | rgb_average << 8 | rgb_average;
            }
        }

        return graySquare;
    }
}
