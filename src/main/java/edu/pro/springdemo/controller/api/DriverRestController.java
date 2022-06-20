package edu.pro.springdemo.controller.api;

import edu.pro.springdemo.model.Driver;
import edu.pro.springdemo.service.DriverService;;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/drivers/")
public class DriverRestController {
    @Autowired
    DriverService service;

    @ApiOperation(value = " Show all drivers", notes = "Show all drivers from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @GetMapping("/")
    public List<Driver> getAll() {
        return service.getAllDrivers();
    }
    @ApiOperation(value = " Get one driver by Id", notes = "Show one driver by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @GetMapping("/{id}")
    public Driver get(@PathVariable(value = "id") String id){
        return service.getOneById(id);
    }
    @ApiOperation(value = " Create new driver", notes = "Add new driver to list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 201, message = "Successfully created!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @PostMapping("/")
    public Driver create(@RequestBody Driver driver){
        return service.create(driver);
    }
    @ApiOperation(value = " Edit one driver", notes = "Change info about one driver")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 201, message = "Successfully edited!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @PutMapping("/")
    public Driver update(@RequestBody Driver driver){
        return service.update(driver);
    }
    @ApiOperation(value = " Delete one driver", notes = "Delete one driver from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 204, message = "No content to delete!"),
            @ApiResponse(code = 401, message = "Access Denied!")})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id){
        service.delete(id);
    }
}
