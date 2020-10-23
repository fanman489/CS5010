package quest;


/**
 * This class creates Likert type questions. This type of question allows users to provide a rating
 * betwee 1 and 5. Any answer within that range is deemed correct.
 */
public class LikertQuestion extends AbstractQuestion {


  /**
   * This creates a Likert question object. Correct answer is assumed to be any integer of 1 to 5,
   * 1 being strongly agree to 5 being strongly disagree. Input questions will also be
   * in the form of a question.
   * @param inputQuestion Enter the text for the question.
   * @throws IllegalArgumentException The method will throw an exception if the question is left
   *                                  as a "".
   *
   */
  LikertQuestion(String inputQuestion) throws IllegalArgumentException {

    super(inputQuestion);

    if (question.isEmpty()) {
      throw new IllegalArgumentException("Question input is blank");
    }
  }


  /**
   * This method checks the input and returns Correct or Incorrect based on if the answer is
   * a digit between 1 and 5.
   * @param input Input the answer to the question as a string, a digit between 1 to 5. Invalid
   *              answers are incorrect.
   * @return Returns Correct or Incorrect as a string.
   */
  @Override
  public String inputAnswer(String input) {

    if (Character.isDigit(input.charAt(0))) {

      if (Character.getNumericValue(input.charAt(0)) >= 1
              && Character.getNumericValue(input.charAt(0)) <= 5) {
        return "Correct.";
      } else {
        return "Incorrect.";
      }
    }

    return "Incorrect.";
  }



  /**
   * Returns the question text. It will automatically append to the question the requirement
   * that the input needs to be a number between 1 and 5.
   * @return Outputs the question text as a string.
   */
  @Override
  public String toString() {
    String output;
    output = question + " Input a choice between 1 to 5:";

    return output;
  }


  /**
   * Method to compare the question text between Likert type questions.
   * @param other Input an object to compare. The object passed should be of type Likert.
   * @return Returns whether the texts are the same.
   */
  @Override
  protected boolean equalsLikert(LikertQuestion other) {
    return this.toString().compareToIgnoreCase(other.toString()) == 0;
  }


  /**
   * Compares the text of this Likert question with an object to determine if they are equal.
   * @param other This method takes an object of any type to compare to.
   * @return Returns a boolean indicating whether the two objects are equal.
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractQuestion) {
      AbstractQuestion q = (AbstractQuestion) other;
      return q.equalsLikert(this);
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
