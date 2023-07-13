package com.daydayup.mapper;

import java.util.List;
import com.daydayup.entity.ScheduleOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 课程预约
 * @author kimmy
 * @date ${date}
 */
@Mapper
public interface ScheduleOrderMapper {

	List<ScheduleOrder> list(ScheduleOrder scheduleOrder);

	int insert(ScheduleOrder scheduleOrder);

	int updateById(ScheduleOrder scheduleOrder);

	ScheduleOrder selectById(Integer id);

	int delById(Integer id);

    ScheduleOrder select(ScheduleOrder param);
}
