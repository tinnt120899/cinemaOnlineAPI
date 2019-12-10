package com.example.cinemaonline.listgroup.repository;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.listgroup.model.ListRap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListRapRepositoryImpl implements IListRapRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<ListRap> getAll() {
        return mongoTemplate.findAll(ListRap.class);
    }

    public List<ListRap> findByName(String heThongRap, String cumRap) {
        Criteria criteria = new Criteria().andOperator(
                Criteria.where("heThongRap").is(heThongRap),
                Criteria.where("cumRap").is(cumRap));
        Query query= new Query().addCriteria(criteria);
        return mongoTemplate.find(query, ListRap.class);
    }

    @Override
    public ListRap findById(String id) {
        Query query= new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, ListRap.class);
    }

    @Override
    public PagingResponse<ListRap> findAll(int pageNumber, int pageSize) {
        Query query = new Query()
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);
        List<ListRap> content = mongoTemplate.find(query, ListRap.class);
        long totalElements = countAllListRapUnit();
        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public PagingResponse<ListRap> searchByKey(int pageNumber, int pageSize, String searchKey) {
        Criteria ma = Criteria.where("tenRap").regex(searchKey, "i");
        Criteria ten = Criteria.where("diaChi").regex(searchKey, "i");
        Criteria summary = new Criteria().orOperator(ma, ten);

        Query pagingQuery = new Query(summary)
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);

        Query countQuery = new Query(summary);

        List<ListRap> content = mongoTemplate.find(pagingQuery, ListRap.class);
        long totalElements = mongoTemplate.count(countQuery, ListRap.class);

        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public ListRap edit(ListRap ListRap) {
        return mongoTemplate.save(ListRap);
    }

    @Override
    public ListRap insert(ListRap ListRap) {
        return mongoTemplate.insert(ListRap);
    }

    @Override
    public void delete(ListRap ListRap) {
        mongoTemplate.remove(ListRap);
    }

    private long countAllListRapUnit() {
        return mongoTemplate.count(new Query(), ListRap.class);
    }

    @Override
    public ListRap findByMaOrTen(String maSo, String ten) {
        Criteria ma = Criteria.where("tenRap").is(maSo);
        Criteria tenCond = Criteria.where("routeName").is(ten);
        Criteria summary = new Criteria().orOperator(ma, tenCond);
        Query query= new Query(summary);
        return mongoTemplate.findOne(query, ListRap.class);
    }

    @Override
    public ListRap findByMaOrTenAndNotId(String maSo, String ten, String id) {
        Criteria maCond = Criteria.where("tenRap").is(maSo);
        Criteria tenCond = Criteria.where("routeName").is(ten);
        Criteria summary = new Criteria().orOperator(maCond, tenCond);
        Criteria idCond = new Criteria("_id").ne(id);
        Query query= new Query(new Criteria().andOperator(idCond, summary));
        return mongoTemplate.findOne(query, ListRap.class);
    }

}
