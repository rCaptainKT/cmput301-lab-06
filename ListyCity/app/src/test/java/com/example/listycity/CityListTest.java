package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testEquals() {
        City city1 = new City("Calgary", "Alberta");
        City city2 = new City("Calgary", "Alberta");
        City city3 = new City("Edmonton", "Alberta");

        assertEquals(city1, city2);
        assertNotEquals(city1, city3);
        assertNotEquals(city2, city3);
    }

    @Test
    void testHashCode() {
        City city1 = new City("Calgary", "Alberta");
        City city2 = new City("Calgary", "Alberta");
        City city3 = new City("Edmonton", "Alberta");

        assertEquals(city1.hashCode() , city2.hashCode());
        assertNotEquals(city1.hashCode(), city3.hashCode());
        assertNotEquals(city2.hashCode(), city3.hashCode());
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city1 = new City("Calgary", "Alberta");
        City city2 = new City("Calgary", "Alberta");
        cityList.add(city1);

        assertTrue(cityList.hasCity(city1));
        assertTrue(cityList.hasCity(city2));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city1 = new City("Regina", "Saskatchewan");
        City city2 = new City("Calgary", "Alberta");
        cityList.add(city1);
        cityList.add(city2);
        assertEquals(3, cityList.getCities().size());

        cityList.delete(city2);
        assertFalse(cityList.getCities().contains(city2));
        assertEquals(2, cityList.getCities().size());

        cityList.delete(city1);
        assertFalse(cityList.getCities().contains(city1));
        assertEquals(1, cityList.getCities().size());
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        assertNotEquals(2, cityList.countCities());
    }
}
