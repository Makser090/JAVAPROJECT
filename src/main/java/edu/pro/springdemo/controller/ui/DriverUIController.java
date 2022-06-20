package edu.pro.springdemo.controller.ui;

import edu.pro.springdemo.form.DriverForm;
import edu.pro.springdemo.model.Driver;
import edu.pro.springdemo.service.DriverService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/drivers/")
public class DriverUIController {
    @Autowired
    DriverService service;

    @ApiOperation(value = " Show all drivers", notes = "Show all drivers from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @GetMapping("/")
    public String getAll(Model model) {
        List<Driver> drivers = service.getAllDrivers();
        model.addAttribute("drivers", drivers);
        return "drivers";
    }

    @ApiOperation(value = " Delete driver by id", notes = "Delete one driver from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @GetMapping("/delete/{id}")
    public String getAll(Model model, @PathVariable String id) {
        service.delete(id);
        return "redirect:/ui/v1/drivers/";
    }

    @ApiOperation(value = " Create new driver", notes = "Add new driver to list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 201, message = "Successfully created!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addDriver(Model model) {
        DriverForm driverForm = new DriverForm();
        model.addAttribute("form", driverForm);
        return "add-driver";
    }
    @ApiOperation(value = " Create new driver", notes = "Add new driver to list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 201, message = "Successfully created!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addDriver(Model model, @ModelAttribute("form") DriverForm form) {
        Driver driver = new Driver(form.getName(), form.getSurname(), form.getExperience());
        service.create(driver);
        return "redirect:/ui/v1/drivers/";
    }
    @ApiOperation(value = " Edit one driver by Id", notes = "Edit one driver from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editDriver(Model model, @PathVariable("id") String id) {
        Driver driver = service.getOneById(id);
        DriverForm driverForm = new DriverForm();
        driverForm.setId(driver.getId());
        driverForm.setName(driver.getName());
        driverForm.setSurname(driver.getSurname());
        driverForm.setExperience(driver.getExperience());
        driverForm.setCreatedAt(driver.getCreatedAt().toString());
        driverForm.setUpdatedAt(driver.getUpdatedAt().toString());
        model.addAttribute("form", driverForm);
        return "edit-driver";
    }

    @ApiOperation(value = " Edit one driver by Id", notes = "Edit one driver from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editDriver(@PathVariable("id") String id,
                           @ModelAttribute("form") DriverForm form ){
        Driver driver = service.getOneById(form.getId());
        driver.setName(form.getName());
        driver.setSurname(form.getSurname());
        driver.setExperience(form.getExperience());
        LocalDate date = LocalDate.parse(form.getCreatedAt());
        LocalDateTime localDateTime = date.atStartOfDay();
        driver.setCreatedAt(LocalDate.parse(form.getCreatedAt()).atTime(0,0,0));
        service.update(driver);
        return "redirect:/ui/v1/drivers/";
    }
}
