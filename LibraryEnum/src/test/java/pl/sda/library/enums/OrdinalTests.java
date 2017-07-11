package pl.sda.library.enums;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(JUnit4.class)
public class OrdinalTests {

    @Test
    /*
     * Wypisz liczbę osób w zespole, zapisaną w enumie
     * BandType za pomocą metody numberOfMusicians()
     * dla wartości QUINTET.
     * Zanotuj sobie co zostało zwrócone.
     */
    public void showQuintetMusiciansNumber() {

        assertThat(BandType.QUARTET.numberOfMusicians()).isEqualTo(4);
    }

    @Test
    /*
     * Zmień kolejność przesuwając deklarację typu QUINTET
     * na sam początek.
     * Ponownie wypisz liczbę osób w zespole dla typu QUINTET.
     * Porównaj co zostało zwrócone w pierwszym podejściu!
     */
    public void showQuintetMusiciansNumberOops() {
      assertThat(BandType.QUARTET.numberOfMusicians()).isEqualTo(4);
    }
}
