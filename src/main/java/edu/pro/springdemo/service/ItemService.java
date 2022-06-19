package edu.pro.springdemo.service;/*
  @author   makse
  @project   spring-demo
  @class  ItemService
  @version  1.0.0 
  @since 15.06.2022 - 23.43
*/

import edu.pro.springdemo.model.Item;
import edu.pro.springdemo.repository.ItemMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    private LocalDateTime now = LocalDateTime.now();
    private List<Item> items = new ArrayList<>(
            Arrays.asList(
                    new Item("0", "item0", "descr0", now, null),
                    new Item("1", "item1", "descr1", now, null),
                    new Item("2", "item2", "descr2", now, null)
            )
    );

    @Autowired
    ItemMongoRepository repository;

  //  @PostConstruct
    void init(){
      repository.saveAll(items);
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }
    public Item getOneById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Item create(Item item){
        item.setCreatedAt(LocalDateTime.now());
        Item itemFromDB = repository.save(item);
        return itemFromDB;
    }
    public Item update(Item item){
        item.setUpdatedAt(LocalDateTime.now());
        return repository.save(item);
    }

    public void delete(String id){
        repository.deleteById(id);
    }
}
