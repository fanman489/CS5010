package decoder;

/**
 * This interface is for a prefix code decoder that will take a symbol and it's code and store it.
 * It allows users to input their coding and use it to decode messages.
 */

public interface Decoder {

  /**
   * This method allows the user to add symbols and codes to the list.
   * @param symbol The decoded symbol.
   * @param code The code representing the symbol.
   */
  void addCode(char symbol, String code);

  /**
   * This method will take the encoded message and output the message.
   * @param encodedMessage Input the encoded message as a string.
   * @return Outputs the decoded message as a string.
   */
  String decode(String encodedMessage);

  /**
   * This method outputs all of the codes input into the list so far.
   * @return Outputs all of the code input and the symbols they represent.
   */

  String allCodes();


  /**
   * Checks whether the code is able to decode all valid codes given a message containing only
   * coding characters.
   * @return Returns a boolean indicating whether the code table is complete.
   */
  boolean isCodeComplete();

}
