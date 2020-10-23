package decoder;

import org.junit.Test;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * This class is for running tests on the Decoder class.
 */

public class DecoderTest {

  Decoder testTree = new DecoderImpl("1234567890");


  @Test
  public void testConstructor() {

    try {
      Decoder testTreeNull = new DecoderImpl("");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Cannot input empty code characters.", ex.getMessage());
    }


    try {
      Decoder testTreeNull = new DecoderImpl(null);
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Cannot input null.", ex.getMessage());
    }

    Decoder testTreeRepeat = new DecoderImpl("1 11");
    testTreeRepeat.addCode('b', "1");
    testTreeRepeat.addCode('c', " ");
    assertEquals("b:1\n" + "c: \n", testTreeRepeat.allCodes());
    assertEquals(true, testTreeRepeat.isCodeComplete());



    Decoder testTreeValid = new DecoderImpl("abc");

    try {
      testTreeValid.addCode('b', " ");
      Assert.fail();
    } catch (IllegalStateException ex) {
      assertEquals("This code is not allowed.", ex.getMessage());
    }

    try {
      testTreeValid.addCode('b', " ac");
      Assert.fail();
    } catch (IllegalStateException ex) {
      assertEquals("This code is not allowed.", ex.getMessage());
    }

    Decoder testTreeSingle = new DecoderImpl("a");
    testTreeValid.addCode('b', "a");
  }


  @Test
  public void testAddTreeBase() {

    assertEquals("", testTree.allCodes());

    try {
      testTree.addCode('b', null);
      Assert.fail();
    } catch (NullPointerException ex) {
      assertEquals(null, ex.getMessage());
    }

    testTree.addCode('b',"1");
    assertEquals(testTree.allCodes(), "b:1\n");

    try {
      testTree.addCode('c', "12");
      Assert.fail();
    } catch (IllegalStateException ex) {
      assertEquals("Cannot insert.", ex.getMessage());
    }

    try {
      testTree.addCode('c', "a");
      Assert.fail();
    } catch (IllegalStateException ex) {
      assertEquals("This code is not allowed.", ex.getMessage());
    }

    testTree.addCode('c',"1");
    assertEquals("b:1" + "\n", testTree.allCodes());

  }



  @Test
  public void testAddMultipleNodes() {

    assertEquals(testTree.allCodes(), "");

    testTree.addCode('b',"1213");
    assertEquals(testTree.allCodes(), "b:1213\n");
    testTree.addCode('c',"1216");
    assertEquals(testTree.allCodes(), "b:1213\n"
            + "c:1216\n");
    testTree.addCode('d',"4311");
    testTree.addCode('r',"1212");

    try {
      testTree.addCode('g', "acb");
      Assert.fail();
    } catch (IllegalStateException ex) {
      assertEquals("This code is not allowed.", ex.getMessage());
    }

    try {
      testTree.addCode('d', "1215");
      Assert.fail();
    } catch (IllegalStateException ex) {
      assertEquals("This symbol already input.", ex.getMessage());
    }

    assertEquals(testTree.allCodes(), "b:1213\n"
            + "c:1216\n"
            + "r:1212\n"
            + "d:4311\n" );
  }


  @Test
  public void testDecodeMultipleChar() {

    try {
      assertEquals(testTree.decode("1"), "");
      Assert.fail();
    } catch (IllegalStateException ex) {
      assertEquals("No such code exists.", ex.getMessage());
    }

    try {
      assertEquals(testTree.decode(null), "");
      Assert.fail();
    } catch (IllegalStateException ex) {
      assertEquals("No such code exists.", ex.getMessage());
    }

    assertEquals(testTree.decode(""), "");

    testTree.addCode('b',"10");
    testTree.addCode('c',"121");
    testTree.addCode('a',"");
    testTree.addCode('-',"132");
    testTree.addCode('e',"2");
    testTree.addCode(' ',"31");

    assertEquals(testTree.decode(""), "");
    assertEquals("-", testTree.decode("132"));
    assertEquals("b c-b", testTree.decode("103112113210"));


    try {
      assertEquals(testTree.decode("132 "), "");
      Assert.fail();
    } catch (IllegalStateException ex) {
      assertEquals("No such code exists.", ex.getMessage());
    }



    try {
      assertEquals(testTree.decode("1321"), "");
      Assert.fail();
    } catch (IllegalStateException ex) {
      assertEquals("No such code exists.", ex.getMessage());
    }

  }


  @Test
  public void testDecodeSingleChar() {


    testTree.addCode('a',"1");
    testTree.addCode('b',"2");
    testTree.addCode('c',"3");
    testTree.addCode('d',"4");
    testTree.addCode('e',"5");

    assertEquals("abcde", testTree.decode("12345"));
    assertEquals("abcbcd", testTree.decode("123234"));

    try {
      assertEquals(testTree.decode("132623"), "");
      Assert.fail();
    } catch (IllegalStateException ex) {
      assertEquals("No such code exists.", ex.getMessage());
    }


    try {
      assertEquals(testTree.decode("123b"), "");
      Assert.fail();
    } catch (IllegalStateException ex) {
      assertEquals("No such code exists.", ex.getMessage());
    }



  }


  @Test
  public void testTreeCompleteCheck() {

    Decoder completeTree = new DecoderImpl("01");

    assertEquals(false, completeTree.isCodeComplete());

    completeTree.addCode('b',"10");
    assertEquals(false, completeTree.isCodeComplete());
    completeTree.addCode('c',"11");
    assertEquals(false, completeTree.isCodeComplete());
    completeTree.addCode('a',"01");
    assertEquals(false, completeTree.isCodeComplete());
    completeTree.addCode('d',"00");

    assertEquals(true, completeTree.isCodeComplete());
  }

  @Test
  public void testTreeCompleteCheckLarge() {

    Decoder completeTree = new DecoderImpl("012");

    assertEquals(false, completeTree.isCodeComplete());

    completeTree.addCode('b',"01");
    assertEquals(false, completeTree.isCodeComplete());
    completeTree.addCode('c',"02");
    assertEquals(false, completeTree.isCodeComplete());
    completeTree.addCode('a',"00");
    assertEquals(false, completeTree.isCodeComplete());
    completeTree.addCode('d',"11");
    assertEquals(false, completeTree.isCodeComplete());
    completeTree.addCode('e',"12");
    assertEquals(false, completeTree.isCodeComplete());
    completeTree.addCode('f',"10");
    assertEquals(false, completeTree.isCodeComplete());
    completeTree.addCode('g',"20");
    assertEquals(false, completeTree.isCodeComplete());
    completeTree.addCode('h',"21");
    assertEquals(false, completeTree.isCodeComplete());
    completeTree.addCode('i',"22");


    assertEquals(true, completeTree.isCodeComplete());
  }

  @Test
  public void testSingleTreeCompleteCheck() {

    Decoder singleTree = new DecoderImpl("1");

    singleTree.addCode('b',"1");
    assertEquals(true, singleTree.isCodeComplete());

  }

  @Test
  public void testSingleTreeCompleteCheckMultipleCodes() {

    Decoder singleTree = new DecoderImpl("123");


    singleTree.addCode('b',"1");
    assertEquals(false, singleTree.isCodeComplete());
    singleTree.addCode('c',"2");
    assertEquals(false, singleTree.isCodeComplete());
    singleTree.addCode('d',"32");
    assertEquals(false, singleTree.isCodeComplete());
    singleTree.addCode('e',"31");
    assertEquals(false, singleTree.isCodeComplete());

  }


  @Test
  public void testSingleTreeRepeatedCode() {

    Decoder singleTree = new DecoderImpl("111");

    singleTree.addCode('b',"1");
    assertEquals(true, singleTree.isCodeComplete());

  }




}