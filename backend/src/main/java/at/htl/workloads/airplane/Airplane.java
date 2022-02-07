package at.htl.workloads.airplane;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String airplaneNr;
    private Double fuelCapacity;
    private Double actualFuel;
    private Integer crewCnt;
    private Double maxHeight;
    private Double maxSpeed;
    private int seatRows;
    private int seatColumns;

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

    public Integer getCrewCnt() {
        return crewCnt;
    }

    public void setCrewCnt(Integer crew) {
        this.crewCnt = crew;
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

    public int getSeatRows() {
        return seatRows;
    }

    public void setSeatRows(int rows) {
        this.seatRows = rows;
    }

    public int getSeatColumns() {
        return seatColumns;
    }

    public void setSeatColumns(int columns) {
        this.seatColumns = columns;
    }

    //region Description
    public Airplane(String airplaneNr, Double fuelCapacity, Double actualFuel, Integer crewCnt, Double maxHeight, Double maxSpeed, int seatRows, int seatColumns) {
        this.airplaneNr = airplaneNr;
        this.fuelCapacity = fuelCapacity;
        this.actualFuel = actualFuel;
        this.crewCnt = crewCnt;
        this.maxHeight = maxHeight;
        this.maxSpeed = maxSpeed;
        this.seatRows = seatRows;
        this.seatColumns = seatColumns;
    }

    public Airplane() {
    }
    //endregion
}
