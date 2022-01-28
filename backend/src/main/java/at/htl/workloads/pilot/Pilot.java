package at.htl.workloads.pilot;

import at.htl.workloads.employee.Employee;
import at.htl.workloads.person.Person;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Pilot extends Employee {


    public Pilot(String firstName, String lastName, String email, Integer phoneNumber, LocalDate birthdate, Integer socialSecurityNumber, String employeeNumber, BigDecimal salary) {
        super(firstName, lastName, email, phoneNumber, birthdate, socialSecurityNumber, employeeNumber, salary);
    }

    public Pilot() {

    }
}
