package media.pic.recognize.service.impl.convolution.entity;

import util.MathUtil;

import java.math.BigDecimal;

/**
 * @description: 高斯卷积计算实体
 * @author: liyq
 * @createtime: 2023-03-28 20:34
 */
public class ConvoWindowGaosiEntity extends ConvoWindowEntity {

    BigDecimal σ;

    public ConvoWindowGaosiEntity(BigDecimal σ, int windowRadius) {
        super(windowRadius);
        this.σ = σ;
        BigDecimal sum = new BigDecimal(0);
        for (int y = 0; y < window.length; y++) {
            for (int x = 0; x < window[y].length; x++) {
                BigDecimal zhengtaifenbuDaoshu = MathUtil.zhengtaifenbuDaoshu(x - windowRadius, y - windowRadius, σ.doubleValue());
                window[x][y] = zhengtaifenbuDaoshu;

                sum = sum.add(zhengtaifenbuDaoshu);
            }
        }
        for (int y = 0; y < window.length; y++) {
            for (int x = 0; x < window[y].length; x++) {
                window[x][y] = window[x][y].divide(sum, 10, BigDecimal.ROUND_HALF_UP);
            }
        }
    }
}
