package com.keyin.passengers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PassengersRepositoryTest {

    @Autowired
    private PassengersRepository passengersRepository;

    @BeforeEach
    public void setup() {
        passengersRepository.deleteAll();
    }

    @Test
    public void testSavePassenger() {
        Passengers passenger = new Passengers();
        passenger.setPassengerName("David Green");
        passenger.setPassengerAddress("999 Oak St");
        passenger.setPassengerPhone("555-1122");
        passenger.setPassengerEmail("david@example.com");

        Passengers savedPassenger = passengersRepository.save(passenger);
        assertNotNull(savedPassenger.getPassengerID());
        assertEquals("David Green", savedPassenger.getPassengerName());
    }

    @Test
    public void testFindByPassengerID() {
        Passengers passenger = new Passengers();
        passenger.setPassengerName("Emma White");
        passenger.setPassengerAddress("987 Cedar St");
        passenger.setPassengerPhone("555-2233");
        passenger.setPassengerEmail("emma@example.com");

        // Save the passenger to the repository
        Passengers savedPassenger = passengersRepository.save(passenger);

        // Retrieve the passenger by their ID
        Passengers foundPassenger = passengersRepository.findById(savedPassenger.getPassengerID()).orElse(null);

        // Validate that the passenger was retrieved successfully
        assertNotNull(foundPassenger);
        assertEquals("Emma White", foundPassenger.getPassengerName());
    }
}