package media.pic.recognize.train.controller.domain.request;

import lombok.Data;
import media.pic.recognize.train.entity.PicRecognizeFeatureLog;
import org.springframework.stereotype.Component;

@Component
@Data
public class FeatureMatchRequest extends PicRecognizeFeatureLog {

    private String charc;
}
