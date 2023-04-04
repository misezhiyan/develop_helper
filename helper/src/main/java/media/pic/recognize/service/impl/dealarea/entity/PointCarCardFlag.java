package media.pic.recognize.service.impl.dealarea.entity;

import java.math.BigDecimal;

/**
 * 像素点
 */
public class PointCarCardFlag {

    String flag;
    int order;
    BigDecimal pointRateX, pointRateY;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public BigDecimal getPointRateX() {
        return pointRateX;
    }

    public void setPointRateX(BigDecimal pointRateX) {
        this.pointRateX = pointRateX;
    }

    public BigDecimal getPointRateY() {
        return pointRateY;
    }

    public void setPointRateY(BigDecimal pointRateY) {
        this.pointRateY = pointRateY;
    }

    public static PointCarCardFlag build(String flag, int order, BigDecimal pointRateX, BigDecimal pointRateY) {
        PointCarCardFlag carCardFlag = new PointCarCardFlag();
        carCardFlag.setFlag(flag);
        carCardFlag.setOrder(order);
        carCardFlag.setPointRateX(pointRateX);
        carCardFlag.setPointRateY(pointRateY);
        return carCardFlag;
    }
}
