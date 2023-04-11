package media.pic.recognize.service.impl.cut;

import media.pic.recognize.PicRecognize;
import media.pic.recognize.entity.Color;
import media.pic.recognize.service.Cut;
import media.pic.recognize.service.impl.cut.check.CutGridCheck;
import media.pic.util.PicUtil;
import util.ArrayUtil;

import java.io.IOException;
import java.util.Arrays;

/**
 * @description: 栅格化切割
 * @author: liyq
 * @createtime: 2023-03-31 17:01:53
 */
public class CutGrid implements Cut {

    /**
     * @description:
     * @author: liyq
     * @createtime: 2023-03-31 17:00:55
     * @param: square
     * @return int[][]
     */
    @Override
    public int[][][] cut(int[][] square) {

        // 1、边缘切割
        int[][] outCircleSquare = outCircleCut(square);

        // 2、纵向切割到字符图片并分别保存
        return charCut(outCircleSquare);
    }

    private int[][][] charCut(int[][] square) {

        int[][][] result = new int[1][][];

        // 从右侧切第一个字符，字符宽度 +-5 作为下全局字符宽度设置判断

        // 判断左右边字符开始结束，并将字符切出来
        CutGridCheck checkX = CutGridCheck.checkX(square);

        // X轴切割
        int xCut[][] = PicUtil.cutX(square, checkX.startX, checkX.endX);

        // 转置
        int[][] xToY = ArrayUtil.rowToColumn(xCut);

        CutGridCheck checkY = CutGridCheck.checkX(xToY);

        // y轴切割
        int[][] dst = ArrayUtil.rowToColumn(PicUtil.cutX(xToY, checkY.startX, checkY.endX));

        // try {
        //     PicRecognize.saveAndOpen(dst, "first");
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        result[0] = dst;

        return result;
    }

    /**
     * @description: 外圈边缘切割
     * @author: liyq
     * @createtime: 2023-04-03 09:56:29
     * @param: square
     * @return int[][]
     */
    private int[][] outCircleCut(int[][] square) {

        // 1、上下边缘切割
        // 2、左右边缘切割
        // 3、右侧切割第一个字符作为栅格的长宽

        int left = 0;
        int right = 0;
        int top = 0;
        int down = 0;

        int width = square.length;
        int height = square[0].length;

        for (int i = 1; i < width; i++) {
            long count = Arrays.stream(square[i]).distinct().count();
            if (count == 2) {
                System.out.println(i + "：左侧线条切割到了字符");
                left = i - 1;
                break;
            }
        }
        for (int i = width - 1; i > 0; i--) {
            long count = Arrays.stream(square[i]).distinct().count();
            if (count == 2) {
                System.out.println(i + "：右侧线条切割到了字符");
                right = i + 1;
                break;
            }
        }

        int[][] rowToColumnSquare = ArrayUtil.rowToColumn(square);
        for (int i = 1; i < height; i++) {
            long count = Arrays.stream(rowToColumnSquare[i]).distinct().count();
            if (count == 2) {
                System.out.println(i + "：下方线条切割到了字符");
                down = i + 1;
                break;
            }
        }
        for (int i = height - 1; i > 0; i--) {
            long count = Arrays.stream(rowToColumnSquare[i]).distinct().count();
            if (count == 2) {
                System.out.println(i + "：上方线条切割到了字符");
                top = i - 1;
                break;
            }
        }

        int[][] dst = new int[right - left + 1][top - down + 1];
        for (int i = 0; i < dst.length; i++) {
            for (int j = 0; j < dst[i].length; j++) {
                dst[i][j] = square[i + left][j + down];
            }
        }

        return dst;
    }

}
