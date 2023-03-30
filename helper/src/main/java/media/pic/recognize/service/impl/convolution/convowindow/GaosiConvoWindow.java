package media.pic.recognize.service.impl.convolution.convowindow;

import media.pic.recognize.service.ConvoWindow;
import media.pic.recognize.service.impl.convolution.entity.ConvoWindowEntity;
import media.pic.recognize.service.impl.convolution.entity.ConvoWindowGaosiEntity;

import java.math.BigDecimal;

/**
 * @description: 高斯窗口
 * @author: liyq
 * @createtime: 2023-03-28 20:33
 */
public class GaosiConvoWindow implements ConvoWindow {

    /**
     * @description: 高斯模糊矩阵
     * @author: liyq
     * @createtime: 2023-03-28 20:34:02
     * @param: windowRadius
     * @return BigDecimal[][]
     */
    public ConvoWindowGaosiEntity convoWindow(int windowRadius) {
        BigDecimal σ = new BigDecimal(1.5);
        return new ConvoWindowGaosiEntity(σ, windowRadius);
    }

}
