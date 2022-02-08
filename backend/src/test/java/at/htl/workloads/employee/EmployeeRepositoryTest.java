package at.htl.workloads.employee;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
class EmployeeRepositoryTest {

    @Inject
    private EmployeeRepository employeeRepository;

    @Test
    @TestTransaction
    void addEmployee_access() {
        Employee e1 = new Employee("Larry", "Remplfarmer", "l.remplfarmer@gmail.com", "06502342533", LocalDate.parse("2001-01-23"), "924351064", "EMP102345", BigDecimal.valueOf(700.00), null, true, "pw1234", "user");
        Employee e2 = new Employee("Parrley", "Remplfarmer", "p.remplfarmer@gmail.com", "01231153523", LocalDate.parse("2000-10-10"), "123409649", "EMP134528", BigDecimal.valueOf(1000.00), null, true, "pw1234", "user");

        assertThatCode(() -> employeeRepository.add(e1)).doesNotThrowAnyException();
        assertThatCode(() -> employeeRepository.add(e2)).doesNotThrowAnyException();

        var loadedE1 = employeeRepository.getEmployee(1L);
        assertThat(loadedE1).isNotNull().isEqualTo(e1);
        assertThat(loadedE1.getSocialSecurityNumber()).isEqualTo(e1.getSocialSecurityNumber());
        assertThat(loadedE1.getEmail()).isEqualTo(e1.getEmail());
        assertThat(loadedE1.getFirstName()).isEqualTo(e1.getFirstName());
        assertThat(loadedE1.getLastName()).isEqualTo(e1.getLastName());
    }
}