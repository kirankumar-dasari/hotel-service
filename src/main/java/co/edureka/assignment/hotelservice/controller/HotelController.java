package co.edureka.assignment.hotelservice.controller;

import co.edureka.assignment.hotelservice.data.Hotel;
import co.edureka.assignment.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HotelController {
    @Autowired
    private HotelService hotelService;

    private Link linkToHotels = linkTo(methodOn(this.getClass()).getHotels(null, null)).withRel("hotels");

    @GetMapping(path = "/hotels")
    public ResponseEntity<PagedResources<?>> getHotels(Pageable pageable, PagedResourcesAssembler<Hotel> assembler) {
        return new ResponseEntity<PagedResources<?>>(assembler.toResource(hotelService.getHotels(pageable)), HttpStatus.OK);
    }

    @PostMapping(path = "/hotels")
    public ResponseEntity<Resource<Hotel>> addHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<Resource<Hotel>>(
                new Resource<Hotel>(hotelService.addHotel(hotel), linkToHotels), null, HttpStatus.CREATED);
    }
}
