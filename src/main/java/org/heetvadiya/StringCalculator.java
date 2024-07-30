package org.heetvadiya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public String DELIMITER = "[,\\n]"; // Default delimiters : "," and "\n"
    public final String[] ESC_CHARS = new String[]{ "\n" , "\t" , "\r" , "\f" , "\b" , "\\" , "\"" };

    public int sumOfNumbers(String[] numArray , List<String> negNumbers){
        int tempSum = 0;
        for(String number : numArray) {
            int intNumber = parseInt(number);
            if(intNumber < 0){
                negNumbers.add(number);
            }
            else if(intNumber <= 1000){
                tempSum += intNumber;
            }
        }
        return tempSum;
    }

    public int add(String input) {
        if(input.isEmpty()){
            return 0;
        }

        int sum = 0;
        String [] numbers;
        List<String> negativeNumbers = new ArrayList<>();

        if(input.startsWith("//")){
            int delimiter_start_ind = input.indexOf("//");
            int delimiter_end_ind = input.indexOf("\n");

            DELIMITER = input.substring(delimiter_start_ind+2, delimiter_end_ind);

            input = input.substring(delimiter_end_ind+1);

            if(Arrays.asList(ESC_CHARS).contains(DELIMITER)){
                DELIMITER = "\\" + DELIMITER;
            }
        }

        numbers = input.split(DELIMITER);

        sum = sumOfNumbers(numbers, negativeNumbers);

        if(!negativeNumbers.isEmpty()){
            String negativeNumbersList = String.join(", ", negativeNumbers);
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbersList);
        }

        return sum;
    }
}
