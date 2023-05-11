package media.pic.recognize.train.mapper;

import java.util.List;
import media.pic.recognize.train.entity.PicRecognizeFeatureLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 图片识别，特征点与字符对应
 * @author kimmy
 * @date ${date}
 */
@Mapper
public interface PicRecognizeFeatureLogMapper {

	List<PicRecognizeFeatureLog> list(PicRecognizeFeatureLog picRecognizeFeatureLog);

	int insert(PicRecognizeFeatureLog picRecognizeFeatureLog);

	int updateById(PicRecognizeFeatureLog picRecognizeFeatureLog);

	PicRecognizeFeatureLog selectById(Integer id);

	int delById(Integer id);

	PicRecognizeFeatureLog selectByFeature(String feature);
}
