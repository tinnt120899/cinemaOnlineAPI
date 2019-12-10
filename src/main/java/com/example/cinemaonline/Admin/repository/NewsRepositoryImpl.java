package com.example.cinemaonline.Admin.repository;


import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class NewsRepositoryImpl implements INewsRepository{
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public News findById(String id) {
		Query query= new Query().addCriteria(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(query, News.class);
	}

	@Override
	public PagingResponse<News> findAll(int pageNumber, int pageSize) {
		Query query = new Query()
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);
        List<News> content = mongoTemplate.find(query, News.class);
        long totalElements = countAllNewsUnit();
        return new PagingResponse<>(content, totalElements);
	}

	@Override
	public PagingResponse<News> searchByKey(int pageNumber, int pageSize, String searchKey) {
		Criteria ma = Criteria.where("maTinTuc").regex(searchKey, "i");
		Criteria ten = Criteria.where("tieuDe").regex(searchKey, "i");
		Criteria summary = new Criteria().orOperator(ma, ten);
		
		Query pagingQuery = new Query(summary)
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);
		
		Query countQuery = new Query(summary);
		
        List<News> content = mongoTemplate.find(pagingQuery, News.class);
        long totalElements = mongoTemplate.count(countQuery, News.class);
        
        return new PagingResponse<>(content, totalElements);
	}

	@Override
	public News edit(News News) {
		return mongoTemplate.save(News);
	}

	@Override
	public News insert(News News) {
		return mongoTemplate.insert(News);
	}

	@Override
	public void delete(News News) {
		mongoTemplate.remove(News);
	}
	
	private long countAllNewsUnit() {
        return mongoTemplate.count(new Query(), News.class);
    }

	@Override
	public News findByMaOrTen(String maSo, String ten) {
		Criteria ma = Criteria.where("maTinTuc").is(maSo);
		Criteria tenCond = Criteria.where("tieuDe").is(ten);
		Criteria summary = new Criteria().orOperator(ma, tenCond);
		Query query= new Query(summary);
		return mongoTemplate.findOne(query, News.class);
	}

	@Override
	public News findByMaOrTenAndNotId(String maSo, String ten, String id) {
		Criteria maCond = Criteria.where("maTinTuc").is(maSo);
		Criteria tenCond = Criteria.where("tieuDe").is(ten);
		Criteria summary = new Criteria().orOperator(maCond, tenCond);
		Criteria idCond = new Criteria("_id").ne(id);
		Query query= new Query(new Criteria().andOperator(idCond, summary));
		return mongoTemplate.findOne(query, News.class);
	}
}
