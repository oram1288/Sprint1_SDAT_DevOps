package com.keyin.cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitiesService {

    @Autowired
    private CitiesRepository citiesRepository;

    public Cities addCity(Cities cities) {
        return citiesRepository.save(cities);
    }

    public Iterable<Cities> getAllCities() {
        return citiesRepository.findAll();
    }

    public Iterable<Cities> findByAirport(String name) {
        return citiesRepository.findCityByAirportName(name);
    }
}
