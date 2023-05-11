package media.pic.recognize.train.controller.domain.response;

import media.pic.recognize.train.controller.domain.BaseResponse;
import media.pic.recognize.train.enums.ResMsg;
import org.springframework.stereotype.Component;

@Component
public class FeatureLogDelResponse extends BaseResponse {

    public static FeatureLogDelResponse success() {
        FeatureLogDelResponse response = response(ResMsg.SUCCESS);
        return response;
    }

    public static FeatureLogDelResponse fail(String msg) {
        FeatureLogDelResponse response = response(ResMsg.FAIL);
        response.setResMsg(msg);
        return response;
    }

    public static FeatureLogDelResponse response(ResMsg resMsg) {
        FeatureLogDelResponse response = new FeatureLogDelResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
