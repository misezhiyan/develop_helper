package media.pic.recognize.train.mapper;

import java.util.List;
import media.pic.recognize.train.entity.PicRecognizeLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 图片识别记录
 * @author kimmy
 * @date ${date}
 */
@Mapper
public interface PicRecognizeLogMapper {

	List<PicRecognizeLog> list(PicRecognizeLog picRecognizeLog);

	int insert(PicRecognizeLog picRecognizeLog);

	int updateById(PicRecognizeLog picRecognizeLog);

	PicRecognizeLog selectById(Integer id);

	int delById(Integer id);
}
