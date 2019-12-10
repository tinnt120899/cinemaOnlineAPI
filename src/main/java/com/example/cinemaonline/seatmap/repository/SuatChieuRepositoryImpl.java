package com.example.cinemaonline.seatmap.repository;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.seatmap.model.SuatChieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SuatChieuRepositoryImpl implements ISuatChieuRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    public List<SuatChieu> findByIdSuatChieu(String id) {
        Query query= new Query().addCriteria(Criteria.where("idSuatChieu").is(id));
        return mongoTemplate.find(query, SuatChieu.class);
    }

    @Override
    public SuatChieu findById(String id) {
        Query query= new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, SuatChieu.class);
    }

    @Override
    public PagingResponse<SuatChieu> findAll(int pageNumber, int pageSize) {
        Query query = new Query()
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);
        List<SuatChieu> content = mongoTemplate.find(query, SuatChieu.class);
        long totalElements = countAllSuatChieuUnit();
        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public PagingResponse<SuatChieu> searchByKey(int pageNumber, int pageSize, String searchKey) {
        Criteria ma = Criteria.where("suatChieu").regex(searchKey, "i");
        Criteria summary = new Criteria().orOperator(ma);

        Query pagingQuery = new Query(summary)
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);

        Query countQuery = new Query(summary);

        List<SuatChieu> content = mongoTemplate.find(pagingQuery, SuatChieu.class);
        long totalElements = mongoTemplate.count(countQuery, SuatChieu.class);

        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public SuatChieu edit(SuatChieu SuatChieu) {
        return mongoTemplate.save(SuatChieu);
    }

    @Override
    public SuatChieu insert(SuatChieu SuatChieu) {
        return mongoTemplate.insert(SuatChieu);
    }

    @Override
    public void delete(SuatChieu SuatChieu) {
        mongoTemplate.remove(SuatChieu);
    }

    private long countAllSuatChieuUnit() {
        return mongoTemplate.count(new Query(), SuatChieu.class);
    }

    @Override
    public SuatChieu findByMaOrTen(String maSo, String ten) {
        Criteria ma = Criteria.where("suatChieu").is(maSo);
        Criteria tenCond = Criteria.where("idSeatMap").is(ten);
        Criteria summary = new Criteria().orOperator(ma, tenCond);
        Query query= new Query(summary);
        return mongoTemplate.findOne(query, SuatChieu.class);
    }

    @Override
    public SuatChieu findByMaOrTenAndNotId(String maSo, String ten, String id) {
        Criteria maCond = Criteria.where("suatChieu").is(maSo);
        Criteria tenCond = Criteria.where("idSeatMap").is(ten);
        Criteria summary = new Criteria().orOperator(maCond, tenCond);
        Criteria idCond = new Criteria("_id").ne(id);
        Query query= new Query(new Criteria().andOperator(idCond, summary));
        return mongoTemplate.findOne(query, SuatChieu.class);
    }

   
}
