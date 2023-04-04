package media.pic.recognize.service.impl.zoom;

import media.pic.recognize.service.Zoom;
import media.pic.util.PicUtil;

import java.math.BigDecimal;

/**
 * @description: 正方形缩放
 * @author: liyq
 * @createtime: 2023-04-03 13:09
 */
public class ZoomSquare implements Zoom {

    /**
     * @description: 图片缩放
     * @author: liyq
     * @createtime: 2023-04-03 13:13:54
     * @param: square
     * @return int[][]
     */
    @Override
    public int[][] zoom(int[][] square) {
        // 图片缩放
        int[][] zoom = PicUtil.zoom(square, 30, 30);

        System.out.println(zoom.length);
        System.out.println(zoom[0].length);

        return zoom;
    }
}
