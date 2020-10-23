package encoder;

import org.junit.Assert;

import org.junit.Test;

import decoder.Decoder;

import static org.junit.Assert.assertEquals;

public class EncoderTest {

  Encoder test = new EncoderImpl("01");

  @Test
  public void testConstructorInvalid() {

    try {
      Encoder testEmpty = new EncoderImpl("");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Need at least 2 unique characters to encode.", ex.getMessage());
    }


    try {
      Encoder testSingle = new EncoderImpl("1");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Need at least 2 unique characters to encode.", ex.getMessage());
    }

    try {
      Encoder testSingle = new EncoderImpl("111");
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertEquals("Need at least 2 unique characters to encode.", ex.getMessage());
    }

  }

  @Test
  public void testEncodeMessage() {

    assertEquals("1100111101010010101101001000111101011", test.encode("Hello World."));

    Encoder testDecodeEncode = new EncoderImpl("01");
    Decoder testDecode = testDecodeEncode.createTree("Hello World.");
    assertEquals("Hello World.", testDecode.decode(
            "1100111101010010101101001000111101011"));
    assertEquals("H:1100\n"
            + "W:1101\n"
            + "e:1111\n"
            + "d:1110\n"
            + " :1010\n"
            + ".:1011\n"
            + "r:100\n"
            + "l:01\n"
            + "o:00\n", testDecode.allCodes());
  }

  @Test
  public void testEncodeMessageLessThanCodeNumber() {

    Encoder testDecodeEncode2 = new EncoderImpl("0134567890abcdef");
    assertEquals("369980487951", testDecodeEncode2.encode("Hello World."));

    Encoder testDecodeEncode3 = new EncoderImpl("0134567890abcdef");
    Decoder testDecode3 = testDecodeEncode3.createTree("Hello World.");
    assertEquals("Hello World.", testDecode3.decode(
            "369980487951"));

    assertEquals("H:3\n" +
            "e:6\n" +
            "l:9\n" +
            "o:8\n" +
            " :0\n" +
            "W:4\n" +
            "r:7\n" +
            "d:5\n" +
            ".:1\n", testDecode3.allCodes());
  }

  @Test
  public void testEncodeWikipedia() {

    String inputWiki =  "(Taken from wikipedia)\n"
            + "\n"
            + "Grace Brewster Murray Hopper (née Murray;"
            + " December 9, 1906 – January 1, 1992) was an American computer "
            + "scientist and United States Navy rear admiral.[1] One of the first"
            + " programmers of the Harvard Mark I computer, she was a pioneer of "
            + "computer programming who invented one of the first compiler related "
            + "tools. She popularized the idea of machine-independent programming"
            + " languages, which led to the development of COBOL, an early high-level"
            + " programming language still in use today.\n"
            + "\n"
            + "Hopper attempted to enlist in the Navy during World War II but"
            + " was rejected because she was 34 years old. She instead joined the"
            + " Navy Reserves. Hopper began her computing career in 1944 when she"
            + " worked on the Harvard Mark I team led by Howard H. Aiken. In 1949,"
            + " she joined the Eckert–Mauchly Computer Corporation and was part of "
            + "the team that developed the UNIVAC I computer. At Eckert–Mauchly she "
            + "began developing the compiler. She believed that a programming language"
            + " based on English was possible. Her compiler converted English terms into"
            + " machine code understood by computers. By 1952, Hopper had "
            + "finished her program"
            + " linker (originally called a compiler), "
            + "which was written for the A-0 System.";

    Encoder testDecodeEncode = new EncoderImpl("01");
    assertEquals(true, testDecodeEncode.createTree(inputWiki).isCodeComplete());
    String outputBinary = testDecodeEncode.encode(inputWiki);

    System.out.print(outputBinary);

    Encoder testDecodeEncodeHex = new EncoderImpl("0123456789abcdef");
    String outputHex = testDecodeEncodeHex.encode(inputWiki);

    System.out.print(outputHex);

  }




}