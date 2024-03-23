package com.siloe.enss.domain.bussiness.person;

import java.util.Objects;

public class Address {

    private String street;
    private Integer number;
    private String neighborhood;
    private String city;
    private State state;

    private Address(String street, Integer number, String neighborhood, String city, State state) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }

    public static Address of(String street, Integer number, String neighborhood, String city, State state){
        Objects.requireNonNull(street, "street must not be null");
        Objects.requireNonNull(neighborhood, "neighborhood must not be null");
        Objects.requireNonNull(city, "city must not be null");
        Objects.requireNonNull(state, "state must not be null");
        return new Address(street, number, neighborhood, city, state);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Address other){
            return Objects.equals(this.street, other.street)
                    && this.number == other.number
                    && Objects.equals(this.neighborhood, other.neighborhood)
                    && Objects.equals(this.city, other.city)
                    && Objects.equals(this.state, other.state);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, neighborhood, city, state);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", state=" + state +
                '}';
    }
}
