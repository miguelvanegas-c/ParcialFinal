package com.example.demo.repository;

import com.example.demo.model.Specialty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends MongoRepository<Specialty,String> {

}
