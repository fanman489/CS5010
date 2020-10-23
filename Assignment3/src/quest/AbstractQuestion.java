package quest;


/**
 * This class contains abstract methods used by all of the question type objects.
 */
public abstract class AbstractQuestion implements Question {

  final protected String question;
  final protected String correctAnswer;


  /**
   * Takes the input question and correct answer and assigns them to the question object.
   * @param q Question text.
   * @param a Correct answer.
   */
  protected AbstractQuestion(String q, String a) {
    question = q;
    correctAnswer = a;
  }


  /**
   * Takes the input question for likert question since correct answer is predetermined..
   * @param q Question text.
   */
  protected AbstractQuestion(String q) {
    question = q;
    correctAnswer = "";
  }


  protected boolean equalsYesNo(YesNoQuestion other) {
    return false;
  }

  protected boolean equalsLikert(LikertQuestion other) {
    return false;
  }

  protected boolean equalsMultipleChoice(MultipleChoiceQuestion other) {
    return false;
  }

  protected boolean equalsMultipleAnswer(MultipleAnswerQuestion other) {
    return false;
  }


  protected String compareAnswer(String input, String correctAnswer) {
    if (correctAnswer.equalsIgnoreCase(input)) {
      return "Correct.";
    } else {
      return "Incorrect.";
    }
  }




}
