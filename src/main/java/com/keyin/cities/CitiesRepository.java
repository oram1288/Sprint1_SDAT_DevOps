package com.keyin.cities;

import org.springframework.data.repository.CrudRepository;

public interface CitiesRepository extends CrudRepository<Cities, Long> {
    Iterable<Cities> findCitiesByAirportName(String airports_airportsName);
}
