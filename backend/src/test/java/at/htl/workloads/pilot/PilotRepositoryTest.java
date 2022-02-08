package at.htl.workloads.pilot;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
class PilotRepositoryTest {

    @Inject
    private PilotRepository pilotRepository;

    @Test
    @TestTransaction
    public void addPilot_getPilot_success(){
        Pilot pi1 = new Pilot("Bill", "Chill", "bill.chill@gmail.com", "194206421", LocalDate.parse("1980-01-24"), "098765432", "PI01", BigDecimal.valueOf(1500.00), null, "A8347BE843Y", Double.parseDouble("150.00"), "pw1234", "user");
        Pilot pi2 = new Pilot("Hillary", "Right", "hillary.right@gmail.com", "863210631", LocalDate.parse("1997-11-10"), "764320196", "PI02", BigDecimal.valueOf(2500.00), null, "D45FRT4545323", Double.parseDouble("600.00"), "pw1234", "user");
        Pilot pi4 = new Pilot("Jenny", "Air", "jenny.air@gmail.com", "851230632", LocalDate.parse("1990-10-05"), "865424210", "PI04", BigDecimal.valueOf(1000.00), null, "KLDNF0328943DE9", Double.parseDouble("50.00"), "pw1234", "user");

        assertThatCode(() -> pilotRepository.add(pi1)).doesNotThrowAnyException();
        assertThatCode(() -> pilotRepository.add(pi2)).doesNotThrowAnyException();
        assertThatCode(() -> pilotRepository.add(pi4)).doesNotThrowAnyException();

        var loadedPi2 = pilotRepository.getPilot(2L);

        assertThat(loadedPi2).isNotNull().isEqualTo(pi2);
        assertThat(loadedPi2.getPilotNumber()).isEqualTo(pi2.getPilotNumber());
        assertThat(loadedPi2.getSocialSecurityNumber()).isEqualTo(pi2.getSocialSecurityNumber());
        assertThat(loadedPi2.getExtraPayment()).isEqualTo(pi2.getExtraPayment());
    }
}