package vehicle;



/**
 * This interface is used for classes that will simulate a car transmission.
 * This includes methods to return the speed and gear of the transmission, as well as commands
 * to increase and decrease both. There is an option to output a status to show whether
 * the input command was carried out successfully.
 */

public interface ManualTransmission {

  /**
   * Returns the status of the transmission. The status describes whether the previous command
   * to change gear or speed was performed successfully.
   * @return Returns the status of the transmission as a string.
   */
  public String getStatus();

  /**
   * Gets the current speed of the vehicle.
   * @return Returns the speed of the vehicle as an integer.
   */
  public int getSpeed();

  /**
   * Gets the current gear of the vehicle.
   * @return Returns the gear of the vehicle as an integer.
   */
  public int getGear();


  /**
   * Increases the speed by a fixed increment.
   * @return Returns the transmission with the speed increased by a fixed increment.
   */
  public ManualTransmission increaseSpeed();


  /**
   * Decreases the speed by a fixed increment.
   * @return Returns the transmission with the speed decreased by a fixed increment.
   */
  public ManualTransmission decreaseSpeed();


  /**
   * Increases the gear of the transmission by 1.
   * @return Returns the transmission with the gear increased by 1.
   */
  public ManualTransmission increaseGear();

  /**
   * Decreases the gear of the transmission by 1.
   * @return Returns the transmission with the gear decreased by 1.
   */
  public ManualTransmission decreaseGear();



}
