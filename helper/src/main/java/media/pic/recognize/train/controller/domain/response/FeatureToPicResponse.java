package media.pic.recognize.train.controller.domain.response;

import media.pic.recognize.train.controller.domain.BaseResponse;
import media.pic.recognize.train.enums.ResMsg;
import org.springframework.stereotype.Component;

@Component
public class FeatureToPicResponse extends BaseResponse {

    public static FeatureToPicResponse success() {
        FeatureToPicResponse response = response(ResMsg.SUCCESS);
        return response;
    }

    public static FeatureToPicResponse fail(String msg) {
        FeatureToPicResponse response = response(ResMsg.FAIL);
        response.setResMsg(msg);
        return response;
    }

    public static FeatureToPicResponse response(ResMsg resMsg) {
        FeatureToPicResponse response = new FeatureToPicResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
