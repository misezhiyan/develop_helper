package media.pic.recognize.service.impl.removenoise;

import media.pic.recognize.service.RemoveNoise;
import media.pic.recognize.service.impl.convolution.entity.ConvoWindowEntity;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @description: 中值滤波去噪
 * @author: liyq
 * @createtime: 2023-03-28 19:06
 */
public class RmoveNoiseMedian implements RemoveNoise {

    @Override
    public int[][] removeNoise(int[][] square) {

        int radius = 1;
        int[][] dst = new int[square.length][square[0].length];
        for (int x = 0; x < square.length; x++) {
            for (int y = 0; y < square[x].length; y++) {
                if (x - radius < 0 || y - radius < 0 || x + radius >= dst.length || y + radius >= dst[y].length) {
                    dst[x][y] = square[x][y];
                    continue;
                }
                // 获取窗口
                int[][] medianWindow = getMedianWindow(radius);
                // 窗口取模
                for (int i = 0; i < medianWindow.length; i++) {
                    for (int j = 0; j < medianWindow[0].length; j++) {
                        int realX = x - radius + i;
                        int realY = y - radius + j;
                        medianWindow[i][j] = square[realX][realY];
                    }
                }
                dst[x][y] = getMedianPoint(medianWindow);
            }
        }

        return dst;
    }

    /**
     * @description: 取中值
     * @author: liyq
     * @createtime: 2023-03-30 10:58:02
     * @param: medianWindow
     * @return int
     */
    private int getMedianPoint(int[][] medianWindow) {
        int[] arr = new int[medianWindow.length * medianWindow.length];
        int index = 0;
        for (int i = 0; i < medianWindow.length; i++)
            for (int j = 0; j < medianWindow[i].length; j++)
                arr[index++] = medianWindow[i][j];
        Arrays.sort(arr);
        return arr[arr.length >> 1];
    }

    /**
     * @description: 中值滤波取模窗口
     * @author: liyq
     * @createtime: 2023-03-30 10:57:47
     * @param: radius
     * @return int[][]
     */
    private int[][] getMedianWindow(int radius) {
        int winLength = (radius << 1) | 1;
        return new int[winLength][winLength];
    }

}
