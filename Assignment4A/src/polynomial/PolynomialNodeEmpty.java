package polynomial;

/**
 * Represents an empty node of the polynomial list. This represents the end of the list.
 */

public class PolynomialNodeEmpty implements PolynomialNode {


  /**
   * Adding a new term to the empty node.
   * @param comparator A class with the method to compare the degree of two polynomials.
   * @param insert New polynomial term.
   * @return Returns a new node ahead of the empty node.
   */
  public PolynomialNode addTerm(ComparePower comparator, PolynomialTerm insert) {
    return new PolynomialNodeElement(insert, this);
  }

  /**
   * Outputs a 0 when reaching the end of the list when converting to string..
   * @return Returns the end of the string of the polynomial list..
   */
  @Override
  public String toString() {
    return "0";
  }


  /**
   * Gets the degree of the empty node.
   * @return Returns 0 for empty term.
   */
  public int getDegree() {
    return 0;
  }


  /**
   * Gets the coefficient for the empty node.
   * @param p Input the degree to get the coefficient for.
   * @return Returns 0 for the empty node.
   */
  public int getCoefficient(int p) {
    return 0;

  }

  /**
   * Returns the end of the evaluation for the end of the evaluation.
   * @param e A class with the evaluate function.
   * @param d The number as a double to evaluate with.
   * @return Returns 0.0 for an empty node.
   */
  public Double evaluate(EvaluatePolynomial e, Double d) {
    return 0.0;
  }

  /**
   * Returns the end of the list of the derivative.
   * @return Returns the list of polynomials in the derivative.
   */
  public PolynomialNode derive() {
    return this;
  }


  /**
   * Represents the end of the count.
   * @return Contributes 0 to the count.
   */
  public Integer count() {
    return 0;
  }


  /**
   * Returns the list of polynomials with the 0 coefficient terms removed.
   * @return Returns the list of polynomials.
   */
  public PolynomialNode removeNoCoefficient() {
    return this;
  }



}
