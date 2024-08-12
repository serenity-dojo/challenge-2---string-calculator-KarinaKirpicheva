package com.serenitydojo.calculator;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WhenDoingMathsTest {
    Calculator calculator = new Calculator();

    @Test
    public void shouldReturnZeroForAnEmptyString() {
        assertThat(calculator.evaluate("")).isEqualTo(0);

    }


    @Test
    public void shouldReportNonSupportedOperations() {
        assertThatThrownBy(() -> calculator.evaluate("1 ^ 2"))
                .isInstanceOf(IllegalMathOperatorException.class)
                .hasMessageContaining("Unsupported operator");
    }

    @Test
    public void shouldReturnTheValueOfASingleNumber() {
        assertThat(calculator.evaluate("1")).isEqualTo(1);
    }

    @Test
    public void shouldAddTwoNumbers() {
        assertThat(calculator.evaluate("1 + 1")).isEqualTo(2);
    }

    @Test
    public void shouldAddThreeNumbers() {
        assertThat(calculator.evaluate("1 + 2 + 3")).isEqualTo(6);
    }

    @Test
    public void shouldAlsoSubtract() {
        assertThat(calculator.evaluate("10 - 6")).isEqualTo(4);
    }

    @Test
    public void shouldAddAndSubtract() {
        assertThat(calculator.evaluate("10 + 5 - 6")).isEqualTo(9);
    }

    @Test
    public void shouldMultiplyNumbers() {
        assertThat(calculator.evaluate("10 * 5")).isEqualTo(50);
    }

}




