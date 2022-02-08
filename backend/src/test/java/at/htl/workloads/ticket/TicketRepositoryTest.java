package at.htl.workloads.ticket;

import at.htl.workloads.airplane.Airplane;
import at.htl.workloads.airplane.AirplaneRepository;
import at.htl.workloads.employee.Employee;
import at.htl.workloads.employee.EmployeeRepository;
import at.htl.workloads.flight.Flight;
import at.htl.workloads.flight.FlightRepository;
import at.htl.workloads.location.Location;
import at.htl.workloads.location.LocationRepository;
import at.htl.workloads.luggage.Luggage;
import at.htl.workloads.luggage.LuggageRepository;
import at.htl.workloads.luggage.Size;
import at.htl.workloads.person.Person;
import at.htl.workloads.person.PersonRepository;
import at.htl.workloads.pilot.Pilot;
import at.htl.workloads.pilot.PilotRepository;
import at.htl.workloads.travelclass.TravelClass;
import at.htl.workloads.travelclass.TravelClassRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class TicketRepositoryTest {

    @Inject
    private LocationRepository locationRepository;
    @Inject
    private TicketRepository ticketRepository;
    @Inject
    private LuggageRepository luggageRepository;
    @Inject
    private PersonRepository personRepository;
    @Inject
    private TravelClassRepository travelClassRepository;
    @Inject
    private FlightRepository flightRepository;
    @Inject
    private EmployeeRepository employeeRepository;
    @Inject
    private PilotRepository pilotRepository;
    @Inject
    private AirplaneRepository airplaneRepository;

    @Test
    @TestTransaction
    public void addTicket_getTicket_success(){
        Luggage lu1 = new Luggage(20.00, Size.Medium, "A223");
        Luggage lu2 = new Luggage(50.00, Size.Large, "Y384");
        Luggage lu3 = new Luggage(15.67, Size.Medium, "B485");
        Luggage lu4 = new Luggage(5.89, Size.Small, "U398");
        Luggage lu5 = new Luggage(2.55, Size.Small, "T485");
        Luggage lu6 = new Luggage(1.00, Size.Small, "U398");
        Luggage lu7 = new Luggage(2.00, Size.Large, "U399");
        Luggage lu13 = new Luggage(8.00, Size.Large, "U405");
        Luggage lu14 = new Luggage(9.00, Size.Large, "U406");

        assertThatCode(() -> luggageRepository.add(lu1)).doesNotThrowAnyException();
        assertThatCode(() -> luggageRepository.add(lu2)).doesNotThrowAnyException();
        assertThatCode(() -> luggageRepository.add(lu3)).doesNotThrowAnyException();
        assertThatCode(() -> luggageRepository.add(lu4)).doesNotThrowAnyException();
        assertThatCode(() -> luggageRepository.add(lu5)).doesNotThrowAnyException();
        assertThatCode(() -> luggageRepository.add(lu6)).doesNotThrowAnyException();
        assertThatCode(() -> luggageRepository.add(lu7)).doesNotThrowAnyException();
        assertThatCode(() -> luggageRepository.add(lu13)).doesNotThrowAnyException();
        assertThatCode(() -> luggageRepository.add(lu14)).doesNotThrowAnyException();

        Location l1 = new Location("Austria", "Vienna", "Vienna International Airport", "1300 Schwechat", "VIE");
        Location l2 = new Location("Austria", "Graz", "Graz Airport", "8073 Feldkirchen bei Graz", "GRZ");
        Location l3 = new Location("Austria", "Linz", "Linz Airport", "Flughafenstraße 1, 4063 Hörsching", "LNZ");

        assertThatCode(() -> locationRepository.add(l1)).doesNotThrowAnyException();
        assertThatCode(() -> locationRepository.add(l2)).doesNotThrowAnyException();
        assertThatCode(() -> locationRepository.add(l3)).doesNotThrowAnyException();

        Person p1 = new Person("John", "Doe", "john.doe@gmail.com", "123456789", LocalDate.parse("1990-12-19"), "123456789", 300.50, "pw", "user");
        Person p2 = new Person("Jim", "Paul", "jim.pau@gmail.com", "987654321", LocalDate.parse("1990-08-19"), "987654321", 50.99, "pw1234", "user");
        Person p3 = new Person("Jane", "Doe", "jane.doe@gmail.com", "123456789", LocalDate.parse("1990-09-19"), "123456789", 1000.00, "pw1234", "user");
        Person p4 = new Person("Jack", "Doe", "jack.doe@gmail.com", "123456789", LocalDate.parse("1990-10-19"), "123456789", 5367.90, "pw1234", "user");

        assertThatCode(() -> personRepository.add(p1)).doesNotThrowAnyException();
        assertThatCode(() -> personRepository.add(p2)).doesNotThrowAnyException();
        assertThatCode(() -> personRepository.add(p3)).doesNotThrowAnyException();
        assertThatCode(() -> personRepository.add(p4)).doesNotThrowAnyException();

        TravelClass trC1 = new TravelClass("first", 150.00, false, false, true, 2);
        TravelClass trC2 = new TravelClass("business", 230.00, false, true, true, 3);
        TravelClass trC3 = new TravelClass("economy", 300.00, true, true, true, 5);

        assertThatCode(() -> travelClassRepository.add(trC1)).doesNotThrowAnyException();
        assertThatCode(() -> travelClassRepository.add(trC2)).doesNotThrowAnyException();
        assertThatCode(() -> travelClassRepository.add(trC3)).doesNotThrowAnyException();

        Employee e1 = new Employee("Larry", "Remplfarmer", "l.remplfarmer@gmail.com", "06502342533", LocalDate.parse("2001-01-23"), "924351064", "EMP102345", BigDecimal.valueOf(700.00), null, true, "pw1234", "user");
        Employee e2 = new Employee("Parrley", "Remplfarmer", "p.remplfarmer@gmail.com", "01231153523", LocalDate.parse("2000-10-10"), "123409649", "EMP134528", BigDecimal.valueOf(1000.00), null, true, "pw1234", "user");
        Employee e3 = new Employee("Danny", "Kenny", "d.kenny@gmail.com", "015321023321", LocalDate.parse("1990-02-10"), "0673863086", "EMP1063465", BigDecimal.valueOf(1500.00), null, true, "pw1234", "user");

        assertThatCode(() -> employeeRepository.add(e1)).doesNotThrowAnyException();
        assertThatCode(() -> employeeRepository.add(e2)).doesNotThrowAnyException();
        assertThatCode(() -> employeeRepository.add(e3)).doesNotThrowAnyException();

        Pilot pi1 = new Pilot("Bill", "Chill", "bill.chill@gmail.com", "194206421", LocalDate.parse("1980-01-24"), "098765432", "PI01", BigDecimal.valueOf(1500.00), null, "A8347BE843Y", Double.parseDouble("150.00"), "pw1234", "user");
        Pilot pi2 = new Pilot("Hillary", "Right", "hillary.right@gmail.com", "863210631", LocalDate.parse("1997-11-10"), "764320196", "PI02", BigDecimal.valueOf(2500.00), null, "D45FRT4545323", Double.parseDouble("600.00"), "pw1234", "user");
        Pilot pi3 = new Pilot("Johnathan", "Johnson", "johnathan.johnson@gmail.com", "865432960", LocalDate.parse("1988-06-21"), "438291063", "PI03", BigDecimal.valueOf(1200.00), null, "LIEDY994570", Double.parseDouble("300.00"), "pw1234", "user");
        Pilot pi4 = new Pilot("Jenny", "Air", "jenny.air@gmail.com", "851230632", LocalDate.parse("1990-10-05"), "865424210", "PI04", BigDecimal.valueOf(1000.00), null, "KLDNF0328943DE9", Double.parseDouble("50.00"), "pw1234", "user");

        assertThatCode(() -> pilotRepository.add(pi1)).doesNotThrowAnyException();
        assertThatCode(() -> pilotRepository.add(pi2)).doesNotThrowAnyException();
        assertThatCode(() -> pilotRepository.add(pi3)).doesNotThrowAnyException();
        assertThatCode(() -> pilotRepository.add(pi4)).doesNotThrowAnyException();

        Airplane ap1 = new Airplane("P01", 5000.00, 3000.00, 4, 10000.00, 300.00, 8, 6, 100);
        Airplane ap2 = new Airplane("P02", 6000.00, 5000.00, 4, 10500.00, 250.00, 10, 6, 200);

        assertThatCode(() -> airplaneRepository.add(ap1)).doesNotThrowAnyException();
        assertThatCode(() -> airplaneRepository.add(ap2)).doesNotThrowAnyException();

        Flight fl1 = new Flight(l1, "G1", LocalDateTime.of(2022, Month.JANUARY, 20, 16, 30), l3, "G2", 209.00, ap1, LocalDateTime.of(2022, Month.JANUARY, 20, 20, 30), List.of(e1, e2), pi1, pi2);
        Flight fl2 = new Flight(l2, "G3", LocalDateTime.of(2021, Month.DECEMBER, 24, 4, 15), l1, "G6", 201.00, ap2, LocalDateTime.of(2021, Month.DECEMBER, 24, 9, 15), List.of(e1, e3), pi2, pi4);
        Flight fl3 = new Flight(l3, "G1", LocalDateTime.of(2022, Month.FEBRUARY, 3, 12, 45), l1, "G3", 209.00, ap2, LocalDateTime.of(2022, Month.FEBRUARY, 3, 14, 45), List.of(e2, e3), pi3, pi1);

        assertThatCode(() -> flightRepository.add(fl1)).doesNotThrowAnyException();
        assertThatCode(() -> flightRepository.add(fl2)).doesNotThrowAnyException();
        assertThatCode(() -> flightRepository.add(fl3)).doesNotThrowAnyException();

        Ticket t1 = fl1.bookFlight(p2, trC3, 1, List.of(lu1, lu13, lu14));
        Ticket t2 = fl1.bookFlight(p3, trC2, 2, List.of(lu2, lu3));
        Ticket t3 = fl2.bookFlight(p1, trC2, 3, List.of(lu4,lu5));
        Ticket t4 = fl3.bookFlight(p4, trC1, 5, List.of(lu6,lu7));

        assertThatCode(() -> ticketRepository.add(t1)).doesNotThrowAnyException();
        assertThatCode(() -> ticketRepository.add(t2)).doesNotThrowAnyException();
        assertThatCode(() -> ticketRepository.add(t3)).doesNotThrowAnyException();
        assertThatCode(() -> ticketRepository.add(t4)).doesNotThrowAnyException();

        var loadedT3 = ticketRepository.getTicket(3L);

        assertThat(loadedT3).isNotNull().isEqualTo(t3);
        assertThat(loadedT3.getLuggage().size()).isEqualTo(2);
        assertThat(loadedT3.getTravelclass()).isEqualTo(t3.getTravelclass());
        assertThat(loadedT3.getPerson()).isEqualTo(t3.getPerson());
    }
}