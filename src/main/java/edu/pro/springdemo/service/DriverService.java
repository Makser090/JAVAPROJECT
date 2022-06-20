package edu.pro.springdemo.service;

import edu.pro.springdemo.model.Driver;
import edu.pro.springdemo.repository.DriverMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



    @Service
    public class DriverService {

        private LocalDateTime now = LocalDateTime.now();
        private List<Driver> drivers = new ArrayList<>(
                Arrays.asList(
                        new Driver("0", "Святослав", "Пашук", "10", now, now),
                        new Driver("1", "Олексій", "Климчук", "7", now, now),
                        new Driver("2", "Іван", "Філюк", "0", now, now),
                        new Driver("3", "Ілля", "Артимишин", "5", now, now),
                        new Driver("4", "Єгор", "Самчук", "2", now, now)

                )
        );

        @Autowired
        DriverMongoRepository repository;

        @PostConstruct
        void init(){
            repository.saveAll(drivers);
        }

        public List<Driver> getAllDrivers() {

            return repository.findAll();
        }
        public Driver getOneById(String id) {
            return repository.findById(id).orElse(null);
        }

        public Driver create(Driver driver){
            driver.setCreatedAt(LocalDateTime.now());
            Driver driverFromDB = repository.save(driver);
            return driverFromDB;
        }
        public Driver update(Driver driver){
            driver.setUpdatedAt(LocalDateTime.now());
            return repository.save(driver);
        }

        public void delete(String id){

            repository.deleteById(id);
        }
    }

