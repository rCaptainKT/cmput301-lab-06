package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of city objects in a list.
 */
public class CityList {
    private ArrayList<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist.
     * @param city
     * The city object to be added.
     * @throws IllegalArgumentException
     * Throws exception if city already exists in list.
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns the sorted list of cities
     * @return
     * Returns the sorted list of cities
     */
    public List<City> getCities() {
        ArrayList<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks if a city already exists in the list
     * @param city
     * The city object to be checked if in list
     * @return
     * Boolean, whether or not city is already in list
     */
    public boolean hasCity(City city) {
        return this.cities.contains(city);
    }

    /**
     * This removes a city from the list if the city exists in the list
     * @param city
     * The city object to remove.
     * @throws IllegalArgumentException
     * Throws exception if city does not exist in list.
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This returns the number of cities currently stored in the list.
     * @return
     * Returns the number of cities in list.
     */
    public int countCities() {
        return this.cities.size();
    }
}
