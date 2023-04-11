package media.pic.recognize.train.controller.domain.response;

import media.pic.recognize.train.controller.domain.BaseResponse;
import media.pic.recognize.train.entity.PicRecognizeLog;
import media.pic.recognize.train.enums.ResMsg;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogDelResponse extends BaseResponse {

    public static LogDelResponse success() {
        return response(ResMsg.SUCCESS);
    }

    public static LogDelResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static LogDelResponse response(ResMsg resMsg) {
        LogDelResponse response = new LogDelResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
