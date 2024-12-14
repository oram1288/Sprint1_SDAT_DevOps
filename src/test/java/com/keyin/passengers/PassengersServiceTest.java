package com.keyin.passengers;
import com.keyin.aircraft.Aircraft;
import com.keyin.aircraft.AircraftService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PassengersServiceTest {

    @Autowired
    private PassengersService passengersService;

    @Autowired
    private PassengersRepository passengersRepository;

    @Autowired
    private AircraftService aircraftService;

    @BeforeEach
    public void setup() {
        passengersRepository.deleteAll();
    }

    @Test
    public void testAddPassenger() {
        // Create an aircraft
        Aircraft aircraft = new Aircraft();
        aircraft.setType("Boeing 737");
        aircraft.setAirlineName("Boeing");
        aircraftService.addAircraft(aircraft);

        // Create a new passenger
        Passengers passenger = new Passengers();
        passenger.setPassengerName("Mark Smith");
        passenger.setPassengerAddress("123 Elm St");
        passenger.setPassengerPhone("555-3456");
        passenger.setPassengerEmail("mark@example.com");
        passenger.setAircraftId(aircraft);

        // Save passenger and assert it is saved
        Passengers savedPassenger = passengersService.addPassenger(passenger);
        assertNotNull(savedPassenger.getPassengerID());
        assertEquals("Mark Smith", savedPassenger.getPassengerName());
    }

    @Test
    public void testFindByPassengerID() {
        // Add passenger
        Aircraft aircraft = new Aircraft();
        aircraft.setType("Airbus A320");
        aircraft.setAirlineName("Airbus");
        aircraftService.addAircraft(aircraft);

        Passengers passenger = new Passengers();
        passenger.setPassengerName("Samuel Johnson");
        passenger.setPassengerAddress("321 Maple Ave");
        passenger.setPassengerPhone("555-7890");
        passenger.setPassengerEmail("samuel@example.com");
        passenger.setAircraftId(aircraft);
        passengersRepository.save(passenger);

        // Test finding passenger by ID
        Passengers foundPassenger = passengersService.findByPassengerID(passenger.getPassengerID()).orElseThrow();
        assertEquals("Samuel Johnson", foundPassenger.getPassengerName());
    }

//    @Test
//    public void testDeletePassenger() {
//        // Add passenger
//        Aircraft aircraft = new Aircraft();
//        aircraft.setType("Boeing 787");
//        aircraft.setAirlineName("Boeing");
//        aircraftService.addAircraft(aircraft);
//
//        Passengers passenger = new Passengers();
//        passenger.setPassengerName("Laura Brown");
//        passenger.setPassengerAddress("654 Birch Rd");
//        passenger.setPassengerPhone("555-4321");
//        passenger.setPassengerEmail("laura@example.com");
//        passenger.setAircraftId(aircraft);
//        passengersRepository.save(passenger);
//
//        // Test delete passenger
//        boolean deleted = passengersService.deletePassenger(passenger.getPassengerID());
//        assertTrue(deleted);
//        assertFalse(passengersRepository.existsById(passenger.getPassengerID()));
//    }
}

