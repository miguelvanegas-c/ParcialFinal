package com.example.demo.repository;

import com.example.demo.model.Date;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DateRepository extends MongoRepository<Date,String> {
    List<Date> findByDate(String date);
    List<Date> findByStatus(String status);
}
