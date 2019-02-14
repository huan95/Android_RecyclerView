package com.example.recyclerview;
//tạo class chứa kiểu dữ liệu
public class DataShop {
    private int Pictures;
    private String Name;

    public DataShop(int pictures, String name) {
        Pictures = pictures;
        Name = name;
    }

    public int getPictures() {
        return Pictures;
    }

    public void setPictures(int pictures) {
        Pictures = pictures;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
