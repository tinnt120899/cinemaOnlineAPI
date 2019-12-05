package com.example.cinemaonline.seatmap.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("SuatChieu")
public class SuatChieu {
    @Id
    private ObjectId _id;
    private String suatChieu;
    private String idSuatChieu;
    private String idSeatMap;

    public SuatChieu() {
    }

    public SuatChieu(ObjectId _id, String suatChieu, String idSuatChieu, String idSeatMap) {
        this._id = _id;
        this.suatChieu = suatChieu;
        this.idSuatChieu = idSuatChieu;
        this.idSeatMap = idSeatMap;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getSuatChieu() {
        return suatChieu;
    }

    public void setSuatChieu(String suatChieu) {
        this.suatChieu = suatChieu;
    }

    public String getIdSuatChieu() {
        return idSuatChieu;
    }

    public void setIdSuatChieu(String idSuatChieu) {
        this.idSuatChieu = idSuatChieu;
    }

    public String getIdSeatMap() {
        return idSeatMap;
    }

    public void setIdSeatMap(String idSeatMap) {
        this.idSeatMap = idSeatMap;
    }
}
