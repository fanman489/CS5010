package encoder;

import decoder.Decoder;

/**
 * This method will take a message and encript it into a code based on the allowed characters.
 * It will also create a data structure to store the code.
 */
public interface Encoder {

  /**
   * Creates a tree structure which will store the decoding information.
   * @param message The message that will be encoded.
   * @return Outputs the tree that will store the encoding.
   */
  Decoder createTree(String message);

  /**
   * This method will encode the message and output the encoded message as a string.
   * @param message The message that will be encoded.
   * @return The encoded message.
   */
  String encode(String message);

}
