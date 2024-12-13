package com.keyin.passengers;

import com.keyin.aircraft.Aircraft;
import com.keyin.aircraft.AircraftRepository;
import com.keyin.aircraft.AircraftService;
import com.keyin.cities.Cities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PassengersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PassengersRepository passengersRepository;

    @InjectMocks
    private PassengersService passengersService;

    @Autowired
    private AircraftService aircraftService;
    @Autowired
    private AircraftRepository aircraftRepository;

    @BeforeEach
    public void setup() {
        // Clear any existing data in the repository before each test
        passengersRepository.deleteAll();
    }

//    @Test
//    public void testCreatePassenger() throws Exception {
//        // Create a new passenger and aircraft
//        Aircraft aircraft = new Aircraft();
//        aircraft.setType("Boeing 200");
//        aircraft.setAirlineName("Boeing");
//        aircraftService.addAircraft(aircraft);
//
//        String passengerJson = "{ \"passengerName\": \"John Doe\", \"passengerAddress\": \"123 Main St\", \"passengerPhone\": \"555-1234\", \"passengerEmail\": \"john@example.com\", \"aircraftId\": { \"aircraftId\": \"1L\"}}";
//
//        mockMvc.perform(post("/addNewPassenger")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(passengerJson))
//                .andExpect(jsonPath("$.passengerName").value("John Doe"))
//                .andExpect(status().isOk());
//
//    }
    @Test
     void testCreatePassenger() throws Exception {
        Aircraft aircraft = new Aircraft();
        aircraft.setAircraftId(1L);
        Passengers passenger = new Passengers();
        passenger.setPassengerID(1L);
        passenger.setPassengerName("Kyle");
        passenger.setPassengerEmail("kyle@x");
        passenger.setPassengerPhone("1234556");
        passenger.setPassengerAddress("123 Main St");
        passenger.setAircraftId(aircraft);

        when(passengersRepository.save(passenger)).thenReturn(passenger);

        Passengers result = passengersService.addPassenger(passenger);

        assertEquals("Kyle", result.getPassengerName());
        assertEquals("123 Main St", result.getPassengerAddress());
        verify(passengersRepository, times(1)).save(passenger);
     }

    @Test
    public void testGetAllPassengers() throws Exception {
        // Add a sample passenger
        Aircraft aircraft = new Aircraft();
        aircraft.setType("Airbus A320");
        aircraft.setAirlineName("Airbus");
        aircraftService.addAircraft(aircraft);

        Passengers passenger = new Passengers();
        passenger.setPassengerName("Samuel Johnson");
        passenger.setPassengerAddress("456 Oak St");
        passenger.setPassengerPhone("555-6789");
        passenger.setPassengerEmail("sam@example.com");
        passenger.setAircraftId(aircraft);
        passengersRepository.save(passenger);

        mockMvc.perform(get("/getAllPassengers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].passengerName").value("Samuel Johnson"));
    }

    @Test
    public void testDeletePassenger() throws Exception {
        // Add a sample passenger
        Aircraft aircraft = new Aircraft();
        aircraft.setType("Boeing 747");
        aircraft.setAirlineName("Boeing");
        aircraftService.addAircraft(aircraft);

        Passengers passenger = new Passengers();
        passenger.setPassengerName("Alice");
        passenger.setPassengerAddress("789 Pine St");
        passenger.setPassengerPhone("555-9876");
        passenger.setPassengerEmail("alice@example.com");
        passenger.setAircraftId(aircraft);
        passengersRepository.save(passenger);

        mockMvc.perform(delete("/deletePassengerByID/" + passenger.getPassengerID()))
                .andExpect(status().isNoContent());
    }
}

