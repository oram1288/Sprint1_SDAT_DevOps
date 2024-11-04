package com.keyin.passengers;
import com.keyin.cities.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class PassengersService {

    @Autowired
    private PassengersRepository passengersRepository;

    public Passengers addPassenger(Passengers passengers) {
        return passengersRepository.save(passengers);
    }

    public Iterable<Passengers> getAllPassengers() {
        return passengersRepository.findAll();
    }

    public Optional<Passengers> findByPassengerID(Long passengerID) {
        return passengersRepository.findByPassengerID(passengerID);
    }

    public Iterable<Passengers> findByAircraftID(Long aircraftID) {
        return passengersRepository.findPassengerByAircraftID(aircraftID);
    }

    public Passengers updatePassenger(Long passengerID, Passengers updatedPassenger) {
        return passengersRepository.findByPassengerID(passengerID).map(passenger -> {
            passenger.setPassengerName(updatedPassenger.getPassengerName());
            passenger.setPassengerAddress(updatedPassenger.getPassengerAddress());
            passenger.setPassengerEmail(updatedPassenger.getPassengerEmail());
            passenger.setPassengerPhone(updatedPassenger.getPassengerPhone());
            passenger.setAircrafts(updatedPassenger.getAircrafts());

            return passengersRepository.save(passenger);
        }).orElseThrow(() -> new RuntimeException("Passenger not found with id " + passengerID));
    }

    public boolean deletePassenger(Long passengerID) {
        if(passengersRepository.existsById(passengerID)) {
            passengersRepository.deleteById(passengerID);
        }else{
            throw new RuntimeException("Passenger not found with id " + passengerID);
        }
        return false;
    }



}
