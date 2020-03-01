package com.example.ub_app;

public class ListData {

    private String name;
    private String type;

    public ListData() {
    }

    public ListData(String s, String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}