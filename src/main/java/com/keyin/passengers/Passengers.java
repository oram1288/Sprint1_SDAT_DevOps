package com.keyin.passengers;

public class Passengers {
    private int passengerID;
    private String passengerName;
    private String passengerAddress;
    private String passengerPhone;
    private String passengerEmail;

    public Passengers() {

    }

    public int getPassengerID() {
        return passengerID;
    }
    public void setPassengerID(int passengerID) {
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

    public String toString() {
        return "Passenger: "+ passengerName + ", ID:" + passengerID + ", Address: " + passengerAddress + ", Phone: " + passengerPhone + ", Email: " + passengerEmail;
    }
}
