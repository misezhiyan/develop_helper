package com.kimmy.online.esb.finance.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kimmy.online.esb.finance.entity.XinShuAsset;
import com.kimmy.online.esb.finance.entity.XinShuLog;
import com.kimmy.online.esb.finance.mapper.FinanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/test")
@RestController
public class FinanceController {

    @Autowired
    FinanceMapper financeMapper;

    @RequestMapping("/test")
    public void test() {

        // 1、抽取日志数据
        // Integer logCount = financeMapper.logCount();
        // List<XinShuLog> xinShuLogs = financeMapper.logList();
        // System.out.println(xinShuLogs.size());

        // List<XinShuLog> dealSearchList = xinShuLogs.stream().filter(xinshu -> StringUtils.isEmpty(xinshu.getCustName())).collect(Collectors.toList());
        // System.out.println(dealSearchList.size());
        // dealSearchParam(dealSearchList);

        // xinShuLogs = xinShuLogs.stream().filter(xinshu -> "0000".equals(xinshu.getRc())).collect(Collectors.toList());
        // List<XinShuLog> collect = xinShuLogs.stream().filter(xinshu -> checkFail(xinshu)).collect(Collectors.toList());
        //
        // List<XinShuLog> failList  = collect.stream().filter(xinshu -> checkFail(xinshu)).collect(Collectors.toList());
        // System.out.println(JSON.toJSONString(failList));
        // System.out.println(failList.size());
        //
        // for (int i = 0; i < failList.size(); i++) {
        //     failList.get(i).setRc("0001");
        //     financeMapper.failFinance(failList.get(i));
        // }

        // 2、处理落库数据
        List<XinShuAsset> assetList = financeMapper.assetList();
        System.out.println(assetList.size());

        List<XinShuAsset> failList = assetList.stream().filter(asset -> checkFail(asset)).collect(Collectors.toList());
        System.out.println(failList.size());
        for (int i = 0; i < failList.size(); i++) {
            financeMapper.delAsset(failList.get(i));
        }
    }

    private boolean checkFail(XinShuAsset asset) {
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(asset));
        return checkOneFail(jsonObject.getString(getValue( "ASSGRO"))) && checkOneFail(jsonObject.getString(getValue( "LIAGRO"))) &&
                checkOneFail(jsonObject.getString(getValue("MAIBUSINC"))) && checkOneFail(jsonObject.getString(getValue( "NETINC"))) &&
                checkOneFail(jsonObject.getString(getValue("PROGRO"))) && checkOneFail(jsonObject.getString(getValue( "RATGRO"))) &&
                checkOneFail(jsonObject.getString(getValue("TOTEQU"))) && checkOneFail(jsonObject.getString(getValue( "VENDINC"))) &&
                checkOneFail(jsonObject.getString(getValue("NOT_ASSGRO"))) && checkOneFail(jsonObject.getString(getValue( "NOT_LIAGRO"))) &&
                checkOneFail(jsonObject.getString(getValue("NOT_MAIBUSINC"))) && checkOneFail(jsonObject.getString(getValue( "NOT_NETINC"))) &&
                checkOneFail(jsonObject.getString(getValue("NOT_PROGRO"))) && checkOneFail(jsonObject.getString(getValue( "NOT_RATGRO"))) &&
                checkOneFail(jsonObject.getString(getValue("NOT_TOTEQU"))) && checkOneFail(jsonObject.getString(getValue( "NOT_VENDINC")));
    }

    private String getValue(String assgro) {
        return assgro.toLowerCase(Locale.ROOT);
    }

    private boolean checkFail(XinShuLog xinshu) {
        JSONObject jsonObjectData = JSON.parseObject(xinshu.getData());
        JSONObject jsonData = jsonObjectData.getJSONObject("data");

        // 请求格式
        if (null != jsonData) {
            JSONArray result = jsonData.getJSONArray("result");
            JSONObject jsonObject = result.getJSONObject(0);
            return checkOneFail(jsonObject.getString("ASSGRO")) && checkOneFail(jsonObject.getString("LIAGRO")) && checkOneFail(jsonObject.getString("MAIBUSINC")) && checkOneFail(jsonObject.getString("NETINC")) && checkOneFail(jsonObject.getString("PROGRO")) && checkOneFail(jsonObject.getString("RATGRO")) && checkOneFail(jsonObject.getString("TOTEQU")) && checkOneFail(jsonObject.getString("VENDINC")) && checkOneFail(jsonObject.getString("NOT_ASSGRO")) && checkOneFail(jsonObject.getString("NOT_LIAGRO")) && checkOneFail(jsonObject.getString("NOT_MAIBUSINC")) && checkOneFail(jsonObject.getString("NOT_NETINC")) && checkOneFail(jsonObject.getString("NOT_PROGRO")) && checkOneFail(jsonObject.getString("NOT_RATGRO")) && checkOneFail(jsonObject.getString("NOT_TOTEQU")) && checkOneFail(jsonObject.getString("NOT_VENDINC"));
        }
        // 库数据格式
        JSONObject jsonObject = jsonObjectData.getJSONArray(xinshu.getYear()).getJSONObject(0);
        return checkOneFail(jsonObject.getString("ASSGRO")) && checkOneFail(jsonObject.getString("LIAGRO")) && checkOneFail(jsonObject.getString("MAIBUSINC")) && checkOneFail(jsonObject.getString("NETINC")) && checkOneFail(jsonObject.getString("PROGRO")) && checkOneFail(jsonObject.getString("RATGRO")) && checkOneFail(jsonObject.getString("TOTEQU")) && checkOneFail(jsonObject.getString("VENDINC")) && checkOneFail(jsonObject.getString("NOT_ASSGRO")) && checkOneFail(jsonObject.getString("NOT_LIAGRO")) && checkOneFail(jsonObject.getString("NOT_MAIBUSINC")) && checkOneFail(jsonObject.getString("NOT_NETINC")) && checkOneFail(jsonObject.getString("NOT_PROGRO")) && checkOneFail(jsonObject.getString("NOT_RATGRO")) && checkOneFail(jsonObject.getString("NOT_TOTEQU")) && checkOneFail(jsonObject.getString("NOT_VENDINC"));
    }

    private boolean checkOneFail(String checkValue) {
        return org.springframework.util.StringUtils.isEmpty(checkValue) || new BigDecimal(checkValue).compareTo(BigDecimal.ZERO) == 0;
    }

    private void dealSearchParam(List<XinShuLog> dealSearchList) {

        for (int i = 0; i < dealSearchList.size(); i++) {
            System.err.println(i);
            XinShuLog xinShuLog = dealSearchList.get(i);
            if (StringUtils.isEmpty(xinShuLog.getCustName())) {
                String param = xinShuLog.getParam();
                JSONObject jsonObject = JSON.parseObject(param);
                String custName = jsonObject.getString("searchKey");
                String year = jsonObject.getString("ancheYear");
                xinShuLog.setCustName(custName);
                xinShuLog.setYear(year);
                if (StringUtils.isEmpty(xinShuLog.getSource())) {
                    xinShuLog.setSource("XINSHU");
                }
                financeMapper.updateCustName(xinShuLog);
            }
        }

    }

}
