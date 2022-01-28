package at.htl;

import at.htl.workloads.location.Location;
import at.htl.workloads.person.Person;
import io.quarkus.runtime.StartupEvent;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class InitBean {
    void init(@Observes StartupEvent event){
        // customers
        Person p1 = new Person("John", "Doe", "john.doe@gmail.com", "123456789", LocalDate.parse("19.12.1990"), "123456789");
        Person p2 = new Person("Jim", "Paul", "jim.pau@gmail.com", "987654321", LocalDate.parse("19.08.1990"), "987654321");
        Person p3 = new Person("Jane", "Doe", "jane.doe@gmail.com", "123456789", LocalDate.parse("19.09.1990"), "123456789");
        Person p4 = new Person("Jack", "Doe", "jack.doe@gmail.com", "123456789", LocalDate.parse("19.10.1990"), "123456789");
        Person p5 = new Person("Jill", "Doe", "jill.doe@gmail.com", "123456789", LocalDate.parse("19.11.1990"), "123456789");
        Person p6 = new Person("Jack", "Doe", "jack.doe@gmail.com", "123456789", LocalDate.parse("19.01.1990"), "123456789");

        // airports
        Location l1 = new Location("Austria", "Vienna", "Vienna International Airport", "1300 Schwechat", "VIE");
        Location l2 = new Location("Austria", "Graz", "Graz Airport", "8073 Feldkirchen bei Graz", "GRZ");
        Location l3 = new Location("Austria", "Linz", "Linz Airport", "Flughafenstraße 1, 4063 Hörsching", "LNZ");

        // pilots

        // luggage

        // airplane

        // flight

        // ticket

    }
}
