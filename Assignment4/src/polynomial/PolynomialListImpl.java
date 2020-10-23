package polynomial;

public class PolynomialListImpl implements PolynomialList {

  private PolynomialNode head;

  public PolynomialListImpl() {
    head = new PolynomialNodeEmpty();
  }

  public PolynomialListImpl(PolynomialNode p) {
    head = p;
  }


  public void addTerm(Polynomial p) {
    head = head.addTerm(p);
  }

  public Integer getDegree() {
    return head.getDegree();
  }

  public Integer getCoefficient(Integer power) {
    return head.getCoefficient(power);
  }


  public PolynomialList derive() {
    return new PolynomialListImpl(this.head.derive());
  }

  public String toString() {
    return head.toString();
  }

  public Double evaluate(Double d) {
    return head.evaluate(d);
  }

  public Integer count() {
    return head.count();
  }

  public PolynomialList removeFirstElement() {
    return new PolynomialListImpl(this.head.removeFirstElement());
  }


  public PolynomialList add(PolynomialList p) {
    Integer d;
    Integer c;
    PolynomialList test = this;
    PolynomialList input = p;

    do {
      d = input.getDegree();
      c = input.getCoefficient(d);

      test.addTerm(new Polynomial(d, c));
      input = input.removeFirstElement();
    } while (input.count() > 0);

    return test;
  }

}
