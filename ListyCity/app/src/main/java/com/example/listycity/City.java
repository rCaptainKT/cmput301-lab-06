package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    @Override
    public int compareTo(City city) {
        return this.name.compareTo(city.getName());
    }
}
