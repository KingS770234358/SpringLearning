package com.wq.pojo;

public class Cat {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void shout(){
        System.out.println(this.name);
    }
}
