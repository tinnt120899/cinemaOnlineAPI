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
    private String ngayPhatHanh;
    private String daoDien;
    private String dienVien;
    private String theLoai;
    private String quocGiaSx;
    private String noiDung;
    private String linkTrailer;

    public ListPhim() {
    }

    public ListPhim(ObjectId _id, String tenPhim, String thoiLuongChieu, String srcImageSm, String srcImageMd, String trangThai, String routeName, String suatChieu, String ngayPhatHanh, String daoDien, String dienVien, String theLoai, String quocGiaSx, String noiDung, String linkTrailer) {
        this._id = _id;
        this.tenPhim = tenPhim;
        this.thoiLuongChieu = thoiLuongChieu;
        this.srcImageSm = srcImageSm;
        this.srcImageMd = srcImageMd;
        this.trangThai = trangThai;
        this.routeName = routeName;
        this.suatChieu = suatChieu;
        this.ngayPhatHanh = ngayPhatHanh;
        this.daoDien = daoDien;
        this.dienVien = dienVien;
        this.theLoai = theLoai;
        this.quocGiaSx = quocGiaSx;
        this.noiDung = noiDung;
        this.linkTrailer = linkTrailer;
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

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getDienVien() {
        return dienVien;
    }

    public void setDienVien(String dienVien) {
        this.dienVien = dienVien;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getQuocGiaSx() {
        return quocGiaSx;
    }

    public void setQuocGiaSx(String quocGiaSx) {
        this.quocGiaSx = quocGiaSx;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getLinkTrailer() {
        return linkTrailer;
    }

    public void setLinkTrailer(String linkTrailer) {
        this.linkTrailer = linkTrailer;
    }
}
