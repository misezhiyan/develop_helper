package media.pic.recognize.service.impl.convolution.entity;

import util.MathUtil;

import java.math.BigDecimal;

/**
 * @description: 卷积计算实体
 * @author: liyq
 * @createtime: 2023-03-28 20:34
 */
public class ConvoWindowEntity {

    int windowLength;
    int windowRadius;
    BigDecimal[][] window;

    public ConvoWindowEntity() {

    }

    public ConvoWindowEntity(int windowRadius) {
        this.windowRadius = windowRadius;
        this.windowLength = windowRadius << 1 | 1;
        this.window = new BigDecimal[windowLength][windowLength];
    }

    public void setWindow(BigDecimal[][] window) {

        if ((window.length & 0xff) != 1 || window.length != window[0].length)
            throw new RuntimeException("窗口非标准卷积窗口");

        this.window = window;

        this.windowLength = window.length;
        this.windowRadius = this.windowLength >> 1;
    }

    public BigDecimal[][] getWindow() {
        return window;
    }

    public int getWindowRadius() {
        return windowRadius;
    }
}
