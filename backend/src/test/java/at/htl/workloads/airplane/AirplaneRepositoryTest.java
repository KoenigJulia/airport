package at.htl.workloads.airplane;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.*;

@QuarkusTest
class AirplaneRepositoryTest {

    @Inject
    private AirplaneRepository airplaneRepository;

    @Test
    @TestTransaction
    void addThreeAirplanesGetSecondAirplane_access() {
        Airplane ap1 = new Airplane("P01", 5000.00, 3000.00, 4, 10000.00, 300.00, 8, 6, 100);
        Airplane ap2 = new Airplane("P02", 6000.00, 5000.00, 4, 10500.00, 250.00, 10, 6, 200);
        Airplane ap3 = new Airplane("P03", 10000.00, 5000.00, 6, 11000.00, 200.00, 12, 6, 500);
        assertThatCode(() -> airplaneRepository.add(ap1)).doesNotThrowAnyException();
        assertThatCode(() -> airplaneRepository.add(ap2)).doesNotThrowAnyException();
        assertThatCode(() -> airplaneRepository.add(ap3)).doesNotThrowAnyException();

        var loadedAp2 = airplaneRepository.getAirplane(2L);
        assertThat(loadedAp2).isNotNull().isEqualTo(ap2);
        assertThat(loadedAp2.getAirplaneNr()).isEqualTo(ap2.getAirplaneNr());
        assertThat(loadedAp2.getActualFuel()).isEqualTo(ap2.getActualFuel());
    }
}