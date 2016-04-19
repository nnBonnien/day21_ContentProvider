package com.jianda.liwenjie.expandlelistview.model;

/**
 * Created by liwenjie on 2016/3/7.
 */
public class Child {
    private String name;

    public Child() {
    }

    public Child(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                '}';
    }
}
