package quest;

import java.util.ArrayList;
import java.util.List;


/**
 * This class creates multiple choice questions. It allows questions that have multiple choices,
 * allowing the answer to select one of the choices. It will indicate if the input answer matches
 *  * the correct answer.
 */
public class MultipleChoiceQuestion extends AbstractQuestion {

  final protected List<String> multipleAnswers = new ArrayList<>();
  final private Integer choiceLimit = 8;


  /**
   * This method creates a multiple choice question. The question contains the text of the question
   * and 3 - 8 multiple choices. The method will check that the first digit of the correct answer
   * is a number and is valid based on the number of choices. It will ignore anything after the
   * first digit.
   * @param inputQuestion Enter the question text.
   * @param inputCorrectAnswer Enter the correct answer as a digit greater than 0 but less than
   *                           the number of choices. Anything else will be deemed incorrect.
   * @param answer Enter the answer choices, between 3 and 8 answers.
   *               The first answer will be labeled 1 by the method.
   * @throws IllegalArgumentException When the answer choices are not between 3 and 8, or if the
   *          correct answer is invalid.
   */
  MultipleChoiceQuestion(String inputQuestion, String inputCorrectAnswer, String ... answer)
          throws IllegalArgumentException {

    super(inputQuestion, inputCorrectAnswer);

    for (String i : answer) {
      this.multipleAnswers.add(i);
    }
    this.checkCorrectAnswer();
  }


  /**
   * This method checks the input and determines if it's the correct choice.
   * @param input Input the answer to the question. The method will compare the first digit of the
   *              input answer, anything else will be ignored. Anything other than
   *              the correct answer will be incorrect.
   * @return Returns string correct or incorrect based on the answer input.
   */
  @Override
  public String inputAnswer(String input) {

    String compareAnswer = Character.toString(correctAnswer.charAt(0));

    return compareAnswer(compareAnswer, input);

  }


  /**
   * Outputs the question and multiple choice answers to a string.
   * @return Returns the question along with the answers labeled by the order they were entered.
   */
  @Override
  public String toString() {

    String output;
    output = this.question;

    for (int i = 0; i < this.multipleAnswers.size(); i++) {
      output = output + " ["  + i + "] " + this.multipleAnswers.get(i);
    }
    return output;
  }


  /**
   * Method to compare the question text between multiple choice type questions.
   * @param other Input an object to compare. The object passed should be of type Yes/No.
   * @return Returns whether the texts are the same.
   */
  @Override
  protected boolean equalsMultipleChoice(MultipleChoiceQuestion other) {
    return this.toString().compareToIgnoreCase(other.toString()) == 0;
  }


  /**
   * Compares the text of this multiple choice question with an object to determine
   * if they are equal.
   * @param other This method takes an object of any type to compare to.
   * @return Returns a boolean indicating whether the two objects are equal.
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractQuestion) {
      AbstractQuestion q = (AbstractQuestion) other;
      return q.equalsMultipleChoice(this);
    }
    return false;
  }


  //Method used to check format of correct answer.
  private void checkCorrectAnswer() throws IllegalArgumentException {

    if (this.multipleAnswers.size() < 3 || this.multipleAnswers.size() > choiceLimit) {
      throw new IllegalArgumentException("Need to have between 3 to 8 multiple choice answers.");
    }

    if (this.question.isEmpty() || this.correctAnswer.isEmpty()) {
      throw new IllegalArgumentException("Need to input question, multiple choices,"
              + " and correct answer.");
    }

    if (Character.isDigit(this.correctAnswer.charAt(0))) {
      if (Character.getNumericValue( this.correctAnswer.charAt(0)) <= 0
              || Character.getNumericValue( this.correctAnswer.charAt(0))
              > this.multipleAnswers.size()) {
        throw new IllegalArgumentException("Invalid correct answer.");
      }
    } else {
      throw new IllegalArgumentException("Invalid correct answer.");
    }

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
