package media.pic.recognize.train.controller.domain.response;

import media.pic.recognize.train.controller.domain.BaseResponse;
import media.pic.recognize.train.entity.PicRecognizeLog;
import media.pic.recognize.train.enums.ResMsg;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogListResponse extends BaseResponse {

    private List<PicRecognizeLog> list;

    public List<PicRecognizeLog> getList() {
        return list;
    }

    public void setList(List<PicRecognizeLog> list) {
        this.list = list;
    }

    public static LogListResponse success(List<PicRecognizeLog> list) {
        LogListResponse response = response(ResMsg.SUCCESS);
        response.setList(list);
        return response;
    }

    public static LogListResponse success() {
        return response(ResMsg.SUCCESS);
    }

    public static LogListResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static LogListResponse response(ResMsg resMsg) {
        LogListResponse response = new LogListResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
