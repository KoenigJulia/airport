package at.htl.workloads.airplane;

import at.htl.workloads.IntTestBase;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AirplaneRepositoryTest extends IntTestBase {

    @Inject
    AirplaneRepository airplaneRepository;

    @Order(1)
    @Test
    void T01_getAirplane() {
        assertThat(airplaneRepository.getAirplane(1L).getAirplaneNr()).isEqualTo("P01");
    }

    @Order(2)
    @Test
    void T02_getToFuel() {
        List<Airplane> toFuel = airplaneRepository.getToFuel();
//        Airplane ap3 = new Airplane("P03", 10000.00, 5000.00, 6, 11000.00, 200.00, 12, 6, 500);

        assertThat(toFuel.size()).isEqualTo(1);

        assert(airplaneRepository.getToFuel().size() == 1);
    }
}