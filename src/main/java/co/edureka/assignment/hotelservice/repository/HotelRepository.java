package co.edureka.assignment.hotelservice.repository;

import co.edureka.assignment.hotelservice.data.Hotel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {
}
