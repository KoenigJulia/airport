package at.htl;

import at.htl.workloads.airplane.Airplane;
import at.htl.workloads.flight.Flight;
import at.htl.workloads.location.Location;
import at.htl.workloads.luggage.Luggage;
import at.htl.workloads.person.Person;
import at.htl.workloads.pilot.Pilot;
import at.htl.workloads.ticket.Ticket;
import io.quarkus.runtime.StartupEvent;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class InitBean {
    void init(@Observes StartupEvent event){
        // customers
        Person p1 = new Person("John", "Doe", "john.doe@gmail.com", "123456789", LocalDate.parse("19.12.1990"), "123456789", Double.parseDouble("300,50"));
        Person p2 = new Person("Jim", "Paul", "jim.pau@gmail.com", "987654321", LocalDate.parse("19.08.1990"), "987654321", Double.parseDouble("50,99") );
        Person p3 = new Person("Jane", "Doe", "jane.doe@gmail.com", "123456789", LocalDate.parse("19.09.1990"), "123456789", Double.parseDouble("1000,00"));
        Person p4 = new Person("Jack", "Doe", "jack.doe@gmail.com", "123456789", LocalDate.parse("19.10.1990"), "123456789", Double.parseDouble("5367,90"));
        Person p5 = new Person("Jill", "Doe", "jill.doe@gmail.com", "123456789", LocalDate.parse("19.11.1990"), "123456789", Double.parseDouble("743,47"));
        Person p6 = new Person("Jack", "Doe", "jack.doe@gmail.com", "123456789", LocalDate.parse("19.01.1990"), "123456789", Double.parseDouble("100000,45"));

        // airports
        Location l1 = new Location("Austria", "Vienna", "Vienna International Airport", "1300 Schwechat", "VIE");
        Location l2 = new Location("Austria", "Graz", "Graz Airport", "8073 Feldkirchen bei Graz", "GRZ");
        Location l3 = new Location("Austria", "Linz", "Linz Airport", "Flughafenstraße 1, 4063 Hörsching", "LNZ");

        // pilots
        Pilot pi1 = new Pilot("Bill", "Chill", "bill.chill@gmail.com", "194206421", LocalDate.parse("24.01.1980"), "098765432", "PI01", BigDecimal.valueOf(1500.00));
        Pilot pi2 = new Pilot("Hillary", "Right", "hillary.right@gmail.com", "863210631", LocalDate.parse("10.11.1997"), "764320196", "PI02", BigDecimal.valueOf(2500.00));
        Pilot pi3 = new Pilot("Johnathan", "Johnson", "johnathan.johnson@gmail.com", "865432960", LocalDate.parse("21.06.1988"), "438291063", "PI03", BigDecimal.valueOf(1200.00));
        Pilot pi4 = new Pilot("Jenny", "Air", "jenny.air@gmail.com", "851230632", LocalDate.parse("05.10.1990"), "865424210", "PI04", BigDecimal.valueOf(1000.00));

        // luggage
        //TODO(fields)
        Luggage lu1 = new Luggage();
        Luggage lu2 = new Luggage();
        Luggage lu3 = new Luggage();
        Luggage lu4 = new Luggage();
        Luggage lu5 = new Luggage();

        // airplane
        Airplane ap1 = new Airplane("P01", 5000.00, 3000.00, 20, 8, 10000.00, 300.00);
        Airplane ap2 = new Airplane("P02", 6000.00, 5000.00, 80, 10, 10500.00, 250.00);
        Airplane ap3 = new Airplane("P03", 10000.00, 5000.00, 100, 8, 11000.00, 200.00);

        // flight
        //TODO(fields)
        Flight fl1 = new Flight();
        Flight fl2 = new Flight();
        Flight fl3 = new Flight();
        Flight fl4 = new Flight();
        Flight fl5 = new Flight();

        // ticket
        //TODO(fields)
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        Ticket t4 = new Ticket();
        Ticket t5 = new Ticket();
        Ticket t6 = new Ticket();
    }
}
