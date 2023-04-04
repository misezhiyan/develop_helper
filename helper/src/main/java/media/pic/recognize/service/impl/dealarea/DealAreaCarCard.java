package media.pic.recognize.service.impl.dealarea;

import media.pic.recognize.service.DealArea;
import media.pic.recognize.service.impl.dealarea.fature.FeaturePoint;

/**
 * @description: 车牌操作区域
 * @author: liyq
 * @createtime: 2023-03-30 13:13
 */
public class DealAreaCarCard implements DealArea {

    // 左下
    // row: 427/453  high: 363/453
    // 左上
    // row: 26/453  high: 363/1507
    // 中
    // row: 222/453  high: 468/1507
    // 右下
    // row: 24/453  high: 600 + 914/1507
    // 右上
    // row: 428/453  high: 600 + 914/1507

    /**
     * @description: 按照特征抽取操作区域
     * @author: liyq
     * @createtime: 2023-03-30 13:21:03
     * @param: square
     * @return int[][]
     */
    @Override
    public int[][] dealAreaByFreature(int[][] square) {

        int[][] featureArea = FeaturePoint.matchFeatureArea(square);

        return featureArea;
    }

}
