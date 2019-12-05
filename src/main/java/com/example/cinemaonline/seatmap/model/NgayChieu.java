package com.example.cinemaonline.seatmap.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("NgayChieu")
public class NgayChieu {
    @Id
    private ObjectId _id;
    private String ngayChieu;
    private String idPhim;
    private String idSuatChieu;

    public NgayChieu() {
    }

    public NgayChieu(ObjectId _id, String ngayChieu, String idSuatChieu, String idPhim) {
        this._id = _id;
        this.ngayChieu = ngayChieu;
        this.idSuatChieu = idSuatChieu;
        this.idPhim = idPhim;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public String getIdSuatChieu() {
        return idSuatChieu;
    }

    public void setIdSuatChieu(String idSuatChieu) {
        this.idSuatChieu = idSuatChieu;
    }

    public String getIdPhim() {
        return idPhim;
    }

    public void setIdPhim(String idPhim) {
        this.idPhim = idPhim;
    }
}
