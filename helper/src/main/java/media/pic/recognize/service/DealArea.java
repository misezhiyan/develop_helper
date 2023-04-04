package media.pic.recognize.service;

/**
 * @description: 处理区域抽取
 * @author: liyq
 * @createtime: 2023-03-30 13:11:29
 */
public interface DealArea {

    /**
     * @description: 根据特征抽取处理区域
     * @author: liyq
     * @createtime: 2023-03-30 13:17:55
     * @param: square
     * @return int[][]
     */
    int[][] dealAreaByFreature(int[][] square);
}
