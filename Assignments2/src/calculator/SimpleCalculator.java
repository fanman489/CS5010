package calculator;


/**
 * This class represents a simple calculator. The simple calculator takes inputs one character
 * at a time. The calculator handles positive inputs only although it can output negative numbers.
 * The operations it can handle are addition, subtraction, and multiplication. The calculator will
 * show the current output and results. Inputs into the calculator must be in the form of
 * operand, operator, operand. If entered in another order the calculator will throw an error.
 * Entering 'C' will clear the contents of the calculator.
 */

public class SimpleCalculator extends AbstractCalculator {

  private Integer firstNumber;
  private Integer secondNumber;
  private Character operator;

  /**
   * Constructor for the simple calculator.
   */
  public SimpleCalculator() {
    firstNumber = null;
    secondNumber = null;
    operator = null;
  }


  /**
   * Input digits into the calculator one at a time. Inputs must be in the format of operand,
   * operator, operand. Any other order of inputs will result in an error. Negative numbers cannot
   * be input. If the calculated result is too large for the calculator to handle, the result
   * will be 0. If the input operand is too large, you will get an error message. After two
   * operands and an operator have been input, entering another operator will cause the calculator
   * to perform the first operation on the two operands.
   * @param inputValue Input values into the calculator as a character. Inputs can be either
   *                   0 -9 or an operator +, -, *, or =. Entering 'C' will clear all inputs.
   * @return This method returns a SmartCalculator class object with the numbers and operations
   *                   updated based on the input.
   * @throws IllegalArgumentException This method will throw the exception when the character
    *                  input is not one of the characters specified above. It also throws the
   *                   exception if you hit C when there is nothing in the calculator.
   */
  @Override
  public SimpleCalculator input(Character inputValue) throws IllegalArgumentException {

    Character selector = checkInput(inputValue);


    //Clear the calculator inputs if C entered.
    if (selector == 'c') {
      if (firstNumber == null) {
        throw new IllegalArgumentException("Inputs already cleared");
      } else {
        firstNumber = null;
        secondNumber = null;
        operator = null;
        return this;
      }
    }




    //Populate first number until an operator is input.
    if (operator == null) {
      if (selector == 'i') {
        updateFirstNumber(inputValue);
      } else {
        if (firstNumber == null) {
          throw new IllegalArgumentException("Need to input number");
        }
        if (selector == 'e') {
          operator = inputValue;
          return this;
        } else {
          operator = inputValue;
        }
      }

    } else {


      if (operator == '=' && selector == 'i'){
        throw new IllegalArgumentException("Need to input an operation");
      }

      //Populate second number until operator is input.
      if (selector == 'i') {


        updateSecondNumber(inputValue);
      } else {



        if (secondNumber == null) {
          throw new IllegalArgumentException("Need to input second number");
        }



        if (selector == 'e') {
          calculate(operator);
          secondNumber = null;
          operator = inputValue;
        } else {
          calculate(operator);
          secondNumber = null;
          operator = inputValue;
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
    }
    if (operator == null || operator == '=') {
      return firstNumber.toString();
    } else if (secondNumber == null) {
      return firstNumber.toString() + operator.toString();
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
  //Performs the calculation on the two numbers already entered.
  private void calculate(Character operation) {
    firstNumber = performCalculation(operation, firstNumber, secondNumber);
  }








}