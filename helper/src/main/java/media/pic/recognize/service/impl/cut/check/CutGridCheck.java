package media.pic.recognize.service.impl.cut.check;

import media.pic.recognize.PicRecognize;
import media.pic.recognize.service.Cut;
import media.pic.util.PicUtil;
import util.ArrayUtil;

import java.io.IOException;
import java.util.Arrays;

/**
 * @description: 栅格化切割验证结果
 * @author: liyq
 * @createtime: 2023-03-31 17:01:53
 */
public class CutGridCheck  {

    public int startX, endX;


    /**
     * @description: 判断X轴起始点
     * @author: liyq
     * @createtime: 2023-04-03 12:00:51
     * @param: square
     * @return CutGridCheck
     */
    public static CutGridCheck checkX(int[][] square) {
        boolean startX = false;
        int startXPoint = 0;
        int end = 0;
        for (int i = square.length - 1; i > 0; i--) {
            long count = Arrays.stream(square[i]).distinct().count();
            if (!startX && count == 2) {
                startXPoint = i;
                startX = true;
            }
            if (startX && count == 1) {
                end = i + 1;
                break;
            }
        }

        CutGridCheck check = new CutGridCheck();
        check.startX = end;
        check.endX = startXPoint;
        return check;
    }
}
