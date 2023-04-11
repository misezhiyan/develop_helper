package media.pic.recognize.train.entity;

import java.util.Date;

/**
 * @discription 
 * @author kimmy
 * @date ${date}
 */
public class PicRecognizeStep {

    private Integer id;
    private Integer picRecognizeLogId;
    private String stepName;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPicRecognizeLogId() {
        return picRecognizeLogId;
    }

    public void setPicRecognizeLogId(Integer picRecognizeLogId) {
        this.picRecognizeLogId = picRecognizeLogId;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
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
