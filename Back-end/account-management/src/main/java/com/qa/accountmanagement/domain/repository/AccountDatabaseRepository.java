package com.qa.accountmanagement.domain.repository;

import com.qa.accountmanagement.domain.AccountDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AccountDatabaseRepository extends JpaRepository<AccountDatabase, Long> {

    @Query("SELECT a from AccountDatabase a where a.firstName = :firstName")
    List<AccountDatabase> findByName(String firstName);

}
