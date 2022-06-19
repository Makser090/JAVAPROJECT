package edu.pro.springdemo.controller.ui;/*
  @author   makse
  @project   spring-demo
  @class  ItemUIController
  @version  1.0.0 
  @since 19.06.2022 - 16.47
*/

import edu.pro.springdemo.model.Item;
import edu.pro.springdemo.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ui/v1/items/")
public class ItemUIController {
    @Autowired
    ItemService service;

    @GetMapping("/")
    public String getAll() {
        return "";
    }
}
