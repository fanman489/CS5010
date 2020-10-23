package quest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import static java.lang.Character.isDigit;

/**
 * This class creates multiple answers questions. It allows questions that have multiple choices,
 * allowing the answer to select multiple answers. It will indicate if the input answer matches
 * the correct answer.
 */
public class MultipleAnswerQuestion extends MultipleChoiceQuestion {


  /**
   * This method creates a multiple answer question. The question contains the text of the question
   * and 3 - 8 multiple choices, of which the correct answer can be more than one of the choices.
   * The correct answers must be in the form of digit + space + digit.
   * Answers with no spaces or with any invalid answer choice will throw an error. The answers
   * can be in any order, and repeats of the same answer choice will be counted as one instance.
   * Having more unique correct answers than the number of choices will also throw an error.
   * @param questionInput Enter the question text.
   * @param inputCorrectAnswer Enter the correct answers, separated by a space. Any
   *                           digit greater than 0 but less than
   *                           the number of choices in the answer will be rejected.
   * @param answer Enter the answer choices, between 3 and 8 answers.
   *               The first answer will be labeled 1 by the method.
   * @throws IllegalArgumentException When the answer choices are not between 3 and 8, or if the
   *          correct answer is invalid.
   */
  MultipleAnswerQuestion(String questionInput, String inputCorrectAnswer, String ... answer)
          throws IllegalArgumentException {
    super(questionInput, inputCorrectAnswer, answer);



    if (correctAnswer.length() > answer.length * 2 - 1) {
      throw new IllegalArgumentException("Invalid correct answer.");
    }

    for (int i = 0; i < correctAnswer.length(); i += 2) {
      if (!isDigit(correctAnswer.charAt(i))) {
        throw new IllegalArgumentException("Invalid correct answer.");
      }

      if (Character.getNumericValue(correctAnswer.charAt(i)) > multipleAnswers.size()
              || Character.getNumericValue(correctAnswer.charAt(i)) <= 0) {
        throw new IllegalArgumentException("Invalid correct answer.");
      }
    }

    for (int i = 1; i < correctAnswer.length(); i += 2) {
      if (correctAnswer.charAt(i) != ' ') {
        throw new IllegalArgumentException("Invalid correct answer.");
      }
    }

  }


  /**
   * This method will take the answer input and determine if it is correct. The orders of the
   * input answer does not need to match the correct answer. It will only look at unique input
   * answers. The answer must be in the form of digit + space + digit. The exact choices must be
   * selected in order for the answer to be correct, meaning no choices left out or no extra
   * choices selected.
   * @param input Input the answer as digits separated by spaces. Invalid answers are
   *                   incorrect.
   * @return Returns correct or incorrect based on input answer.
   */
  @Override
  public String inputAnswer(String input) {

    String answer = convertAnswer(input);
    String checkAnswer = convertAnswer(this.correctAnswer);

    if (answer == null || checkAnswer == null) {
      return "Incorrect.";
    }

    return compareAnswer(checkAnswer, answer);

  }


  //Sorts the input answer and the correct answer for comparison.
  private String convertAnswer(String input) {
    String inputAnswer = null;
    ArrayList<String> inputNumbers = new ArrayList<>();
    ArrayList<String> inputNumbersUnique;

    for (int i = 0; i < input.length(); i += 2) {
      if (isDigit(input.charAt(i))) {
        inputNumbers.add(Character.toString(input.charAt(i)));
      } else {
        return null;
      }
    }

    for (int i = 1; i < input.length(); i += 2) {
      if (input.charAt(i) != ' ') {
        return null;
      }
    }

    Collections.sort(inputNumbers);
    inputNumbersUnique = (ArrayList<String>)
            inputNumbers.stream().distinct().collect(Collectors.toList());

    for (int i = 0; i < inputNumbers.size(); i++) {
      inputAnswer = String.join("", inputNumbersUnique);
    }

    return inputAnswer;
  }


  @Override
  protected boolean equalsMultipleAnswer(MultipleAnswerQuestion other) {
    return this.toString().compareToIgnoreCase(other.toString()) == 0;
  }

  //Make sure the comparison will not falsely set these two object types equal.
  @Override
  protected boolean equalsMultipleChoice(MultipleChoiceQuestion other) {
    return false;
  }

  /**
   * Compares the text of this multiple answer question with an object to determine
   * if they are equal.
   * @param other This method takes an object of any type to compare to.
   * @return Returns a boolean indicating whether the two objects are equal.
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractQuestion) {
      AbstractQuestion q = (AbstractQuestion) other;
      return q.equalsMultipleAnswer(this);
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
