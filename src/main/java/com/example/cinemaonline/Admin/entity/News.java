package com.example.cinemaonline.Admin.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("TinTuc")
public class News {
    @Id
    private ObjectId _id;
    private String maTinTuc;
    private String tieuDe;
    private String tieuDePhu;
    private String noiDung;
    private String ngayDang;
    private String srcImage;

    public News() {
    }

    public News(ObjectId _id, String maTinTuc, String tieuDe, String tieuDePhu, String noiDung, String ngayDang, String srcImage) {
        this._id = _id;
        this.maTinTuc = maTinTuc;
        this.tieuDe = tieuDe;
        this.tieuDePhu = tieuDePhu;
        this.noiDung = noiDung;
        this.ngayDang = ngayDang;
        this.srcImage = srcImage;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getMaTinTuc() {
        return maTinTuc;
    }

    public void setMaTinTuc(String maTinTuc) {
        this.maTinTuc = maTinTuc;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTieuDePhu() {
        return tieuDePhu;
    }

    public void setTieuDePhu(String tieuDePhu) {
        this.tieuDePhu = tieuDePhu;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }

    public String getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }
}
