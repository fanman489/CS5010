package quest;

import org.junit.Test;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * Class created to test Question objects.
 */
public class QuestionTest {


  //Check if yes or no answer disregards capitalization.
  @Test
  public void testYesNoCapitalization() {
    Question drive = new YesNoQuestion("Do you drive?", "Yes");
    assertEquals(drive.inputAnswer("Yes"), "Correct.");
    assertEquals(drive.inputAnswer("YES"), "Correct.");
    assertEquals(drive.inputAnswer("No"), "Incorrect.");
    assertEquals(drive.inputAnswer("yes"), "Correct.");
    assertEquals(drive.inputAnswer("12"), "Incorrect.");

    Question driveNo = new YesNoQuestion("Do you drive?", "No");
    assertEquals(driveNo.inputAnswer("No"), "Correct.");
    assertEquals(driveNo.inputAnswer("Yes"), "Incorrect.");
    assertEquals(driveNo.inputAnswer("nO"), "Correct.");
    assertEquals(driveNo.inputAnswer("n1"), "Incorrect.");
  }


  //Check that invalid correct answers will throw error, and invalid answers will throw incorrect.
  @Test
  public void testYesNoInvalidAnswers() {

    try {
      Question driveNo1 = new YesNoQuestion("", "NO");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Need to input question and answer.", ex.getMessage());
    }

    try {
      Question driveNew = new YesNoQuestion("Do you drive?", "123");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Need to input either Yes or No as the correct answer, ignoring "
              + "capitalization.", ex.getMessage());
    }

  }


  //Check that correct answers for likert
  @Test
  public void LikertCheckingAnswer() {
    Question drive = new LikertQuestion("Do you like driving?");

    assertEquals(drive.inputAnswer("5"), "Correct.");
    assertEquals(drive.inputAnswer("4"), "Correct.");
    assertEquals(drive.inputAnswer("3"), "Correct.");
    assertEquals(drive.inputAnswer("2"), "Correct.");
    assertEquals(drive.inputAnswer("1"), "Correct.");
    assertEquals(drive.inputAnswer("0"), "Incorrect.");
    assertEquals(drive.inputAnswer("6"), "Incorrect.");
    assertEquals(drive.inputAnswer("A"), "Incorrect.");

  }


  //Check multiple choice question to string and getting correct answers
  @Test
  public void multipleChoiceCheckToStringAndCheckAnswer() {
    Question driveMult = new MultipleChoiceQuestion("What do you drive?",
            "1", "Honda", "Toyota", "Subaru");

    assertEquals(driveMult.toString(), "What do you drive? [0] Honda [1] Toyota [2] Subaru");
    assertEquals(driveMult.inputAnswer("1"), "Correct.");


    assertEquals(driveMult.toString(), "What do you drive? [0] Honda [1] Toyota [2] Subaru");
    assertEquals(driveMult.inputAnswer("3"), "Incorrect.");


    Question driveMult2 = new MultipleChoiceQuestion("What do you drive?",
            "1e", "Honda", "Toyota", "Subaru");

    assertEquals(driveMult2.toString(), "What do you drive? [0] Honda [1] Toyota [2] Subaru");
    assertEquals(driveMult2.inputAnswer("1"), "Correct.");
  }


  //Check multiple choice invalid answers and correct answers
  @Test
  public void multipleChoiceInvalidAnswer() {

    try {
      Question driveMult = new MultipleChoiceQuestion("What do you drive?",
              "0", "Honda", "Toyota", "Subaru");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid correct answer.", ex.getMessage());
    }


    try {
      Question driveMult1 = new MultipleChoiceQuestion("What do you drive?",
              "4", "Honda", "Toyota", "Subaru");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid correct answer.", ex.getMessage());
    }

    try {
      Question driveMult2 = new MultipleChoiceQuestion("What do you drive?",
              "1", "Honda", "Toyota");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Need to have between 3 to 8 multiple choice answers.", ex.getMessage());
    }


    try {
      Question driveMult3 = new MultipleChoiceQuestion("What do you drive?",
              "1", "Honda", "Toyota", "Nissan", "Kia", "Subaru",
              "Mitsubishi", "Mazda", "Lexus", "Acura");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Need to have between 3 to 8 multiple choice answers.", ex.getMessage());
    }

    try {
      Question driveMult4 = new MultipleChoiceQuestion("What do you drive?",
              "a", "Honda", "Toyota", "Nissan", "Subaru",
              "Mitsubishi", "Mazda", "Lexus", "Acura");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid correct answer.", ex.getMessage());
    }


    try {
      Question driveMult5 = new MultipleChoiceQuestion("What do you drive?",
              "0", "Honda", "Toyota", "Nissan", "Subaru",
              "Mitsubishi", "Mazda", "Lexus", "Acura");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid correct answer.", ex.getMessage());
    }

    try {
      Question driveMult6 = new MultipleChoiceQuestion("What do you drive?",
              "9", "Honda", "Toyota", "Nissan", "Subaru",
              "Mitsubishi", "Mazda", "Lexus", "Acura");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid correct answer.", ex.getMessage());
    }
  }



  @Test
  public void multipleChoiceTestAnswers() {
    Question driveMult = new MultipleChoiceQuestion("What do you drive?",
            "7", "Honda", "Toyota", "Nissan", "Subaru",
            "Mitsubishi", "Mazda", "Lexus", "Acura");

    assertEquals(driveMult.toString(), "What do you drive? [0] Honda [1] Toyota "
            + "[2] Nissan [3] Subaru [4] Mitsubishi [5] Mazda [6] Lexus [7] Acura");
    assertEquals(driveMult.inputAnswer("7"), "Correct.");

    assertEquals(driveMult.toString(), "What do you drive? [0] Honda [1] Toyota "
            + "[2] Nissan [3] Subaru [4] Mitsubishi [5] Mazda [6] Lexus [7] Acura");
    assertEquals(driveMult.inputAnswer("7a"), "Incorrect.");

    assertEquals(driveMult.inputAnswer("7"), "Correct.");
    assertEquals(driveMult.inputAnswer("9"), "Incorrect.");
  }



  //Check multiple answer invalid questions and correct answers
  @Test
  public void multipleAnswerCheckInvalidQuestions() {

    try {
      Question driveMult = new MultipleAnswerQuestion("What do you drive?",
              "1", "Honda", "Toyota", "Nissan", "Kia",
              "Subaru", "Mitsubishi", "Mazda", "Lexus", "Acura");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Need to have between 3 to 8 multiple choice answers.", ex.getMessage());
    }


    try {
      Question driveMult = new MultipleAnswerQuestion("What do you drive?",
              "a", "Honda", "Toyota", "Nissan", "Subaru",
              "Mitsubishi", "Mazda", "Lexus", "Acura");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid correct answer.", ex.getMessage());
    }

    try {
      Question driveMult = new MultipleAnswerQuestion("What do you drive?",
              "73", "Honda", "Toyota", "Nissan",
              "Subaru", "Mitsubishi", "Mazda", "Lexus", "Acura");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid correct answer.", ex.getMessage());
    }


    try {
      Question driveMult = new MultipleAnswerQuestion("What do you drive?",
              "7a", "Honda", "Toyota", "Nissan", "Subaru",
              "Mitsubishi", "Mazda", "Lexus", "Acura");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid correct answer.", ex.getMessage());
    }


    try {
      Question driveMult = new MultipleAnswerQuestion("What do you drive?",
              "", "Honda", "Toyota", "Nissan",
              "Subaru", "Mitsubishi", "Mazda", "Lexus", "Acura");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Need to input question, multiple choices, and correct"
              + " answer.", ex.getMessage());
    }

    try {
      Question driveMult = new MultipleAnswerQuestion("What do you drive?",
              "1 4 9", "Honda", "Toyota", "Nissan",
              "Subaru", "Mitsubishi", "Mazda", "Lexus", "Acura");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid correct answer.", ex.getMessage());
    }


    try {
      Question driveMult = new MultipleAnswerQuestion("What do you drive?",
              "1 4 0", "Honda", "Toyota", "Nissan",
              "Subaru", "Mitsubishi", "Mazda", "Lexus", "Acura");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Invalid correct answer.", ex.getMessage());
    }
  }


  //Check single answer checking.
  @Test
  public void multipleAnswerCheckSingleAnswers() {
    Question driveMult = new MultipleAnswerQuestion("What do you drive?",
            "7", "Honda", "Toyota", "Nissan", "Subaru",
            "Mitsubishi", "Mazda", "Lexus", "Acura");

    assertEquals(driveMult.toString(), "What do you drive? [0] Honda [1] Toyota "
            + "[2] Nissan [3] Subaru [4] Mitsubishi [5] Mazda [6] Lexus [7] Acura");
    assertEquals(driveMult.inputAnswer("7"), "Correct.");
    assertEquals(driveMult.inputAnswer("4"), "Incorrect.");
  }


  //Multiple answer checking
  @Test
  public void multipleAnswerCheckMultipleAnswer() {
    Question driveMult = new MultipleAnswerQuestion("What do you drive?",
            "7 3", "Honda", "Toyota", "Nissan", "Subaru",
            "Mitsubishi", "Mazda", "Lexus", "Acura");

    assertEquals(driveMult.toString(), "What do you drive? [0] Honda [1]"
            + " Toyota [2] Nissan [3] Subaru [4] Mitsubishi [5] Mazda [6] Lexus [7] Acura");
    assertEquals(driveMult.inputAnswer("7 3"), "Correct.");
    assertEquals(driveMult.inputAnswer("7 3"), "Correct.");
    assertEquals(driveMult.inputAnswer("7 1"), "Incorrect.");
    assertEquals(driveMult.inputAnswer("73"), "Incorrect.");
  }



  //Multiple answer checking with repeats
  @Test
  public void multipleAnswerRepeats() {
    Question driveMult = new MultipleAnswerQuestion("What do you drive?",
            "3 7 1 3 3 3 4", "Honda", "Toyota", "Nissan",
            "Subaru", "Mitsubishi", "Mazda", "Lexus", "Acura");


    assertEquals(driveMult.inputAnswer("3 7 1 4 4 1 1 7"), "Correct.");
    assertEquals(driveMult.inputAnswer("1 7 4 3"), "Correct.");
    assertEquals(driveMult.inputAnswer("1 7 43"), "Incorrect.");
    assertEquals(driveMult.inputAnswer("4 7 5 1 3"), "Incorrect.");
    assertEquals(driveMult.inputAnswer("4 7 1"), "Incorrect.");
    assertEquals(driveMult.inputAnswer("3 7 1 4"), "Correct.");

  }




  //Check yes no question to string
  @Test
  public void testYesNoToString() {
    Question driveYN3 = new YesNoQuestion("Is your insurance valid?",
            "Yes");
    assertEquals(driveYN3.toString(), "Is your insurance valid? Input "
            + "either yes or no:");
  }


  //Likert question to string
  @Test
  public void testLikertToString() {
    Question driveL1 = new LikertQuestion("Do you like driving?");
    assertEquals(driveL1.toString(), "Do you like driving? Input a choice between 1 to 5:");
  }


  //Test equality function for all object types
  @Test
  public void testEquality() {
    Question driveMultA = new MultipleAnswerQuestion("What do you drive?",
            "1 2 4", "Honda", "Toyota", "Subaru", "Mazda");
    Question driveMultA1 = new MultipleAnswerQuestion("What do you drive?",
            "1 2 4", "Honda", "Toyota", "Subaru", "Mazda");
    Question driveMultB = new MultipleAnswerQuestion("What do you drive?",
            "1 2 3", "Honda", "Toyota", "Subaru");
    Question driveMultC = new MultipleAnswerQuestion("What do you drive?",
            "1", "Honda", "Toyota", "Subaru");
    Question driveMult2 = new MultipleAnswerQuestion("What do you drive?",
            "1", "Honda", "Toyota", "Nissan", "Kia", "Subaru",
            "Mitsubishi", "Mazda");


    Question driveMA = new MultipleChoiceQuestion("What do you drive?",
            "1", "Honda", "Toyota", "Nissan", "Kia", "Subaru",
            "Mitsubishi", "Mazda", "Lexus");
    Question driveM1 = new MultipleChoiceQuestion("What do you drive?",
            "1 2", "Honda", "Toyota", "Nissan", "Kia", "Subaru",
            "Mitsubishi", "Mazda", "Lexus");
    Question driveM2 = new MultipleChoiceQuestion("What do you drive?",
            "1", "Honda", "Toyota", "Nissan", "Kia", "Subaru",
            "Mitsubishi", "Mazda");


    Question driveYN1 = new YesNoQuestion("Do you drive?",
            "Yes");
    Question driveYN2 = new YesNoQuestion("Can you drive manual?",
            "Yes");
    Question driveYN3 = new YesNoQuestion("Is your insurance valid?",
            "Yes");

    Question driveL1 = new LikertQuestion("Do you like driving?");
    Question driveL2 = new LikertQuestion("How is your driving skill?");
    Question driveL3 = new LikertQuestion("What would you rate your current car?");


    assertEquals(driveMultA.equals(driveMultA), true);
    assertEquals(driveMultA.equals(driveMultC), false);
    assertEquals(driveMultA.equals(driveMultA1), true);
    assertEquals(driveMultA.equals(driveMultB), false);
    assertEquals(driveMultB.equals(driveMultC), true);
    assertEquals(driveMultA1.equals(driveMultB), false);
    assertEquals(driveMultA.equals(driveMA), false);
    assertEquals(driveMultC.equals(driveMultB), true);

    assertEquals(driveMA.equals(driveM1), true);
    assertEquals(driveM1.equals(driveMA), true);
    assertEquals(driveM1.equals(driveM2), false);

    assertEquals(driveM1.equals(driveL1), false);
    assertEquals(driveM1.equals(driveYN3), false);

    assertEquals(driveL1.equals(driveM1), false);
    assertEquals(driveL1.equals(driveL1), true);


    assertEquals(driveYN1.equals(driveM1), false);
    assertEquals(driveYN1.equals(driveL1), false);
    assertEquals(driveYN1.equals(driveYN1), true);

    assertEquals(driveMult2.equals(driveM2), false);
    assertEquals(driveM2.equals(driveMult2), false);


  }






}