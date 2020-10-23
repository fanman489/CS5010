package encoder;

import java.util.ArrayList;

/**
 * This class represents a code object that will be used in the encoder. It contains
 * a list of characters and a frequency which represents the total frequency of all of the
 * characters in the array.
 */

public class CharacterCode {

  private int frequency;
  private ArrayList<Character> characters = new ArrayList<>();

  protected CharacterCode(int freq) {
    frequency = freq;
  }

  protected CharacterCode combineChar(CharacterCode newChar) {

    CharacterCode output = new CharacterCode(frequency + newChar.getFrequency());
    for (Character c:characters) {
      output.addCode(c);
    }
    for (Character c:newChar.getCharacters()) {
      output.addCode(c);
    }
    return output;

  }

  protected int getFrequency() {
    return frequency;
  }

  public void addCode(Character c) {
    characters.add(c);
  }

  protected ArrayList<Character> getCharacters() {
    return characters;
  }

  protected String getOutput() {
    StringBuilder output = new StringBuilder("");

    for (Character c:characters) {
      output.append(c);
    }
    return output.toString() + ":" + Integer.toString(frequency) + "\n";
  }


}
