package com.example.cinemaonline.seatmap.repository;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.seatmap.model.SeatsMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SeatsMapRepositoryImpl implements ISeatMapRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public SeatsMap findByIdSeatMap(String id) {
        Query query= new Query().addCriteria(Criteria.where("idSeatMap").is(id));
        return mongoTemplate.findOne(query, SeatsMap.class);
    }

    @Override
    public SeatsMap findById(String id) {
        Query query= new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, SeatsMap.class);
    }

    @Override
    public PagingResponse<SeatsMap> findAll(int pageNumber, int pageSize) {
        Query query = new Query()
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);
        List<SeatsMap> content = mongoTemplate.find(query, SeatsMap.class);
        long totalElements = countAllSeatsMapUnit();
        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public PagingResponse<SeatsMap> searchByKey(int pageNumber, int pageSize, String searchKey) {
        Criteria ma = Criteria.where("idSeatMap").regex(searchKey, "i");
        Criteria summary = new Criteria().orOperator(ma);

        Query pagingQuery = new Query(summary)
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);

        Query countQuery = new Query(summary);

        List<SeatsMap> content = mongoTemplate.find(pagingQuery, SeatsMap.class);
        long totalElements = mongoTemplate.count(countQuery, SeatsMap.class);

        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public SeatsMap edit(SeatsMap SeatsMap) {
        return mongoTemplate.save(SeatsMap);
    }

    @Override
    public SeatsMap insert(SeatsMap SeatsMap) {
        return mongoTemplate.insert(SeatsMap);
    }

    @Override
    public void delete(SeatsMap SeatsMap) {
        mongoTemplate.remove(SeatsMap);
    }

    private long countAllSeatsMapUnit() {
        return mongoTemplate.count(new Query(), SeatsMap.class);
    }

    @Override
    public SeatsMap findByMaOrTen(String maSo) {
        Criteria ma = Criteria.where("idSeatMap").is(maSo);
        Criteria summary = new Criteria().orOperator(ma);
        Query query= new Query(summary);
        return mongoTemplate.findOne(query, SeatsMap.class);
    }

    @Override
    public SeatsMap findByMaOrTenAndNotId(String maSo, String id) {
        Criteria maCond = Criteria.where("idSeatMap").is(maSo);
        Criteria summary = new Criteria().orOperator(maCond);
        Criteria idCond = new Criteria("_id").ne(id);
        Query query= new Query(new Criteria().andOperator(idCond, summary));
        return mongoTemplate.findOne(query, SeatsMap.class);
    }

   
}
