# Incubyte TDD Assesment

This repository contains a simple implementation of a String Calculator, following the Test-Driven Development (TDD) approach. The calculator processes strings of numbers, handling different delimiters and supporting negative number validation.

`StringCalculator` class, provides a method `add(String numbers)` which performs the calculation based on the input string.

### Method Signature

```java
public int add(String numbers)
```

### Examples

- `""` → `0`
- `"1"` → `1`
- `"1,5"` → `6`
- `"1\n2,3"` → `6`
- `"//;\n1;2"` → `3`

## Test Cases

The test class `StringCalculatorTest` contains various test cases to ensure the functionality of the `StringCalculator`. Each test validates different aspects of the implementation.

### Tests

1. **Empty String Should Return 0**

   - **Test**: `empty_string_should_return_0`
   - **Description**: Verifies that an empty string returns 0.
   - **Example**: `""` → `0`

2. **Single Number String Should Return That Number**

   - **Test**: `single_number_string_should_return_that_number`
   - **Description**: Checks if a single number string returns the number itself.
   - **Examples**: `"1"` → `1`, `"20"` → `20`

3. **Two Number String Should Return Sum of Two**

   - **Test**: `two_number_string_should_return_sum_of_two`
   - **Description**: Validates the sum of two comma-separated numbers.
   - **Examples**: `"1,2"` → `3`, `"6,4"` → `10`

4. **Any Amount of Number String Should Return Sum of All Those Numbers**

   - **Test**: `any_amount_of_number_string_should_return_sum_of_all_those_number`
   - **Description**: Ensures the sum of multiple comma-separated numbers is computed correctly.
   - **Examples**: `"6,4,2"` → `12`, `"6,4,9,1,4"` → `24`, `"1,2,4,1,2,3,2,4"` → `19`

5. **Newline as Delimiter Should Also Work**

   - **Test**: `newline_as_delimeter_should_also_work`
   - **Description**: Confirms that new lines can be used as delimiters along with commas.
   - **Examples**: `"1\n2"` → `3`, `"6\n4\n9"` → `19`, `"1\n2,3"` → `6`

6. **Given Different Delimiter Should Work**

   - **Test**: `given_different_delimiter_should_work`
   - **Description**: Validates the use of a custom delimiter specified in the input string.
   - **Examples**: `"//;\n1;2"` → `3`, `"//;\n1;2;3"` → `6`

7. **Given Different Delimiter Should Work If It's an Escape Character**

   - **Test**: `given_different_delimiter_should_work_if_its_escape_character`
   - **Description**: Checks support for escape characters as delimiters.
   - **Examples**: `"//\\\n1\\2"` → `3`, `"//\t\n1\t2\t3"` → `6`, `"//\"\n1\"2\"3\"4"` → `10`

8. **Negative Number Should Throw Exception**

   - **Test**: `negetive_number_should_throw_exception`
   - **Description**: Ensures that an exception is thrown for negative numbers, listing all negative numbers in the message.
   - **Examples**: `"3,4,-8"` → Throws exception with message `"Negative numbers not allowed: -8"`, `"-8"` → Throws exception with message `"Negative numbers not allowed: -8"`, `"-7, -9, -10 , -11"` → Throws exception with message `"Negative numbers not allowed: -7, -9, -10, -11"`

## Refactoring and Improvements

Each feature was implemented incrementally, and tests were written to ensure functionality. The final implementation supports various delimiters, handles new lines, and validates negative numbers, providing a robust solution to the problem.

## Thank You Incubyte

For providing this amazing learning opportunity to explore TDD - Heet Vadiya