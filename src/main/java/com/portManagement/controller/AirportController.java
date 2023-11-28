package com.portManagement.controller;

import com.portManagement.model.Airport;
import com.portManagement.service.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/create")
    public List<Airport> createAirport(){
        return airportService.createAirport();
    }
    @GetMapping("/airports/list")
    public List<Airport> getList(){
        return  airportService.airportList();
    }

    @DeleteMapping("delete/{id}")
    public Boolean deleteAirport(@PathVariable("id") Integer id){
       return airportService.deleteAirport(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable("id") Integer id, @RequestBody Airport airport){
        Airport updateAirport = airportService.updateAirport(id, airport);
        return ResponseEntity.ok(updateAirport);
    }

}