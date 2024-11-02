package com.keyin.aircraft;

import com.keyin.airport.Airport;
import com.keyin.passengers.Passengers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    // Add a new airport
    @PostMapping("/addNewAircraft")
    public Aircraft addNewAircraft(@RequestBody Aircraft aircraft) {

        return aircraftService.addAircraft(aircraft);
    }

    // Get all aircraft
    @GetMapping("/listAllAircrafts")
    public Iterable<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    // Get an aircraft by ID
    @GetMapping("/getAircraftById/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        Optional<Aircraft> aircraft = aircraftService.getAircraftById(id);
        return aircraft.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an aircraft
    @PutMapping("/updateAircraftById/{id}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable Long id, @RequestBody Aircraft updatedAircraft) {
        Optional<Aircraft> aircraft = aircraftService.updateAircraft(id, updatedAircraft);
        return aircraft.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete an aircraft
    @DeleteMapping("/deleteAircraftById/{id}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable Long id) {
        if (aircraftService.deleteAircraft(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Get passengers on an aircraft by aircraft ID
    @GetMapping("/{id}/passengers")
    public ResponseEntity<List<Passengers>> getPassengersByAircraft(@PathVariable Long id) {
        Optional<List<Passengers>> passengers = aircraftService.getPassengersByAircraft(id);
        return passengers.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Assign an airport to an aircraft
    @PostMapping("/{aircraftId}/airports/{airportId}")
    public ResponseEntity<Aircraft> addAirportToAircraft(@PathVariable Long aircraftId, @PathVariable Long airportId) {
        Optional<Aircraft> aircraft = aircraftService.addAirportToAircraft(aircraftId, airportId);
        return aircraft.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

