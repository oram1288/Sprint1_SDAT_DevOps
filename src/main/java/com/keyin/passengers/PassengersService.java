package com.keyin.passengers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Iterable<Passengers> findByPassengerName(String name) {
        return passengersRepository.findByPassengerName(name);
    }


}
