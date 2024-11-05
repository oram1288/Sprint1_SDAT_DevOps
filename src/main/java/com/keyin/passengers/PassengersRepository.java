package com.keyin.passengers;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersRepository extends CrudRepository<Passengers, Long> {
    Iterable<Passengers> findPassengerByAircraftID(Long aircraftID);
    Optional<Passengers> findByPassengerID(Long passengerID);
}
