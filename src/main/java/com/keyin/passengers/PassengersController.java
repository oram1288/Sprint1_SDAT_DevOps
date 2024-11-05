package com.keyin.passengers;

import com.keyin.cities.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RestController
@CrossOrigin
public class PassengersController {

    @Autowired
    private PassengersService passengersService;

    @GetMapping("/getAllPassengers")
    public Iterable<Passengers> getAllPassengers() {
        return passengersService.getAllPassengers();
    }

    @PostMapping("/addNewPassenger")
    public Passengers addNewPassenger(@RequestBody Passengers passenger) {
        return passengersService.addPassenger(passenger);
    }

    @GetMapping("/findByPassengerID/{passengerID}")
    public ResponseEntity<Passengers> findByPassengerID(@PathVariable Long passengerID) {
        Optional<Passengers> passengers = passengersService.findByPassengerID(passengerID);
        return passengers.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getAircraftForPassenger")
    public Iterable<Passengers> getAircraftForPassenger(@RequestParam("ID") Long passengerID) {
        return passengersService.findByAircraftID(passengerID);
    }

    @PutMapping("/updatePassengerByID/{PassengerID}")
    public ResponseEntity<Passengers> updatePassenger(@PathVariable Long passengerID,@RequestBody Passengers updatedPassenger) {
        Optional<Passengers> passengers = Optional.ofNullable(passengersService.updatePassenger(passengerID, updatedPassenger));
        return passengers.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletePasengerByID/{passengerID}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long passengerID) {
        if(passengersService.deletePassenger(passengerID)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
