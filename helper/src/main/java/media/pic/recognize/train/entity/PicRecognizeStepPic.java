package media.pic.recognize.train.entity;

import java.util.Date;

/**
 * @discription 
 * @author kimmy
 * @date ${date}
 */
public class PicRecognizeStepPic {

    private Integer id;
    private Integer picRecognizeStepId;
    private String picUrl;
    private Boolean picRecog;
    private String recognizeResult;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPicRecognizeStepId() {
        return picRecognizeStepId;
    }

    public void setPicRecognizeStepId(Integer picRecognizeStepId) {
        this.picRecognizeStepId = picRecognizeStepId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Boolean getPicRecog() {
        return picRecog;
    }

    public void setPicRecog(Boolean picRecog) {
        this.picRecog = picRecog;
    }

    public String getRecognizeResult() {
        return recognizeResult;
    }

    public void setRecognizeResult(String recognizeResult) {
        this.recognizeResult = recognizeResult;
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
