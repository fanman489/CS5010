package calculator;

import org.junit.Test;
import org.junit.Assert;


/**
 * This class is for running JUnit tst for SimpleCalculator.
 */
public class SimpleCalculatorTest {


  private Calculator calculator = new SimpleCalculator();

  @Test
  public void testSetup1a() {

    Assert.assertEquals("", calculator.getResult());

  }


  @Test
  public void testInput1a() {

    calculator.input('2');

    Assert.assertEquals("2", calculator.getResult());

  }


  @Test
  public void testInput1b() {

    try {
      calculator.input('a');
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      Assert.assertEquals("Invalid input a", ex.getMessage() );
    }

  }


  @Test
  public void testInput1c() {

    try {
      calculator.input('-');
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      Assert.assertEquals("Need to input number", ex.getMessage() );
    }
  }


  @Test
  public void testInput1d() {

    try {
      calculator.input('C');
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      Assert.assertEquals("Inputs already cleared", ex.getMessage() );
    }
  }


  @Test
  public void testInput1f() {

    try {
      calculator.input('+');
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      Assert.assertEquals("Need to input number", ex.getMessage() );
    }
  }

  @Test
  public void testInput1g() {

    try {
      calculator.input('*');
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      Assert.assertEquals("Need to input number", ex.getMessage() );
    }
  }


  @Test
  public void testInput1h() {

    try {
      calculator.input('=');
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      Assert.assertEquals("Need to input number", ex.getMessage() );
    }
  }


  @Test
  public void testInput2a() {

    calculator.input('2');
    calculator.input('3');

    Assert.assertEquals("23", calculator.getResult());

  }


  @Test
  public void testInput2b() {

    calculator.input('2');
    calculator.input('3');
    calculator.input('+');

    Assert.assertEquals("23+", calculator.getResult());

  }


  @Test
  public void testInput2c() {

    calculator.input('2');
    calculator.input('3');
    calculator.input('-');

    Assert.assertEquals("23-", calculator.getResult());

  }


  @Test
  public void testInput2d() {

    calculator.input('2');
    calculator.input('3');
    calculator.input('*');

    Assert.assertEquals("23*", calculator.getResult());

  }



  @Test
  public void testInput2e() {

    calculator.input('2');
    calculator.input('1');
    calculator.input('4');
    calculator.input('7');
    calculator.input('4');
    calculator.input('8');
    calculator.input('3');
    calculator.input('6');
    calculator.input('4');
    calculator.input('7');

    Assert.assertEquals( calculator.getResult(), "2147483647");

  }



  @Test
  public void testInput2f() {

    try {

      calculator.input('2');
      calculator.input('1');
      calculator.input('4');
      calculator.input('7');
      calculator.input('4');
      calculator.input('8');
      calculator.input('3');
      calculator.input('6');
      calculator.input('4');
      calculator.input('8');

      Assert.fail();
    } catch (RuntimeException ex) {

      Assert.assertEquals("Input integer is too high", ex.getMessage() );

    }

  }


  @Test
  public void testInput2g() {

    calculator.input('0');
    calculator.input('+');
    calculator.input('2');
    calculator.input('1');
    calculator.input('4');
    calculator.input('7');
    calculator.input('4');
    calculator.input('8');
    calculator.input('3');
    calculator.input('6');
    calculator.input('4');
    calculator.input('7');
    calculator.input('=');


    Assert.assertEquals( "2147483647", calculator.getResult());

  }


  @Test
  public void testInput2h() {

    try {
      calculator.input('0');
      calculator.input('+');
      calculator.input('2');
      calculator.input('1');
      calculator.input('4');
      calculator.input('7');
      calculator.input('4');
      calculator.input('8');
      calculator.input('3');
      calculator.input('6');
      calculator.input('4');
      calculator.input('8');
      Assert.fail();
    } catch (RuntimeException ex) {

      Assert.assertEquals("Input integer is too high", ex.getMessage() );

    }

  }



  @Test
  public void testInput2i() {

    calculator.input('2');
    calculator.input('+');
    calculator.input('2');
    calculator.input('1');
    calculator.input('4');
    calculator.input('7');
    calculator.input('4');
    calculator.input('8');
    calculator.input('3');
    calculator.input('6');
    calculator.input('4');
    calculator.input('7');
    calculator.input('=');





    Assert.assertEquals( "0", calculator.getResult());


  }


  @Test
  public void testInput2j() {

    calculator.input('0');
    calculator.input('-');
    calculator.input('2');
    calculator.input('1');
    calculator.input('4');
    calculator.input('7');
    calculator.input('4');
    calculator.input('8');
    calculator.input('3');
    calculator.input('6');
    calculator.input('4');
    calculator.input('7');
    calculator.input('-');
    calculator.input('1');
    calculator.input('=');


    Assert.assertEquals("-2147483648", calculator.getResult());

  }


  @Test
  public void testInput2k() {

    calculator.input('0');
    calculator.input('-');
    calculator.input('2');
    calculator.input('1');
    calculator.input('4');
    calculator.input('7');
    calculator.input('4');
    calculator.input('8');
    calculator.input('3');
    calculator.input('6');
    calculator.input('4');
    calculator.input('7');
    calculator.input('-');
    calculator.input('2');
    calculator.input('=');

    Assert.assertEquals( "0", calculator.getResult());

  }


  @Test
  public void testInput2l() {

    calculator.input('1');
    calculator.input('-');
    calculator.input('2');
    calculator.input('1');
    calculator.input('4');
    calculator.input('7');
    calculator.input('4');
    calculator.input('8');
    calculator.input('3');
    calculator.input('6');
    calculator.input('4');
    calculator.input('7');
    calculator.input('*');
    calculator.input('2');
    calculator.input('=');

    Assert.assertEquals( "0", calculator.getResult());

  }


  @Test
  public void testInput2m() {

    calculator.input('2');
    calculator.input('1');
    calculator.input('4');
    calculator.input('7');
    calculator.input('4');
    calculator.input('8');
    calculator.input('3');
    calculator.input('6');
    calculator.input('4');
    calculator.input('7');
    calculator.input('*');
    calculator.input('2');
    calculator.input('=');

    Assert.assertEquals( "0", calculator.getResult());

  }




  @Test
  public void testCalc1a() {

    calculator.input('2');
    calculator.input('1');
    calculator.input('+');
    calculator.input('3');

    Assert.assertEquals( "21+3", calculator.getResult());

  }


  @Test
  public void testCalc1b() {

    calculator.input('2');
    calculator.input('1');
    calculator.input('+');
    calculator.input('3');
    calculator.input('=');

    Assert.assertEquals( "24", calculator.getResult());

  }

  @Test
  public void testCalc1c() {

    calculator.input('2');
    calculator.input('1');
    calculator.input('+');
    calculator.input('3');
    calculator.input('-');

    Assert.assertEquals( "24-", calculator.getResult());

  }

  @Test
  public void testCalc1d() {

    calculator.input('2');
    calculator.input('1');
    calculator.input('-');
    calculator.input('3');
    calculator.input('2');

    Assert.assertEquals( "21-32", calculator.getResult());

  }

  @Test
  public void testCalc1e() {

    calculator.input('2');
    calculator.input('1');
    calculator.input('-');
    calculator.input('3');
    calculator.input('2');
    calculator.input('=');

    Assert.assertEquals( "-11", calculator.getResult());

  }


  @Test
  public void testCalc1f() {

    calculator.input('2');
    calculator.input('1');
    calculator.input('-');
    calculator.input('3');
    calculator.input('2');
    calculator.input('*');
    calculator.input('5');
    calculator.input('9');


    Assert.assertEquals( "-11*59", calculator.getResult());

  }


  @Test
  public void testCalc1g() {

    calculator.input('2');
    calculator.input('1');
    calculator.input('-');
    calculator.input('3');
    calculator.input('2');
    calculator.input('*');
    calculator.input('5');
    calculator.input('9');
    calculator.input('+');


    Assert.assertEquals( "-649+", calculator.getResult());

  }




  @Test
  public void testCalc2h() {

    try {
      calculator.input('2');
      calculator.input('1');
      calculator.input('-');
      calculator.input('3');
      calculator.input('2');
      calculator.input('*');
      calculator.input('5');
      calculator.input('9');
      calculator.input('+');
      calculator.input('=');
      Assert.fail();

    } catch (IllegalArgumentException ex) {

      Assert.assertEquals("Need to input second number", ex.getMessage() );

    }

  }





  @Test
  public void testCalc2i() {


    calculator.input('2');
    calculator.input('1');
    calculator.input('+');
    calculator.input('3');
    calculator.input('C');

    Assert.assertEquals( "",  calculator.getResult());


  }



  @Test
  public void testCalc2j() {

    calculator.input('5');
    calculator.input('C');

    Assert.assertEquals( "", calculator.getResult());

  }


  @Test
  public void testInput21e() {


    calculator.input('1');
    calculator.input('2');
    calculator.input('3');
    calculator.input('4');
    calculator.input('5');
    calculator.input('6');
    calculator.input('7');
    calculator.input('8');
    calculator.input('+');
    calculator.input('9');
    calculator.input('0');
    calculator.input('-');
    calculator.input('8');
    calculator.input('7');
    calculator.input('6');
    calculator.input('5');
    calculator.input('4');
    calculator.input('3');
    calculator.input('*');
    calculator.input('2');
    calculator.input('=');


    Assert.assertEquals( "22938450", calculator.getResult());


  }




  @Test
  public void testCalc2g() {

    calculator.input('3');
    calculator.input('3');
    calculator.input('+');
    calculator.input('2');
    calculator.input('1');
    calculator.input('=');
    calculator.input('=');
    calculator.input('=');
    calculator.input('=');
    calculator.input('=');

    Assert.assertEquals( "54", calculator.getResult());

  }




  @Test
  public void testCalc2k() {

    calculator.input('3');
    calculator.input('3');
    calculator.input('3');
    calculator.input('2');
    calculator.input('1');
    calculator.input('*');
    Assert.assertEquals( "33321*", calculator.getResult());

    calculator.input('2');
    calculator.input('4');
    calculator.input('3');
    calculator.input('2');
    calculator.input('4');
    calculator.input('5');
    Assert.assertEquals( "33321*243245", calculator.getResult());
    calculator.input('*');

    Assert.assertEquals( "0*", calculator.getResult());
    calculator.input('3');
    calculator.input('2');
    calculator.input('3');
    calculator.input('4');
    Assert.assertEquals( "0*3234", calculator.getResult());
    calculator.input('-');
    Assert.assertEquals( "0-", calculator.getResult());
    calculator.input('8');
    calculator.input('=');


    Assert.assertEquals( "-8", calculator.getResult());

  }



  @Test
  public void testCalc2l() {

    calculator.input('3');
    calculator.input('3');
    calculator.input('3');
    calculator.input('2');
    calculator.input('1');
    calculator.input('+');
    Assert.assertEquals( "33321+", calculator.getResult());
    calculator.input('2');
    calculator.input('4');
    calculator.input('3');
    calculator.input('2');
    calculator.input('4');
    calculator.input('5');
    Assert.assertEquals( "33321+243245", calculator.getResult());
    calculator.input('*');
    Assert.assertEquals( "276566*", calculator.getResult());
    calculator.input('3');
    calculator.input('2');
    calculator.input('3');
    calculator.input('4');
    Assert.assertEquals( "276566*3234", calculator.getResult());
    calculator.input('-');
    Assert.assertEquals( "894414444-", calculator.getResult());
    calculator.input('8');
    calculator.input('=');
    Assert.assertEquals( "894414436", calculator.getResult());

  }




  @Test
  public void testAdditionalTesting7() {

    calculator.input('8');
    calculator.input('*');
    calculator.input('9');
    calculator.input('-');
    calculator.input('8');
    calculator.input('-');
    calculator.input('8');
    calculator.input('-');
    calculator.input('8');
    calculator.input('-');
    calculator.input('8');
    calculator.input('8');
    calculator.input('8');
    calculator.input('*');
    calculator.input('8');
    calculator.input('=');





    Assert.assertEquals("-6720", calculator.getResult() );

  }




  @Test
  public void testAdditionalTesting8() {

    calculator.input('1');
    calculator.input('2');
    Assert.assertEquals("12", calculator.getResult() );
    calculator.input('+');
    Assert.assertEquals("12+", calculator.getResult() );
    calculator.input('3');
    Assert.assertEquals("12+3", calculator.getResult() );
    calculator.input('-');
    Assert.assertEquals("15-", calculator.getResult() );
    calculator.input('8');
    Assert.assertEquals("15-8", calculator.getResult() );
    calculator.input('=');
    Assert.assertEquals("7", calculator.getResult() );
    calculator.input('=');
    Assert.assertEquals("7", calculator.getResult() );
    calculator.input('-');
    Assert.assertEquals("7-", calculator.getResult() );
    calculator.input('1');
    calculator.input('0');
    Assert.assertEquals("7-10", calculator.getResult() );
    calculator.input('*');
    Assert.assertEquals("-3*", calculator.getResult() );
    calculator.input('3');
    calculator.input('=');

    Assert.assertEquals("-9", calculator.getResult() );

  }




  @Test
  public void testAdditionalTesting9() {

    calculator.input('8');
    calculator.input('*');
    calculator.input('9');
    calculator.input('=');



    Assert.assertEquals("72", calculator.getResult() );

  }
}