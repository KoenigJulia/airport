package at.htl.workloads.luggage;

import at.htl.workloads.ticket.Ticket;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
public class Luggage {

    public static final double SIZE_SMALL_PRICE = 10;
    public static final double SIZE_MEDIUM_PRICE = 50;
    public static final double SIZE_LARGE_PRICE = 100;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double weight;
    private Size size;
    private String luggageNumber;
//    @JsonbTransient
//    @ManyToOne
//    private Ticket ticket;

    //region constructor
    public Luggage() {
    }
    public Luggage(Double weight, Size size, String luggageNumber) {
        this.weight = weight;
        this.size = size;
        this.luggageNumber = luggageNumber;
    }
    //endregion
    //region gettersetter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }
    public String getLuggageNumber() {
        return luggageNumber;
    }
    public void setLuggageNumber(String luggageNumber) {
        this.luggageNumber = luggageNumber;
    }
    //endregion
}
