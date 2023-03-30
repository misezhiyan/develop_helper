package media.pic.recognize.service.impl.rectify;

import media.pic.util.PicUtil;
import media.pic.recognize.service.Rectify;

/**
 * @description: 透视算法纠偏
 * @author: liyq
 * @createtime: 2023-03-28 19:20
 */
public class PerspectiveRectify implements Rectify {
    @Override
    public int[][] rectify(int[][] square) {
        return PicUtil.perspectiveToRectangle(square);
    }
}
