package edu.pro.springdemo.controller.api;/*
  @author   makse
  @project   spring-demo
  @class  ItemRestController
  @version  1.0.0 
  @since 15.06.2022 - 22.55
*/


import edu.pro.springdemo.model.Item;
import edu.pro.springdemo.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/items/")
public class ItemRestController {
    @Autowired
    ItemService service;

    @ApiOperation(value = " Get them all", notes = "Amogus")
    @ApiResponse(code = 200, message = "Success")
    @GetMapping("/")
    public List<Item> getAll() {
        return service.getAllItems();
    }
    @ApiOperation(value = " Get one by Id", notes = "Amogus")
    @ApiResponse(code = 200, message = "Success")
    @GetMapping("/{id}")
    public Item get(@PathVariable(value = "id") String id){
        return service.getOneById(id);
    }

    @PostMapping("/")
    public Item create(@RequestBody Item item){
        return service.create(item);
    }

    @PutMapping("/")
    public Item update(@RequestBody Item item){
        return service.update(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id){
        service.delete(id);
    }
}
