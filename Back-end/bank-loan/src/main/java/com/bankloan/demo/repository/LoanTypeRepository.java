package com.bankloan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankloan.demo.model.LoanType;

@Repository
public interface LoanTypeRepository extends JpaRepository<LoanType, Integer> {

}
