package com.example.yeqinglu.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeqing.lu on 2016/9/5.
 */
public class Info implements Serializable{

    private static final long serialVersionUID = 3658826751266583151L;
    private double latitude;
    private double longtitude;
    private int imagId;
    private String name;
    private String distance;
    private int zan;

    public static List<Info>infos = new ArrayList<>();


    static
    {
        infos.add(new Info(31.063456,121.249524,"万达广场",R.drawable.a1,"距离614m",1000));
        infos.add(new Info(31.050076,121.244278,"松云水苑",R.drawable.a2,"距离3800m",500));
        infos.add(new Info(31.062822,121.220868,"东华大学",R.drawable.a3,"距离2400m",1500));
    }

    public Info(  double latitude,double longtitude, String name, int imagId, String distance,int zan) {
        this.latitude = latitude;
        this.zan = zan;
        this.longtitude = longtitude;
        this.name = name;
        this.imagId = imagId;
        this.distance = distance;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public int getImagId() {
        return imagId;
    }

    public void setImagId(int imagId) {
        this.imagId = imagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }





}
