package com.kimmy.learn.web.mapper;

import com.kimmy.learn.web.controller.domain.request.MenuRequest;
import com.kimmy.learn.web.entity.db.Menu;
import com.kimmy.learn.web.entity.domains.MenuTree;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<Menu> getMenuList();

    List<MenuTree> getMenuTree();

    int addMenu(Menu request);

    int delMenu(Menu request);

}
