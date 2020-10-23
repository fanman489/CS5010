package polynomial;

/**
 * This represents a node for the list containing the polynomial. This is part of a list containing
 * multiple terms of polynomials.
 */

public class PolynomialNodeElement implements PolynomialNode {

  private PolynomialTerm polynomialTerm;
  private PolynomialNode rest;

  public PolynomialNodeElement(PolynomialTerm p, PolynomialNode n) {
    polynomialTerm = p;
    rest = n;
  }

  /**
   * Adds a node to the list, based on the power of the term. The higher terms added towards the
   * beginning of the list.
   * @param comparator A class containing the formula to compare the degree of two polynomials.
   * @param insert The polynomial term to insert.
   * @return Return a new node into the list. If there is a node with the same power, this will
   *          add the coefficients of the two polynomials, and the polynomial term in the list
   *          will be mutated.
   */
  public PolynomialNode addTerm(ComparePower comparator, PolynomialTerm insert) {

    if (comparator.compare(this.polynomialTerm, insert) > 0) {
      return new PolynomialNodeElement(this.polynomialTerm, this.rest.addTerm(comparator, insert));
    } else if (comparator.compare(this.polynomialTerm, insert) < 0) {
      return new PolynomialNodeElement(insert, this);

    } else {
      this.polynomialTerm.add(insert);
      return this;
    }
  }


  /**
   * Outputs the polynomial as a string, using "x" as the variable.
   * @return Polynomial string.
   */
  @Override
  public String toString() {
    return this.polynomialTerm.toString() + "+" + this.rest.toString();
  }


  /**
   * Returns the degree of the current term.
   * @return Degree as an integer.
   */
  public int getDegree() {
    return this.polynomialTerm.getPower();
  }

  /**
   * Returns the coefficient of the term with the specified degree.
   * @param p The power to get the term of.
   * @return Returns the coefficient as an integer.
   */
  public int getCoefficient(int p) {
    if (polynomialTerm.getPower() == p ) {
      return this.polynomialTerm.getCoefficient();
    } else {
      return this.rest.getCoefficient(p);
    }
  }


  /**
   * Evaluates the term of the polynomial using the input double.
   * @param e The class which contains the calculation function for the term.
   * @param d The double to evaluate with.
   * @return Returns as a double the result term.
   */
  public Double evaluate(EvaluatePolynomial e, Double d) {
    return e.applyAsDouble(polynomialTerm, d) + this.rest.evaluate(e, d);
  }

  /**
   * Returns the derivative of the polynomial.
   * @return A node that is the derivative of the polynomial.
   */
  public PolynomialNode derive() {
    return new PolynomialNodeElement(this.polynomialTerm.derive(), this.rest.derive());
  }


  /**
   * Provides the count of the node as counted from the front of the list.
   * @return Returns the count as an integer.
   */
  public Integer count() {
    return (1 + this.rest.count());
  }


  /**
   * Method that removes terms with 0 as the coefficient from the list.
   * @return Returns a list of nodes with all non-zero coefficients.
   */
  public PolynomialNode removeNoCoefficient() {

    if (this.polynomialTerm.getCoefficient() == 0) {
      return this.rest;
    } else {
      this.rest = this.rest.removeNoCoefficient();
      return this;
    }
  }


}





