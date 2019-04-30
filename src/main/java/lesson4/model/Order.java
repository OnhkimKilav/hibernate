package lesson4.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDER")
public class Order {
    private long id;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    private User userOrder;
    @ManyToOne
    @JoinColumn(name = "USER_FK")
    public User getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(User userOrder) {
        this.userOrder = userOrder;
    }

    @Id
    @SequenceGenerator(name = "ORDER_SEQ", sequenceName = "ORDER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ROOM_ID")
    public Room getRoom() {
        return room;
    }

    @Column(name = "DATE_FROM")
    public Date getDateFrom() {
        return dateFrom;
    }

    @Column(name = "DATE_TO")
    public Date getDateTo() {
        return dateTo;
    }

    @Column(name = "MONEY_PAID")
    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }
}
