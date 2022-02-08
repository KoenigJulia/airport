package at.htl.workloads.location;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
class LocationRepositoryTest {

    @Inject
    private LocationRepository locationRepository;

    @Test
    @TestTransaction
    public void addLocation_getLocation_success(){
        Location l1 = new Location("Austria", "Vienna", "Vienna International Airport", "1300 Schwechat", "VIE");
        Location l2 = new Location("Austria", "Graz", "Graz Airport", "8073 Feldkirchen bei Graz", "GRZ");
        Location l3 = new Location("Austria", "Linz", "Linz Airport", "Flughafenstraße 1, 4063 Hörsching", "LNZ");

        assertThatCode(() -> locationRepository.add(l1)).doesNotThrowAnyException();
        assertThatCode(() -> locationRepository.add(l2)).doesNotThrowAnyException();
        assertThatCode(() -> locationRepository.add(l3)).doesNotThrowAnyException();

        var loadedL3 = locationRepository.getLocation(3L);

        assertThat(loadedL3).isNotNull().isEqualTo(l3);
        assertThat(loadedL3.getIATA()).isEqualTo(l3.getIATA());
    }
}