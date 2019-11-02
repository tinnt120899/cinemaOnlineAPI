package com.example.cinemaonline.tabset.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ListPhim")
public class ListPhim {
    @Id
    private ObjectId _id;
    private String tenPhim;
    private String thoiLuongChieu;
    private String srcImageSm;
    private String srcImageMd;
    private String trangThai;
    private String routeName;
    private String suatChieu;

    public ListPhim() {
    }

    public ListPhim(ObjectId _id, String tenPhim, String thoiLuongChieu, String srcImageSm, String srcImageMd, String trangThai, String routeName, String suatChieu) {
        this._id = _id;
        this.tenPhim = tenPhim;
        this.thoiLuongChieu = thoiLuongChieu;
        this.srcImageSm = srcImageSm;
        this.srcImageMd = srcImageMd;
        this.trangThai = trangThai;
        this.routeName = routeName;
        this.suatChieu = suatChieu;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getThoiLuongChieu() {
        return thoiLuongChieu;
    }

    public void setThoiLuongChieu(String thoiLuongChieu) {
        this.thoiLuongChieu = thoiLuongChieu;
    }

    public String getSrcImageSm() {
        return srcImageSm;
    }

    public void setSrcImageSm(String srcImageSm) {
        this.srcImageSm = srcImageSm;
    }

    public String getSrcImageMd() {
        return srcImageMd;
    }

    public void setSrcImageMd(String srcImageMd) {
        this.srcImageMd = srcImageMd;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getSuatChieu() {
        return suatChieu;
    }

    public void setSuatChieu(String suatChieu) {
        this.suatChieu = suatChieu;
    }
}
