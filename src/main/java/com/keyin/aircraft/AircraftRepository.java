package com.keyin.aircraft;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
    Iterable<Aircraft> findAircraftByAirports_airportId(Long airportId);
}