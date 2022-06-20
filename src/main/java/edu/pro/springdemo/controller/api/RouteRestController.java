package edu.pro.springdemo.controller.api;

import edu.pro.springdemo.model.Routes;
import edu.pro.springdemo.service.RoutesService;
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
@RequestMapping("/api/v1/routes/")
public class RouteRestController {
    @Autowired
    RoutesService service;

    @ApiOperation(value = " Show all routes", notes = "Show all routes from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @GetMapping("/")
    public List<Routes> getAll() {
        return service.getAllRoutes();
    }

    @ApiOperation(value = " Get one route by id", notes = "Show one route from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @GetMapping("/{id}")
    public Routes get(@PathVariable(value = "id") String id){
        return service.getOneById(id);
    }

    @ApiOperation(value = " Create new route", notes = "Add new route to list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 201, message = "Successfully created!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @PostMapping("/")
    public Routes create(@RequestBody Routes routes){return service.create(routes);
    }

    @ApiOperation(value = " Edit one route by Id", notes = "Edit one route from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @PutMapping("/")
    public Routes update(@RequestBody Routes routes){
        return service.update(routes);
    }

    @ApiOperation(value = " Delete route by id", notes = "Delete one route from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id){
        service.delete(id);
    }
}
