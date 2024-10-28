package com.keyin.airport;

import com.keyin.aircraft.Aircraft;
import com.keyin.cities.Cities;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private Cities city;

    @ManyToMany(mappedBy = "airports")
    private List<Aircraft> aircrafts = new ArrayList<>();

    // Constructors
    public Airport() {}

    public Airport(String name, String code, Cities city) {
        this.name = name;
        this.code = code;
        this.city = city;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    // toString method
    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", city=" + city.getCity() +
                '}';
    }
}
