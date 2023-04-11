package media.pic.recognize.train.mapper;

import java.util.List;
import media.pic.recognize.train.entity.PicRecognizeStep;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 
 * @author kimmy
 * @date ${date}
 */
@Mapper
public interface PicRecognizeStepMapper {

	List<PicRecognizeStep> list(PicRecognizeStep picRecognizeStep);

	int insert(PicRecognizeStep picRecognizeStep);

	int updateById(PicRecognizeStep picRecognizeStep);

	PicRecognizeStep selectById(Integer id);

	int delById(Integer id);

	int delByLogId(Integer id);
}
