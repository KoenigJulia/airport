package at.htl.workloads.person;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

@QuarkusTest
class PersonRepositoryTest {

    @Inject
    private PersonRepository personRepository;

    @Test
    @TestTransaction
    public void addPerson_getPerson_success(){
        Person p1 = new Person("John", "Doe", "john.doe@gmail.com", "123456789", LocalDate.parse("1990-12-19"), "123456789", 300.50, "pw", "user");
        Person p2 = new Person("Jim", "Paul", "jim.pau@gmail.com", "987654321", LocalDate.parse("1990-08-19"), "987654321", 50.99, "pw1234", "user");
        Person p3 = new Person("Jane", "Doe", "jane.doe@gmail.com", "123456789", LocalDate.parse("1990-09-19"), "123456789", 1000.00, "pw1234", "user");
        Person p4 = new Person("Jack", "Doe", "jack.doe@gmail.com", "123456789", LocalDate.parse("1990-10-19"), "123456789", 5367.90, "pw1234", "user");

        assertThatCode(() -> personRepository.add(p1)).doesNotThrowAnyException();
        assertThatCode(() -> personRepository.add(p2)).doesNotThrowAnyException();
        assertThatCode(() -> personRepository.add(p3)).doesNotThrowAnyException();
        assertThatCode(() -> personRepository.add(p4)).doesNotThrowAnyException();

        var loadedP4 = personRepository.getPerson(4L);

        assertThat(loadedP4).isNotNull().isEqualTo(p4);
        assertThat(loadedP4.getSocialSecurityNumber()).isEqualTo(p4.getSocialSecurityNumber());
        assertThat(loadedP4.getFirstName()).isEqualTo(p4.getFirstName());
        assertThat(loadedP4.getLastName()).isEqualTo(p4.getLastName());
        assertThat(loadedP4.getPhoneNumber()).isEqualTo(p4.getPhoneNumber());
    }
}