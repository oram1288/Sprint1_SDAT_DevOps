package com.keyin.aircraft;

import com.keyin.airport.Airport;
import com.keyin.cities.Cities;
import com.keyin.passengers.Passengers;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aircraftId;

    private String type;
    private String airlineName;
    private int numberOfPassengers;

    @ManyToOne
    private Airport airportId;

    @ManyToOne
    private Passengers passengerID;

    @ManyToMany
    private List<Airport> airports = new ArrayList<Airport>();

    @OneToMany
    private List<Passengers> passengers = new ArrayList<>();

    // Constructors
    public Aircraft() {}

    public Aircraft(String type, String airlineName, int numberOfPassengers, Airport airportId) {
        this.type = type;
        this.airlineName = airlineName;
        this.numberOfPassengers = numberOfPassengers;
        this.airportId = airportId;
    }

    // Getters and Setters

    public Long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public Airport getAirportId() {
        return airportId;
    }

    public void setAirportId(Airport airportId) {
        this.airportId = airportId;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public Passengers getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Passengers passengerID) {
        this.passengerID = passengerID;
    }

    public List<Passengers> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passengers> passengers) {
        this.passengers = passengers;
    }

    // toString method
    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + aircraftId +
                ", type='" + type + '\'' +
                ", airlineName='" + airlineName + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }
}
