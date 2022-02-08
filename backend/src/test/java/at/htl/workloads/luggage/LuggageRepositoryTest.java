package at.htl.workloads.luggage;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.*;

@QuarkusTest
class LuggageRepositoryTest {

    @Inject
    private LuggageRepository luggageRepository;

    @Test
    @TestTransaction
    public void addLuggage_getLuggage_success(){
        Luggage lu6 = new Luggage(1.00, Size.Small, "U398");
        Luggage lu7 = new Luggage(2.00, Size.Large, "U399");
        Luggage lu8 = new Luggage(3.00, Size.Medium, "U400");
        Luggage lu9 = new Luggage(4.00, Size.Large, "U401");

        assertThatCode(() -> luggageRepository.add(lu6)).doesNotThrowAnyException();
        assertThatCode(() -> luggageRepository.add(lu7)).doesNotThrowAnyException();
        assertThatCode(() -> luggageRepository.add(lu8)).doesNotThrowAnyException();
        assertThatCode(() -> luggageRepository.add(lu9)).doesNotThrowAnyException();

        var loadedLu8 = luggageRepository.getLuggage(3L);

        assertThat(loadedLu8).isNotNull().isEqualTo(lu8);
        assertThat(loadedLu8.getLuggageNumber()).isEqualTo(lu8.getLuggageNumber());
        assertThat(loadedLu8.getSize()).isEqualTo(lu8.getSize());
        assertThat(loadedLu8.getWeight()).isEqualTo(lu8.getWeight());
    }
}