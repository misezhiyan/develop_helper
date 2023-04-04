package util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @description: 数组处理工具类
 * @author: liyq
 * @createtime: 2023-03-30 13:44:34
 */
public class ArrayUtil {

    public static int[][] rowToColumn(int[][] square) {
        int[][] result = new int[square[0].length][square.length];
        for (int i = 0; i < result.length; i++)
            for (int j = 0; j < result[i].length; j++)
                result[i][j] = square[j][i];

        return result;
    }

    /**
     * @description: X轴切割
     * @author: liyq
     * @createtime: 2023-04-03 11:48:13
     * @param: square
     * @param: start
     * @param: end
     * @return int[][]
     */
    public static int[][] cutX(int[][] square, int start, int end) {

        int dst[][] = new int[end - start][square[0].length];
        for (int i = 0; i < dst.length; i++) {
            for (int j = 0; j < dst[i].length; j++) {
                dst[i][j] = square[start + i][j];
            }
        }
        return dst;
    }
}
