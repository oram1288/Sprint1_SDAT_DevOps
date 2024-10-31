package com.keyin.airport;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/airports")
//public class AirportController {
//
//    @Autowired
//    private AirportRepository airportRepository;
//
//    @Autowired
//    private CityRepository cityRepository;
//
//    // Get all airports
//    @GetMapping
//    public List<Airport> getAllAirports() {
//        return airportRepository.findAll();
//    }
//
//    // Get an airport by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
//        Optional<Airport> airport = airportRepository.findById(id);
//        return airport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // Create a new airport
//    @PostMapping
//    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
//        // Check if the city exists before creating the airport
//        if (airport.getCityName() != null && cityRepository.existsById(airport.getCityName().getCityId())) {
//            Airport savedAirport = airportRepository.save(airport);
//            return ResponseEntity.ok(savedAirport);
//        }
//        return ResponseEntity.badRequest().build();
//    }
//
//    // Update an airport
//    @PutMapping("/{id}")
//    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @RequestBody Airport updatedAirport) {
//        return airportRepository.findById(id).map(airport -> {
//            airport.setName(updatedAirport.getName());
//            airport.setCode(updatedAirport.getCode());
//            airport.setCity(updatedAirport.getCity());
//            return ResponseEntity.ok(airportRepository.save(airport));
//        }).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // Delete an airport
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
//        if (airportRepository.existsById(id)) {
//            airportRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    // Get airports by city ID
//    @GetMapping("/city/{cityId}")
//    public ResponseEntity<List<Airport>> getAirportsByCity(@PathVariable Long cityId) {
//        if (cityRepository.existsById(cityId)) {
//            List<Airport> airports = airportRepository.findByCityId(cityId);
//            return ResponseEntity.ok(airports);
//        }
//        return ResponseEntity.notFound().build();
//    }
//}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    // Get all airports
    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    // Get an airport by ID
    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        Optional<Airport> airport = airportService.getAirportById(id);
        return airport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new airport
    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        Optional<Airport> savedAirport = airportService.createAirport(airport);
        return savedAirport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    // Update an airport
    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @RequestBody Airport updatedAirport) {
        Optional<Airport> airport = airportService.updateAirport(id, updatedAirport);
        return airport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete an airport
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        if (airportService.deleteAirport(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Get airports by city ID
    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<Airport>> getAirportsByCity(@PathVariable Long cityId) {
        List<Airport> airports = airportService.getAirportsByCityId(cityId);
        if (!airports.isEmpty()) {
            return ResponseEntity.ok(airports);
        }
        return ResponseEntity.notFound().build();
    }
}
