package com.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



import com.model.Account;



@Repository

public interface AccountRepository extends JpaRepository<Account, String> {

// Additional query methods can be defined here if needed

}