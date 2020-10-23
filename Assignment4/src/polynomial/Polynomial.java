package polynomial;

public class Polynomial {

  private Integer power;
  private Integer coefficient;


  public Polynomial(Integer p, Integer c) {
    power = p;
    coefficient = c;

  }

  public Integer getPower() {
    return power;
  }

  public Integer getCoefficient() {
    return coefficient;
  }

  public Double evaluate(Double input) {
    return coefficient * Math.pow(input, power);
  }

  public void add(Polynomial p) {
    this.coefficient = this.coefficient + p.coefficient;
  }

  public String toString() {
    if (power == 1) {
      return Integer.toString(coefficient) + "X";
    } else if (power == 0) {
      return Integer.toString(coefficient);
    } else {
      return Integer.toString(coefficient) + "X^" + Integer.toString(power);
    }
  }

  public Polynomial derive() {

    return new Polynomial(this.power - 1, this.coefficient * this.power);

  }


}
