import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ReversePolishNotationCalculatorTest {
    static ReversePolishNotationCalculator calculator;

    @BeforeAll
    static void init() {
        calculator = new ReversePolishNotationCalculator();
    }

    @Test
    public void shouldCalculatePus() {
        int answer = calculator.calculatePolishNotation("2 3 +");
        assertEquals(5, answer);
    }

    @Test
    public void shouldCalculateMinus() {
        int answer = calculator.calculatePolishNotation("2 3 -");
        assertEquals(-1, answer);
    }

    @Test
    public void shouldCalculateMultiply() {
        int answer = calculator.calculatePolishNotation("2 3 *");
        assertEquals(6, answer);
    }

    @Test
    public void shouldCalculateLastNumbersWhenNumberMoreThenOperation() {
        int answer = calculator.calculatePolishNotation("2 3 4 5 +");
        assertEquals(9, answer);
    }

    @Test
    public void shouldThrowExceptionWhenOperationMoreThenNumbers() {
        assertThrows(NoSuchElementException.class, () -> {
            calculator.calculatePolishNotation("2 3 + - *");
        });
    }
    @Test
    public void shouldThrowExceptionWhenUsedIncorrectSymbol() {
        assertThrows(NumberFormatException.class, ()->{
            calculator.calculatePolishNotation("2 3 n-");
        });
    }
    @Test
    public void shouldCalculateWhenUsedDoubleSpaceSymbol() {
           int answer = calculator.calculatePolishNotation("2 3  -");
            assertEquals(-1, answer);
    }
}
