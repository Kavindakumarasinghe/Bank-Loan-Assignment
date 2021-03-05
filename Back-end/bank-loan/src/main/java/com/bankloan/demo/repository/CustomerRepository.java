package com.bankloan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankloan.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
