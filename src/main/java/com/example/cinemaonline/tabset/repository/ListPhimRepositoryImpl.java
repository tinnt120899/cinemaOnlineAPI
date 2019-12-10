package com.example.cinemaonline.tabset.repository;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.tabset.model.ListPhim;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ListPhimRepositoryImpl implements IListPhimRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    public List<ListPhim> findByNameRap(String routeName) {
        Query query= new Query().addCriteria(Criteria.where("routeName").is(routeName));
        return mongoTemplate.find(query, ListPhim.class);
    }

    public List<ListPhim> findByTinhThanh(String tinhThanh) {
        Query query= new Query().addCriteria(Criteria.where("tinhThanh").is(tinhThanh));
        return mongoTemplate.find(query, ListPhim.class);
    }

    @Override
    public ListPhim findById(String id) {
        Query query= new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, ListPhim.class);
    }

    @Override
    public PagingResponse<ListPhim> findAll(int pageNumber, int pageSize) {
        Query query = new Query()
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);
        List<ListPhim> content = mongoTemplate.find(query, ListPhim.class);
        long totalElements = countAllListPhimUnit();
        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public PagingResponse<ListPhim> searchByKey(int pageNumber, int pageSize, String searchKey) {
        Criteria ma = Criteria.where("tenPhim").regex(searchKey, "i");
        Criteria ten = Criteria.where("suatChieu").regex(searchKey, "i");
        Criteria summary = new Criteria().orOperator(ma, ten);

        Query pagingQuery = new Query(summary)
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);

        Query countQuery = new Query(summary);

        List<ListPhim> content = mongoTemplate.find(pagingQuery, ListPhim.class);
        long totalElements = mongoTemplate.count(countQuery, ListPhim.class);

        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public ListPhim edit(ListPhim ListPhim) {
        return mongoTemplate.save(ListPhim);
    }

    @Override
    public ListPhim insert(ListPhim ListPhim) {
        return mongoTemplate.insert(ListPhim);
    }

    @Override
    public void delete(ListPhim ListPhim) {
        mongoTemplate.remove(ListPhim);
    }

    private long countAllListPhimUnit() {
        return mongoTemplate.count(new Query(), ListPhim.class);
    }

    @Override
    public ListPhim findByMaOrTen(String maSo) {
        Criteria ma = Criteria.where("idPhim").is(maSo);
        Criteria summary = new Criteria().orOperator(ma);
        Query query= new Query(summary);
        return mongoTemplate.findOne(query, ListPhim.class);
    }

    @Override
    public ListPhim findByMaOrTenAndNotId(String maSo, String id) {
        Criteria maCond = Criteria.where("idPhim").is(maSo);
        Criteria summary = new Criteria().orOperator(maCond);
        Criteria idCond = new Criteria("_id").ne(id);
        Query query= new Query(new Criteria().andOperator(idCond, summary));
        return mongoTemplate.findOne(query, ListPhim.class);
    }
   
}
