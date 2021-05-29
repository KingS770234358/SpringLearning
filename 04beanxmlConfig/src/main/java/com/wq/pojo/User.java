package com.wq.pojo;

public class User {

//    public User(){
//        System.out.println("User的无参构造");
//    }

    private String name;
    private int id;

    public User(String name, int id){
        this.name = name;
        this.id = id+1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name:"+this.name+"id:"+this.id);
    }

}
