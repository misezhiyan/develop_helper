package com.kimmy.learn.web.entity.domains;

import com.kimmy.learn.web.entity.db.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuTree extends Menu {

    private List<Menu> children;

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
