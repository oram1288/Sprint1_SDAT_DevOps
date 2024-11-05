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

    public Cities(String cityName, String country, String state, List<Airport> airports, String weather, String population) {
        this.cityName = cityName;
        this.country = country;
        this.state = state;
        this.airports = airports;
        this.weather = weather;
        this.population = population;
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

//{
//        "name": "Edmonton International Airport",
//        "code": "YEG",
//        "cityName": "Edmonton",
//        "aircrafts": ["Boeing 737", "Airbus A320", "Bombardier Q400", "Embraer E175"]
//        },
//        {
//        "name": "George Bush Intercontinental Airport",
//        "code": "IAH",
//        "cityName": "Houston",
//        "aircrafts": ["Boeing 777", "Airbus A330", "Boeing 787", "Airbus A321"]
//        },
//        {
//        "name": "Phoenix Sky Harbor International Airport",
//        "code": "PHX",
//        "cityName": "Phoenix",
//        "aircrafts": ["Airbus A320", "Boeing 737", "Embraer E190", "Airbus A321"]
//        },
//        {
//        "name": "Heathrow Airport",
//        "code": "LHR",
//        "cityName": "London",
//        "aircrafts": ["Airbus A380", "Boeing 787", "Boeing 777", "Airbus A350"]
//        }


//[
//  {
//    "cityName": "Toronto",
//    "country": "Canada",
//    "state": "Ontario",
//    "airports": [],
//    "weather": "Sunny",
//    "population": 2930000
//  },
//  {
//    "cityName": "Vancouver",
//    "country": "Canada",
//    "state": "British Columbia",
//    "airports": [],
//    "weather": "Rainy",
//    "population": 675218
//  },
//  {
//    "cityName": "Montreal",
//    "country": "Canada",
//    "state": "Quebec",
//    "airports": [],
//    "weather": "Snowy",
//    "population": 1780000
//  },
//  {
//    "cityName": "Edmonton",
//    "country": "Canada",
//    "state": "Alberta",
//    "airports": [],
//    "weather": "Windy",
//    "population": 1012000
//  },
//  {
//    "cityName": "Orlando",
//    "country": "United States",
//    "state": "Florida",
//    "airports": [],
//    "weather": "Clear",
//    "population": 1239220
//  },
//  {
//    "cityName": "Los Angeles",
//    "country": "United States",
//    "state": "California",
//    "airports": [],
//    "weather": "Sunny",
//    "population": 3967000
//  },
//  {
//    "cityName": "Chicago",
//    "country": "United States",
//    "state": "Illinois",
//    "airports": [],
//    "weather": "Windy",
//    "population": 2716000
//  },
//  {
//    "cityName": "Houston",
//    "country": "United States",
//    "state": "Texas",
//    "airports": [],
//    "weather": "Cloudy",
//    "population": 2328000
//  },
//  {
//    "cityName": "Phoenix",
//    "country": "United States",
//    "state": "Arizona",
//    "airports": [],
//    "weather": "Sunny",
//    "population": 1681000
//  },
//  {
//    "cityName": "London",
//    "country": "United Kingdom",
//    "state": "England",
//    "airports": [],
//    "weather": "Rainy",
//    "population": 8982000
//  }
//]
