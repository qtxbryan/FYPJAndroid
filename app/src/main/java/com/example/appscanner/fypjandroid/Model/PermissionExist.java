package com.example.appscanner.fypjandroid.Model;


public class PermissionExist {

    private String app_id;
    private String permName;
    private String protectLevel;

    public PermissionExist(String appId, String permName, String protectLevel) {
        this.app_id = appId;
        this.permName = permName;
        this.protectLevel = protectLevel;
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

