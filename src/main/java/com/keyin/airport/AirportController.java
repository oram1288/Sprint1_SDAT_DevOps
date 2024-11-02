package com.keyin.airport;

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
    @GetMapping("/listAllAirports")
    public Iterable<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    // Get an airport by ID
    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        Optional<Airport> airport = airportService.getAirportById(id);
        return airport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new airport
    @PostMapping("/createAirport")
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
    public ResponseEntity<Iterable<Airport>> getAirportsByCity(@PathVariable Long cityId) {
        Iterable<Airport> airports = airportService.getAirportsByCityId(cityId);
        if (airports.iterator().hasNext()) {
            return ResponseEntity.ok(airports);
        }
        return ResponseEntity.notFound().build();
    }
}
