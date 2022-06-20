package edu.pro.springdemo.service;

import edu.pro.springdemo.model.Routes;
import edu.pro.springdemo.repository.RouteMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Service
public class RoutesService {

    private LocalDateTime now = LocalDateTime.now();
    private List<Routes> routes = new ArrayList<>(
            Arrays.asList(
                    new Routes("0", "Почта", "267км", "0", "9790", now, now),
                    new Routes("1", "Молоко", "1554км", "2", "24550",now, now),
                    new Routes("2", "Іграшки", "567км", "1","12560", now, now),
                    new Routes("3", "Цистерна", "2056", "4","31000", now, now)

            )
    );

    @Autowired
    RouteMongoRepository repository;

    @PostConstruct
    void init(){
        repository.saveAll(routes);
    }

    public List<Routes> getAllRoutes() {

        return repository.findAll();
    }
    public Routes getOneById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Routes create(Routes routes){
        routes.setCreatedAt(LocalDateTime.now());
        Routes routesFromDB = repository.save(routes);
        return routesFromDB;
    }
    public Routes update(Routes routes){
        routes.setUpdatedAt(LocalDateTime.now());
        return repository.save(routes);
    }

    public void delete(String id){

        repository.deleteById(id);
    }
}


