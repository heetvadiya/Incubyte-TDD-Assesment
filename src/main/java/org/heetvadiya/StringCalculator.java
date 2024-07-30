package org.heetvadiya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public String DELIMITER = "[,\\n]"; // Default delimiters : "," and "\n"

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

    public String escapeSpecialChars(String delimiter) {
        if (delimiter.isEmpty()) {
            return "\\Q\\E"; // Return a neutral pattern if delimiter is empty
        }
        return delimiter.replaceAll("([\\[\\]\\\\*+?.()|^$])", "\\\\$1");
    }

    public String processDelimiterSection(String deliSection){
        String delimiter = "";

        if (deliSection.startsWith("[") && deliSection.endsWith("]")) {
            deliSection = deliSection.substring(1, deliSection.length() - 1);
            String[] delimiters = deliSection.split("]\\[");
            delimiter = Arrays.stream(delimiters)
                    .map(this::escapeSpecialChars)
                    .reduce("", (acc, d) -> acc + "|" + d);

            delimiter = delimiter.substring(1); // Remove the leading '|'
        } else {
            delimiter = escapeSpecialChars(deliSection);
        }

        return delimiter;
    }

    public int add(String input) {
        if(input.isEmpty()){
            return 0;
        }

        int sum = 0;
        String [] numbers;
        List<String> negativeNumbers = new ArrayList<>();

        if(input.startsWith("//")){
            int delimiterStartInd = input.indexOf("//") + 2;
            int delimiterEndInd = input.indexOf("\n");

            String delimiterSection = input.substring(delimiterStartInd, delimiterEndInd);

            DELIMITER = processDelimiterSection(delimiterSection);

            input = input.substring(delimiterEndInd+1);

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
