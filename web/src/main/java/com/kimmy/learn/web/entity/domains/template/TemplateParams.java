package com.kimmy.learn.web.entity.domains.template;

import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TemplateParams extends HashMap {

    public <T> void asParam(String paramName, T bean) {
        Map innerMap = new HashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                Object value = beanMap.get(key);
                innerMap.put(key + "", value);
            }
        }
        this.put(paramName, innerMap);
    }

}
