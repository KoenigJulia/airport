package at.htl;

import at.htl.workloads.airplane.Airplane;
import at.htl.workloads.airplane.AirplaneRepository;
import at.htl.workloads.bus.Bus;
import at.htl.workloads.bus.BusRepository;
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
import at.htl.workloads.ticket.Ticket;
import at.htl.workloads.ticket.TicketRepository;
import at.htl.workloads.travelclass.Travelclass;
import at.htl.workloads.travelclass.TravelclassRepository;
import io.quarkus.runtime.StartupEvent;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;

@ApplicationScoped
public class InitBean {
    private final AirplaneRepository airplaneRepository;
    private final BusRepository busRepository;
    private final EmployeeRepository employeeRepository;
    private final FlightRepository flightRepository;
    private final LocationRepository locationRepository;
    private final LuggageRepository luggageRepository;
    private final PersonRepository personRepository;
    private final PilotRepository pilotRepository;
    private final TicketRepository ticketRepository;
    private final TravelclassRepository travelclassRepository;

    public InitBean(
                    AirplaneRepository airplaneRepository,
                    BusRepository busRepository,
                    EmployeeRepository employeeRepository,
                    FlightRepository flightRepository,
                    LocationRepository locationRepository,
                    LuggageRepository luggageRepository,
                    PersonRepository personRepository,
                    PilotRepository pilotRepository,
                    TicketRepository ticketRepository,
                    TravelclassRepository travelclassRepository) {
        this.airplaneRepository = airplaneRepository;
        this.busRepository = busRepository;
        this.employeeRepository = employeeRepository;
        this.flightRepository = flightRepository;
        this.locationRepository = locationRepository;
        this.luggageRepository = luggageRepository;
        this.personRepository = personRepository;
        this.pilotRepository = pilotRepository;
        this.ticketRepository = ticketRepository;
        this.travelclassRepository = travelclassRepository;
    }

    void init(@Observes StartupEvent event){

        //travelclass
        Travelclass trC1 = new Travelclass("third", 150.00, false, false,true);
        Travelclass trC2 = new Travelclass("second", 230.00, false, true, true);
        Travelclass trC3 = new Travelclass("first", 300.00, true, true, true);
        travelclassRepository.add(trC1);
        travelclassRepository.add(trC2);
        travelclassRepository.add(trC3);


        //bus
        Bus b1 = new Bus("BMW", 20, 200.00, 140.00);
        Bus b2 = new Bus("VW", 10, 180.00, 150.00);
        Bus b3 = new Bus("BMW", 15, 180.00, 120.00);
        Bus b4 = new Bus("VW", 0, 150.00, 0.0);
        busRepository.add(b1);
        busRepository.add(b2);
        busRepository.add(b3);
        busRepository.add(b4);

        //employee
        Employee e1 = new Employee("Larry", "Remplfarmer", "l.remplfarmer@gmail.com", "06502342533", LocalDate.parse("2001-01-23"), "924351064", "EMP102345", BigDecimal.valueOf(700.00));
        Employee e2 = new Employee("Parrley", "Remplfarmer", "p.remplfarmer@gmail.com", "01231153523", LocalDate.parse("2000-10-10"), "123409649", "EMP134528", BigDecimal.valueOf(1000.00));
        Employee e3 = new Employee("Danny", "Kenny", "d.kenny@gmail.com", "015321023321", LocalDate.parse("1990-02-10"), "0673863086", "EMP1063465", BigDecimal.valueOf(1500.00));
        Employee e4 = new Employee("Harry", "Luft", "h.luft@gmail.com", "10341053123", LocalDate.parse("1999-05-20"), "654753862", "EMP012676", BigDecimal.valueOf(1600.00));
        employeeRepository.add(e1);
        employeeRepository.add(e2);
        employeeRepository.add(e3);
        employeeRepository.add(e4);

        // customers
        Person p1 = new Person("John", "Doe", "john.doe@gmail.com", "123456789", LocalDate.parse("1990-12-19"), "123456789", 300.50);
        Person p2 = new Person("Jim", "Paul", "jim.pau@gmail.com", "987654321", LocalDate.parse("1990-08-19"), "987654321", 50.99 );
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
        Pilot pi1 = new Pilot("Bill", "Chill", "bill.chill@gmail.com", "194206421", LocalDate.parse("1980-01-24"), "098765432", "PI01", BigDecimal.valueOf(1500.00));
        Pilot pi2 = new Pilot("Hillary", "Right", "hillary.right@gmail.com", "863210631", LocalDate.parse("1997-11-10"), "764320196", "PI02", BigDecimal.valueOf(2500.00));
        Pilot pi3 = new Pilot("Johnathan", "Johnson", "johnathan.johnson@gmail.com", "865432960", LocalDate.parse("1988-06-21"), "438291063", "PI03", BigDecimal.valueOf(1200.00));
        Pilot pi4 = new Pilot("Jenny", "Air", "jenny.air@gmail.com", "851230632", LocalDate.parse("1990-10-05"), "865424210", "PI04", BigDecimal.valueOf(1000.00));
        pilotRepository.add(pi1);
        pilotRepository.add(pi2);
        pilotRepository.add(pi3);
        pilotRepository.add(pi4);

        // luggage
        //TODO(fields)
        Luggage lu1 = new Luggage();
        Luggage lu2 = new Luggage();
        Luggage lu3 = new Luggage();
        Luggage lu4 = new Luggage();
        Luggage lu5 = new Luggage();
        luggageRepository.add(lu1);
        luggageRepository.add(lu2);
        luggageRepository.add(lu3);
        luggageRepository.add(lu4);
        luggageRepository.add(lu5);

        // airplane
        Airplane ap1 = new Airplane("P01", 5000.00, 3000.00, 20, 8, 10000.00, 300.00);
        Airplane ap2 = new Airplane("P02", 6000.00, 5000.00, 80, 10, 10500.00, 250.00);
        Airplane ap3 = new Airplane("P03", 10000.00, 5000.00, 100, 8, 11000.00, 200.00);
        airplaneRepository.add(ap1);
        airplaneRepository.add(ap2);
        airplaneRepository.add(ap3);

        // flight
        //TODO(fields)
        Flight fl1 = new Flight();
        Flight fl2 = new Flight();
        Flight fl3 = new Flight();
        Flight fl4 = new Flight();
        Flight fl5 = new Flight();
        flightRepository.add(fl1);
        flightRepository.add(fl2);
        flightRepository.add(fl3);
        flightRepository.add(fl4);
        flightRepository.add(fl5);

        // ticket
        //TODO(fields)
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        Ticket t4 = new Ticket();
        Ticket t5 = new Ticket();
        Ticket t6 = new Ticket();
        ticketRepository.add(t1);
        ticketRepository.add(t2);
        ticketRepository.add(t3);
        ticketRepository.add(t4);
        ticketRepository.add(t5);
        ticketRepository.add(t6);

    }
}
