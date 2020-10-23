package quest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Allows the creating of an array of question type objects to use in a question bank. This class
 * can collect question objects and arrange them in a specified order.
 */
public class QuestionnaireArray implements Questionnaire {

  private List<Question> questionnaireArray =  new ArrayList<Question>();

  /**
   * This method takes the input question objects and creates an arraylist.
   * @param list Question objects.
   * @throws IllegalArgumentException Throws an exception if the question with
   *          the same text and multiple choice answers is already input.
   */
  QuestionnaireArray(Question... list) throws IllegalArgumentException {

    for (Question i : list) {
      questionnaireArray.add(i);
    }

    for (int i = 0; i < questionnaireArray.size(); i ++) {
      for (int j = i + 1; j < questionnaireArray.size(); j ++) {
        if (questionnaireArray.get(i).equals(questionnaireArray.get(j))) {
          throw new IllegalArgumentException("Cannot input duplicate questions");
        }
      }
    }
  }


  /**
   * Outputs all of the questions as a string.
   * @return Returns the question text as string.
   */

  public String toString() {
    int size = questionnaireArray.size();
    String output = "";

    for (int i = 0; i < size; i++) {
      output = output + (i + 1) + ". " + questionnaireArray.get(i).toString() + " \n";
    }

    return output;

  }

  /**
   * Sorts the array based on question text in lexicographical order, ans also by type in the order
   * yes/no questions, likert questions, multiple choice, multiple answer.
   */
  public void sort() {

    Collections.sort(questionnaireArray, new TextComparator());
    Collections.sort(questionnaireArray, new TypeComparator());

  }




}
