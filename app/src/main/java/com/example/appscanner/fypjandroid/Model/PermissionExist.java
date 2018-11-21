package com.example.appscanner.fypjandroid.Model;


public class PermissionExist {

    private String app_id;
    private String permName;
    private String protectLevel;
    private String perm_id;

    public PermissionExist(String appId, String permName, String protectLevel, String perm_id) {
        this.app_id = appId;
        this.permName = permName;
        this.protectLevel = protectLevel;
        this.perm_id = perm_id;
    }


    public String getPerm_id() {
        return perm_id;
    }

    public void setPerm_id(String perm_id) {
        this.perm_id = perm_id;
    }

    public String getAppId() {
        return app_id;
    }

    public void setAppId(String appId) {
        this.app_id = appId;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getProtectLevel() {
        return protectLevel;
    }

    public void setProtectLevel(String protectLevel) {
        this.protectLevel = protectLevel;
    }
}

