package com.keyin.cities;

import jakarta.persistence.*;

@Entity
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    private String name;

    private String country;

    private String state;

    @OneToMany
    private Airports airports;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Airports getAirport() {
        return airports;
    }

    public void setAirport(Airports airport) {
        this.airports = airport;
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
                "Name:" + name +
                "Country:" + country +
                "State:" + state +
                "Airports" + airports +
                "Weather:" + weather +
                "Population" + population +
                "}";
    }
}

//[
//  {
//    "id": 1,
//    "name": "Toronto",
//    "country": "Canada",
//    "state": "Ontario",
//    "weather": "Sunny",
//    "population": 2930000
//  },
//  {
//    "id": 2,
//    "name": "Vancouver",
//    "country": "Canada",
//    "state": "British Columbia",
//    "weather": "Rainy",
//    "population": 675218
//  },
//  {
//    "id": 3,
//    "name": "Montreal",
//    "country": "Canada",
//    "state": "Quebec",
//    "weather": "Snowy",
//    "population": 1780000
//  },
//  {
//    "id": 4,
//    "name": "Edmonton",
//    "country": "Canada",
//    "state": "Alberta",
//    "weather": "Windy",
//    "population": 1012000
//  },
//  {
//    "id": 5,
//    "name": "Calgary",
//    "country": "Canada",
//    "state": "Alberta",
//    "weather": "Clear",
//    "population": 1239220
//  },
//  {
//    "id": 6,
//    "name": "Los Angeles",
//    "country": "United States",
//    "state": "California",
//    "weather": "Sunny",
//    "population": 3967000
//  },
//  {
//    "id": 7,
//    "name": "Chicago",
//    "country": "United States",
//    "state": "Illinois",
//    "weather": "Windy",
//    "population": 2716000
//  },
//  {
//    "id": 8,
//    "name": "Houston",
//    "country": "United States",
//    "state": "Texas",
//    "weather": "Hot",
//    "population": 2328000
//  },
//  {
//    "id": 9,
//    "name": "Phoenix",
//    "country": "United States",
//    "state": "Arizona",
//    "weather": "Sunny",
//    "population": 1681000
//  },
//  {
//    "id": 10,
//    "name": "London",
//    "country": "United Kingdom",
//    "state": "England",
//    "weather": "Rainy",
//    "population": 8982000
//  }
//]
