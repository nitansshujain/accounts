package com.microservice.accounts.repository;

import com.microservice.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {
    Optional<Accounts> findByCustomerId(Long customerId);

    // These 2 annotations are mandatory to add in the custom methods in the Repository class
    @Transactional // Provides the feature of rollback if any problem happens in runtime
    @Modifying // It tells spring data JPA framework that this method is going to modify the data, so please query this method inside a Transaction
    void deleteByCustomerId(Long customerId);
}
