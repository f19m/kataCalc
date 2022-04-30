import org.junit.jupiter.api.Test;
import ru.kata.calc.numberSystem.Rome;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomeTest {
    @Test
    public void converFrom0To100PassIfCorrect(){
        for (int i = 1; i <= 100; i++) {
            assertEquals(Rome.convertRomeToArabic(Rome.convertArabicToRome(i)), i);
        }
    }
}
