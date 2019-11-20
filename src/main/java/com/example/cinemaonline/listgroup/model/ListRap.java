package com.example.cinemaonline.listgroup.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ListRap")
public class ListRap {
    @Id
    private ObjectId _id;
    private String cumRap;
    private String heThongRap;
    private String tenRap;
    private String diaChi;
    private String srcImage;
    private String routeName;
    private String tinhThanh;

    public ListRap() {
    }

    public ListRap(ObjectId _id, String cumRap, String heThongRap, String tenRap, String diaChi, String srcImage, String routeName, String tinhThanh) {
        this._id = _id;
        this.cumRap = cumRap;
        this.heThongRap = heThongRap;
        this.tenRap = tenRap;
        this.diaChi = diaChi;
        this.srcImage = srcImage;
        this.routeName = routeName;
        this.tinhThanh = tinhThanh;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getCumRap() {
        return cumRap;
    }

    public void setCumRap(String cumRap) {
        this.cumRap = cumRap;
    }

    public String getHeThongRap() {
        return heThongRap;
    }

    public void setHeThongRap(String heThongRap) {
        this.heThongRap = heThongRap;
    }

    public String getTenRap() {
        return tenRap;
    }

    public void setTenRap(String tenRap) {
        this.tenRap = tenRap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }
}


