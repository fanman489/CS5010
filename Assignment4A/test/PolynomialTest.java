import polynomial.Polynomial;

import polynomial.PolynomialImpl;


import org.junit.Test;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * Testing for the polynomial objects.
 */

public class PolynomialTest {

  Polynomial testList = new PolynomialImpl();
  Polynomial testList2 = new PolynomialImpl();

  @Test
  public void testAddTerm() {

    assertEquals("0", testList.toString());

    testList.addTerm(1, 1);

    assertEquals("1x^1", testList.toString());
    testList.addTerm(2, 2);
    testList.addTerm(3, 3);
    testList.addTerm(4, 4);
    testList.addTerm(1, 7);

    assertEquals("1x^7+4x^4+3x^3+2x^2+1x^1", testList.toString());

    testList2.addTerm(1,0);
    assertEquals("1", testList2.toString());
    testList2.addTerm(-2,2);
    assertEquals("-2x^2+1", testList2.toString());
    testList2.addTerm(4,4);
    assertEquals("4x^4-2x^2+1", testList2.toString());
    testList2.addTerm(4,4);
    assertEquals("8x^4-2x^2+1", testList2.toString());
    testList2.addTerm(2,0);
    assertEquals("8x^4-2x^2+3", testList2.toString());


    Polynomial test = new PolynomialImpl();

    assertEquals(test.toString(), "0");

    test.addTerm(1, 1);
    test.addTerm(2, 2);
    test.addTerm(3, 3);
    test.addTerm(2010101010, 7);
    test.addTerm(7, 7);
    test.addTerm(3, 0);


    try {
      test.addTerm(2010101010, 7);
      Assert.fail();
    } catch (ArithmeticException ex) {
      assertEquals("Coefficient out of bounds.", ex.getMessage());
    }



  }

  @Test
  public void testConstructUsingString() {


    Polynomial a = new PolynomialImpl("");
    assertEquals("", a.toString());


    Polynomial x = new PolynomialImpl("3x^2 +3x^3 -2x^1 -5");
    assertEquals("3x^3+3x^2-2x^1-5", x.toString());

    Polynomial h = new PolynomialImpl("3x^2 +3x^3 -2x^1 -5 +4x^2");
    assertEquals("3x^3+7x^2-2x^1-5", h.toString());


    try {
      Polynomial z = new PolynomialImpl("2x^2 +6x^1-5");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid Polynomial.", ex.getMessage());
    }

    try {
      Polynomial z = new PolynomialImpl("2x^2 +6x^-1 -5");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid Polynomial.", ex.getMessage());
    }

    try {
      Polynomial z = new PolynomialImpl("2x^2 +6x^e -5");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid Polynomial.", ex.getMessage());
    }

  }




  @Test
  public void testGetDegree() {

    assertEquals(0, testList.getCoefficient(1));

    testList.addTerm(1, 1);
    testList.addTerm(2, 2);
    testList.addTerm(3, 3);
    testList.addTerm(4, 4);
    testList.addTerm(7, 7);
    testList.addTerm(3, 0);
    testList.addTerm(-5, 0);

    assertEquals(7, testList.getCoefficient(7));
    assertEquals(1, testList.getCoefficient(1));
    assertEquals(2, testList.getCoefficient(2));
    assertEquals(-2, testList.getCoefficient(0));
    assertEquals(0, testList.getCoefficient(5));


  }



  @Test
  public void testEvaluateShort() {

    Polynomial test = new PolynomialImpl();

    assertEquals(test.evaluate(2.0), 0, 0.001);

    test.addTerm(1, 1);

    assertEquals(test.evaluate(2.0), 2.0, 0.001);
    test.addTerm(2, 2);
    test.addTerm(-3, 3);
    test.addTerm(-4, 4);
    test.addTerm(7, 7);
    test.addTerm(3, 0);

    assertEquals(test.evaluate(2.0), 821.0, 0.001);

    test.addTerm(5, 20430);

    assertEquals(Double.isInfinite(test.evaluate(10.0)), true);

  }


  @Test
  public void testDerivative() {

    Polynomial test = new PolynomialImpl();

    assertEquals(test.derivative().toString(), "0");

    test.addTerm(1, 1);
    assertEquals(test.derivative().toString(), "1");
    test.addTerm(2, 3);
    assertEquals(test.derivative().toString(), "6x^2+1");
    test.addTerm(3, 3);
    test.addTerm(2, 3);
    test.addTerm(7, 7);
    test.addTerm(3, 0);

    assertEquals(test.toString(), "7x^7+7x^3+1x^1+3");
    assertEquals(test.derivative().toString(), "49x^6+21x^2+1");

  }


  @Test
  public void testGetCoefficient() {

    Polynomial test = new PolynomialImpl();

    assertEquals(test.getCoefficient(1), 0);

    test.addTerm(1, 1);
    test.addTerm(2, 3);
    test.addTerm(3, 3);
    test.addTerm(2, 3);
    test.addTerm(3, 0);
    test.addTerm(3, 0);

    assertEquals(test.toString(), "7x^3+1x^1+6");
    assertEquals(test.getCoefficient(1), 1);
    assertEquals(test.getCoefficient(0), 6);
    assertEquals(test.getCoefficient(3), 7);

  }


  @Test
  public void testStringPolynomialCreation() {

    Polynomial x = new PolynomialImpl("3x^3 +3x^2 -5 -2x^1");
    assertEquals("3x^3+3x^2-2x^1-5", x.toString());

    Polynomial h = new PolynomialImpl("3x^3 +3x^2 -5 -72");
    assertEquals("3x^3+3x^2-77", h.toString());

    try {
      Polynomial z = new PolynomialImpl("3x^2+4x^1 -2");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid Polynomial.", ex.getMessage());
    }

    try {
      Polynomial z = new PolynomialImpl("3x^-1 +9x^3 -2x^1 -5");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid Polynomial.", ex.getMessage());
    }
  }


  @Test
  public void testAddPolynomial() {

    testList.addTerm(1, 1);
    testList.addTerm(2, 3);
    testList.addTerm(3, 3);
    testList.addTerm(2, 3);
    testList.addTerm(3, 0);
    testList.addTerm(3, 0);

    testList2.addTerm(-7, 0);
    testList2.addTerm(4, 1);
    testList2.addTerm(-3, 3);


    assertEquals("7x^3+1x^1+6", testList.toString());
    assertEquals("-3x^3+4x^1-7", testList2.toString());

    Polynomial sumList = testList.add(testList2);
    assertEquals("4x^3+5x^1-1", sumList.toString());
    assertEquals("7x^3+1x^1+6", testList.toString());
    assertEquals("-3x^3+4x^1-7", testList2.toString());

    Polynomial sumList2 = testList2.add(testList);

    assertEquals("7x^3+1x^1+6", testList.toString());
    assertEquals("-3x^3+4x^1-7", testList2.toString());
    assertEquals("4x^3+5x^1-1", sumList2.toString());

  }


  @Test
  public void testAddPolynomialsCoeff0() {

    testList.addTerm(2, 2);
    testList.addTerm(-3, 3);


    testList2.addTerm(4, 1);
    testList2.addTerm(3, 3);

    Polynomial sumList = testList.add(testList2);

    assertEquals(testList.toString(), "-3x^3+2x^2");
    assertEquals(testList2.toString(), "3x^3+4x^1");
    assertEquals(sumList.toString(), "2x^2+4x^1");

  }

  @Test
  public void testEquals() {

    Polynomial testList3 = new PolynomialImpl();

    assertEquals(testList.equals(testList2), true);
    assertEquals(testList2.equals(testList), true);
    assertEquals(testList.equals(testList), true);

    testList.addTerm(1, 1);
    testList.addTerm(2, 3);
    testList.addTerm(3, 3);


    testList2.addTerm(1, 1);
    testList2.addTerm(2, 3);
    testList2.addTerm(3, 3);

    assertEquals(testList.equals(testList2), true);
    assertEquals(testList2.equals(testList), true);
    assertEquals(testList.equals(testList), true);


    testList3 = new PolynomialImpl("2x^3 +1x^1 +3x^3");

    assertEquals(testList.equals(testList2), true);
    assertEquals(testList2.equals(testList3), true);
    assertEquals(testList3.equals(testList), true);


    testList2.addTerm(3, 0);

    assertEquals(testList.equals(testList2), false);
    assertEquals(testList2.equals(testList), false);

  }



}