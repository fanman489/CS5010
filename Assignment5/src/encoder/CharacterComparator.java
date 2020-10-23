package encoder;

import java.util.Comparator;

/**
 * This method is a comparator for CharacterCode objects. It is used to sort the list by
 * frequency, and by alphabetical order.
 */
public class CharacterComparator implements Comparator<CharacterCode> {

  /**
   * This method compares two CharacterCode objects. The first comparison is by their frequency
   * with lower frequencies assigned a lower priority. If the two objects have the same
   * frequency, then it is compared by lexicographical order with earlier characters having lower
   * priority.
   * @param a The first CharacterCode object to compare.
   * @param b The second CharacterCode object to compare.
   * @return Returns a negative number if a is before b, or positive if b is before a. It would
   *          return 0 if the two characters are the same.
   */
  public int compare(CharacterCode a, CharacterCode b) {

    if (a.getFrequency() != b.getFrequency()) {
      return a.getFrequency() - b.getFrequency();
    }
    return a.getCharacters().toString().compareTo(b.getCharacters().toString());
  }
}
