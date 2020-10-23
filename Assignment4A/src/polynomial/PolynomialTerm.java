package polynomial;

/**
 * This class represents an object that stores a single term of the polynomial. It contains the
 * power and coefficient for the term.
 */
public class PolynomialTerm {

  private int power;
  private int coefficient;


  /**
   * Creates a polynomial term.
   * @param p The power or degree of the term.
   * @param c The coefficient of the term.
   * @throws IllegalArgumentException Throws an exception when the power is less than 0.
   */
  public PolynomialTerm(int p, int c) throws IllegalArgumentException {
    if (c == 0 ) {
      return;
    }

    if (power < 0) {
      throw new IllegalArgumentException("Invalid degree.");
    }
    power = p;
    coefficient = c;

  }

  protected int getPower() {
    return power;
  }

  protected int getCoefficient() {
    return coefficient;
  }



  protected void add(PolynomialTerm p) {
    try {
      this.coefficient = Math.addExact(this.coefficient, p.coefficient);
    } catch (ArithmeticException ex) {
      throw new ArithmeticException("Coefficient out of bounds.");
    }
  }

  @Override
  public String toString() {
    if (power == 0) {
      return Integer.toString(coefficient);
    } else {
      return Integer.toString(coefficient) + "x^" + Integer.toString(power);
    }
  }

  protected PolynomialTerm derive() {
    return new PolynomialTerm(this.power - 1, this.coefficient * this.power);
  }


}
