package com.example.cinemaonline.seatmap.repository;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.seatmap.model.NgayChieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NgayChieuRepositoryImpl implements INgayChieuRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    public List<NgayChieu> findByIdPhim(String idPhim) {
        Query query= new Query().addCriteria(Criteria.where("idPhim").is(idPhim));
        return mongoTemplate.find(query, NgayChieu.class);
    }

    @Override
    public NgayChieu findById(String id) {
        Query query= new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, NgayChieu.class);
    }

    @Override
    public PagingResponse<NgayChieu> findAll(int pageNumber, int pageSize) {
        Query query = new Query()
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);
        List<NgayChieu> content = mongoTemplate.find(query, NgayChieu.class);
        long totalElements = countAllNgayChieuUnit();
        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public PagingResponse<NgayChieu> searchByKey(int pageNumber, int pageSize, String searchKey) {
        Criteria ma = Criteria.where("ngayChieu").regex(searchKey, "i");
        Criteria summary = new Criteria().orOperator(ma);

        Query pagingQuery = new Query(summary)
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);

        Query countQuery = new Query(summary);

        List<NgayChieu> content = mongoTemplate.find(pagingQuery, NgayChieu.class);
        long totalElements = mongoTemplate.count(countQuery, NgayChieu.class);

        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public NgayChieu edit(NgayChieu NgayChieu) {
        return mongoTemplate.save(NgayChieu);
    }

    @Override
    public NgayChieu insert(NgayChieu NgayChieu) {
        return mongoTemplate.insert(NgayChieu);
    }

    @Override
    public void delete(NgayChieu NgayChieu) {
        mongoTemplate.remove(NgayChieu);
    }

    private long countAllNgayChieuUnit() {
        return mongoTemplate.count(new Query(), NgayChieu.class);
    }

    @Override
    public NgayChieu findByMaOrTen(String maSo) {
        Criteria ma = Criteria.where("ngayChieu").is(maSo);
        Criteria summary = new Criteria().orOperator(ma);
        Query query= new Query(summary);
        return mongoTemplate.findOne(query, NgayChieu.class);
    }

    @Override
    public NgayChieu findByMaOrTenAndNotId(String maSo, String id) {
        Criteria maCond = Criteria.where("ngayChieu").is(maSo);
        Criteria summary = new Criteria().orOperator(maCond);
        Criteria idCond = new Criteria("_id").ne(id);
        Query query= new Query(new Criteria().andOperator(idCond, summary));
        return mongoTemplate.findOne(query, NgayChieu.class);
    }

   
}
