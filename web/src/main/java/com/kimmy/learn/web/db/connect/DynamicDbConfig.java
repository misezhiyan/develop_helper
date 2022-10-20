package com.kimmy.learn.web.db.connect;

import com.alibaba.druid.DbType;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class DynamicDbConfig {

    private DbType dbType;
    private String driverClassName;
    private String url;
    private String userName;
    private String password;

}
