package com.example.myapplicationdemo01.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joy on 2016/4/22.
 */
public class EntranceStatusData {
    private long id;
    private String name;
    private String assetsStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssetsStatus() {
        return assetsStatus;
    }

    public void setAssetsStatus(String assetsStatus) {
        this.assetsStatus = assetsStatus;
    }

    public static List<EntranceStatusData> getEntranceDatas(int floor) {
        //创建一个离线测试List
        List<EntranceStatusData> datas = new ArrayList<>();
        EntranceStatusData esd;
        if (floor == 1) {
            for (int i = 'A'; i <= 'Z'; i++) {
                esd = new EntranceStatusData();
                esd.setId(i);
                esd.setName("" + (char) i + "000");
                esd.setAssetsStatus("关闭");
                datas.add(esd);
            }
        } else if (floor == 2) {
            for (int i = 'A'; i <= 'Z'; i++) {
                esd = new EntranceStatusData();
                esd.setId(i);
                esd.setName("" + (char) i + "000");
                esd.setAssetsStatus("打开");
                datas.add(esd);
            }
        } else if (floor == 3) {
            for (int i = 'E'; i <= 'z'; i++) {
                esd = new EntranceStatusData();
                esd.setId(i);
                esd.setName("" + (char) i + "000");
                esd.setAssetsStatus("打开");
                datas.add(esd);
            }
        }
        return datas;
    }
}
