package media.pic.recognize.train.controller.domain;

import org.springframework.stereotype.Component;

@Component
public class BaseResponse<T> {

    private String resCode = "0000";
    private String resMsg = "";

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
}
