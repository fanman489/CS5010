package calculator;


/**
 * This class represents a smart calculator. It does everything the simple calculator does, but
 * is able to infer operand inputs.
 * It handles addition, subtraction, and multiplication. Inputs cannot be negative, but calculated
 * outputs can be negative. In addition to the simple calculator, the smart calculator can also
 * handle: <br>
 *   - Input operator after another operator will overwrite the first operator. <br>
 *   - Input operator followed by '=', the calculator will perform the operation on the last
 *   number input. <br>
 *   - Input '=' after a '=' will repeat the last operation performed. <br>
 *   - Input an operator first, other than a '-', the operator will be ignored. An input of '-'
 *   will result in an error.
 */
public class SmartCalculator extends AbstractCalculator {


  private Integer firstNumber;
  private Integer secondNumber;
  private Character operator;
  private boolean inMemory = false;
  private Character storedOperator;
  private Integer storedNumber;


  /**
   * Constructor for the SmartCalculator.
   */
  public SmartCalculator() {
    firstNumber = null;
    secondNumber = null;
    operator = null;
    storedOperator = null;
    storedNumber = null;

  }



  /**
   * Input digits into the calculator one at a time. Inputs must be in the format of operand.
   * Negative numbers cannot be input. If the calculated result is too large for the calculator
   * to handle, the result will be 0.
   * If the input operand is too large, you will get an error message. After two
   * operands and an operator have been input, entering another operator will cause the calculator
   * to perform the first operation on the two operands. Please read the comments for this class
   * regarding features of the smart calculator.
   * @param inputValue Input values into the calculator as a character. Inputs can be either
   *                   0 -9 or an operator +, -, *, or =. Entering 'C' will clear all inputs.
   * @return This method returns a SmartCalculator class object with the numbers and operations
   *                   updated based on the input.
   * @throws IllegalArgumentException This method will throw the exception when the character
   *                    input is not one of the characters specified above. It also throws the
   *                    exception when you input C when the calculator is empty.
   */

  @Override
  public SmartCalculator input(Character inputValue) throws IllegalArgumentException {

    Character selector = checkInput(inputValue);

    if (selector == 'c') {
      if (firstNumber == null) {
        throw new IllegalArgumentException("Inputs are empty.");
      } else {
        firstNumber = null;
        secondNumber = null;
        operator = null;
        storedOperator = null;
        storedNumber = null;
        inMemory = false;
        return this;
      }
    }


    if (operator == null) {
      if (selector == 'i') {
        updateFirstNumber(inputValue);
      } else {

        if (firstNumber == null) {
          if (selector == 'm') {
            throw new IllegalArgumentException("Cannot input negative number.");
          } else {
            return this;
          }
        }

        if (selector == 'e' ) {
          return this;
        } else {
          storedNumber = firstNumber;
          operator = inputValue;
        }
      }

    } else {

      if (selector == 'i') {

        updateSecondNumber(inputValue);
      } else {

        if (secondNumber == null) {

          if (selector == 'e') {
            storedOperator = operator;
            secondNumber = storedNumber;
            calculate(storedOperator);
            secondNumber = null;
            inMemory = true;
          } else {
            operator = inputValue;
            storedOperator = inputValue;
            inMemory = false;
            getResult();
            return this;
          }

        } else {
          storedNumber = secondNumber;
          calculate(operator);
          secondNumber = null;

          if (selector == 'e') {
            inMemory = true;
          } else {
            operator = inputValue;
            inMemory = false;
          }
        }
      }
    }

    return this;
  }


  /**
   * This method will output the current inputs into the calculator. If you input an operator, the
   * output will show the input. When you input '=' it will display the result. If you have already
   * entered two operands and an operator, upon entering the second operator the calculator
   * will show the result of first operation on the two numbers along with the new operator.
   * @return Outputs the current numbers and operators in the calculator as a string.
   */

  @Override
  public String getResult() {

    if (firstNumber == null) {
      return "";
    } else if (operator == null) {
      return firstNumber.toString();
    } else if (secondNumber == null) {
      if (inMemory) {
        return firstNumber.toString();
      } else {
        return firstNumber.toString() + operator.toString();
      }
    } else {
      return firstNumber.toString() + operator.toString() + secondNumber.toString();
    }

  }


  /**
   * This method takes the first number and updates it based on the new number input. It will
   * update the current first number stored in the calculator as an integer.
   * @param inputValue This is the character input by the user, it should be a character between
   *                  0-9.
   * @throws RuntimeException This method will throw an exception if the number is too large
   *                  for the integer to handle.
   */
  private void updateFirstNumber(Character inputValue) throws RuntimeException {
    firstNumber = updateNumber(inputValue, firstNumber);
  }


  /**
   * This method takes the second number and updates it based on the new number input. It will
   * update the current second number stored in the calculator as an integer.
   * @param inputValue This is the character input by the user, it should be a character between
   *                  0-9.
   * @throws RuntimeException This method will throw an exception if the number is too large
   *                  for the integer to handle.
   */
  private void updateSecondNumber(Character inputValue) throws RuntimeException {
    secondNumber = updateNumber(inputValue, secondNumber);
  }


  /**
   * This method performs the operation specified on the two or single number stored in the
   * calculator.
   * @param operation This input specifies the operation to be performed.
   */
  private void calculate(Character operation) {
    firstNumber = performCalculation(operation, firstNumber, secondNumber);
  }



}




