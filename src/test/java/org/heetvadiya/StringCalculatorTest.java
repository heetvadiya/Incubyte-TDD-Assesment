package org.heetvadiya;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void empty_string_should_return_0() {
        assertEquals(0,stringCalculator.add(""));
    }

    @Test
    public void single_number_string_should_return_that_number() {
        assertEquals(1,stringCalculator.add("1"));
        assertEquals(20,stringCalculator.add("20"));
    }

    @Test
    public void two_number_string_should_return_sum_of_two(){
        assertEquals(3,stringCalculator.add("1,2"));
        assertEquals(10, stringCalculator.add("6,4"));
    }


}
