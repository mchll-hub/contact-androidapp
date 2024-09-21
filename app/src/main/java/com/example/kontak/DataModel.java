package com.example.kontak;

public class DataModel {
    String name,nohp;
    DataModel() {

    }

    public DataModel(String name, String nohp) {
        this.name = name;
        this.nohp = nohp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

}