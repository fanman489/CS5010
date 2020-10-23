package vehicle;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Assert;


public class RegularManualTransmissionTest {


  private RegularManualTransmission car;


  /*
  The first set of tests are designed to test the constructor to make sure the transmission
  follows conditions specified in the assignment.
  */


  //Verify error thrown if all gears are identical.
  @Test
  public void testConstructor1() {



    try {
      car = new RegularManualTransmission(0,4,0,4,0,4,0,4,0,4);
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals(ex.getMessage(), "Minimum of lower gear must be lower than minimum of"
              + " a higher gear.");
    }


  }

  /*
  Test to verify error thrown if minimum speed of lower gear is
  not lower than minimum of a higher gear.
  */
  @Test
  public void testConstructor2() {

    try {
      car = new RegularManualTransmission(0, 4, 2, 5, 3, 6, 4, 7,
              4, 8);
      Assert.fail();

    } catch (IllegalArgumentException ex) {
      assertEquals(ex.getMessage(), "Minimum of lower gear must be lower than "
              + "minimum of a higher gear.");
    }


  }


  //Test to verify error thrown if there are speeds not covered between 0 and the maximum.
  @Test
  public void testConstructor3() {


    try {
      car = new RegularManualTransmission(0,4,4,5,5,6,7,9,
              9,10);
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals(ex.getMessage(), "All speeds must be covered by a gear.");
    }




  }


  // Test to verify only adjacent gears are allowed to overlap.
  @Test
  public void testConstructor4() {


    try {
      car = new RegularManualTransmission(0,4,2,5,3,6,5,7,6,8);
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals(ex.getMessage(), "Gear ranges should not overlap except for "
              + "adjacent gears.");
    }




  }


  // Test to verify the lowest speed of the first gear must be 0.
  @Test
  public void testConstructor5() {


    try {
      car = new RegularManualTransmission(1,2,2,5,3,6,6,7,7,8);
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals(ex.getMessage(), "Minimum speed of first gear must be 0.");
    }




  }


  // Test to verify lower speed of gear needs to be lower than the upper limit.
  @Test
  public void testConstructor6() {


    try {
      car = new RegularManualTransmission(0,2,2,10,10,6,10,
              11,11,12);
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals(ex.getMessage(), "Minimum speed of gear must be lower than maximum.");
    }



  }


  /*
  Test to verify upper speed limit of lower gear needs to be lower than the upper speed limit
  of a higher gear.
  */
  @Test
  public void testConstructor7() {

    try {
      car = new RegularManualTransmission(0,2,2,10,8,9,11,
              12,12,13);
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals(ex.getMessage(), "Maximum of lower gear must be lower than maximum "
              + "of a higher gear.");
    }

  }












  /*
  The following set of tests are for the output of the methods. They are based on the same
  transmission.
  */



  //Test the status at setup of the transmission is ok.
  @Test
  public void testOutput1a() {

    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);

    assertEquals(car.getStatus(), "OK: everything is OK.");
  }


  @Test
  public void testOutput1b() {

    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);

    assertEquals(car.getSpeed(), 0);
  }

  @Test
  public void testOutput1c() {

    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);

    assertEquals(car.getGear(), 1);
  }






  //Test increasing speed without being in range of the next gear.
  @Test
  public void testOutput2a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);

    car.increaseSpeed();
    car.increaseSpeed();
    assertEquals(car.getStatus(), "OK: everything is OK.");
  }


  @Test
  public void testOutput2b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    assertEquals(car.getSpeed(),  2);
  }

  @Test
  public void testOutput2c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    assertEquals(car.getGear(),  1);
  }


  //Test increasing speed while being in range of the next gear.
  @Test
  public void testOutput3a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    assertEquals(car.getStatus(), "OK: you may increase the gear.");
  }


  @Test
  public void testOutput3b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    assertEquals(car.getSpeed(),  3);
  }

  @Test
  public void testOutput3c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    assertEquals(car.getGear(),  1);
  }



  //Test increasing speed while reaching maximum speed of gear.
  @Test
  public void testOutput4a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    assertEquals(car.getStatus(), "Cannot increase speed, increase gear first.");
  }


  @Test
  public void testOutput4b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    assertEquals(car.getSpeed(),  4);
  }

  @Test
  public void testOutput4c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    assertEquals(car.getGear(),  1);
  }






  //Test increasing gear when not in range.

  @Test
  public void testOutput5a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseGear();

    assertEquals(car.getStatus(), "Cannot increase gear, increase speed first.");
  }


  @Test
  public void testOutput5b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseGear();
    assertEquals(car.getSpeed(),  1);
  }

  @Test
  public void testOutput5c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseGear();
    assertEquals(car.getGear(),  1);
  }




  //Test increasing gear in range will increase the gear.

  @Test
  public void testOutput6a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();

    assertEquals(car.getStatus(), "OK: everything is OK.");
  }


  @Test
  public void testOutput6b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    assertEquals(car.getSpeed(),  3);
  }

  @Test
  public void testOutput6c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    assertEquals(car.getGear(),  2);
  }



  //Make sure transmission will not exceed maximum speed.

  @Test
  public void testOutput7a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();


    assertEquals(car.getStatus(), "Cannot increase speed. Reached maximum speed.");
  }


  @Test
  public void testOutput7b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    assertEquals(car.getSpeed(),  12);
  }

  @Test
  public void testOutput7c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    assertEquals(car.getGear(),  5);
  }


  //Make sure transmission will not exceed maximum gear.

  @Test
  public void testOutput8a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();


    assertEquals(car.getStatus(), "Cannot increase gear. Reached maximum gear.");
  }


  @Test
  public void testOutput8b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    assertEquals(car.getSpeed(),  12);
  }

  @Test
  public void testOutput8c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    assertEquals(car.getGear(),  5);
  }



  //Make sure decrease speed while not in range of lower gear will produce correct status.

  @Test
  public void testOutput9a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();




    assertEquals(car.getStatus(), "OK: everything is OK.");
  }


  @Test
  public void testOutput9b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    assertEquals(car.getSpeed(),  11);
  }

  @Test
  public void testOutput9c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    assertEquals(car.getGear(),  5);
  }


  //Make sure decrease speed while not in range of lower gear will produce correct status.

  @Test
  public void testOutput10a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();


    assertEquals(car.getStatus(), "OK: you may decrease the gear.");
  }


  @Test
  public void testOutput10b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    assertEquals(car.getSpeed(),  10);
  }

  @Test
  public void testOutput10c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    assertEquals(car.getGear(),  5);
  }



  //Check gear decrease functionality.

  @Test
  public void testOutput11a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();

    assertEquals(car.getStatus(), "OK: everything is OK.");
  }


  @Test
  public void testOutput11b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();
    assertEquals(car.getSpeed(),  10);
  }

  @Test
  public void testOutput11c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();
    assertEquals(car.getGear(),  4);
  }



  //Check gear decrease and then increase back to top gear.

  @Test
  public void testOutput12a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();

    assertEquals(car.getStatus(), "OK: everything is OK.");
  }


  @Test
  public void testOutput12b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    assertEquals(car.getSpeed(),  11);
  }

  @Test
  public void testOutput12c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    assertEquals(car.getGear(),  5);
  }



  //Check gear cannot decrease past lower limit.

  @Test
  public void testOutput13a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();


    assertEquals(car.getStatus(), "Cannot decrease speed, decrease gear first.");
  }


  @Test
  public void testOutput13b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();

    assertEquals(car.getSpeed(),  9);
  }

  @Test
  public void testOutput13c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();

    assertEquals(car.getGear(),  5);
  }



  //Check gear cannot be decreased if not in range.
  @Test
  public void testOutput14a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseGear();



    assertEquals(car.getStatus(), "Cannot decrease gear, decrease speed first.");
  }


  @Test
  public void testOutput14b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseGear();


    assertEquals(car.getSpeed(),  12);
  }

  @Test
  public void testOutput14c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseGear();

    assertEquals(car.getGear(),  5);
  }




  //Check gear decrease when in range of lower gear.
  @Test
  public void testOutput15a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.decreaseSpeed();


    assertEquals(car.getStatus(), "OK: you may decrease the gear.");
  }


  @Test
  public void testOutput15b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.decreaseSpeed();
    car.decreaseSpeed();


    assertEquals(car.getSpeed(),  5);
  }

  @Test
  public void testOutput15c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.decreaseSpeed();
    car.decreaseSpeed();

    assertEquals(car.getGear(),  3);
  }




  //Check cannot decrease gear below one.
  @Test
  public void testOutput16a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();


    assertEquals(car.getStatus(), "Cannot decrease gear. Reached minimum gear.");
  }


  @Test
  public void testOutput16b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();

    assertEquals(car.getSpeed(),  1);
  }

  @Test
  public void testOutput16c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();

    assertEquals(car.getGear(),  1);
  }




  //Check cannot decrease speed below 0.
  @Test
  public void testOutput17a() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();


    assertEquals(car.getStatus(), "Cannot decrease speed. Reached minimum speed.");
  }


  @Test
  public void testOutput17b() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();

    assertEquals(car.getSpeed(),  0);
  }

  @Test
  public void testOutput17c() {
    car = new RegularManualTransmission(0,4,3,6,5,8,7,10,9,12);
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseSpeed();
    car.increaseGear();
    car.increaseSpeed();
    car.increaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseGear();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();
    car.decreaseSpeed();

    assertEquals(car.getGear(),  1);
  }




















}