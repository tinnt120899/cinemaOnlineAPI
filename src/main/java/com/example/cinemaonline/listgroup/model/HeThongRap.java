package com.example.cinemaonline.listgroup.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("HeThongRap")
public class HeThongRap {
    @Id
    private ObjectId _id;
    private String srcImage;
    private String id;
    private String href;
    private String nameList;
    private String tinhThanh;

    public HeThongRap() {
    }

    public HeThongRap(ObjectId _id, String srcImage, String id, String href, String nameList, String tinhThanh) {
        this._id = _id;
        this.srcImage = srcImage;
        this.id = id;
        this.href = href;
        this.nameList = nameList;
        this.tinhThanh = tinhThanh;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }
}
