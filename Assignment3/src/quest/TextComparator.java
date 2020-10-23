package quest;

import java.util.Comparator;

/**
 * This class allows for the sorting of two question objects by their question text in
 * lexicographical order.
 * @param <Question> Indicates the class works with objects of question types.
 */
public class TextComparator<Question> implements Comparator<Question> {

  /**
   * Compares object a with object b, and returns a -1 if text in object a is earlier in
   * order to text in object b, returns 0 if they are same type, and returns 1 if object
   * a is later in order than b.
   * @param a Ouestion object a
   * @param b Ouestion object b
   * @return Returns an int, either -1, 0, or 1
   */
  public int compare(Question a, Question b) {

    return a.toString().compareToIgnoreCase(b.toString());

  }



}
