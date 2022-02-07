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
import at.htl.workloads.person.Person;
import at.htl.workloads.person.PersonRepository;
import at.htl.workloads.pilot.Pilot;
import at.htl.workloads.pilot.PilotRepository;
import at.htl.workloads.seat.SeatRepository;
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

        //travelclass
        TravelClass trC1 = new TravelClass("first", 150.00, false, false, true, 2);
        TravelClass trC2 = new TravelClass("business", 230.00, false, true, true,3);
        TravelClass trC3 = new TravelClass("economy", 300.00, true, true, true,5);
        travelclassRepository.add(trC1);
        travelclassRepository.add(trC2);
        travelclassRepository.add(trC3);

        //employee
        Employee e1 = new Employee("Larry", "Remplfarmer", "l.remplfarmer@gmail.com", "06502342533", LocalDate.parse("2001-01-23"), "924351064", "EMP102345", BigDecimal.valueOf(700.00), null, true);
        Employee e2 = new Employee("Parrley", "Remplfarmer", "p.remplfarmer@gmail.com", "01231153523", LocalDate.parse("2000-10-10"), "123409649", "EMP134528", BigDecimal.valueOf(1000.00), null, true);
        Employee e3 = new Employee("Danny", "Kenny", "d.kenny@gmail.com", "015321023321", LocalDate.parse("1990-02-10"), "0673863086", "EMP1063465", BigDecimal.valueOf(1500.00), null, true);
        Employee e4 = new Employee("Harry", "Luft", "h.luft@gmail.com", "10341053123", LocalDate.parse("1999-05-20"), "654753862", "EMP012676", BigDecimal.valueOf(1600.00), null, false);
        employeeRepository.add(e1);
        employeeRepository.add(e2);
        employeeRepository.add(e3);
        employeeRepository.add(e4);

        // customers
        Person p1 = new Person("John", "Doe", "john.doe@gmail.com", "123456789", LocalDate.parse("1990-12-19"), "123456789", 300.50);
        Person p2 = new Person("Jim", "Paul", "jim.pau@gmail.com", "987654321", LocalDate.parse("1990-08-19"), "987654321", 50.99);
        Person p3 = new Person("Jane", "Doe", "jane.doe@gmail.com", "123456789", LocalDate.parse("1990-09-19"), "123456789", 1000.00);
        Person p4 = new Person("Jack", "Doe", "jack.doe@gmail.com", "123456789", LocalDate.parse("1990-10-19"), "123456789", 5367.90);
        Person p5 = new Person("Jill", "Doe", "jill.doe@gmail.com", "123456789", LocalDate.parse("1990-11-19"), "123456789", 743.47);
        Person p6 = new Person("Jack", "Doe", "jack.doe@gmail.com", "123456789", LocalDate.parse("1990-01-19"), "123456789", 100000.45);
        personRepository.add(p1);
        personRepository.add(p2);
        personRepository.add(p3);
        personRepository.add(p4);
        personRepository.add(p5);
        personRepository.add(p6);

        // airports
        Location l1 = new Location("Austria", "Vienna", "Vienna International Airport", "1300 Schwechat", "VIE");
        Location l2 = new Location("Austria", "Graz", "Graz Airport", "8073 Feldkirchen bei Graz", "GRZ");
        Location l3 = new Location("Austria", "Linz", "Linz Airport", "Flughafenstraße 1, 4063 Hörsching", "LNZ");
        locationRepository.add(l1);
        locationRepository.add(l2);
        locationRepository.add(l3);

        // pilots
        Pilot pi1 = new Pilot("Bill", "Chill", "bill.chill@gmail.com", "194206421", LocalDate.parse("1980-01-24"), "098765432", "PI01", BigDecimal.valueOf(1500.00), null, "A8347BE843Y", Double.parseDouble("150.00"));
        Pilot pi2 = new Pilot("Hillary", "Right", "hillary.right@gmail.com", "863210631", LocalDate.parse("1997-11-10"), "764320196", "PI02", BigDecimal.valueOf(2500.00), null, "D45FRT4545323", Double.parseDouble("600.00"));
        Pilot pi3 = new Pilot("Johnathan", "Johnson", "johnathan.johnson@gmail.com", "865432960", LocalDate.parse("1988-06-21"), "438291063", "PI03", BigDecimal.valueOf(1200.00), null, "LIEDY994570", Double.parseDouble("300.00"));
        Pilot pi4 = new Pilot("Jenny", "Air", "jenny.air@gmail.com", "851230632", LocalDate.parse("1990-10-05"), "865424210", "PI04", BigDecimal.valueOf(1000.00), null, "KLDNF0328943DE9", Double.parseDouble("50.00"));
        pilotRepository.add(pi1);
        pilotRepository.add(pi2);
        pilotRepository.add(pi3);
        pilotRepository.add(pi4);

        // luggage
//        Luggage lu1 = new Luggage(20.00, Size.Medium, "A223");
//        Luggage lu2 = new Luggage(50.00, Size.Large, "Y384");
//        Luggage lu3 = new Luggage(15.67, Size.Medium, "B485");
//        Luggage lu4 = new Luggage(5.89, Size.Small, "U398");
//        Luggage lu5 = new Luggage(2.55, Size.Small, "T485");
//        luggageRepository.add(lu1);
//        luggageRepository.add(lu2);
//        luggageRepository.add(lu3);
//        luggageRepository.add(lu4);
//        luggageRepository.add(lu5);

        // airplane
        Airplane ap1 = new Airplane("P01", 5000.00, 3000.00, 20, 8, 10000.00, 300.00, 8, 6);
        Airplane ap2 = new Airplane("P02", 6000.00, 5000.00, 80, 10, 10500.00, 250.00, 10, 6);
        Airplane ap3 = new Airplane("P03", 10000.00, 5000.00, 100, 8, 11000.00, 200.00, 12, 6);
        airplaneRepository.add(ap1);
        airplaneRepository.add(ap2);
        airplaneRepository.add(ap3);

        // flight
        //TODO(fields)
        //public Flight(Location startDestination, Location endDestination, Double distance, Airplane airplane, LocalDateTime startTime, List<Employee> flightAttendants, List<Pilot> pilots) {
        Flight fl1 = new Flight(l1, "G1", l3, "G2", 209.00, ap1, LocalDateTime.of(2022, Month.JANUARY, 20, 20, 30), List.of(e1, e2), pi1, pi2);
        Flight fl2 = new Flight(l2, "G3", l1, "G6", 201.00, ap2, LocalDateTime.of(2021, Month.DECEMBER, 24, 9, 15), List.of(e1, e3), pi2, pi4);
        Flight fl3 = new Flight(l3, "G1", l1, "G3", 209.00, ap2, LocalDateTime.of(2022, Month.FEBRUARY, 3, 14, 45), List.of(e2, e3), pi3, pi1);
        Flight fl4 = new Flight(l2, "G2", l1, "G1", 201.00, ap3, LocalDateTime.of(2021, Month.JANUARY, 30, 5, 15), List.of(e1, e3), pi2, pi3);
        Flight fl5 = new Flight(l2, "G3", l3, "G2", 225.00, ap1, LocalDateTime.of(2022, Month.SEPTEMBER, 6, 17, 0), List.of(e2, e3), pi1, pi4);
        flightRepository.add(fl1);
        flightRepository.add(fl2);
        flightRepository.add(fl3);
        flightRepository.add(fl4);
        flightRepository.add(fl5);

        // seat
//        Seat s1 = new Seat(1, "A", seatType);
//        Seat s2 = new Seat(3, "A", seatType);
//        Seat s3 = new Seat(20, "E", seatType);
//        Seat s4 = new Seat(27, "H", seatType);
//        Seat s5 = new Seat(16, "F", seatType);
//        seatRepository.add(s1);
//        seatRepository.add(s2);
//        seatRepository.add(s3);
//        seatRepository.add(s4);
//        seatRepository.add(s5);

//
//        // ticket
//        //TODO(fields)
//        //public Ticket(Flight flight, Person person, Double price, Integer seatNumber, String rowNumber, TravelClass travelclass, List<Luggage> luggage) {
        List<Luggage> luggage = new ArrayList<>();

        //TODO refactor tickets with new seat creation

//        luggage.add(lu1);
//        luggage.add(lu2);
//        Ticket t6 = new Ticket(fl5, p4, 2993.83, s1, trC1, luggage);
//        Ticket t3 = new Ticket(fl2, p5, 1500.40, s2, trC1, luggage);
//        luggage.add(lu5);
//        Ticket t4 = new Ticket(fl3, p3, 1020.80, s3, trC2, luggage);
//        Ticket t5 = new Ticket(fl4, p6, 892.46, s4, trC2, luggage);
//        luggage.add(lu3);
//        luggage.add(lu4);
//        Ticket t2 = new Ticket(fl1, p3, 340.77, s5, trC3, luggage);
//        Ticket t1 = new Ticket(fl1, p2, 330.88, s1, trC3, luggage);
//        ticketRepository.add(t1);
//        ticketRepository.add(t2);
//        ticketRepository.add(t3);
//        ticketRepository.add(t4);
//        ticketRepository.add(t5);
//        ticketRepository.add(t6);

    }
}
