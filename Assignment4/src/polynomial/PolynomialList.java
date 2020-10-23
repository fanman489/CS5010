package polynomial;

public interface PolynomialList {

  void addTerm(Polynomial p);

  Integer getDegree();

  Integer getCoefficient(Integer power);

  Double evaluate(Double input);

  PolynomialList derive();

  PolynomialList add(PolynomialList p);

  Integer count();

  PolynomialList removeFirstElement();

}
