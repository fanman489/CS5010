package polynomial;

public interface PolynomialNode {


  PolynomialNode addBack(Polynomial p);

  PolynomialNode addFront(Polynomial p);

  PolynomialNode addTerm(Polynomial p);

  Integer getDegree();

  Integer getCoefficient(Integer p);

  Double evaluate(Double d);

  PolynomialNode derive();

  Integer count();

  PolynomialNode removeFirstElement();
}
