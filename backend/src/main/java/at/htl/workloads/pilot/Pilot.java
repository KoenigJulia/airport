package at.htl.workloads.pilot;

import at.htl.workloads.employee.Employee;
import at.htl.workloads.person.Person;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Pilot extends Employee {
    private String pilotNumber;
    private Double extraPayment;
    //region constructor
    public Pilot(String firstName, String lastName, String email, String phoneNumber, LocalDate birthdate, String socialSecurityNumber, String employeeNumber, BigDecimal salary, Double flightMiles, String pilotNumber, Double extraPayment, String password, String role) {
        super(firstName, lastName, email, phoneNumber, birthdate, socialSecurityNumber, employeeNumber, salary, flightMiles, false, password, role);
        this.pilotNumber = pilotNumber;
        this.extraPayment = extraPayment;
    }
    public Pilot() {

    }
    //endregion
    //region gettersetter
    public String getPilotNumber() {
        return pilotNumber;
    }
    public void setPilotNumber(String pilotNumber) {
        this.pilotNumber = pilotNumber;
    }
    public Double getExtraPayment() {
        return extraPayment;
    }
    public void setExtraPayment(Double extraPayment) {
        this.extraPayment = extraPayment;
    }
    //endregion
}
