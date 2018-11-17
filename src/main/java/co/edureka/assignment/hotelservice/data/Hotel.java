package co.edureka.assignment.hotelservice.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "city"}))
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    private String name;
    private String description;
    private String city;
    private int rating;
}
