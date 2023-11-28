package com.portManagement.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Airport")
@Data
@Getter
@Setter
@Entity
@Builder
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;
    private String city;
    private String port;

    public Airport() {

    }

    public Airport(Long id,String name, String country, String city, String port) {
    }
}
