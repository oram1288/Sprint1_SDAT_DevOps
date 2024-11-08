package com.keyin.passengers;

import com.keyin.aircraft.Aircraft;
import com.keyin.airport.Airport;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Passengers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerID;
    private String passengerName;
    private String passengerAddress;
    private String passengerPhone;
    private String passengerEmail;

    @ManyToOne
    private Aircraft aircraftId;

//    @ManyToMany
//    private List<Aircraft> aircrafts = new ArrayList<Aircraft>();


    public Passengers() {

    }

    public Long getPassengerID() {
        return passengerID;
    }
    public void setPassengerID(Long passengerID) {
        this.passengerID = passengerID;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    public String getPassengerAddress() {
        return passengerAddress;
    }
    public void setPassengerAddress(String passengerAddress) {
        this.passengerAddress = passengerAddress;
    }
    public String getPassengerPhone() {
        return passengerPhone;
    }
    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }
    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public Aircraft getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Aircraft aircraftId) {
        this.aircraftId = aircraftId;
    }

//    public List<Aircraft> getAircrafts() {
//        return aircrafts;
//    }
//    public void setAircrafts(List<Aircraft> aircrafts) {
//        this.aircrafts = aircrafts;
//    }

    public String toString() {
        return "Passenger: "+ passengerName + ", ID:" + passengerID + ", Address: " + passengerAddress + ", Phone: " + passengerPhone + ", Email: " + passengerEmail;
    }
}
