package com.example.cinemaonline.Admin.repository;


import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AccountRepositoryImpl implements IAccountRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Account findById(String id) {
        Query query= new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Account.class);
    }

    @Override
    public PagingResponse<Account> findAll(int pageNumber, int pageSize) {
        Query query = new Query()
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);
        List<Account> content = mongoTemplate.find(query, Account.class);
        long totalElements = countAllAccountUnit();
        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public PagingResponse<Account> searchByKey(int pageNumber, int pageSize, String searchKey) {
        Criteria ma = Criteria.where("ten").regex(searchKey, "i");
        Criteria ten = Criteria.where("email").regex(searchKey, "i");
        Criteria summary = new Criteria().orOperator(ma, ten);

        Query pagingQuery = new Query(summary)
                .with(PageRequest.of(pageNumber - 1, pageSize))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize);

        Query countQuery = new Query(summary);

        List<Account> content = mongoTemplate.find(pagingQuery, Account.class);
        long totalElements = mongoTemplate.count(countQuery, Account.class);

        return new PagingResponse<>(content, totalElements);
    }

    @Override
    public Account edit(Account Account) {
        return mongoTemplate.save(Account);
    }

    @Override
    public Account insert(Account Account) {
        return mongoTemplate.insert(Account);
    }

    @Override
    public void delete(Account Account) {
        mongoTemplate.remove(Account);
    }

    private long countAllAccountUnit() {
        return mongoTemplate.count(new Query(), Account.class);
    }

    @Override
    public Account findByMaOrTen( String ten, String email) {
        Criteria tenCond = Criteria.where("username").is(ten);
        Criteria emailCond = Criteria.where("email").is(email);
        Criteria summary = new Criteria().orOperator(tenCond, emailCond);
        Query query= new Query(summary);
        return mongoTemplate.findOne(query, Account.class);
    }

    @Override
    public List<Account> checkLogin(String user, String pass) {
        Criteria criteria = new Criteria().andOperator(
                Criteria.where("username").is(user),
                Criteria.where("password").is(pass));
        Query query= new Query().addCriteria(criteria);
        return mongoTemplate.find(query, Account.class);
    }

    @Override
    public Account findByMaOrTenAndNotId(String maSo, String ten, String email, String id) {
        Criteria maCond = Criteria.where("id").is(maSo);
        Criteria tenCond = Criteria.where("username").is(ten);
        Criteria emailCond = Criteria.where("email").is(email);
        Criteria summary = new Criteria().orOperator(maCond, tenCond, emailCond);
        Criteria idCond = new Criteria("_id").ne(id);
        Query query= new Query(new Criteria().andOperator(idCond, summary));
        return mongoTemplate.findOne(query, Account.class);
    }
}
