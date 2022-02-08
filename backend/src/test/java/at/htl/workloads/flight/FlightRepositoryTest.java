package at.htl.workloads.flight;

import at.htl.workloads.airplane.Airplane;
import at.htl.workloads.airplane.AirplaneRepository;
import at.htl.workloads.employee.Employee;
import at.htl.workloads.employee.EmployeeRepository;
import at.htl.workloads.location.Location;
import at.htl.workloads.location.LocationRepository;
import at.htl.workloads.pilot.Pilot;
import at.htl.workloads.pilot.PilotRepository;
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

@QuarkusTest
class FlightRepositoryTest {

    @Inject
    private FlightRepository flightRepository;
    @Inject
    private LocationRepository locationRepository;
    @Inject
    private AirplaneRepository airplaneRepository;
    @Inject
    private PilotRepository pilotRepository;
    @Inject
    private EmployeeRepository employeeRepository;

    @Test
    @TestTransaction
    public void addFlight_getFlight_success(){
        Location l1 = new Location("Austria", "Vienna", "Vienna International Airport", "1300 Schwechat", "VIE");
        Location l2 = new Location("Austria", "Graz", "Graz Airport", "8073 Feldkirchen bei Graz", "GRZ");
        Location l3 = new Location("Austria", "Linz", "Linz Airport", "Flughafenstraße 1, 4063 Hörsching", "LNZ");

        assertThatCode(() -> locationRepository.add(l1)).doesNotThrowAnyException();
        assertThatCode(() -> locationRepository.add(l2)).doesNotThrowAnyException();
        assertThatCode(() -> locationRepository.add(l3)).doesNotThrowAnyException();

        Airplane ap1 = new Airplane("P01", 5000.00, 3000.00, 4, 10000.00, 300.00, 8, 6, 100);
        Airplane ap2 = new Airplane("P02", 6000.00, 5000.00, 4, 10500.00, 250.00, 10, 6, 200);

        assertThatCode(() -> airplaneRepository.add(ap1)).doesNotThrowAnyException();
        assertThatCode(() -> airplaneRepository.add(ap2)).doesNotThrowAnyException();

        Pilot pi1 = new Pilot("Bill", "Chill", "bill.chill@gmail.com", "194206421", LocalDate.parse("1980-01-24"), "098765432", "PI01", BigDecimal.valueOf(1500.00), null, "A8347BE843Y", Double.parseDouble("150.00"), "pw1234", "user");
        Pilot pi2 = new Pilot("Hillary", "Right", "hillary.right@gmail.com", "863210631", LocalDate.parse("1997-11-10"), "764320196", "PI02", BigDecimal.valueOf(2500.00), null, "D45FRT4545323", Double.parseDouble("600.00"), "pw1234", "user");
        Pilot pi4 = new Pilot("Jenny", "Air", "jenny.air@gmail.com", "851230632", LocalDate.parse("1990-10-05"), "865424210", "PI04", BigDecimal.valueOf(1000.00), null, "KLDNF0328943DE9", Double.parseDouble("50.00"), "pw1234", "user");

        assertThatCode(() -> pilotRepository.add(pi1)).doesNotThrowAnyException();
        assertThatCode(() -> pilotRepository.add(pi2)).doesNotThrowAnyException();
        assertThatCode(() -> pilotRepository.add(pi4)).doesNotThrowAnyException();


        Employee e1 = new Employee("Larry", "Remplfarmer", "l.remplfarmer@gmail.com", "06502342533", LocalDate.parse("2001-01-23"), "924351064", "EMP102345", BigDecimal.valueOf(700.00), null, true, "pw1234", "user");
        Employee e2 = new Employee("Parrley", "Remplfarmer", "p.remplfarmer@gmail.com", "01231153523", LocalDate.parse("2000-10-10"), "123409649", "EMP134528", BigDecimal.valueOf(1000.00), null, true, "pw1234", "user");
        Employee e3 = new Employee("Danny", "Kenny", "d.kenny@gmail.com", "015321023321", LocalDate.parse("1990-02-10"), "0673863086", "EMP1063465", BigDecimal.valueOf(1500.00), null, true, "pw1234", "user");

        assertThatCode(() -> employeeRepository.add(e1)).doesNotThrowAnyException();
        assertThatCode(() -> employeeRepository.add(e2)).doesNotThrowAnyException();
        assertThatCode(() -> employeeRepository.add(e3)).doesNotThrowAnyException();


        Flight fl1 = new Flight(l1, "G1", LocalDateTime.of(2022, Month.JANUARY, 20, 16, 30), l3, "G2", 209.00, ap1, LocalDateTime.of(2022, Month.JANUARY, 20, 20, 30), List.of(e1, e2), pi1, pi2);
        Flight fl2 = new Flight(l2, "G3", LocalDateTime.of(2021, Month.DECEMBER, 24, 4, 15), l1, "G6", 201.00, ap2, LocalDateTime.of(2021, Month.DECEMBER, 24, 9, 15), List.of(e1, e3), pi2, pi4);

        assertThatCode(() -> flightRepository.add(fl1)).doesNotThrowAnyException();
        assertThatCode(() -> flightRepository.add(fl2)).doesNotThrowAnyException();

        var loadedFlight = flightRepository.getFlight(2L);

        assertThat(loadedFlight).isNotNull().isEqualTo(loadedFlight);
        assertThat(loadedFlight.getAirplane().getAirplaneNr()).isEqualTo(ap2.getAirplaneNr());
        assertThat(loadedFlight.getPilot().getPilotNumber()).isEqualTo(pi2.getPilotNumber());
        assertThat(loadedFlight.getArrivalGate()).isEqualTo(fl2.getArrivalGate());
        assertThat(loadedFlight.getCoPilot().getPilotNumber()).isEqualTo(pi4.getPilotNumber());
    }
}