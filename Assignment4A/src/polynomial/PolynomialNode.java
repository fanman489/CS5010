package polynomial;

/**
 * This class represents a node of a polynomial list. This is a recursive list structure
 * that can store nodes containing polynomial terms. It allows the user to add terms to the list,
 * count, take the derivative, get the maximum degree and coefficients of terms in the polynomial
 * list.
 */
public interface PolynomialNode {

  /**
   * This method will add a term to the list of polynomial nodes. It will add to the position
   * such that the list will stay in decreasing order of it's power. Like terms will be combined.
   * @param comparator A class with the method to compare the degree of two terms.
   * @param insert A new polynomial term.
   * @return Returns a new node containing the polynomial that will be added to the list.
   */
  PolynomialNode addTerm(ComparePower comparator, PolynomialTerm insert);


  /**
   * This method will give the highest degree of the polynomial list.
   * @return Returns the degree as an integer.
   */
  int getDegree();

  /**
   * This method specifies the coefficient given the power.
   * @param p Input the degree to get the coefficient of.
   * @return Outputs the coefficient of the term with the degree.
   */
  int getCoefficient(int p);

  /**
   * Evaluates the terms using the given number.
   * @param e A class with the evaluate function.
   * @param d The number as a double to evaluate with.
   * @return Returns the results as a double.
   */
  Double evaluate(EvaluatePolynomial e, Double d);

  /**
   * Gets the derivative of this term.
   * @return Returns a new node with the derivative.
   */
  PolynomialNode derive();

  /**
   * Counts the number of terms in the polynomial list.
   * @return Returns the count as an integer.
   */
  Integer count();

  /**
   * Outputs the polynomials in the list as a string.
   * @return Returns the polynomial as a list.
   */
  String toString();


  /**
   * Removes the terms that have a coefficient of 0.
   * @return Returns the nodes that do not have a coefficient of 0.
   */
  PolynomialNode removeNoCoefficient();

}
