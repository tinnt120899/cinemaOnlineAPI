package com.example.cinemaonline.Admin.repository;

import com.example.cinemaonline.Admin.constant.PagingResponse;
import com.example.cinemaonline.Admin.entity.Account;

public interface IAccountRepository {
    Account findById(String id);

    PagingResponse<Account> findAll(int pageNumber, int pageSize);

    PagingResponse<Account> searchByKey(int pageNumber, int pageSize, String searchKey);

    Account edit(Account Account) ;

    Account insert(Account Account);

    void delete(Account Account);

    Account findByMaOrTen(String ma, String ten, String email);

    Account checkLogin(String ma, String ten);

    Account findByMaOrTenAndNotId(String ma, String ten, String email, String id);

}
