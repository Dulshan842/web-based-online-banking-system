package com.banksystem.banksystem.Repository;

import com.banksystem.banksystem.Entity.SecurityQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityQuestionRepository extends JpaRepository<SecurityQuestion, Integer> {

    List<SecurityQuestion> findByUserId(int userId);

    @Transactional
    @Modifying
    @Query("DELETE FROM SecurityQuestion q WHERE q.userId = :userId")
    void deleteByUserId(@Param("userId") int userId);
}
