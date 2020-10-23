package calculator;


/**
 * This interface is used for classes that will simulate a calculator.
 *
 */
public interface Calculator {

  /**
   * This method allows the user to input the numbers or operators into the calculator.
   * @param input Input a character into the calculator.
   * @return This method returns a Calculator object.
   */
  Calculator input(Character input);


  /**
   * This method will output the current inputs of the calculator as a string.
  */
  String getResult();


}
