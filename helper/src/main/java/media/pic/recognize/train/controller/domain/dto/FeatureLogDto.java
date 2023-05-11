package media.pic.recognize.train.controller.domain.dto;

import lombok.Data;
import media.pic.recognize.entity.Color;
import media.pic.recognize.train.entity.PicRecognizeFeatureLog;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @discription 图片识别，特征点与字符对应
 * @author kimmy
 * @date ${date}
 */
@Data
public class FeatureLogDto extends PicRecognizeFeatureLog {

    public FeatureLogDto(PicRecognizeFeatureLog log) {
        BeanUtils.copyProperties(log, this);

        // String feature = log.getFeature();
        // Double d = Math.pow(Double.parseDouble(String.valueOf(feature.length())), 2);
        // int squareLength = d.intValue();
        // int[][] square = new int[squareLength][squareLength];
        // for (int i = 0; i < feature.toCharArray().length; i++) {
        //     if (feature.toCharArray()[i] != 0)
        //         fillSquare(square, i, Color.white);
        // }
    }
}
