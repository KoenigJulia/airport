package at.htl;

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
import at.htl.workloads.seat.SeatRepository;
import at.htl.workloads.ticket.Ticket;
import at.htl.workloads.ticket.TicketRepository;
import at.htl.workloads.travelclass.TravelClass;
import at.htl.workloads.travelclass.TravelClassRepository;
import io.quarkus.runtime.StartupEvent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {
    private final AirplaneRepository airplaneRepository;
    private final EmployeeRepository employeeRepository;
    private final FlightRepository flightRepository;
    private final LocationRepository locationRepository;
    private final LuggageRepository luggageRepository;
    private final PersonRepository personRepository;
    private final PilotRepository pilotRepository;
    private final TicketRepository ticketRepository;
    private final TravelClassRepository travelclassRepository;
    private final SeatRepository seatRepository;

    public InitBean(
            AirplaneRepository airplaneRepository,
            EmployeeRepository employeeRepository,
            FlightRepository flightRepository,
            LocationRepository locationRepository,
            LuggageRepository luggageRepository,
            PersonRepository personRepository,
            PilotRepository pilotRepository,
            TicketRepository ticketRepository,
            TravelClassRepository travelclassRepository,
            SeatRepository seatRepository) {
        this.airplaneRepository = airplaneRepository;
        this.employeeRepository = employeeRepository;
        this.flightRepository = flightRepository;
        this.locationRepository = locationRepository;
        this.luggageRepository = luggageRepository;
        this.personRepository = personRepository;
        this.pilotRepository = pilotRepository;
        this.ticketRepository = ticketRepository;
        this.travelclassRepository = travelclassRepository;
        this.seatRepository = seatRepository;
    }

    @Transactional
    void init(@Observes StartupEvent event) {

        if(!"test".equals(io.quarkus.runtime.configuration.ProfileManager.getActiveProfile())) {
            loadAirport();
        }
    }

    void loadAirport(){

        //travelclass
        TravelClass trC1 = new TravelClass("first", 150.00, false, false, true, 2);
        TravelClass trC2 = new TravelClass("business", 230.00, false, true, true, 3);
        TravelClass trC3 = new TravelClass("economy", 300.00, true, true, true, 5);
        travelclassRepository.add(trC1);
        travelclassRepository.add(trC2);
        travelclassRepository.add(trC3);

        //employee
        Employee e1 = new Employee("Larry", "Remplfarmer", "l.remplfarmer@gmail.com", "06502342533", LocalDate.parse("2001-01-23"), "924351064", "EMP102345", BigDecimal.valueOf(700.00), null, true, "pw1234", "user");
        Employee e2 = new Employee("Parrley", "Remplfarmer", "p.remplfarmer@gmail.com", "01231153523", LocalDate.parse("2000-10-10"), "123409649", "EMP134528", BigDecimal.valueOf(1000.00), null, true, "pw1234", "user");
        Employee e3 = new Employee("Danny", "Kenny", "d.kenny@gmail.com", "015321023321", LocalDate.parse("1990-02-10"), "0673863086", "EMP1063465", BigDecimal.valueOf(1500.00), null, true, "pw1234", "user");
        Employee e4 = new Employee("Harry", "Luft", "h.luft@gmail.com", "10341053123", LocalDate.parse("1999-05-20"), "654753862", "EMP012676", BigDecimal.valueOf(1600.00), null, false, "pw1234", "user");
        employeeRepository.add(e1);
        employeeRepository.add(e2);
        employeeRepository.add(e3);
        employeeRepository.add(e4);

        // customers
        Person admin = new Person("Admin", "Admin", "admin@gmail.com", "123456789", LocalDate.parse("1990-12-19"), "123456789", 300.50, "admin", "user, admin");
        Person p1 = new Person("John", "Doe", "john.doe@gmail.com", "123456789", LocalDate.parse("1990-12-19"), "123456789", 300.50, "pw", "user");
        Person p2 = new Person("Jim", "Paul", "jim.pau@gmail.com", "987654321", LocalDate.parse("1990-08-19"), "987654321", 50.99, "pw1234", "user");
        Person p3 = new Person("Jane", "Doe", "jane.doe@gmail.com", "123456789", LocalDate.parse("1990-09-19"), "123456789", 1000.00, "pw1234", "user");
        Person p4 = new Person("Jack", "Doe", "jack.doe@gmail.com", "123456789", LocalDate.parse("1990-10-19"), "123456789", 5367.90, "pw1234", "user");
        Person p5 = new Person("Jill", "Doe", "jill.doe@gmail.com", "123456789", LocalDate.parse("1990-11-19"), "123456789", 743.47, "pw1234", "user");
        Person p6 = new Person("Jack", "Doe", "jack.doe@gmail.com", "123456789", LocalDate.parse("1990-01-19"), "123456789", 100000.45, "pw1234", "user");
        personRepository.add(admin);
        personRepository.add(p1);
        personRepository.add(p2);
        personRepository.add(p3);
        personRepository.add(p4);
        personRepository.add(p5);
        personRepository.add(p6);

        // airports
        Location l1 = new Location("Austria", "Vienna", "Vienna International Airport", "1300 Schwechat", "VIE");
        Location l2 = new Location("Austria", "Graz", "Graz Airport", "8073 Feldkirchen bei Graz", "GRZ");
        Location l3 = new Location("Austria", "Linz", "Linz Airport", "Flughafenstra??e 1, 4063 H??rsching", "LNZ");
        locationRepository.add(l1);
        locationRepository.add(l2);
        locationRepository.add(l3);

        // pilots
        Pilot pi1 = new Pilot("Bill", "Chill", "bill.chill@gmail.com", "194206421", LocalDate.parse("1980-01-24"), "098765432", "PI01", BigDecimal.valueOf(1500.00), null, "A8347BE843Y", Double.parseDouble("150.00"), "pw1234", "user");
        Pilot pi2 = new Pilot("Hillary", "Right", "hillary.right@gmail.com", "863210631", LocalDate.parse("1997-11-10"), "764320196", "PI02", BigDecimal.valueOf(2500.00), null, "D45FRT4545323", Double.parseDouble("600.00"), "pw1234", "user");
        Pilot pi3 = new Pilot("Johnathan", "Johnson", "johnathan.johnson@gmail.com", "865432960", LocalDate.parse("1988-06-21"), "438291063", "PI03", BigDecimal.valueOf(1200.00), null, "LIEDY994570", Double.parseDouble("300.00"), "pw1234", "user");
        Pilot pi4 = new Pilot("Jenny", "Air", "jenny.air@gmail.com", "851230632", LocalDate.parse("1990-10-05"), "865424210", "PI04", BigDecimal.valueOf(1000.00), null, "KLDNF0328943DE9", Double.parseDouble("50.00"), "pw1234", "user");
        pilotRepository.add(pi1);
        pilotRepository.add(pi2);
        pilotRepository.add(pi3);
        pilotRepository.add(pi4);

        // airplane
        Airplane ap1 = new Airplane("P01", 5000.00, 3000.00, 4, 10000.00, 300.00, 8, 6, 100);
        Airplane ap2 = new Airplane("P02", 6000.00, 5000.00, 4, 10500.00, 250.00, 10, 6, 200);
        Airplane ap3 = new Airplane("P03", 10000.00, 5000.00, 6, 11000.00, 200.00, 12, 6, 500);
        airplaneRepository.add(ap1);
        airplaneRepository.add(ap2);
        airplaneRepository.add(ap3);

        // flight
        //TODO(fields)
        Flight fl1 = new Flight(l1, "G1", LocalDateTime.of(2022, Month.JANUARY, 20, 16, 30), l3, "G2", 209.00, ap1, LocalDateTime.of(2022, Month.JANUARY, 20, 20, 30), List.of(e1, e2), pi1, pi2);
        Flight fl2 = new Flight(l2, "G3", LocalDateTime.of(2021, Month.DECEMBER, 24, 4, 15), l1, "G6", 201.00, ap2, LocalDateTime.of(2021, Month.DECEMBER, 24, 9, 15), List.of(e1, e3), pi2, pi4);
        Flight fl3 = new Flight(l3, "G1", LocalDateTime.of(2022, Month.FEBRUARY, 3, 12, 45), l1, "G3", 209.00, ap2, LocalDateTime.of(2022, Month.FEBRUARY, 3, 14, 45), List.of(e2, e3), pi3, pi1);
        Flight fl4 = new Flight(l2, "G2", LocalDateTime.of(2021, Month.JANUARY, 30, 2, 15), l1, "G1", 201.00, ap3, LocalDateTime.of(2021, Month.JANUARY, 30, 5, 15), List.of(e1, e3), pi2, pi3);
        Flight fl5 = new Flight(l2, "G3", LocalDateTime.of(2022, Month.SEPTEMBER, 6, 13, 0), l3, "G2", 225.00, ap1, LocalDateTime.of(2022, Month.SEPTEMBER, 6, 17, 0), List.of(e2, e3), pi1, pi4);
        flightRepository.add(fl1);
        flightRepository.add(fl2);
        flightRepository.add(fl3);
        flightRepository.add(fl4);
        flightRepository.add(fl5);

        // ticket

        Luggage lu1 = new Luggage(20.00, Size.Medium, "A223");
        Luggage lu2 = new Luggage(50.00, Size.Large, "Y384");
        Luggage lu3 = new Luggage(15.67, Size.Medium, "B485");
        Luggage lu4 = new Luggage(5.89, Size.Small, "U398");
        Luggage lu5 = new Luggage(2.55, Size.Small, "T485");
        Luggage lu6 = new Luggage(1.00, Size.Small, "U398");
        Luggage lu7 = new Luggage(2.00, Size.Large, "U399");
        Luggage lu8 = new Luggage(3.00, Size.Medium, "U400");
        Luggage lu9 = new Luggage(4.00, Size.Large, "U401");
        Luggage lu10 = new Luggage(5.00, Size.Large, "U402");
        Luggage lu11 = new Luggage(6.00, Size.Large, "U403");
        Luggage lu12 = new Luggage(7.00, Size.Large, "U404");
        Luggage lu13 = new Luggage(8.00, Size.Large, "U405");
        Luggage lu14 = new Luggage(9.00, Size.Large, "U406");
        
        Ticket t1 = fl1.bookFlight(p2, trC3, 1, List.of(lu1, lu13, lu14));
        Ticket t2 = fl1.bookFlight(p3, trC2, 2, List.of(lu2, lu3));
        Ticket t3 = fl2.bookFlight(p1, trC2, 3, List.of(lu4,lu5));
        Ticket t4 = fl3.bookFlight(p4, trC1, 5, List.of(lu6,lu7));
        Ticket t5 = fl5.bookFlight(p5, trC3, 4, List.of(lu8,lu9,lu10));
        Ticket t6 = fl4.bookFlight(p6, trC1, 6, List.of(lu11,lu12));
        ticketRepository.add(t1);
        ticketRepository.add(t2);
        ticketRepository.add(t3);
        ticketRepository.add(t4);
        ticketRepository.add(t5);
        ticketRepository.add(t6);
        //TODO refactor tickets with new seat creation

    }
}
