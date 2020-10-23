package quest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;


/**
 * Class to test created questionnaire lists.
 */

public class QuestionnaireTest {

  QuestionnaireArray questionnaire = new QuestionnaireArray(
          new MultipleAnswerQuestion("What do you drive?", "1 2 4",
                  "Honda", "Toyota", "Subaru", "Mazda"),
          new YesNoQuestion("Do you drive?", "Yes"),
          new YesNoQuestion("Does your significant other drive?",
                  "Yes"));


  QuestionnaireArray sorted = new QuestionnaireArray(

          new YesNoQuestion("Can you drive manual?", "Yes"),
          new YesNoQuestion("Do you drive?", "Yes"),
          new YesNoQuestion("Is your insurance valid?", "Yes"),

          new LikertQuestion("Do you like driving?"),
          new LikertQuestion("How is your driving skill?"),
          new LikertQuestion("What would you rate your current car?"),


          new MultipleChoiceQuestion("Do you know which model is most reliable?",
                  "2", "Honda", "Toyota", "Subaru"),
          new MultipleChoiceQuestion("Is there a model that is least reliable?",
                  "3", "Honda", "Toyota", "Subaru"),
          new MultipleChoiceQuestion("What do you drive?", "1",
                  "Honda", "Toyota", "Subaru", "Mazda"),
          new MultipleChoiceQuestion("What is your favorite make?", "1",
                  "Honda", "Toyota", "Subaru", "Mazda"),

          new MultipleAnswerQuestion("Can you pick the models which do not make SUVs?",
                  "3 5", "Honda", "Toyota", "Nissan", "Kia", "Subaru",
                  "Mitsubishi", "Mazda"),
          new MultipleAnswerQuestion("Select the models that are luxury models.",
                  "1 2", "Honda", "Toyota", "Nissan", "Kia",
                  "Subaru", "Mitsubishi", "Mazda", "Lexus"),
          new MultipleAnswerQuestion("Which models are Japanese models?",
                  "1 4", "Honda", "Toyota", "Nissan", "Kia",
                  "Subaru", "Mitsubishi", "Mazda", "Lexus"));


  QuestionnaireArray unsorted = new QuestionnaireArray(


          new MultipleChoiceQuestion("Do you know which model is most reliable?",
                  "2", "Honda", "Toyota", "Subaru"),
          new YesNoQuestion("Is your insurance valid?", "Yes"),
          new MultipleAnswerQuestion("Select the models that are luxury models.",
                  "1 2", "Honda", "Toyota", "Nissan", "Kia", "Subaru",
                  "Mitsubishi", "Mazda", "Lexus"),
          new LikertQuestion("Do you like driving?"),
          new MultipleChoiceQuestion("What do you drive?", "1",
                  "Honda", "Toyota", "Subaru", "Mazda"),
          new LikertQuestion("What would you rate your current car?"),
          new YesNoQuestion("Do you drive?", "Yes"),
          new MultipleAnswerQuestion("Which models are Japanese models?",
                  "1 4", "Honda", "Toyota", "Nissan", "Kia",
                  "Subaru", "Mitsubishi", "Mazda", "Lexus"),
          new YesNoQuestion("Can you drive manual?", "Yes"),
          new MultipleChoiceQuestion("Is there a model that is least reliable?",
                  "3", "Honda", "Toyota", "Subaru"),
          new MultipleAnswerQuestion("Can you pick the models which do not make SUVs?",
                  "3 5", "Honda", "Toyota", "Nissan",
                  "Kia", "Subaru", "Mitsubishi", "Mazda"),
          new MultipleChoiceQuestion("What is your favorite make?",
                  "1", "Honda", "Toyota", "Subaru", "Mazda"),
          new LikertQuestion("How is your driving skill?"));


  //check array before and after sort
  @Test
  public void createArrayToStringUnsortedToSorted() {

    assertEquals(questionnaire.toString(), "1. What do you drive? [0] Honda [1] "
            + "Toyota [2] Subaru [3] Mazda \n"
            + "2. Do you drive? Input either yes or no: \n"
            + "3. Does your significant other drive? Input either yes or no: \n");


    questionnaire.sort();

    assertEquals(questionnaire.toString(), "1. Do you drive? Input either yes or no: \n"
            + "2. Does your significant other drive? Input either yes or no: \n"
            + "3. What do you drive? [0] Honda [1] Toyota [2] Subaru [3] Mazda \n");

  }



  //Check long array with multiple questions of each type
  @Test
  public void sortArrayMultipleTypes() {

    unsorted.sort();
    assertEquals(unsorted.toString(), sorted.toString());

  }




  //Check that same question texts of same type will throw error
  @Test
  public void checkMultipleRepeatedQuestionsThrowError() {

    try {
      QuestionnaireArray repeat = new QuestionnaireArray(new MultipleAnswerQuestion(
              "Which models are Japanese models?",
              "1 4", "Honda", "Toyota", "Nissan", "Kia",
              "Subaru", "Mitsubishi", "Mazda", "Lexus"), new MultipleAnswerQuestion(
                      "Which models are Japanese models?",
              "1 4", "Honda", "Toyota", "Nissan", "Kia",
              "Subaru", "Mitsubishi", "Mazda", "Lexus"), new MultipleAnswerQuestion(
                      "Which models are Japanese models?",
              "1 4", "Honda", "Toyota", "Nissan", "Kia",
              "Subaru", "Mitsubishi", "Mazda", "Lexus"));
      Assert.fail();
    } catch (IllegalArgumentException ex) {

      assertEquals("Cannot input duplicate questions", ex.getMessage());
    }
  }

  //check the invalidation does not apply when it's questions of different types
  @Test
  public void checkMultipleRepeatedQuestionsDIffType() {


    QuestionnaireArray repeat = new QuestionnaireArray(new MultipleAnswerQuestion(
            "Which models are Japanese models?",
            "1 4", "Honda", "Toyota", "Nissan", "Kia",
            "Subaru", "Mitsubishi", "Mazda", "Lexus"), new MultipleChoiceQuestion(
            "Which models are Japanese models?",
            "1 4", "Honda", "Toyota", "Nissan", "Kia",
            "Subaru", "Mitsubishi", "Mazda", "Lexus"));


    assertEquals("1. Which models are Japanese models? [0] Honda [1] Toyota [2] "
            + "Nissan [3] Kia [4] Subaru [5] Mitsubishi [6] Mazda [7] Lexus \n"
            + "2. Which models are Japanese models? [0] Honda [1] Toyota [2] Nissan "
            + "[3] Kia [4] Subaru [5] Mitsubishi [6] Mazda [7] Lexus \n", repeat.toString());

  }



}