package at.htl.workloads.travelclass;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
class TravelClassRepositoryTest {

    @Inject
    private TravelClassRepository travelClassRepository;

    @Test
    @TestTransaction
    public void addTravelClass_getTravelClass_success(){
        TravelClass trC1 = new TravelClass("first", 150.00, false, false, true, 2);
        TravelClass trC2 = new TravelClass("business", 230.00, false, true, true, 3);
        TravelClass trC3 = new TravelClass("economy", 300.00, true, true, true, 5);

        assertThatCode(() -> travelClassRepository.add(trC1)).doesNotThrowAnyException();
        assertThatCode(() -> travelClassRepository.add(trC2)).doesNotThrowAnyException();
        assertThatCode(() -> travelClassRepository.add(trC3)).doesNotThrowAnyException();

        var loadedTrC2 = travelClassRepository.getTravelClass(2L);

        assertThat(loadedTrC2).isNotNull().isEqualTo(trC2);
        assertThat(loadedTrC2.getName()).isEqualTo(trC2.getName());
        assertThat(loadedTrC2.getPrice()).isEqualTo(trC2.getPrice());
    }
}