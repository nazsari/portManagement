package com.portManagement.service;

import com.portManagement.model.Airport;
import com.portManagement.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AirportService {

    List<Airport> airports;

    private final AirportRepository airportRepository;


    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> createAirport(){
        airports = new ArrayList<Airport>();
        Airport airport1 = new Airport();
        airport1.setName("Istanbul Havalimanı");
        airport1.setCountry("Turkiye");
        airport1.setCity("Istanbul");
        airport1.setPort("IST");
        airports.add(airport1);

        Airport airport2 = new Airport();
        airport2.setName("Ankara Havalimanı");
        airport2.setCountry("Turkiye");
        airport2.setCity("Ankara");
        airport2.setPort("ANH");
        airports.add(airport2);

        Airport airport3 = new Airport();
        airport3.setName("Kocaeli Havalimanı");
        airport3.setCountry("Turkiye");
        airport3.setCity("Kocaeli");
        airport3.setPort("KCH");
        airports.add(airport3);

        Airport airport4 = new Airport();
        airport4.setName("Muş Havalimanı");
        airport4.setCountry("Turkiye");
        airport4.setCity("Muş");
        airport4.setPort("MUH");
        airports.add(airport4);

        return airportRepository.saveAll(airports);
    }

    public List<Airport> airportList() {
        return airports;

    }

    public Boolean deleteAirport(Integer id) {
        Optional<Airport> model = airportRepository.findById(id);
        if(model.isPresent()){
        airportRepository.deleteById(id);
        return true;
    }
        return false;
    }


    public Airport updateAirport(Integer id, Airport airport){
        Optional<Airport> resultAirport = airportRepository.findById(id);
        if(resultAirport.isPresent()){
            resultAirport.get().setName(airport.getName());
            resultAirport.get().setPort(airport.getPort());
            resultAirport.get().setCity(airport.getCity());
            resultAirport.get().setCountry(airport.getCountry());
            return airportRepository.save(airport);
        }
        return null;
    }


}
