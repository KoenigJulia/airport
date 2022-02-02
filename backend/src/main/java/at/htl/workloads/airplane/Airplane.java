package at.htl.workloads.airplane;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String airplaneNr;
    private Double fuelCapacity;
    private Double actualFuel;
    private Integer seatCapacity;
    private Integer crew;
    private Double maxHeight;
    private Double maxSpeed;

    //region gettersetter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirplaneNr() {
        return airplaneNr;
    }

    public void setAirplaneNr(String airplaneNr) {
        this.airplaneNr = airplaneNr;
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

    public Integer getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Integer seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public Integer getCrew() {
        return crew;
    }

    public void setCrew(Integer crew) {
        this.crew = crew;
    }

    public Double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    //region Description
    public Airplane(String airplaneNr, Double fuelCapacity, Double actualFuel, Integer seatCapacity, Integer crew, Double maxHeight, Double maxSpeed) {
        this.airplaneNr = airplaneNr;
        this.fuelCapacity = fuelCapacity;
        this.actualFuel = actualFuel;
        this.seatCapacity = seatCapacity;
        this.crew = crew;
        this.maxHeight = maxHeight;
        this.maxSpeed = maxSpeed;
    }

    public Airplane() {
    }
    //endregion
}
