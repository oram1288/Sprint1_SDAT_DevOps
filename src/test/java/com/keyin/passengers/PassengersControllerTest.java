package com.keyin.passengers;

import com.keyin.aircraft.Aircraft;
import com.keyin.aircraft.AircraftService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PassengersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PassengersRepository passengersRepository;

    @Autowired
    private AircraftService aircraftService;

    @BeforeEach
    public void setup() {
        // Clear any existing data in the repository before each test
        passengersRepository.deleteAll();
    }

    @Test
    public void testCreatePassenger() throws Exception {
        // Create a new passenger and aircraft
        Aircraft aircraft = new Aircraft();
        aircraft.setType("Boeing 737");
        aircraft.setAirlineName("Boeing");
        aircraftService.addAircraft(aircraft);

        String passengerJson = "{ \"passengerName\": \"John Doe\", \"passengerAddress\": \"123 Main St\", \"passengerPhone\": \"555-1234\", \"passengerEmail\": \"john@example.com\", \"aircraftId\": {\"aircraftId\": \"1\"}}";

        mockMvc.perform(post("/addNewPassenger")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(passengerJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.passengerName").value("John Doe"));
    }

    @Test
    public void testGetAllPassengers() throws Exception {
        // Add a sample passenger
        Aircraft aircraft = new Aircraft();
        aircraft.setType("Airbus A320");
        aircraft.setAirlineName("Airbus");
        aircraftService.addAircraft(aircraft);

        Passengers passenger = new Passengers();
        passenger.setPassengerName("Jane Doe");
        passenger.setPassengerAddress("456 Oak St");
        passenger.setPassengerPhone("555-6789");
        passenger.setPassengerEmail("jane@example.com");
        passenger.setAircraftId(aircraft);
        passengersRepository.save(passenger);

        mockMvc.perform(get("/getAllPassengers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].passengerName").value("Jane Doe"));
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

