package com.org.IBMS.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Joy on 2016/4/23.
 */
public class CheckinHistory {
    private long id;
    private String userName;
    private String assetsName;
    private String assetsLocation;
    private Date checkTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAssetsName() {
        return assetsName;
    }

    public void setAssetsName(String assetsName) {
        this.assetsName = assetsName;
    }

    public String getAssetsLocation() {
        return assetsLocation;
    }

    public void setAssetsLocation(String assetsLocation) {
        this.assetsLocation = assetsLocation;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
    public static List<CheckinHistory> getLogs(long id){
        //构建一个离线List
        List<CheckinHistory> datas = new ArrayList<>();
        Date now = new Date();


        CheckinHistory cih;
        for (int i = 'A'; i <= 'z'; i++) {
            cih = new CheckinHistory();
            cih.setUserName("姓名" + (char) i);
            cih.setAssetsName("" + (char) i);
            cih.setCheckTime(now);
            datas.add(cih);
        }
        return datas;
    }
}
