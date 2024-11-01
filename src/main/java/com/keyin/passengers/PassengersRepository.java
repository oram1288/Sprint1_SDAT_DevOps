package com.keyin.passengers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PassengersRepository extends CrudRepository<Passengers, Long> {
    Iterable<Passengers> findByPassengerName(String passengerName);
}
