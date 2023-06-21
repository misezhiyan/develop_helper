package com.kimmy.online.esb.finance.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description: TODO
 * @author: liyq
 * @createtime: 2023-05-15 15:51
 */
@Data
public class XinShuLog {
    private String id;
    private String urlname;
    private String urlcomm;
    private String servicename;
    private String param;
    private String data;
    private Date createTime;
    private String rc;
    private String batchNo;
    private String custName;
    private String year;
    private String source;

}
