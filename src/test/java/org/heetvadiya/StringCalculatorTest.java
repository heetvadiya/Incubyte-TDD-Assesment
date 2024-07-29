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

    @Test
    public void any_amount_of_number_string_should_return_sum_of_all_those_number(){
        assertEquals(3,stringCalculator.add("1,2"));
        assertEquals(12,stringCalculator.add("6,4,2"));
        assertEquals(24,stringCalculator.add("6,4,9,1,4"));
        assertEquals(19, stringCalculator.add("1,2,4,1,2,3,2,4"));
    }

    @Test
    public void newline_as_delimeter_should_also_work(){
        assertEquals(3,stringCalculator.add("1\n2"));
        assertEquals(19,stringCalculator.add("6\n4\n9"));
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }


}
