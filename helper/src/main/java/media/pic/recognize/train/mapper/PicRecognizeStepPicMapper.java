package media.pic.recognize.train.mapper;

import java.util.List;
import media.pic.recognize.train.entity.PicRecognizeStepPic;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 
 * @author kimmy
 * @date ${date}
 */
@Mapper
public interface PicRecognizeStepPicMapper {

	List<PicRecognizeStepPic> list(PicRecognizeStepPic picRecognizeStepPic);

	int insert(PicRecognizeStepPic picRecognizeStepPic);

	int updateById(PicRecognizeStepPic picRecognizeStepPic);

	PicRecognizeStepPic selectById(Integer id);

	int delById(Integer id);

	int delByStepId(Integer id);
}
