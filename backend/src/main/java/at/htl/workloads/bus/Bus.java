package at.htl.workloads.bus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    private Integer seatCapacity;
    private Double fuelCapacity;
    private Double actualFuel;

    //region gettersetter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public Integer getSeatCapacity() {
        return seatCapacity;
    }
    public void setSeatCapacity(Integer seatCapacity) {
        this.seatCapacity = seatCapacity;
    }
    public Double getFuelCapacity() {
        return fuelCapacity;
    }
    public void setFuelCapacity(Double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
    public Double getActualFuel() {
        return actualFuel;
    }
    public void setActualFuel(Double actualFuel) {
        this.actualFuel = actualFuel;
    }
    //endregion


    //region constructor
    public Bus(String mark, Integer seatCapacity, Double fuelCapacity, Double actualFuel) {
        this.mark = mark;
        this.seatCapacity = seatCapacity;
        this.fuelCapacity = fuelCapacity;
        this.actualFuel = actualFuel;
    }
    public Bus() {
    }
    //endregion
}
