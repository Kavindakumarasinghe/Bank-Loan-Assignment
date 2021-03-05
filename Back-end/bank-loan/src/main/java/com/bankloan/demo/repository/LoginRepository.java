package com.bankloan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankloan.demo.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

}
