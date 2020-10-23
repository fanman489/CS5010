package vehicle;


/**
 * This class represents a regular car's manual transmission.
 * This transmission contains 5 gears and increases/decreases to speed are in increments of 1.
 * The speed ranges of the gears are set by the user.
 * This class implements the ManualTransmission interface.
 */
public class RegularManualTransmission implements ManualTransmission {


  // Attributes to show speed and current gear and status.
  private int speed = 0;
  private int gear = 1;
  private String status;



  //Attributes used to determine status message.
  private boolean maxGearSpeed;
  private boolean maxGearReached;
  private boolean minGearSpeed;
  private boolean minGearReached;
  private boolean inHigherGearRange;
  private boolean inLowerGearRange;



  //Arrays to store the speed ranges of the gears.
  private int[] minSpeedRange = new int[5];
  private int[] maxSpeedRange = new int[5];






  /**
   * Construct the manual transmission. Input the lower and upper speed ranges of each gear. <br>
   * Rules about the speed limits: <br>
   * The lower speed limit of gear 1 should be 0. <br>
   * Min and max values of gears should increase with increasing gears. <br>
   * Only adjacent gears should overlap in their ranges. <br>
   * All speeds should be covered between 0 and the maximum speed of gear 5.
   *
   * @param l1 Lower speed range of gear 1.
   * @param h1 Upper speed range of gear 1.
   * @param l2 Lower speed range of gear 2.
   * @param h2 Upper speed range of gear 2.
   * @param l3 Lower speed range of gear 3.
   * @param h3 Upper speed range of gear 3.
   * @param l4 Lower speed range of gear 4.
   * @param h4 Upper speed range of gear 4.
   * @param l5 Lower speed range of gear 5.
   * @param h5 Upper speed range of gear 5.
   */
  public RegularManualTransmission( int l1, int h1, int l2, int h2, int l3, int h3, int l4,
                                    int h4, int l5, int h5) throws IllegalArgumentException {


    minSpeedRange[0]  = l1;
    minSpeedRange[1]  = l2;
    minSpeedRange[2]  = l3;
    minSpeedRange[3]  = l4;
    minSpeedRange[4]  = l5;

    maxSpeedRange[0]  = h1;
    maxSpeedRange[1]  = h2;
    maxSpeedRange[2]  = h3;
    maxSpeedRange[3]  = h4;
    maxSpeedRange[4]  = h5;


    if ( l1 != 0) {
      throw new IllegalArgumentException("Minimum speed of first gear must be 0.");

    }

    for ( int i = 0; i < 5; i++) {
      if ( minSpeedRange[i] >= maxSpeedRange[i] ) {
        throw new IllegalArgumentException("Minimum speed of gear must be lower than maximum.");
      }
    }


    for ( int i = 0; i < 4; i++) {
      if ( minSpeedRange[i] >= minSpeedRange[i + 1] ) {
        throw new IllegalArgumentException("Minimum of lower gear must be lower than minimum o"
                + "f a higher gear.");
      }
    }

    for ( int i = 0; i < 4; i++) {
      if ( maxSpeedRange[i] >= maxSpeedRange[i + 1] ) {
        throw new IllegalArgumentException("Maximum of lower gear must be lower than maximum "
                + "of a higher gear.");
      }
    }

    for ( int i = 0; i < 3; i++) {
      if ( maxSpeedRange[i] >= minSpeedRange[i + 2] ) {
        throw new IllegalArgumentException("Gear ranges should not overlap except for "
                + "adjacent gears.");
      }
    }




    for ( int i = 0; i < 4; i++) {
      if ( maxSpeedRange[i] < minSpeedRange[i + 1] ) {
        throw new IllegalArgumentException("All speeds must be covered by a gear.");
      }
    }



    checkMaxGearSpeed();
    checkMaxGearReached();
    checkMinGearSpeed();
    checkMinGearReached();
    checkInHigherGearRange();
    checkInLowerGearRange();


    this.setStatus("OK: everything is OK.");

  }



  public String getStatus() {
    return status;

  }

  public int getSpeed() {

    return speed;
  }


  public int getGear() {
    return gear;

  }


  /**
   * Method to increase speed of the transmission. The lowest speed is 0, and the highest is
   * the highest speed of gear 5 as input by the user. The speed can be increased until
   * the limits of the gears are reached. The status will indicate whether the speed can still
   * be increased, or if you need to increase the gear first. If the maximum speed of
   * the transmissionis reached, the status will indicate this as well.
   * @return Returns the transmission with the speed increased by 1 and updates the status.
   */
  public RegularManualTransmission increaseSpeed() {

    if ( maxGearSpeed & gear == 5 ) {
      this.setStatus("Cannot increase speed. Reached maximum speed.");
      return this;
    }

    if ( maxGearSpeed ) {
      this.setStatus("Cannot increase speed, increase gear first.");
      return this;
    }


    this.setSpeed( speed + 1 );

    checkMaxGearSpeed();
    checkMaxGearReached();
    checkMinGearSpeed();
    checkMinGearReached();
    checkInHigherGearRange();
    checkInLowerGearRange();



    if (inHigherGearRange) {
      this.setStatus("OK: you may increase the gear.");
    } else {
      this.setStatus("OK: everything is OK.");
    }

    return this;
  }


  /**
   * Increases the gear of the transmission. The gears ranges from 1 to 5.
   * This will also update the status based on whether the command was carried out.
   * The status will indicate whether the speed is too low for the next gear,
   * or whether you have reached the highest gear.
   * @return Returns the transmission with the gear increased by 1 and updates the status.
   */
  public RegularManualTransmission increaseGear() {

    if (maxGearReached) {
      this.setStatus("Cannot increase gear. Reached maximum gear.");
      return this;
    } else if (!inHigherGearRange) {
      this.setStatus("Cannot increase gear, increase speed first.");
      return this;
    } else {
      this.setGear(gear + 1);
      this.setStatus("OK: everything is OK.");

    }


    checkMaxGearSpeed();
    checkMaxGearReached();
    checkMinGearSpeed();
    checkMinGearReached();
    checkInHigherGearRange();
    checkInLowerGearRange();


    return this;
  }


  /**
   * Method to decreases speed of the transmission. The lowest speed is 0, and the highest is
   * the highest speed of gear 5 as input by the user. The speed can be decreased until
   * the limits of the gears are reached. The status will indicate whether the speed can still
   * be decreased, or if you need to decrease the gear first. If the speed is at 0, the status
   * will indicate the minimum speed is reached.
   * @return Returns the transmission with the speed decreased by 1 and updates the status.
   */
  public RegularManualTransmission decreaseSpeed() {

    if (minGearSpeed & gear == 1) {
      this.setStatus("Cannot decrease speed. Reached minimum speed.");
      return this;
    }

    if (minGearSpeed) {
      this.setStatus("Cannot decrease speed, decrease gear first.");
      return this;
    }

    this.setSpeed(speed - 1 );

    checkMaxGearSpeed();
    checkMaxGearReached();
    checkMinGearSpeed();
    checkMinGearReached();
    checkInHigherGearRange();
    checkInLowerGearRange();



    if (inLowerGearRange) {
      this.setStatus("OK: you may decrease the gear.");
    } else {
      this.setStatus("OK: everything is OK.");
    }

    return this;
  }


  /**
   * Decreases the gear of the transmission. The gears ranges from 1 to 5.
   * This will also update the status based on whether the command was carried out.
   * The status will indicate whether the speed is too high for the next gear,
   * or whether you have reached the lowest gear.
   * @return Returns the transmission with the gear decreased by 1 and updates the status.
   */
  public RegularManualTransmission decreaseGear() {

    if (minGearReached) {
      this.setStatus("Cannot decrease gear. Reached minimum gear.");
      return this;
    } else if (!inLowerGearRange) {
      this.setStatus("Cannot decrease gear, decrease speed first.");
      return this;
    } else {
      this.setGear(gear - 1);
      this.setStatus("OK: everything is OK.");


    }
    checkMaxGearSpeed();
    checkMaxGearReached();
    checkMinGearSpeed();
    checkMinGearReached();
    checkInHigherGearRange();
    checkInLowerGearRange();


    return this;

  }


  //Method used to check if a speed is within the range of a gear.
  private boolean inRangeCheck(int currSpeed, int currGear) {

    int gearCount = currGear - 1;

    return (minSpeedRange[gearCount] <= currSpeed & maxSpeedRange[gearCount] >= currSpeed);


  }





  //Methods to help change the status booleans.

  private void checkMaxGearSpeed() {
    int currSpeed = this.speed;
    int currGear = this.gear - 1;

    if (currSpeed == maxSpeedRange[currGear]) {
      setMaxGearSpeed(true);
    } else {
      setMaxGearSpeed(false);
    }

  }

  private void checkMinGearSpeed() {
    int currSpeed = this.getSpeed();
    int currGear = this.getGear() - 1;

    if (currSpeed == minSpeedRange[currGear]) {
      setMinGearSpeed(true);
    } else {
      setMinGearSpeed(false);
    }
  }

  private void checkMinGearReached() {
    if ( this.getGear()  == 1) {
      setMinGearReached(true);
    } else {
      setMinGearReached(false);
    }
  }

  private void checkMaxGearReached() {
    if ( this.getGear()  == 5) {
      setMaxGearReached(true);
    } else {
      setMaxGearReached(false);
    }
  }

  private void checkInHigherGearRange() {
    int currSpeed = this.getSpeed();
    int currGear = this.getGear();
    if (currGear == 5) {
      setInHigherGearRange(false);
      return;
    }

    currGear = this.getGear() + 1;


    if (inRangeCheck(currSpeed, currGear)) {
      setInHigherGearRange(true);
    } else {
      setInHigherGearRange(false);
    }

  }



  private void checkInLowerGearRange() {
    int currSpeed = this.getSpeed();
    int currGear = this.getGear();
    if (currGear == 1) {
      setInLowerGearRange(false);
      return;
    }

    currGear = this.getGear() - 1;


    if (inRangeCheck(currSpeed, currGear)) {
      setInLowerGearRange(true);
    } else {
      setInLowerGearRange(false);
    }

  }



  //All getters and setters.

  private void setSpeed(int speed) {
    this.speed = speed;
  }

  private void setGear(int gear) {
    this.gear = gear;
  }

  private boolean isMaxGearSpeed() {
    return maxGearSpeed;
  }

  private void setMaxGearSpeed(boolean maxGearSpeed) {
    this.maxGearSpeed = maxGearSpeed;
  }

  private boolean isMaxGearReached() {
    return maxGearReached;
  }

  private void setMaxGearReached(boolean maxGearReached) {
    this.maxGearReached = maxGearReached;
  }

  private boolean isMinGearSpeed() {
    return minGearSpeed;
  }

  private void setMinGearSpeed(boolean minGearSpeed) {
    this.minGearSpeed = minGearSpeed;
  }

  private boolean isMinGearReached() {
    return minGearReached;
  }

  private void setMinGearReached(boolean minGearReached) {
    this.minGearReached = minGearReached;
  }

  private boolean isInHigherGearRange() {
    return inHigherGearRange;
  }

  private void setInHigherGearRange(boolean inHigherGearRange) {
    this.inHigherGearRange = inHigherGearRange;
  }

  private boolean isInLowerGearRange() {
    return inLowerGearRange;
  }

  private void setInLowerGearRange(boolean inLowerGearRange) {
    this.inLowerGearRange = inLowerGearRange;
  }

  private int[] getMinSpeedRange() {
    return minSpeedRange;
  }

  private void setMinSpeedRange(int[] minSpeedRange) {
    this.minSpeedRange = minSpeedRange;
  }

  private int[] getMaxSpeedRange() {
    return maxSpeedRange;
  }

  private void setMaxSpeedRange(int[] maxSpeedRange) {
    this.maxSpeedRange = maxSpeedRange;
  }


  private void setStatus(String status) {
    this.status = status;
  }



















}
