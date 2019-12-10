package com.example.cinemaonline.listgroup.repository;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.listgroup.model.HeThongRap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeThongRapRepositoryImpl implements IHeThongRapRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<HeThongRap> getAll() {
        return mongoTemplate.findAll(HeThongRap.class);
    }

    public List<HeThongRap> findByName(String tinhThanh) {
        Criteria criteria = new Criteria().andOperator(
                Criteria.where("tinhThanh").is(tinhThanh));
        Query query= new Query().addCriteria(criteria);
        return mongoTemplate.find(query, HeThongRap.class);
    }

    @Override
    public HeThongRap findById(String id) {
        Query query= new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, HeThongRap.class);
    }

    @Override
    public PagingResponse<HeThongRap> findAll(int pageNumber, int pageSize) {
        Query query = new Query()
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);
        List<HeThongRap> content = mongoTemplate.find(query, HeThongRap.class);
        long totalElements = countAllHeThongRapUnit();
        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public PagingResponse<HeThongRap> searchByKey(int pageNumber, int pageSize, String searchKey) {
        Criteria ma = Criteria.where("tinhThanh").regex(searchKey, "i");
        Criteria ten = Criteria.where("nameList").regex(searchKey, "i");
        Criteria summary = new Criteria().orOperator(ma, ten);

        Query pagingQuery = new Query(summary)
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);

        Query countQuery = new Query(summary);

        List<HeThongRap> content = mongoTemplate.find(pagingQuery, HeThongRap.class);
        long totalElements = mongoTemplate.count(countQuery, HeThongRap.class);

        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public HeThongRap edit(HeThongRap HeThongRap) {
        return mongoTemplate.save(HeThongRap);
    }

    @Override
    public HeThongRap insert(HeThongRap HeThongRap) {
        return mongoTemplate.insert(HeThongRap);
    }

    @Override
    public void delete(HeThongRap HeThongRap) {
        mongoTemplate.remove(HeThongRap);
    }

    private long countAllHeThongRapUnit() {
        return mongoTemplate.count(new Query(), HeThongRap.class);
    }

    @Override
    public HeThongRap findByMaOrTen(String maSo) {
        Criteria ma = Criteria.where("id").is(maSo);
        Criteria summary = new Criteria().orOperator(ma);
        Query query= new Query(summary);
        return mongoTemplate.findOne(query, HeThongRap.class);
    }

    @Override
    public HeThongRap findByMaOrTenAndNotId(String maSo, String id) {
        Criteria maCond = Criteria.where("id").is(maSo);
        Criteria summary = new Criteria().orOperator(maCond);
        Criteria idCond = new Criteria("_id").ne(id);
        Query query= new Query(new Criteria().andOperator(idCond, summary));
        return mongoTemplate.findOne(query, HeThongRap.class);
    }


}
