package media.pic.recognize.train.controller.domain.response;

import media.pic.recognize.train.controller.domain.BaseResponse;
import media.pic.recognize.train.enums.ResMsg;
import org.springframework.stereotype.Component;

@Component
public class RecognizeResponse extends BaseResponse {

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static RecognizeResponse success(String result) {
        RecognizeResponse response = response(ResMsg.SUCCESS);
        response.setResult(result);
        return response;
    }

    public static RecognizeResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static RecognizeResponse fail(String msg) {
        RecognizeResponse response = response(ResMsg.FAIL);
        response.setResMsg(msg);
        return response;
    }

    public static RecognizeResponse response(ResMsg resMsg) {
        RecognizeResponse response = new RecognizeResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
