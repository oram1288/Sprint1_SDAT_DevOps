package com.keyin;

import com.keyin.cities.Cities;
import com.keyin.cities.CitiesRepository;
import com.keyin.cities.CitiesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CityTest {

    @Mock
    private CitiesRepository citiesRepository;

    @InjectMocks
    private CitiesService citiesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddCity() {
        Cities city = new Cities();
        city.setCityId(1L);
        city.setCityName("Calgary");
        city.setCountry("Canada");
        city.setState("Alberta");
        city.setWeather("Sunny");
        city.setPopulation("925284");
        city.setAirports(new ArrayList<>());

        when(citiesRepository.save(city)).thenReturn(city);

        Cities result = citiesService.addCity(city);

        assertEquals("Calgary", result.getCityName());
        assertEquals("Sunny", result.getWeather());
        verify(citiesRepository, times(1)).save(city);
    }

    @Test
    void testGetAllCities() {
        Cities city1 = new Cities();
        city1.setCityId(3L);
        city1.setCityName("Toronto");
        city1.setCountry("Canada");

        Cities city2 = new Cities();
        city2.setCityId(6L);
        city2.setCityName("Montreal");
        city2.setCountry("Canada");

        when(citiesRepository.findAll()).thenReturn(Arrays.asList(city1, city2));

        Iterable<Cities> result = citiesService.getAllCities();

        assertNotNull(result);
        assertEquals(2, ((Collection<?>) result).size());
        verify(citiesRepository, times(1)).findAll();
    }

    @Test
    void testDeleteCity() {
        when(citiesRepository.existsById(1L)).thenReturn(true);

        boolean result = citiesService.deleteCity(1L);

        assertFalse(result); // this always returns false
        verify(citiesRepository, times(1)).existsById(1L);
        verify(citiesRepository, times(1)).deleteById(1L);
    }
}
