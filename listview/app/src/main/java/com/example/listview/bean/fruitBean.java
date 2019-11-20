package com.example.listview.bean;

public class fruitBean {
    private int id;
    private String name;
    public fruitBean(){

    }
    public fruitBean(String name){
        this.name=name;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
