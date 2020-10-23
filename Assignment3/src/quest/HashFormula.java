package quest;

/**
 * This class represents a formula that will replace the hashCode. It is used in conjunction
 * with the equals method.
 */
public class HashFormula {

  /**
   * Updates the hashformula.
   * @param question The question text from the object.
   * @param correctAnswer The correct answer text from the object.
   * @return Returns the hash number.
   */
  public static int hashCode(String question, String correctAnswer) {
    return question.hashCode() + correctAnswer.hashCode();
  }


}
