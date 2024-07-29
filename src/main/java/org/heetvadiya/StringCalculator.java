package org.heetvadiya;

import org.junit.jupiter.api.Test;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculator {
    public int add(String input) {
        if(input.isEmpty()){
            return 0;
        }
        int sum = 0;
        String delimiter = ",|\\n";
        String [] numbers;
        if(input.startsWith("//")){
            int del_start_ind = input.indexOf("//");
            int del_end_ind = input.indexOf("\n");

            delimiter = input.substring(del_start_ind+2, del_end_ind);

            String onlyNumbers = input.substring(del_end_ind+1);

            numbers = onlyNumbers.split(delimiter);
        }
        else{
            numbers = input.split(delimiter);
        }

        for(String number : numbers) {
            sum += parseInt(number);
        }
        return sum;
    }
}
