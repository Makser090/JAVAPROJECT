package edu.pro.springdemo.repository;
import edu.pro.springdemo.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverMongoRepository extends MongoRepository<Driver,String> {
}
