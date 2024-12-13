package com.keyin;

import com.keyin.airport.Airport;
import com.keyin.airport.AirportRepository;
import com.keyin.airport.AirportService;
import com.keyin.cities.Cities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AirportTest {

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private AirportService airportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddAirport() {
        Cities city = new Cities();
        city.setCityId(1L);
        city.setCityName("Calgary");

        Airport airport = new Airport();
        airport.setAirportId(1L);
        airport.setName("YYC");
        airport.setCode("CAL");
        airport.setCityName(city);

        when(airportRepository.save(airport)).thenReturn(airport);

        Airport result = airportService.addAirport(airport);

        assertEquals("YYC", result.getName());
        assertEquals("CAL", result.getCode());
        assertEquals("Calgary", result.getCityName().getCityName());
        verify(airportRepository, times(1)).save(airport);
    }

    @Test
    void testGetAllAirports() {
        Airport airport1 = new Airport();
        airport1.setAirportId(1L);
        airport1.setName("YYZ");
        airport1.setCode("TOR");

        Airport airport2 = new Airport();
        airport2.setAirportId(2L);
        airport2.setName("YUL");
        airport2.setCode("MON");

        when(airportRepository.findAll()).thenReturn(Arrays.asList(airport1, airport2));

        Iterable<Airport> result = airportService.getAllAirports();

        assertNotNull(result);
        assertEquals(2, ((Collection<?>) result).size());
        verify(airportRepository, times(1)).findAll();
    }

    @Test
    void testGetAirportById() {
        Airport airport = new Airport();
        airport.setAirportId(1L);
        airport.setName("YYC");

        when(airportRepository.findById(1L)).thenReturn(Optional.of(airport));

        Optional<Airport> result = airportService.getAirportById(1L);

        assertTrue(result.isPresent());
        assertEquals("YYC", result.get().getName());
        verify(airportRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateAirport() {
        Airport existingAirport = new Airport();
        existingAirport.setAirportId(1L);
        existingAirport.setName("YYC");
        existingAirport.setCode("CAL");

        Airport updatedAirport = new Airport();
        updatedAirport.setName("YYC Updated");
        updatedAirport.setCode("CAL Updated");

        when(airportRepository.findById(1L)).thenReturn(Optional.of(existingAirport));
        when(airportRepository.save(existingAirport)).thenReturn(existingAirport);

        Optional<Airport> result = airportService.updateAirport(1L, updatedAirport);

        assertTrue(result.isPresent());
        assertEquals("YYC Updated", result.get().getName());
        assertEquals("CAL Updated", result.get().getCode());
        verify(airportRepository, times(1)).findById(1L);
        verify(airportRepository, times(1)).save(existingAirport);
    }

    @Test
    void testDeleteAirport() {
        when(airportRepository.existsById(1L)).thenReturn(true);

        boolean result = airportService.deleteAirport(1L);

        assertTrue(result);
        verify(airportRepository, times(1)).existsById(1L);
        verify(airportRepository, times(1)).deleteById(1L);
    }

    //@Test
    //void testGetAirportsByCityId() {
       // Airport airport1 = new Airport();
       // airport1.setAirportId(1L);
        //airport1.setName("YYZ");
       // airport1.setCode("TOR");

        //Airport airport2 = new Airport();
        //airport2.setAirportId(2L);
       // airport2.setName("YUL");
       // airport2.setCode("MON");

        //when(airportRepository.findAirportByCityName_cityId(1L)).thenReturn(Arrays.asList(airport1, airport2));

       // Iterable<Airport> result = airportService.getAirportsByCityId(1L);

       // assertNotNull(result);
      //  assertEquals(2, ((Collection<?>) result).size());
    //    verify(airportRepository, times(1)).findAirportByCityName_cityId(1L);
    //}
}
