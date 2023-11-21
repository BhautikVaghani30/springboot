package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entitis.student;

public interface StudRepo extends CrudRepository<student,Integer>{
    
}
