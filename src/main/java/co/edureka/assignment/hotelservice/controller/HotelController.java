package co.edureka.assignment.hotelservice.controller;

import co.edureka.assignment.hotelservice.model.Hotel;
import co.edureka.assignment.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class HotelController {
    @Autowired
    private HotelService service;

    @GetMapping(path = "/hotels")
    public List<Hotel> getHotels() {
        return service.findAll();
    }

    @PostMapping(path = "/hotels")
    public ResponseEntity<Object> addHotel(@RequestBody Hotel hotel){
        Hotel savedHotel = service.save(hotel);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedHotel.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
