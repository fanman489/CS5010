package calculator;

import static java.lang.Character.isDigit;


/**
 * This class includes common methods used by calculator designs.
 */
abstract class AbstractCalculator implements Calculator {


  /**
   * This method checks whether the input is allowed by the calculator, which is either a
   * digit 0-9 or an operator +, -, *, =, or C for clearing the calculator.
   * If not, it will throw an error. If it is, it will determine the type and output an indicator.
   * @param input The input is a character.
   * @return This method returns an 'i' if the input is an integer, 'e' for input of '=',
   *          'p' for input of '+', 'm' for input of '-', 'x' for input of '*', and c for input
   *          of 'c'.
   * @throws IllegalArgumentException The exception is thrown when the input is not one of the
   *          allowed characters.
   */
  Character checkInput(Character input) throws IllegalArgumentException {

    if (isDigit(input)) {
      return 'i';
    }
    switch (input) {
      case '=':
        return 'e';
      case '+':
        return 'p';
      case '-':
        return 'm';
      case '*':
        return 'x';
      case 'C':
        return 'c';
      default:
        throw new IllegalArgumentException("Invalid input " + input.toString());
    }
  }


  /**
   * This method will take two numbers and perform the calculation specified by the operation.
   * @param operation The operation to be performed as a character.
   * @param firstNumber The first number to perform the calculation on as an integer.
   * @param secondNumber The second number to perform the calculation on as an integer.
   * @return Returns the result of the calculation as an integer.
   */
  Integer performCalculation(Character operation,
                                       Integer firstNumber, Integer secondNumber) {
    switch (operation) {
      case '+':
        if (Integer.MAX_VALUE - secondNumber >= firstNumber) {
          firstNumber = firstNumber + secondNumber;
        } else {
          firstNumber = 0;
        }

        return firstNumber;

      case '-':
        if (Integer.MIN_VALUE + secondNumber <= firstNumber) {
          firstNumber = firstNumber - secondNumber;
        } else {
          firstNumber = 0;
        }
        return firstNumber;

      case '*':
        if (Integer.MIN_VALUE / secondNumber <= firstNumber
                && Integer.MAX_VALUE / secondNumber >= firstNumber) {
          firstNumber = firstNumber * secondNumber;
        } else {
          firstNumber = 0;
        }

        return firstNumber;

      default:
        return firstNumber;
    }
  }


  /**
   * This method updates an integer based on the character input. The character input needs to be
   * a digit, and the method will append it to the end of the integer input into the method.
   * @param inputValue The character to be appended. It should be a digit between 0-9.
   * @param firstNumber The number to append the digit to.
   * @return Returns an integer with the input character appended to the end.
   * @throws RuntimeException This method will throw an exception if the resulting integer
   *           is too large.
   */
  Integer updateNumber(Character inputValue, Integer firstNumber) throws RuntimeException {

    Integer result = Character.getNumericValue(inputValue);

    if (firstNumber == null) {
      firstNumber = result;
    } else {
      if ( ((Integer.MAX_VALUE - result) / 10) >= firstNumber) {
        firstNumber = firstNumber * 10 + result;
      } else {
        throw new RuntimeException("Input integer is too high");
      }
    }
    return firstNumber;
  }

}
