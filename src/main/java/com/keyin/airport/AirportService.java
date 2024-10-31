package com.keyin.airport;

import com.keyin.cities.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CitiesRepository citiesRepository;

    public Iterable<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    public Optional<Airport> createAirport(Airport airport) {
        if (airport.getCityName() != null && citiesRepository.existsById(airport.getCityName().getCityId())) {
            return Optional.of(airportRepository.save(airport));
        }
        return Optional.empty();
    }

    public Optional<Airport> updateAirport(Long id, Airport updatedAirport) {
        return airportRepository.findById(id).map(airport -> {
            airport.setName(updatedAirport.getName());
            airport.setCode(updatedAirport.getCode());
            airport.setCityName(updatedAirport.getCityName());
            return airportRepository.save(airport);
        });
    }

    public boolean deleteAirport(Long id) {
        if (airportRepository.existsById(id)) {
            airportRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Airport> getAirportsByCityId(Long cityId) {
        if (citiesRepository.existsById(cityId)) {
            return airportRepository.findByCityId(cityId);
        }
        return List.of();
    }
}
