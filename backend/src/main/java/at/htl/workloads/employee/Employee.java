package at.htl.workloads.employee;

import at.htl.workloads.person.Person;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Employee extends Person {
    private String employeeNumber;
    private BigDecimal salary;
    private boolean isFlightAttendant;

    public Employee(String firstName, String lastName, String email, String phoneNumber, LocalDate birthdate, String socialSecurityNumber, String employeeNumber, BigDecimal salary, Double flightMiles, boolean isFlightAttendant, String password, String role) {
        super(firstName, lastName, email, phoneNumber, birthdate, socialSecurityNumber, flightMiles, password, role);
        this.employeeNumber = employeeNumber;
        this.salary = salary;
        this.isFlightAttendant = isFlightAttendant;
    }

    public Employee(String firstName, String lastName, String email, String phoneNumber, LocalDate birthdate, String socialSecurityNumber, Double flightMiles, boolean isFlightAttendant, String password, String role) {
        super(firstName, lastName, email, phoneNumber, birthdate, socialSecurityNumber, flightMiles, password, role);
        this.isFlightAttendant = isFlightAttendant;
    }

    public Employee() {
        super();
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public boolean isFlightAttendant() {
        return isFlightAttendant;
    }

    public void setFlightAttendant(boolean flightAttendant) {
        isFlightAttendant = flightAttendant;
    }
}
