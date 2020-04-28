package com.example.thereqresapicall;

import java.util.ArrayList;

public class DataClass {

    private ArrayList<Structure> data;

    public DataClass(ArrayList<Structure> data) {
        this.data = data;
    }

    public ArrayList<Structure> getData() {
        return data;
    }

    public void setData(ArrayList<Structure> data) {
        this.data = data;
    }
}
