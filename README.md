# Incubyte TDD Assessment

This repository contains a simple implementation of a String Calculator, following the Test-Driven Development (TDD) approach. The calculator processes strings of numbers and returns the sum of those numbers seperated by delimiters.

---
The `StringCalculator` class provides a method `add(String numbers)` which performs the calculation based on the input string.

### Method Signature

```java
public int add(String numbers);
```

### Examples

- `""` → `0`
- `"1"` → `1`
- `"1,5"` → `6`
- `"1\n2,3"` → `6`
- `"//;\n1;2"` → `3`
- `"1\n2"` → `3`
- `"6\n4\n9"` → `19`
- `"1\n2,3"` → `6`
- `"//\\\n1\\2"` → `3`
- `"//\t\n1\t2\t3"` → `6`
- `"//\"\n1\"2\"3\"4"` → `10`
- `"3,4,-8"` → Throws exception with message `"Negative numbers not allowed: -8"`
- `"-7, -9, -10 , -11"` → Throws exception with message `"Negative numbers not allowed: -7, -9, -10, -11"`
- `"1001,1,2,3,1"` → `7`
- `"1001\n1\n2\n3\n1"` → `7`
- `"//[;;;]\n1;;;2;;;3"` → `6`
- `"//[***]\n1***2***4***1"` → `8`
- `"//[;;;][===]\n1;;;20===5"` → `26`
- `"//[***][;;][+++++]\n1***2+++++4;;1"` → `8`
- `"//[]\n1241"` → `8`

## Test Cases

The test class `StringCalculatorTest` contains various test cases to ensure the functionality of the `StringCalculator`. Each test validates different aspects of the implementation.

### Tests

1. **Empty String Should Return 0**

2. **Single Number String Should Return That Number**

3. **Two Number String Should Return Sum of Two**

4. **Any Amount of Number String Should Return Sum of All Those Numbers**

5. **Newline as Delimiter Should Also Work**

6. **Given Different Delimiter Should Work**

7. **Given Different Delimiter Should Work If It's an Escape Character**

8. **Negative Number Should Throw Exception**

9. **Numbers Bigger Than 1000 Should Be Ignored**

10. **SumOfNumbers Method Should Return the Sum of the Numbers**

11. **Given Delimiter with Any Length Should Work**

12. **EscapeSpecialChars Method Should Escape Special Characters**

13. **Given Multiple Delimiters with Any Length Should Work**

## Refactoring and Improvements

Each feature was implemented incrementally, and tests were written to ensure functionality. `escapeSpecialChars` Method is added as a helper to handle special characters as delimiters.
`processDelimiterSection` Method is added to help process delimiter string. `sumOfNumbers` Method is there to just sum the given numbers.

## Regarding Commits
I have ensured to follow TDD methodology throughout the assesment , and in order to showcase that I have made very Frequent commits (some had only 1 or 2 lines of changes).
Which helps users to understand `Red Green Purple` Methodology of Adding a failing case, then writing only enough code to pass that single failing case and at last Refactoring. Repeat the process again for each new requirement.
Hope Very frequent commit is not a bad practice.

### References :
- The Three Laws of TDD - Uncle Bob
- Test-Driven Developement - Fireship

### Test Coverage :
![Test Coverage](https://github.com/heetvadiya/Incubyte-TDD-Assesment/blob/main/assets/TestCoverage.png)

## Thank You Incubyte

For providing this amazing learning opportunity to explore TDD - Heet Vadiya