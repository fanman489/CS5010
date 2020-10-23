package polynomial;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PolynomialListTest {

  PolynomialList testList = new PolynomialListImpl();

  Polynomial p = new Polynomial(1, 2);
  Polynomial q = new Polynomial(2, 4);
  Polynomial r = new Polynomial(5, 1);
  Polynomial s = new Polynomial(2, 3);
  Polynomial t = new Polynomial(3, 3);

  PolynomialList testList2 = new PolynomialListImpl();

  Polynomial u = new Polynomial(7, 1);
  Polynomial v = new Polynomial(3, 2);
  Polynomial w = new Polynomial(4, 1);



  @Test
  public void testAddTerm() {

    testList.addTerm(p);
    testList.addTerm(q);
    testList.addTerm(r);
    testList.addTerm(s);
    testList.addTerm(t);


    testList2.addTerm(u);
    testList2.addTerm(v);
    testList2.addTerm(w);

    PolynomialList testListDerive = testList.add(testList2);
    assertEquals(testListDerive.toString(), "");

    assertEquals(testList.toString(), "");


    assertEquals(testList.evaluate(1.0), (Double) 13.0);
    assertEquals(testList.getDegree(), (Integer) 5);
    assertEquals(testList.getCoefficient(2), (Integer) 5);


  }

}