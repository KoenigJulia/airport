package at.htl.workloads.travelclass;

import javax.persistence.*;

@Entity
public class Travelclass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private boolean legroom;
    private boolean entertainment;
    private boolean cabinLuggage;

    //region constructor
    public Travelclass(String name, Double price, boolean legroom, boolean entertainment, boolean cabinLuggage) {
        this.name = name;
        this.price = price;
        this.legroom = legroom;
        this.entertainment = entertainment;
        this.cabinLuggage = cabinLuggage;
    }

    public Travelclass() {
    }
    //endregion

    //region gettersetter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public boolean isLegroom() {
        return legroom;
    }
    public void setLegroom(boolean legroom) {
        this.legroom = legroom;
    }
    public boolean isEntertainment() {
        return entertainment;
    }
    public void setEntertainment(boolean entertainment) {
        this.entertainment = entertainment;
    }
    public boolean isCabinLuggage() {
        return cabinLuggage;
    }
    public void setCabinLuggage(boolean cabinLuggage) {
        this.cabinLuggage = cabinLuggage;
    }
    //endregion
}