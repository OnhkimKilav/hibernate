package lesson4.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "HOTEL")
public class Hotel {
    private long id;
    private String name;
    private String country;
    private String city;
    private String street;

    private List rooms;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    public List getRooms() {
        return rooms;
    }

    public void setRooms(List rooms) {
        this.rooms = rooms;
    }

    @Id
    @SequenceGenerator(name = "HOTEL_SEQ", sequenceName = "HOTEL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTEL_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
