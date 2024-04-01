package com.siloe.enss.infraestructure.presentation;


import com.siloe.enss.domain.bussiness.person.Address;
import com.siloe.enss.domain.bussiness.person.State;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "address")
public class AddressPresentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;
    private String neighborhood;
    private String city;
    @Enumerated(EnumType.STRING)
    private State state;

    public AddressPresentation(){}
    private AddressPresentation(Long id, String street, Integer number, String neighborhood, String city, State state) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }

    public static AddressPresentation of(Long id, String street, Integer number, String neighborhood, String city, State state){
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(street, "street must not be null");
        Objects.requireNonNull(neighborhood, "neighborhood must not be null");
        Objects.requireNonNull(city, "city must not be null");
        Objects.requireNonNull(state, "state must not be null");
        return new AddressPresentation(id, street, number, neighborhood, city, state);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AddressPresentation other){
            return Objects.equals(this.id, other.id)
                    && Objects.equals(this.street, other.street)
                    && Objects.equals(this.number, other.number)
                    && Objects.equals(this.neighborhood, other.neighborhood)
                    && Objects.equals(this.city, other.city)
                    && Objects.equals(this.state, other.state);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, number, neighborhood, city, state);
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
