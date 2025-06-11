package org.me.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StorePlace {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int zipCode;
    private String city;
    private String street;

    public StorePlace(String name, int zipCode, String city, String street) {
        this.name = name;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
    }

    public StorePlace() {

    }
}
