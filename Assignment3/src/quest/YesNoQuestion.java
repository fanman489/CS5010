package quest;


/**
 * This class allows creating yes/no questions. These questions allow an input of either yes or no,
 * and the method will determine if it matches the correct answer.
 */
public class YesNoQuestion extends AbstractQuestion {

  /**
   * This creates a Yes/No question object. Correct answer can only be either yes or no,
   * ignoring capitalization.
   * @param inputQuestion Enter the text of the question.
   * @param inputCorrectAnswer Enter the correct answer to the question, either yes or no.
   * @throws IllegalArgumentException Throws an exception if the input correct answer is not yes
   *          or no, or if the question or correct answers are empty.
   */
  YesNoQuestion(String inputQuestion, String inputCorrectAnswer) throws IllegalArgumentException {

    super(inputQuestion, inputCorrectAnswer);

    if (question.isEmpty() || correctAnswer.isEmpty()) {
      throw new IllegalArgumentException("Need to input question and answer.");
    }
    if (correctAnswer.equalsIgnoreCase("Yes") || correctAnswer.equalsIgnoreCase(
            "No")) {
      return;
    } else {
      throw new IllegalArgumentException("Need to input either Yes or No as the "
              + "correct answer, ignoring capitalization.");
    }
  }


  /**
   * Checks the input and return correct or incorrect.
   * @param input Input the answer to the question, answers that don't match or invalid are
   *              considered incorrect.
   * @return Returns correct or incorrect based on if the input answer matches the correct answer.
   */
  @Override
  public String inputAnswer(String input) {
    return compareAnswer(correctAnswer, input);
  }


  /**
   * Returns the question text. The method will automatically append a text saying the input answer
   * needs to either be yes or no.
   * @return Outputs the question text as a string.
   */
  @Override
  public String toString() {
    return question + " Input either yes or no:";
  }



  /**
   * Method to compare the question text between Yes/No type questions.
   * @param other Input an object to compare. The object passed should be of type Yes/No.
   * @return Returns whether the texts are the same.
   */
  @Override
  protected boolean equalsYesNo(YesNoQuestion other) {
    return this.toString().compareToIgnoreCase(other.toString()) == 0;
  }


  /**
   * Compares the text of this Yes/No question with an object to determine if they are equal.
   * @param other This method takes an object of any type to compare to.
   * @return Returns a boolean indicating whether the two objects are equal.
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractQuestion) {
      AbstractQuestion q = (AbstractQuestion) other;
      return q.equalsYesNo(this);
    }
    return false;
  }


  /**
   * Updates the hash function, in conjunction with the equals method.
   * @return Returns the hash number.
   */
  @Override
  public int hashCode() {
    return HashFormula.hashCode(question, correctAnswer);
  }



}
