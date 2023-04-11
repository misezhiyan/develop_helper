package media.pic.recognize.train.entity;

import java.util.Date;

/**
 * @discription 图片识别，特征点与字符对应
 * @author kimmy
 * @date ${date}
 */
public class PicRecognizeFeatureChar {

    private Integer id;
    private String feature;
    private String charac;
    private Integer featureSize;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getCharac() {
        return charac;
    }

    public void setCharac(String charac) {
        this.charac = charac;
    }

    public Integer getFeatureSize() {
        return featureSize;
    }

    public void setFeatureSize(Integer featureSize) {
        this.featureSize = featureSize;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
