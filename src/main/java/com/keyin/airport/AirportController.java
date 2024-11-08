package com.keyin.airport;

import com.keyin.cities.Cities;
import com.keyin.cities.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class AirportController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private CitiesService citiesService;

    // Add a new airport
    @PostMapping("/addNewAirport")
    public Airport addNewAirport(@RequestBody Airport airport) {

        Optional<Cities> cityOptional = Optional.ofNullable(citiesService.findByCityName(airport.getCityName().getCityName()));

        Cities cities;
        if (cityOptional.isPresent()) {
            cities = cityOptional.get();
        } else {
            // Save the new city if it doesn't exist
            cities = airport.getCityName();
            citiesService.addCity(cities);
        }

        airport.setCityName(cities); // Set the persisted city on the book

        return airportService.addAirport(airport);
    }

    @GetMapping("/listAllAirports")
    public ResponseEntity<Iterable<Airport>> getAllAirports() {
        airportService.getAllAirports();
        return ResponseEntity.ok().body(airportService.getAllAirports());
    }

    // Get an airport by ID
    @GetMapping("/getAirportById/{airportId}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long airportId) {
        Optional<Airport> airport = airportService.getAirportById(airportId);
        return airport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an airport
    @PutMapping("/updateAirportById/{airportId}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long airportId, @RequestBody Airport updatedAirport) {
        Optional<Airport> airport = airportService.updateAirport(airportId, updatedAirport);
        return airport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete an airport
    @DeleteMapping("/deleteAirportById/{airportId}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long airportId) {
        if (airportService.deleteAirport(airportId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Get airports by city ID
    @GetMapping("/getAirportsByCityId/{cityId}")
    public ResponseEntity<Iterable<Airport>> getAirportsByCity(@PathVariable Long cityId) {
        Iterable<Airport> airports = airportService.getAirportsByCityId(cityId);
        if (airports.iterator().hasNext()) {
            return ResponseEntity.ok(airports);
        }
        return ResponseEntity.notFound().build();
    }
}
