package pl.sda.library.enums;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class OldCarOperations {

    @Test
    /*
     * Stwórz instancję klasy OldCar, initcjalizując ją wartością SEDAN
     */
    public void properValue() {
        OldCar old = new OldCar(OldCar.SEDAN);
    }

    @Test
    /*
     * Stwórz instancję klasy OldCar, initcjalizując ją wartością SEDAN
     * Spróbuj nadpisać wartość używając metody setType i wartości spoza zdefiowanych
     * Czy operacja się powiedzie?
     */
    public void rougeProgrammer() {
        OldCar oldCar = new OldCar(4444);
        oldCar.setType(43535);
        assertThat(oldCar.getType()).isEqualByComparingTo(new Integer("43539"));
    }
}
