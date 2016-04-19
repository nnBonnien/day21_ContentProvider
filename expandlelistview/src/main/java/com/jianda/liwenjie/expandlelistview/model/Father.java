package com.jianda.liwenjie.expandlelistview.model;

import java.util.List;

/**
 * Created by liwenjie on 2016/3/7.
 */
public class Father {
    private String name;
    private List<Child> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
