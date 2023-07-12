package com.daydayup.mapper;

import java.util.List;
import com.daydayup.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 排课表
 * @author kimmy
 * @date ${date}
 */
@Mapper
public interface ScheduleMapper {

	List<Schedule> list(Schedule schedule);

	int insert(Schedule schedule);

	int updateById(Schedule schedule);

	Schedule selectById(Integer id);

	int delById(Integer id);
}
