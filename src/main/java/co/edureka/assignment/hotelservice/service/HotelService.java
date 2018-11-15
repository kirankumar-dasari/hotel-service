package co.edureka.assignment.hotelservice.service;

import co.edureka.assignment.hotelservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelService extends JpaRepository<Hotel, Long> {
}
