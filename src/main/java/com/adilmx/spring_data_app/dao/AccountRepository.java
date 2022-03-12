package com.adilmx.spring_data_app.dao;

import com.adilmx.spring_data_app.constants.AccountType;
import com.adilmx.spring_data_app.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

    List<Account> findByType(AccountType type);

    @Query("select a from Account a where a.type =:t")
    Page<Account> findCustomized(@Param("t ") AccountType type, Pageable pageable);
}
