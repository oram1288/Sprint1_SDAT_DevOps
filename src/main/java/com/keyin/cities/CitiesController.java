package com.keyin.cities;

import com.keyin.airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin
public class CitiesController {

    @Autowired
    private CitiesService citiesService;

    @PostMapping("/addNewCity")
    public Cities addNewCity(@RequestBody Cities cities) {

        return citiesService.addCity(cities);
    }

    @GetMapping("/listAllCities")
    public ResponseEntity<Iterable<Cities>> getAllCities() {
        citiesService.getAllCities();
        return ResponseEntity.ok().body(citiesService.getAllCities());
    }

    @GetMapping("/getAirportsForCity")
    public Iterable<Cities> getAirportsForCity(@RequestParam("name") String name) {
        return citiesService.findByAirport(name);
    }

}
