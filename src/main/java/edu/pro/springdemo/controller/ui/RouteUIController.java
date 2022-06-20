package edu.pro.springdemo.controller.ui;

import edu.pro.springdemo.form.RoutesForm;
import edu.pro.springdemo.model.Routes;
import edu.pro.springdemo.service.RoutesService;
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
@RequestMapping("/ui/v1/routes/")
public class RouteUIController {
    @Autowired
    RoutesService service;

    @ApiOperation(value = " Show all routes", notes = "Show all routes from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @GetMapping("/")
    public String getAll(Model model) {
        List<Routes> routes = service.getAllRoutes();
        model.addAttribute("routes", routes);
        return "routes";
    }

    @ApiOperation(value = " Delete route by id", notes = "Delete one route from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @GetMapping("/delete/{id}")
    public String getAll(Model model, @PathVariable String id) {
        service.delete(id);
        return "redirect:/ui/v1/routes/";
    }

    @ApiOperation(value = " Create new route", notes = "Add new route to list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 201, message = "Successfully created!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @RequestMapping(value = "/ui/v1/routes/", method = RequestMethod.GET)
    public String addRoute(Model model) {
        RoutesForm routesForm = new RoutesForm();
        model.addAttribute("form", routesForm);
        return "add-routes";
    }

    @ApiOperation(value = " Create new route", notes = "Add new route to list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 201, message = "Successfully created!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addRoute(Model model, @ModelAttribute("form") RoutesForm form) {
        Routes routes = new Routes(form.getName(), form.getDistance(), form.getDaysinway(), form.getPayment());
        service.create(routes);
        return "redirect:/ui/v1/routes/";
    }

    @ApiOperation(value = " Edit one route by Id", notes = "Edit one route from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editRoute(Model model, @PathVariable("id") String id) {
        Routes routes = service.getOneById(id);
        RoutesForm routesForm = new RoutesForm();
        routesForm.setId(routes.getId());
        routesForm.setName(routes.getName());
        routesForm.setDistance(routes.getDistance());
        routesForm.setDaysinway(routes.getDaysinway());
        routesForm.setPayment(routes.getPayment());
        routesForm.setCreatedAt(routes.getCreatedAt().toString());
        routesForm.setUpdatedAt(routes.getUpdatedAt().toString());
        model.addAttribute("form", routesForm);
        return "edit-routes";
    }

    @ApiOperation(value = " Edit one route by Id", notes = "Edit one route from the list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result!"),
            @ApiResponse(code = 401, message = "Access Denied!"),
            @ApiResponse(code = 404, message = "Error! Not found")})
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editRoute(@PathVariable("id") String id,
                             @ModelAttribute("form") RoutesForm form ){
        Routes routes = service.getOneById(form.getId());
        routes.setName(form.getName());
        routes.setDistance(form.getDistance());
        routes.setDaysinway(form.getDaysinway());
        routes.setPayment(form.getPayment());
        LocalDate date = LocalDate.parse(form.getCreatedAt());
        LocalDateTime localDateTime = date.atStartOfDay();
        routes.setCreatedAt(LocalDate.parse(form.getCreatedAt()).atTime(0,0,0));
        service.update(routes);
        return "redirect:/ui/v1/routes/";
    }
}
