package quest;


/**
 * This interface represents the methods for all question type objects. These objects take in
 * an answer and determines whether that answer matches the correct answer set by the question.
 * It also can compare whether different objects are equal to each other. Finally, it can output
 * the text of the question and any other information related to the question.
 */
public interface Question {


  /**
   * This method takes the answer and outputs a string to indicate whether the question was correct
   * or incorrect.
   * @param input Input the answer to the question.
   * @return Returns either "Correct" or "Incorrect".
   */
  String inputAnswer(String input);


  /**
   * Compares whether two question objects contain the same exact question. Questions of the same
   * text but different question type are also deemed incorrect. Questions with the same
   * text but different correct answers are also deemed to be the same.
   * @param other This method takes an object of any type.
   * @return Returns a boolean indicating true if the input object is equal to the Question object
   *          where the method is called from.
   */
  boolean equals(Object other);

  /**
   * Outputs all of the question text and any answers.
   * @return Outputs all question and answer as string.
   */
  String toString();

  /**
   * Overrides the hashCode method.
   * @return Outputs hashcode.
   */
  int hashCode();

}
