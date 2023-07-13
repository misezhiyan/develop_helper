package com.daydayup.mapper;

import java.util.List;
import com.daydayup.entity.Schedule;
import com.daydayup.vo.request.ScheduleInfoListRequest;
import com.daydayup.vo.request.ScheduleOccupyListRequest;
import com.daydayup.vo.request.ScheduleOccupyRequest;
import com.daydayup.vo.response.ScheduleInfo;
import com.daydayup.vo.response.ScheduleOccupy;
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

	/**
	 * @description: 明细列表
	 * @author: liyq
	 * @createtime: 2023-07-13 13:24:50
	 * @param: request
	 * @return Schedule>
	 */
    List<ScheduleInfo> infoList(ScheduleInfoListRequest request);

	List<ScheduleOccupy> occupyList(ScheduleOccupyListRequest request);

}
