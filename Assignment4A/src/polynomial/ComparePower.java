package polynomial;

import java.util.Comparator;

/**
 * This class represents a function that will compare the degree of two polynomial terms.
 */
public class ComparePower implements Comparator<PolynomialTerm> {

  /**
   * Compares the power of two terms, will return less than 0 if p1 is less than p2, and greater
   * than 0 if p1 is bigger than p2, and 0 if they are equal.
   * @param p1 First polynomialTerm object.
   * @param p2 Second polynomialTerm object.
   * @return Returns an integer based on the comparison.
   */
  @Override
  public int compare(PolynomialTerm p1, PolynomialTerm p2) {
    return p1.getPower() - p2.getPower();
  }
}
