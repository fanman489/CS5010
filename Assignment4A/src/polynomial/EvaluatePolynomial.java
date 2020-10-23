package polynomial;

import java.util.function.ToDoubleBiFunction;

/**
 * This class represents a function for evaluating the polynomial
 * given the degrees and coefficients.
 */

public class EvaluatePolynomial implements ToDoubleBiFunction<PolynomialTerm, Double> {

  /**
   * Evaluates the term.
   * @param p The polynomial term containing the coefficient and power.
   * @param d The input to the polynomial as a double.
   * @return Returns as a double the result of the evaluation for that term.
   */
  public double applyAsDouble(PolynomialTerm p, Double d) {

    double j = 1.0;
    for (int i = 0; i < p.getPower(); i++) {
      j = j * d;
    }

    return p.getCoefficient() * j;
  }

}
