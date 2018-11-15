package com.springmvc.model.district;

/**
 * @Package: com.springmvc.model.district
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/18.
 */
public class ArtisanDistrictInfo {

    private Integer id;
    private String artisanId;
    private float latitude;
    private float longitude;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtisanId() {
        return artisanId;
    }

    public void setArtisanId(String artisanId) {
        this.artisanId = artisanId;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
