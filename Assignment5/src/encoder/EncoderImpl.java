package encoder;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.PriorityQueue;

import decoder.Decoder;

import decoder.DecoderImpl;

/**
 * This class represents an encoder that will take a message and create a coding scheme for the
 * characters contained in the message.
 */

public class EncoderImpl implements Encoder {

  private ArrayList<Character> codingSet = new ArrayList<>();
  private HashMap<Character, String> codes = new HashMap<>();
  private PriorityQueue<CharacterCode> listOfCharacters;
  private ArrayList<Character> codeList = new ArrayList<>();


  /**
   * This method will create an encoder that will encode messages using the characters input.
   * This encoder will ignore repeated characters.
   * @param input Input the characters to code with as a string. The order of the
   *             characters will matter for the encoded message.
   * @throws IllegalArgumentException Will throw an error if the input contains less than 2
   *          unique characters.
   */
  public EncoderImpl(String input) throws IllegalArgumentException {

    if (input == null) {
      throw new IllegalArgumentException("Cannot input null.");
    }

    for (Character c : input.toCharArray()) {
      if (codingSet.indexOf(c) == -1) {
        codingSet.add(c);
      }
    }

    if (codingSet.size() < 2) {
      throw new IllegalArgumentException("Need at least 2 unique characters to encode.");
    }

  }


  /**
   * This method will take the characters from the message and create a coding tree for the
   * characters in the message.
   * @param message The message that will be encoded.
   * @return Returns a coding tree for the characters in the message that can be used to decode
   *          the message.
   */
  public Decoder createTree(String message) {
    String coding;
    StringBuilder allowedCodes = new StringBuilder();

    //Set the allowed characters
    for (Character c:codingSet) {
      allowedCodes.append(c);
    }

    this.generateHash(message);
    Decoder testDecoder = new DecoderImpl(allowedCodes.toString());

    for (int i = 0; i < codeList.size(); i++) {
      coding = codes.get(codeList.get(i));
      testDecoder.addCode(codeList.get(i), coding);
    }

    return testDecoder;
  }

  /**
   * This method will use a coding tree to encode a given message.
   * @param message The message that will be encoded.
   * @return Returns the coded message.
   */
  public String encode(String message) {
    StringBuilder output = new StringBuilder();

    this.generateHash(message);
    for (Character c:message.toCharArray()) {
      output.append(codes.get(c));
    }

    return output.toString();
  }



  private void getUnique(String phrase) {
    for (char c : phrase.toCharArray()) {
      if (codeList.indexOf(c) == -1) {
        codeList.add(c);
      }
    }
  }


  private int countFreq(Character c, String phrase) {

    int count = 0;
    for (char d : phrase.toCharArray()) {
      if (d == c) {
        count++;
      }
    }
    return count;
  }

  private void getFrequency(String phrase) {

    this.getUnique(phrase);
    listOfCharacters = new PriorityQueue<>(codeList.size(), new CharacterComparator());

    for (char c : codeList) {
      CharacterCode newChar = new CharacterCode(countFreq(c, phrase));
      newChar.addCode(c);
      listOfCharacters.add(newChar);
    }
  }





  private void generateHash(String phrase) {

    //Assigns frequency to the characters in the PriorityQueue.
    this.getFrequency(phrase);

    int i = 0;
    CharacterCode temp = new CharacterCode(0);

    while (listOfCharacters.size() > 0) {
      //Take the least frequent entry in the priority queue.
      CharacterCode characterEntry =  listOfCharacters.poll();
      //Get the code to assign.
      Character e = codingSet.get(i);
      //Adds the character to a new temp CharacterCode.
      temp = temp.combineChar(characterEntry);
      //For each character, adds the prefix.
      for (Character finalCharacter : characterEntry.getCharacters()) {
        addToHash(finalCharacter, e);
      }

      if (listOfCharacters.size() == 0) {
        break;
      }
      i = i + 1;
      if (i == codingSet.size()) {
        listOfCharacters.add(temp);
        temp = new CharacterCode(0);
        i = 0;

      }
    }
  }



  private void addToHash(Character c, Character e) {
    StringBuilder temp = new StringBuilder();
    temp.append(e);

    if (codes.containsKey(c)) {
      temp = temp.append(codes.get(c));
      codes.put(c, temp.toString());
    } else {
      codes.put(c, e.toString());
    }
    return;
  }


}
