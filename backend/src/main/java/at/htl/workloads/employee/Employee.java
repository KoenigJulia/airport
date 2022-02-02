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

    public Employee(String firstName, String lastName, String email, String phoneNumber, LocalDate birthdate, String socialSecurityNumber, String employeeNumber, BigDecimal salary, boolean isFlightAttendant) {
        super(firstName, lastName, email, phoneNumber, birthdate, socialSecurityNumber);
        this.employeeNumber = employeeNumber;
        this.salary = salary;
        this.isFlightAttendant = isFlightAttendant;
    }

    public Employee(String firstName, String lastName, String email, String phoneNumber, LocalDate birthdate, String socialSecurityNumber) {
        super(firstName, lastName, email, phoneNumber, birthdate, socialSecurityNumber);
    }

    public Employee() {
        super();
    }
}
