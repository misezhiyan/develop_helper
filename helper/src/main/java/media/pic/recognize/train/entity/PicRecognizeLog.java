package media.pic.recognize.train.entity;

import java.util.Date;

/**
 * @discription 图片识别记录
 * @author kimmy
 * @date ${date}
 */
public class PicRecognizeLog {

    private Integer id;
    private String picUrl;
    private String picName;
    private boolean picRecog;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public boolean getPicRecog() {
        return picRecog;
    }

    public void setPicRecog(boolean picRecog) {
        this.picRecog = picRecog;
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
