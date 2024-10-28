package com.keyin.cities;

import jakarta.persistence.*;

@Entity
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    private String city;

    private String country;

    private String state;

    @OneToMany
    private Airport airports;

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

    public String getCity() {
        return city;
    }

    public void setCity(String name) {
        this.city = city;
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

    public Airport getAirport() {
        return airports;
    }

    public void setAirport(Airport airport) {
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
                "City:" + city +
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
//    "city": "Toronto",
//    "country": "Canada",
//    "state": "Ontario",
//    "weather": "Sunny",
//    "population": 2930000
//  },
//  {
//    "id": 2,
//    "city": "Vancouver",
//    "country": "Canada",
//    "state": "British Columbia",
//    "weather": "Rainy",
//    "population": 675218
//  },
//  {
//    "id": 3,
//    "city": "Montreal",
//    "country": "Canada",
//    "state": "Quebec",
//    "weather": "Snowy",
//    "population": 1780000
//  },
//  {
//    "id": 4,
//    "city": "Edmonton",
//    "country": "Canada",
//    "state": "Alberta",
//    "weather": "Windy",
//    "population": 1012000
//  },
//  {
//    "id": 5,
//    "city": "Calgary",
//    "country": "Canada",
//    "state": "Alberta",
//    "weather": "Clear",
//    "population": 1239220
//  },
//  {
//    "id": 6,
//    "city": "Los Angeles",
//    "country": "United States",
//    "state": "California",
//    "weather": "Sunny",
//    "population": 3967000
//  },
//  {
//    "id": 7,
//    "city": "Chicago",
//    "country": "United States",
//    "state": "Illinois",
//    "weather": "Windy",
//    "population": 2716000
//  },
//  {
//    "id": 8,
//    "city": "Houston",
//    "country": "United States",
//    "state": "Texas",
//    "weather": "Hot",
//    "population": 2328000
//  },
//  {
//    "id": 9,
//    "city": "Phoenix",
//    "country": "United States",
//    "state": "Arizona",
//    "weather": "Sunny",
//    "population": 1681000
//  },
//  {
//    "id": 10,
//    "city": "London",
//    "country": "United Kingdom",
//    "state": "England",
//    "weather": "Rainy",
//    "population": 8982000
//  }
//]
