package calculator;

import org.junit.Test;
import org.junit.Assert;



/**
 * This class is for running JUnit tst for SmartCalculator.
 */
public class SmartCalculatorTest {


  private Calculator calculator = new SmartCalculator();




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
  public void testInput1bb() {

    try {
      calculator.input('c');
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      Assert.assertEquals("Invalid input c", ex.getMessage() );
    }

  }



  @Test
  public void testInput1bbb() {

    try {
      calculator.input('/');
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      Assert.assertEquals("Invalid input /", ex.getMessage() );
    }

  }


  @Test
  public void testInput1c() {

    try {
      calculator.input('-');
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      Assert.assertEquals("Cannot input negative number.", ex.getMessage() );
    }
  }


  @Test
  public void testInput1d() {

    try {
      calculator.input('C');
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      Assert.assertEquals("Inputs are empty.", ex.getMessage() );
    }
  }


  @Test
  public void testInput1f() {


    calculator.input('+');

    Assert.assertEquals("", calculator.getResult() );

  }

  @Test
  public void testInput1g() {

    calculator.input('*');

    Assert.assertEquals("", calculator.getResult() );

  }


  @Test
  public void testInput1h() {

    calculator.input('=');

    Assert.assertEquals("", calculator.getResult() );

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


    Assert.assertEquals( calculator.getResult(), "2147483647");

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

    calculator.input('2');
    calculator.input('+');
    calculator.input('4');
    calculator.input('=');
    calculator.input('=');
    calculator.input('-');
    calculator.input('=');
    calculator.input('+');
    calculator.input('=');



    Assert.assertEquals("10", calculator.getResult() );



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
  public void testCalc2k() {


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
  public void testCalc2l() {


    calculator.input('1');
    calculator.input('+');
    calculator.input('-');
    calculator.input('3');
    calculator.input('=');
    calculator.input('C');
    calculator.input('+');
    calculator.input('*');
    calculator.input('=');
    calculator.input('=');



    Assert.assertEquals( "", calculator.getResult());


  }


  @Test
  public void testCalc2m() {


    calculator.input('3');
    calculator.input('=');
    calculator.input('=');


    Assert.assertEquals( "3", calculator.getResult());


  }

  @Test
  public void testCalc2n() {



    calculator.input('*');
    calculator.input('=');
    calculator.input('3');
    calculator.input('=');
    calculator.input('=');


    Assert.assertEquals( "3", calculator.getResult());


  }


  @Test
  public void testCalc2o() {



    calculator.input('*');
    calculator.input('=');
    calculator.input('3');
    calculator.input('=');
    calculator.input('*');
    calculator.input('2');
    calculator.input('-');
    calculator.input('=');
    calculator.input('=');



    Assert.assertEquals( "2", calculator.getResult());


  }


  @Test
  public void testCalc2p() {



    calculator.input('*');
    calculator.input('=');
    calculator.input('3');
    calculator.input('=');


    Assert.assertEquals( "3", calculator.getResult());


  }



  @Test
  public void testCalc2q() {



    calculator.input('*');
    calculator.input('2');
    calculator.input('*');
    calculator.input('-');
    calculator.input('5');
    calculator.input('=');



    Assert.assertEquals( "-3", calculator.getResult());


  }



  @Test
  public void testCalc2r() {




    try {

      calculator.input('9');
      calculator.input('2');
      calculator.input('9');
      calculator.input('5');
      calculator.input('6');
      calculator.input('3');
      calculator.input('2');
      calculator.input('+');
      calculator.input('C');
      calculator.input('-');


      Assert.fail();
    } catch (RuntimeException ex) {

      Assert.assertEquals("Cannot input negative number.", ex.getMessage() );

    }


  }


  @Test
  public void testCalc2s() {

    calculator.input('9');
    calculator.input('2');
    calculator.input('9');
    calculator.input('5');
    calculator.input('6');
    calculator.input('3');
    calculator.input('2');
    calculator.input('+');
    calculator.input('C');
    calculator.input('1');
    calculator.input('1');
    calculator.input('*');
    calculator.input('2');
    calculator.input('2');
    calculator.input('=');

    Assert.assertEquals("242", calculator.getResult() );

  }



  @Test
  public void testAdditionalTesting1() {

    calculator.input('9');
    calculator.input('*');
    calculator.input('9');
    calculator.input('*');
    calculator.input('9');
    calculator.input('*');
    calculator.input('9');
    calculator.input('*');
    calculator.input('9');
    calculator.input('9');
    calculator.input('*');
    calculator.input('9');
    calculator.input('9');
    calculator.input('9');
    calculator.input('=');



    Assert.assertEquals("648889461", calculator.getResult() );

  }



  @Test
  public void testAdditionalTesting2() {

    calculator.input('5');
    calculator.input('=');
    calculator.input('+');



    Assert.assertEquals("5+", calculator.getResult() );

  }



  @Test
  public void testAdditionalTesting3() {

    calculator.input('9');
    calculator.input('*');
    calculator.input('9');
    calculator.input('*');




    Assert.assertEquals("81*", calculator.getResult() );

  }


  @Test
  public void testAdditionalTesting4() {

    calculator.input('2');
    calculator.input('*');
    calculator.input('3');

    Assert.assertEquals("2*3", calculator.getResult() );

    calculator.input('=');

    Assert.assertEquals("6", calculator.getResult() );
    calculator.input('=');

    Assert.assertEquals("18", calculator.getResult() );
    calculator.input('=');
    calculator.input('=');
    calculator.input('=');
    calculator.input('=');
    calculator.input('=');
    calculator.input('=');
    calculator.input('=');
    calculator.input('=');
    calculator.input('=');
    calculator.input('=');
    calculator.input('=');
    calculator.input('+');
    calculator.input('=');





    Assert.assertEquals("3188649", calculator.getResult() );

  }




  @Test
  public void testAdditionalTesting5() {

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
  public void testAdditionalTesting6() {

    calculator.input('3');
    calculator.input('3');
    calculator.input('3');
    calculator.input('2');
    calculator.input('1');
    calculator.input('*');
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


    calculator.input('6');
    calculator.input('+');
    Assert.assertEquals("6+", calculator.getResult() );
    calculator.input('2');
    Assert.assertEquals("6+2", calculator.getResult() );
    calculator.input('*');
    Assert.assertEquals("8*", calculator.getResult() );
    calculator.input('=');
    Assert.assertEquals("16", calculator.getResult() );
    calculator.input('=');
    Assert.assertEquals("32", calculator.getResult() );
    calculator.input('+');
    calculator.input('=');
    Assert.assertEquals("34", calculator.getResult() );
    calculator.input('=');
    calculator.input('=');



    Assert.assertEquals("38", calculator.getResult() );

  }


  @Test
  public void testAdditionalTesting8() {


    calculator.input('6');
    calculator.input('-');
    Assert.assertEquals("6-", calculator.getResult() );
    calculator.input('1');
    calculator.input('2');
    Assert.assertEquals("6-12", calculator.getResult() );
    calculator.input('*');
    Assert.assertEquals("-6*", calculator.getResult() );
    calculator.input('=');
    Assert.assertEquals("-72", calculator.getResult() );
    calculator.input('=');
    Assert.assertEquals("-864", calculator.getResult() );
    calculator.input('+');
    calculator.input('=');
    Assert.assertEquals("-852", calculator.getResult() );
    calculator.input('=');
    calculator.input('=');



    Assert.assertEquals("-828", calculator.getResult() );

  }


  @Test
  public void testAdditionalTesting9() {



    calculator.input('+');
    calculator.input('6');
    calculator.input('=');
    calculator.input('=');
    calculator.input('=');


    Assert.assertEquals("6", calculator.getResult() );

  }


  @Test
  public void testAdditionalTesting10() {



    calculator.input('6');
    calculator.input('+');
    calculator.input('=');
    calculator.input('+');



    Assert.assertEquals("12+", calculator.getResult() );

  }


  @Test
  public void testAdditionalTesting11() {


    calculator.input('2');
    calculator.input('*');
    calculator.input('2');

    Assert.assertEquals("12+", calculator.getResult() );

  }










}