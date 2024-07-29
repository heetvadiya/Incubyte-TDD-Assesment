package org.heetvadiya;

import org.junit.jupiter.api.Test;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculator {
    public int add(String input) {
        if(input.isEmpty()){
            return 0;
        }
        String[] numbers = input.split(",");
        if (numbers.length == 1) {
            return parseInt(numbers[0]);
        }
        int sum = 0;
        if(numbers.length == 2) {
            sum = parseInt(numbers[0]) + parseInt(numbers[1]);
            return sum;
        }
        for(String number : numbers) {
            sum += parseInt(number);
        }
        return sum;
    }
}
