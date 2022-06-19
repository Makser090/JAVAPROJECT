package edu.pro.springdemo.repository;/*
  @author   makse
  @project   spring-demo
  @class  ItemMongoRepository
  @version  1.0.0 
  @since 19.06.2022 - 14.36
*/

import edu.pro.springdemo.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMongoRepository extends MongoRepository<Item,String> {
}
