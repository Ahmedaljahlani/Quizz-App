package com.example.quizzapp;

public class Model {
    private int id;
    private Class path;
    private String title;
    private int img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Class getPath() {
        return path;
    }

    public void setPath(Class path) {
        this.path = path;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
