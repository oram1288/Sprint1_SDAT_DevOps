package com.keyin.passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

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

    @GetMapping("/findByPassengerName/{passengerName}")
    public Iterable<Passengers> findByPassengerName(@RequestParam String passengerName) {
        return passengersService.findByPassengerName(passengerName);
    }
}
