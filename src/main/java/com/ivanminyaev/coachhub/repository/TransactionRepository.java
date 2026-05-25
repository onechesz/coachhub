package com.ivanminyaev.coachhub.repository;

import com.ivanminyaev.coachhub.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
