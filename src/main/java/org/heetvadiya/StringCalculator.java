package org.heetvadiya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public int add(String input) {
        if(input.isEmpty()){
            return 0;
        }
        int sum = 0;
        String delimiter = "[,\\n]"; // Default delimiters : "," and "\n"
        String [] numbers;
        List<String> negativeNumbers = new ArrayList<>();

        if(input.startsWith("//")){
            int del_start_ind = input.indexOf("//");
            int del_end_ind = input.indexOf("\n");

            delimiter = input.substring(del_start_ind+2, del_end_ind);

            input = input.substring(del_end_ind+1);

            String[] escapeCharacters = new String[]{ "\n" , "\t" , "\r" , "\f" , "\b" , "\\" , "\"" };
            if(Arrays.asList(escapeCharacters).contains(delimiter)){
                delimiter = "\\" + delimiter;
            }

        }
        numbers = input.split(delimiter);
        for(String number : numbers) {
            int intNumber = parseInt(number);
            if(intNumber < 0){
                negativeNumbers.add(number);
            }
            sum += intNumber;
        }

        if(!negativeNumbers.isEmpty()){
            String negativeNumbersList = String.join(", ", negativeNumbers);
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbersList);
        }
        return sum;
    }
}
