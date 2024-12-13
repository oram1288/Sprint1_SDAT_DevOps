package com.keyin;

import com.keyin.aircraft.Aircraft;
import com.keyin.aircraft.AircraftService;
import com.keyin.aircraft.AircraftRepository;
import com.keyin.airport.Airport;
import com.keyin.airport.AirportService;
import com.keyin.passengers.Passengers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AircraftTest {

    @Mock
    private AircraftRepository aircraftRepository;  // Mock the repository

    @Mock
    private AirportService airportService;  // Mock the airport service

    @InjectMocks
    private AircraftService aircraftService;  // Inject mocks into the service

    private Aircraft aircraft;
    private Airport airport;
    private Passengers passenger;

    @BeforeEach
    void setUp() {
        // Initialize the mocks manually
        MockitoAnnotations.openMocks(this);

        // Setup mock data
        airport = new Airport();
        airport.setAirportId(1L);
        airport.setName("YYZ");

        aircraft = new Aircraft("Boeing 747", "Air Canada", 300, airport);

//        passenger = new Passengers();
//        passenger.setName("John Doe");
    }

    @Test
    void testAddAircraft() {
        // Arrange: Mock the repository to return the aircraft when saving
        when(aircraftRepository.save(any(Aircraft.class))).thenReturn(aircraft);

        // Act: Add the aircraft via the service
        Aircraft result = aircraftService.addAircraft(aircraft);

        // Assert: Verify that the result matches the expected aircraft
        assertNotNull(result);
        assertEquals("Boeing 747", result.getType());
        assertEquals("Air Canada", result.getAirlineName());
        assertEquals(300, result.getNumberOfPassengers());

        // Verify that the repository's save method was called once
        verify(aircraftRepository, times(1)).save(any(Aircraft.class));
    }

    @Test
    void testGetAllAircraft() {
        // Arrange: Mock the repository to return a list of aircraft
        when(aircraftRepository.findAll()).thenReturn(List.of(aircraft));

        // Act: Get all aircraft via the service
        Iterable<Aircraft> result = aircraftService.getAllAircraft();

        // Assert: Verify that the result contains the correct aircraft
        assertNotNull(result);
        assertTrue(result.iterator().hasNext());
        assertEquals("Boeing 747", result.iterator().next().getType());

        // Verify that the repository's findAll method was called once
        verify(aircraftRepository, times(1)).findAll();
    }

    @Test
    void testGetAircraftById() {
        // Arrange: Mock the repository to return an aircraft when searching by ID
        when(aircraftRepository.findById(1L)).thenReturn(Optional.of(aircraft));

        // Act: Get the aircraft by ID via the service
        Optional<Aircraft> result = aircraftService.getAircraftById(1L);

        // Assert: Verify that the result is not empty and contains the correct aircraft
        assertTrue(result.isPresent());
        assertEquals("Boeing 747", result.get().getType());
        assertEquals("Air Canada", result.get().getAirlineName());
        assertEquals(300, result.get().getNumberOfPassengers());

        // Verify that the repository's findById method was called once
        verify(aircraftRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateAircraft() {
        // Arrange: Mock the repository to return the updated aircraft when saving
        Aircraft updatedAircraft = new Aircraft("Boeing 737", "Air Canada", 250, airport);
        when(aircraftRepository.findById(1L)).thenReturn(Optional.of(aircraft));
        when(aircraftRepository.save(any(Aircraft.class))).thenReturn(updatedAircraft);

        // Act: Update the aircraft via the service
        Optional<Aircraft> result = aircraftService.updateAircraft(1L, updatedAircraft);

        // Assert: Verify that the result contains the updated aircraft
        assertTrue(result.isPresent());
        assertEquals("Boeing 737", result.get().getType());
        assertEquals("Air Canada", result.get().getAirlineName());
        assertEquals(250, result.get().getNumberOfPassengers());

        // Verify that the repository's save method was called once
        verify(aircraftRepository, times(1)).save(any(Aircraft.class));
    }

    @Test
    void testDeleteAircraft() {
        // Arrange: Mock the repository to check if the aircraft exists
        when(aircraftRepository.existsById(1L)).thenReturn(true);

        // Act: Delete the aircraft via the service
        boolean result = aircraftService.deleteAircraft(1L);

        // Assert: Verify that the result is true indicating successful deletion
        assertTrue(result);

        // Verify that the repository's deleteById method was called once
        verify(aircraftRepository, times(1)).deleteById(1L);
    }

}