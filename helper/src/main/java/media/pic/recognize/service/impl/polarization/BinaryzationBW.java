package media.pic.recognize.service.impl.polarization;

import media.pic.util.PicUtil;
import media.pic.recognize.service.Binaryzation;

/**
 * @description: 黑白二值化
 * @author: liyq
 * @createtime: 2023-03-28 19:11
 */
public class BinaryzationBW implements Binaryzation {
    @Override
    public int[][] binaryzation(int[][] square, int threshold) {
        return PicUtil.colorToBlack(square, threshold);
    }
}
