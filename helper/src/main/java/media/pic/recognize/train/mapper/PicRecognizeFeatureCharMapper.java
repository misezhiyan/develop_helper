package media.pic.recognize.train.mapper;

import java.util.List;
import media.pic.recognize.train.entity.PicRecognizeFeatureChar;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 图片识别，特征点与字符对应
 * @author kimmy
 * @date ${date}
 */
@Mapper
public interface PicRecognizeFeatureCharMapper {

	List<PicRecognizeFeatureChar> list(PicRecognizeFeatureChar picRecognizeFeatureChar);

	int insert(PicRecognizeFeatureChar picRecognizeFeatureChar);

	int updateById(PicRecognizeFeatureChar picRecognizeFeatureChar);

	PicRecognizeFeatureChar selectById(Integer id);

	int delById(Integer id);

	PicRecognizeFeatureChar selectByFeature(String feature);
}
