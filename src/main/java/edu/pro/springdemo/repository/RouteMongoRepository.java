package edu.pro.springdemo.repository;

import edu.pro.springdemo.model.Routes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteMongoRepository extends MongoRepository<Routes,String> {
}

