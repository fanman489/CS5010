package quest;

import java.util.Comparator;


/**
 * This class allows for the sorting of two question objects by their type. The type is sorted by
 * yes/no, likert, multiple choice, multiple answer.
 * @param <Question> Indicates the class works with objects of question types.
 */
public class TypeComparator<Question> implements Comparator<Question> {

  /**
   * Compares object a with object b, and returns a -1 if object a is earlier in order to object b,
   * returns 0 if they are same type, and returns 1 if object a is later in order than b.
   * @param a Ouestion object a
   * @param b Ouestion object b
   * @return Returns an int, either -1, 0, or 1
   */
  public int compare(Question a, Question b) {

    if (TypeComparator.checkType(a) > (TypeComparator.checkType(b))) {
      return 1;
    } else if (TypeComparator.checkType(a) < TypeComparator.checkType(b)) {
      return -1;
    } else {
      return 0;
    }

  }


  //Assignes an order to each type of object
  private static Integer checkType(Object a) {

    if (a instanceof YesNoQuestion) {
      return 1;
    } else if (a instanceof LikertQuestion) {
      return 2;
    } else if (a instanceof MultipleAnswerQuestion) {
      return 4;
    } else if (a instanceof MultipleChoiceQuestion) {
      return 3;
    } else {
      return null;
    }

  }


}
