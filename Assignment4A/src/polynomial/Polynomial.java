package polynomial;


/**
 * This class represents the methods to create a polynomial list. It allows the user to add terms,
 * get the maximum degree of the polynomial, get the coefficient of a certain term in the
 * polynomial based on the degree, evaluate with a given number, take the derivative of, and
 * add two polynomials together.
 */

public interface Polynomial {

  /**
   * This method creates a polynomial term.
   * @param c The coefficient of the polynomial.
   * @param d The power of the polynomial.
   */
  void addTerm(int c, int d);


  /**
   * The gets the highest degree of the polynomial.
   * @return Returns the degree.
   */
  int getDegree();

  /**
   * Gets the coefficient of the polynomial at the specified degree.
   * @param power Gets the power that you want the coeffienct of.
   * @return Returns the coefficient of that term.
   */
  int getCoefficient(int power);

  /**
   * Calculates the answer of the polynomial given the digit.
   * @param input The digit to evaluate the polynomial from.
   * @return Returns the result of the polynomial.
   */
  double evaluate(Double input);

  /**
   * Returns the polynomial after taking the derivative.
   * @return Returns the derivative of the polynomial.
   */
  Polynomial derivative();

  /**
   * Adds the polynomial to another polynomial.
   * @param p The polynomial to add.
   * @return Returns the polynomial of the two added togher.
   */
  Polynomial add(Polynomial p);

  /**
   * Checks whether the two polynomials are equal.
   * @param p The polynomial to compare to.
   * @return Returns whether they are equal or not.
   */
  @Override
  boolean equals(Object p);

  /**
   * Returns the polynomial as a string.
   * @return Returns the polynomial string.
   */
  @Override
  String toString();


}
