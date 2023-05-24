package com.kaizen.banking.repository;

import com.kaizen.banking.models.Accounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Accounts, Integer> {
    @Query(value ="SELECT * FROM accounts WHERE user_id = :user_id", nativeQuery = true)
    List<Accounts> getUserAccountById(@Param("user_id") int user_id);

    @Query(value ="SELECT * FROM accounts WHERE user_id = :user_id", nativeQuery = true)
    BigDecimal getTotalBalance(@Param("user_id") int user_id);
}
