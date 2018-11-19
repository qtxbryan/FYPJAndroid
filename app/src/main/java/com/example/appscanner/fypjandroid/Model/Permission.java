package com.example.appscanner.fypjandroid.Model;


public class Permission {

    private String perm_id;
    private String name;
    private String protect_id;

    public Permission(String perm_id, String name, String protect_id) {
        this.perm_id = perm_id;
        this.name = name;
        this.protect_id = protect_id;
    }

    public String getPerm_id() {
        return perm_id;
    }

    public void setPerm_id(String perm_id) {
        this.perm_id = perm_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtect_id() {
        return protect_id;
    }

    public void setProtect_id(String protect_id) {
        this.protect_id = protect_id;
    }
}
