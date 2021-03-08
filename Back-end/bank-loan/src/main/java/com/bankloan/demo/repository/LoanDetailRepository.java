package com.bankloan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankloan.demo.model.LoanDetails;

@Repository
public interface LoanDetailsRepository extends JpaRepository<LoanDetails, Integer> {

}
