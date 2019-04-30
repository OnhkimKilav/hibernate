package lesson4.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    private List orders;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userOrder")
    public List getOrders() {
        return orders;
    }

    public void setOrders(List orders) {
        this.orders = orders;
    }

    @Id
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    @Column(name = "USER_TYPE")
    public UserType getUserType() {
        return userType;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}
