package polynomial;

import java.util.Scanner;

/**
 * This class represents a specific polynomial list. It is pointed to the head of
 * a list of polynomials.
 */

public class PolynomialImpl implements Polynomial {

  private PolynomialNode head;

  /**
   * Creates a blank polynomial.
   */
  public PolynomialImpl() {
    head = new PolynomialNodeEmpty();
  }

  /**
   * Creates a polynomial starting at a specific term of the polynomial.
   * @param p A polynomial term that will become the start of a new polynomial.
   */
  private PolynomialImpl(PolynomialNode p) {
    head = p;
  }

  /**
   * Add a term to the polynomial. The new term takes the coefficient and power from the input. If
   * the polynomial already has a term with the same degree, the coefficients will be added
   * together.
   * @param coefficient The coefficient of the polynomial.
   * @param degree The power of the polynomial.
   * @throws IllegalArgumentException Will throw exception if the power is negative.
   */
  public void addTerm(int coefficient, int degree) throws IllegalArgumentException {
    if (degree < 0) {
      throw new IllegalArgumentException("Invalid degree.");
    }

    head = head.addTerm(new ComparePower(), new PolynomialTerm(degree, coefficient));
    head = head.removeNoCoefficient();
  }


  /**
   * Get the highest degree of this polynomial.
   * @return Returns the degree as an integer.
   */
  public int getDegree() {
    return head.getDegree();
  }


  /**
   * Returns the coefficient of the given power.
   * @param power Gets the power that you want the coeffienct of.
   * @return Returns the coefficient of the term.
   */
  public int getCoefficient(int power) {
    return head.getCoefficient(power);
  }


  /**
   * Takes the derivative of the polynomial.
   * @return Returns the result of the derivative.
   */
  public Polynomial derivative() {
    return new PolynomialImpl(this.head.derive().removeNoCoefficient());
  }


  /**
   * Outputs the polynomial as a string.
   * @return Polynomial as a string.
   */
  @Override
  public String toString() {

    if (head.count() == 0) {
      return "0";
    }

    String concact = "";
    if (head.toString().charAt(0) == '+') {
      concact = head.toString().substring(1);
    } else {
      concact = head.toString();
    }

    concact = concact.replaceAll("\\+\\-", "-");
    concact = concact.substring(0, concact.length() - 2);
    return concact;

  }


  /**
   * Calculates the parameter given the number for x. If result is too large, will output Infinity
   * for positive large number or a NaN for negative.
   * @param digit Evaluate the function using this double.
   * @return Returns the result of the function.
   */
  public double evaluate(Double digit) {
    EvaluatePolynomial e = new EvaluatePolynomial();
    return head.evaluate(e, digit);
  }


  /**
   * Adds two polynomials together. This will create a new polynomial and
   * will not mutate any of the polynomials.
   * @param p The polynomial to add.
   * @return Returns the sum of the two polynomials.
   */
  public Polynomial add(Polynomial p) {

    String s = this.toString();
    String t = p.toString();

    s = s.replaceAll("\\+", " \\+");
    s = s.replaceAll("\\-", " \\-");
    t = t.replaceAll("\\+", " \\+");
    t = t.replaceAll("\\-", " \\-");

    String st = s + " +" + t;
    st = st.replaceAll("\\+ \\-", "-");
    return new PolynomialImpl(st);

  }


  /**
   * Check whether the two polynomials are the same.
   * @param p The polynomial to compare to.
   * @return A boolean indicating whether they're equal.
   */
  @Override
  public boolean equals(Object p) {

    if (this == p) {
      return true;
    }

    if (!(p instanceof PolynomialImpl)) {
      return false;
    }

    String s = this.toString();
    String t = p.toString();

    s = s.replaceAll("\\+", " \\+");
    s = s.replaceAll("\\-", " \\-");
    t = t.replaceAll("\\+", " \\+");
    t = t.replaceAll("\\-", " \\-");

    Polynomial sNew = new PolynomialImpl(s);
    Polynomial tNew = new PolynomialImpl(t);

    return sNew.toString().equals(tNew.toString());

  }

  /**
   * This constructor creates a polynomial based on a string input. The input must be a string,
   * where "x" is the variable name. The terms must be separated by a single space.
   * @param input Input the string containing the polynomial.
   * @throws IllegalArgumentException Throws the exception if the string does not follow the
   *                                   format specified.
   */
  public PolynomialImpl(String input) throws IllegalArgumentException {

    head = new PolynomialNodeEmpty();
    String readFromScanner = "";
    int coefficient;
    int degree;
    String temp1;
    String temp2;

    if (input.isEmpty()) {
      throw new IllegalArgumentException("Invalid polynomial.");
    }

    Scanner fromStr = new Scanner(input);
    fromStr.useDelimiter(" ");

    while (fromStr.hasNext()) {
      readFromScanner = fromStr.next();
      Scanner exp = new Scanner(readFromScanner);
      exp.useDelimiter("x\\^");

      temp1 = exp.next();
      coefficient = checkInteger(temp1);

      if (exp.hasNext()) {
        temp2 = exp.next();
        degree = checkInteger(temp2);
      } else {
        degree = 0;
      }

      if (degree < 0) {
        throw new IllegalArgumentException("Invalid Polynomial.");
      }
      head = head.addTerm(new ComparePower(), new PolynomialTerm(degree, coefficient));

    }

    head = head.removeNoCoefficient();
  }

  //Checks if the string is in the format of +/- and digits.
  private int checkInteger(String s) throws IllegalArgumentException {
    if (!s.matches("[+-]?\\d+")) {
      throw new IllegalArgumentException("Invalid Polynomial.");
    }
    return Integer.parseInt(s);
  }


  /**
   * Updates the hash function, in conjunction with the equals method.
   * @return Returns the hash number.
   */
  @Override
  public int hashCode() {
    return head.getDegree() + head.getCoefficient(head.getDegree());
  }


}
