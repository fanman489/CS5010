package polynomial;

public class PolynomialNodeEmpty implements PolynomialNode {

  public PolynomialNode addBack(Polynomial p){
    return addFront(p);
  }

  public PolynomialNode addFront(Polynomial p) {
    return new PolynomialNodeElement(p, this);
  };

  public PolynomialNode addTerm(Polynomial p) {
    return addFront(p);
  }


  public String toString() {
    return "";
  }

  public Integer getDegree() {
    return 0;
  }


  public Integer getCoefficient(Integer p) throws IllegalArgumentException {
    throw new IllegalArgumentException("There is no term with this coefficient.");
  }

  public Double evaluate(Double d) {
    return 0.0;
  }

  public PolynomialNode derive() {
    return this;
  }


  public Integer count() {
    return 0;
  }


  public PolynomialNode removeFirstElement() {
    return this;
  }



}
