package polynomial;

public class PolynomialNodeElement implements PolynomialNode {

  private Polynomial polynomial;
  private PolynomialNode rest;

  public PolynomialNodeElement(Polynomial p, PolynomialNode n) {
    polynomial = p;
    rest = n;
  }


  public PolynomialNode addFront(Polynomial polynomial) {
    return new PolynomialNodeElement(polynomial, this);
  }

  public PolynomialNode addBack(Polynomial polynomial) {
    this.rest = this.rest.addBack(polynomial);
    return this;
  }


  //Is it ok to mutate in this case when the power of the elements are the same
  public PolynomialNode addTerm(Polynomial insert) {

    Integer power = insert.getPower();

    if (this.polynomial.getPower() > power) {
      return new PolynomialNodeElement(this.polynomial, this.rest.addTerm(insert));
    } else if (this.polynomial.getPower() < power) {
      return new PolynomialNodeElement(insert, this);

    } else {
      this.polynomial.add(insert);
      return this;
    }

  }

  public String toString() {
    return this.polynomial.toString() + " + " + this.rest.toString();
  }

  public Integer getDegree() {
    return this.polynomial.getPower();
  }

  public Integer getCoefficient(Integer p) {
    if (polynomial.getPower() == p ) {
      return this.polynomial.getCoefficient();
    } else {
      return this.rest.getCoefficient(p);
    }
  }


  public Double evaluate(Double d) {
    return this.polynomial.evaluate(d) + this.rest.evaluate(d);
  }

  public PolynomialNode derive() {
    return new PolynomialNodeElement(this.polynomial.derive(), this.rest.derive());
  }

  public Integer count() {
    return (1 + this.rest.count());
  }



  public PolynomialNode removeFirstElement() {
    return this.rest;
  }

}





