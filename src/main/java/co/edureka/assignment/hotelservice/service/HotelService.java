package co.edureka.assignment.hotelservice.service;

import co.edureka.assignment.hotelservice.data.Hotel;
import co.edureka.assignment.hotelservice.exception.ResourceAlreadyExistedException;
import co.edureka.assignment.hotelservice.repository.HotelRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Page<Hotel> getHotels(Pageable pageable) {
        return hotelRepository.findAll(pageable);
    }

    public Hotel addHotel(Hotel hotel) {
        try {
            return hotelRepository.save(hotel);
        } catch (DataIntegrityViolationException ex) {
            if (ex.getCause() instanceof ConstraintViolationException)
                throw new ResourceAlreadyExistedException("Hotel with given name and city already existed!");
            else
                throw ex;
        }
    }
}
