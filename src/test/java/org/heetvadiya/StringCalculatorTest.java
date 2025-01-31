package org.heetvadiya;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(25,stringCalculator.add("6,4,9,1,5"));
        assertEquals(7, stringCalculator.add("1,2,4"));
    }

    @Test
    public void newline_as_delimeter_should_also_work(){
        assertEquals(3,stringCalculator.add("1\n2"));
        assertEquals(19,stringCalculator.add("6\n4\n9"));
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void given_different_delimiter_should_work(){
        assertEquals(3,stringCalculator.add("//;\n1;2"));
        assertEquals(6,stringCalculator.add("//;\n1;2;3"));
        assertEquals(6,stringCalculator.add("//>\n1>2>3"));
    }

    @Test
    public void given_different_delimiter_should_work_if_its_escape_character(){
        assertEquals(3,stringCalculator.add("//\\\n1\\2"));
        assertEquals(6,stringCalculator.add("//\t\n1\t2\t3"));
        assertEquals(10,stringCalculator.add("//\"\n1\"2\"3\"4"));
    }

    @Test
    public void negetive_number_should_throw_exception(){
        assertThrows(IllegalArgumentException.class,()->stringCalculator.add("1002,-4"),"Negatives not allowed -4");
        assertThrows(IllegalArgumentException.class,()->stringCalculator.add("1001, 1003, 1009, -8, -9 , -11"),"Negatives not allowed -8 -9 -11");
        assertThrows(IllegalArgumentException.class,()->stringCalculator.add("-10, -3"),"Negatives not allowed -10, -3");
    }

    @Test
    public void numbers_bigger_than_1000_should_be_ignored(){
        assertEquals(3, stringCalculator.add("1002,3"));
        assertEquals(6 , stringCalculator.add("1001,1,2,3,1"));
        assertEquals(6 , stringCalculator.add("1001\n1\n2\n3\n1"));
    }


    @Test
    public void given_delimiter_with_any_length_should_work(){
        assertEquals(3,stringCalculator.add("//[;;;]\n1;;;2"));
        assertEquals(6,stringCalculator.add("//[;;;]\n1;;;2;;;3"));
        assertEquals(7,stringCalculator.add("//[***]\n1***2***4***1"));
        assertEquals(13,stringCalculator.add("//[]\n1246"));
    }


    @Test
    public void given_multiple_delimiter_with_any_length_should_work(){
        assertEquals(8,stringCalculator.add("//[;;;][===]\n1;;;2===5"));
        assertEquals(23,stringCalculator.add("//[;;;][+++]\n1+++2;;;3+++8+++9"));
        assertEquals(10,stringCalculator.add("//[***][;;][+++++]\n1***2+++++4;;3"));
    }

    @Test
    public void duplicates_should_be_ignored(){
        assertEquals(10, stringCalculator.add("//;\n1;1;2;3;4"));
    }

}
