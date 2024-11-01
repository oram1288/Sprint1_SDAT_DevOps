package com.keyin.cities;

import com.keyin.airport.Airport;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    private String cityName;

    private String country;

    private String state;

    @OneToMany
    private List<Airport> airports = new ArrayList<Airport>();

    private String weather;

    private String population;

    public Cities() {

    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City {" +
                "Cities Id:" + cityId +
                "City:" + cityName +
                "Country:" + country +
                "State:" + state +
                "Airports" + airports +
                "Weather:" + weather +
                "Population" + population +
                "}";
    }
}

// Toronto Pearson International Airport, Toronto
// Billy Bishop Toronto City Airport, Toronto

// Chicago Midway International Airport, Chicago
// Chicago O'Hare International Airport, Chicago

// Melbourne Orlando International Airport, Orlando
// Orlando International Airport, Orlando

// Montréal–Trudeau International Airport, Montreal
// MET – Montreal Metropolitan Airport, Montreal

// Los Angeles International Airport, Los Angeles
// John Wayne Airport, Los Angeles

//[
//  {
//    "cityName": "Toronto",
//    "country": "Canada",
//    "state": "Ontario",
//    "weather": "Sunny",
//    "population": 2930000
//  },
//  {
//    "cityName": "Vancouver",
//    "country": "Canada",
//    "state": "British Columbia",
//    "weather": "Rainy",
//    "population": 675218
//  },
//  {
//    "cityName": "Montreal",
//    "country": "Canada",
//    "state": "Quebec",
//    "weather": "Snowy",
//    "population": 1780000
//  },
//  {
//    "cityName": "Edmonton",
//    "country": "Canada",
//    "state": "Alberta",
//    "weather": "Windy",
//    "population": 1012000
//  },
//  {
//    "cityName": "Orlando",
//    "country": "United States",
//    "state": "Florida",
//    "weather": "Clear",
//    "population": 1239220
//  },
//  {
//    "cityName": "Los Angeles",
//    "country": "United States",
//    "state": "California",
//    "weather": "Sunny",
//    "population": 3967000
//  },
//  {
//    "cityName": "Chicago",
//    "country": "United States",
//    "state": "Illinois",
//    "weather": "Windy",
//    "population": 2716000
//  },
//  {
//    "cityName": "Houston",
//    "country": "United States",
//    "state": "Texas",
//    "weather": "Cloudy",
//    "population": 2328000
//  },
//  {
//    "cityName": "Phoenix",
//    "country": "United States",
//    "state": "Arizona",
//    "weather": "Sunny",
//    "population": 1681000
//  },
//  {
//    "cityName": "London",
//    "country": "United Kingdom",
//    "state": "England",
//    "weather": "Rainy",
//    "population": 8982000
//  }
//]
