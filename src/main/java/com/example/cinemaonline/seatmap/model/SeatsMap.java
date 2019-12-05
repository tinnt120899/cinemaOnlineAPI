package com.example.cinemaonline.seatmap.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("SeatMap")
public class SeatsMap {
    @Id
    private ObjectId _id;
    private String idSeatMap;
    private List<Long> trangThaiGhe;
    private List<Long> loaiGhe;

    public SeatsMap() {
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getIdSeatMap() {
        return idSeatMap;
    }

    public void setIdSeatMap(String idSeatMap) {
        this.idSeatMap = idSeatMap;
    }

    public List<Long> getTrangThaiGhe() {
        return trangThaiGhe;
    }

    public void setTrangThaiGhe(List<Long> trangThaiGhe) {
        this.trangThaiGhe = trangThaiGhe;
    }

    public List<Long> getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(List<Long> loaiGhe) {
        this.loaiGhe = loaiGhe;
    }
}
