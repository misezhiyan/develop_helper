package com.kimmy.online.esb.finance.mapper;

import com.kimmy.online.esb.finance.entity.XinShuAsset;
import com.kimmy.online.esb.finance.entity.XinShuLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FinanceMapper {

    Integer logCount();

    List<XinShuLog> logList();

    int updateCustName(XinShuLog xinShuLog);

    int failFinance(XinShuLog xinShuLog);

    List<XinShuAsset> assetList();

    int delAsset(XinShuAsset asset);
}
