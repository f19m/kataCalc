import org.junit.jupiter.api.Test;
import ru.kata.calc.CalcException;
import ru.kata.calc.CalcFactory;
import ru.kata.calc.numberSystem.Rome;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcFactoryTest {
    @Test
    public void wrongStrErrPass() {
        assertThrows(CalcException.class, () -> CalcFactory.calc("asdas"));
    }
    @Test
    public void wrongExpressionErrPass() {
        assertThrows(CalcException.class, () -> CalcFactory.calc("1 + 2 + 3"));
    }
    @Test
    public void wrongTypeErrPass() {
        assertThrows(CalcException.class, () -> CalcFactory.calc("1 + V"));
    }

    @Test
    public void wrongArabicInputIntervalsErrPass() {
        assertThrows(CalcException.class, () -> CalcFactory.calc("11 + 1"));
    }

    @Test
    public void wrongRomeInputIntervalsErrPass() {
        assertThrows(CalcException.class, () -> CalcFactory.calc("XX + V"));
    }

    @Test
    public void negativeRomeErrPass() {
        assertThrows(CalcException.class, () -> CalcFactory.calc("V - X"));
    }

    @Test
    public void zeroRomeErrPass() {
        assertThrows(CalcException.class, () -> CalcFactory.calc("V - V"));
    }

    @Test
    public void romeAdditionPass() {
        assertEquals(CalcFactory.calc("I + V"), Rome.convertArabicToRome(1+5));
    }
    @Test
    public void romeDivisionPass() {
        assertEquals(CalcFactory.calc("VIII / IV"), Rome.convertArabicToRome(8/4));
    }
    @Test
    public void romeMultiplicationPass() {
        assertEquals(CalcFactory.calc("V * IX"), Rome.convertArabicToRome(5 * 9));
    }
    @Test
    public void romeSubtractionPass() {
        assertEquals(CalcFactory.calc("X - VI"), Rome.convertArabicToRome(10 -6));
    }


}
