package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AlienEntity;

@Repository
public interface AlienRepository extends JpaRepository < AlienEntity, Integer > {
    //UserEntity findByEmail(String email);
}