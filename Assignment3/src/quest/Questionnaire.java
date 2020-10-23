package quest;



/**
 * This interface represents the functions used to create an array of question objects that can
 * be used in a question bank. The function is to store questions and display them.
 */
public interface Questionnaire {

  /**
   * Outputs the objects in the list to a string.
   * @return Displays the questions in the question list.
   */
  String toString();

  /**
   * Sorts the current list of questions based on specified algorithm.
   */
  public void sort();
}
