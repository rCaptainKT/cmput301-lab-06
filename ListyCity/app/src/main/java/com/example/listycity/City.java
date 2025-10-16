package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String name;
    private String province;

    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    public String getProvince() {
        return this.province;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Lexicographically compares two City objects using their name String
     * @param city
     * The City object to be compared.
     * @return
     * Returns 0 if argument name String matches this name String;
     * a value less than 0 if this name String is lexicographically less than the argument Name string;
     * and a value greater than 0 if this name String is lexicographically greater than the argument name String.
     */
    @Override
    public int compareTo(City city) {
        return this.name.compareTo(city.getName());
    }

    /**
     * Generates a hash code for the Object.
     * @return
     * Returns a hash code that represents the Object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, province);
    }

    /**
     * Checks if an object is equal to a City object. Compares their name String and province String.
     * @param o
     * Object to be compared
     * @return
     * Returns if Object is equal to City object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            // Same object reference
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        City city = (City) o;
        return this.name.equals(city.getName()) && this.province.equals(city.getProvince());
    }
}
