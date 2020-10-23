package decoder;

import java.util.ArrayList;

import java.util.List;

import java.util.stream.Collectors;

/**
 * This class represents a decoder that will take prefix codes and store them. It then allows a
 * user to take a coded message and convert it to it's actual message. It uses a tree to store and
 * retrieve the coded message.
 *
 */

public class DecoderImpl implements Decoder {

  private TreeNode root;
  private List<Character> codeValues = new ArrayList<>();


  /**
   * This is the constructor that creates a tree for storing the codes. The user inputs the
   * characters that are allowed to be used for the coding. This constructor allows all ASCII
   * characters. Repeated characters will be treated as one character. The constructor requires
   * at least a single ASCII character in the string.
   * @param allowedCode This is a string that contains all of the characters allowed for the code.
   * @throws IllegalArgumentException Throws the exception when the input is null or empty.
   */
  public DecoderImpl(String allowedCode) throws IllegalArgumentException {

    if (allowedCode == null) {
      throw new IllegalArgumentException("Cannot input null.");
    }

    if (allowedCode.equals("")) {
      throw new IllegalArgumentException("Cannot input empty code characters.");
    }

    root = new GroupNode();
    for (Character c:allowedCode.toCharArray()) {
      codeValues.add(c);
    }
  }

  /**
   * This method will add characters and their associated code to the tree as a new leaf.
   * Empty codes will be ignored. Typing in the same symbol will not overwrite
   * existing code for the same symbol. This method will create all of the parent nodes needed to
   * reach the leaf. Leafs cannot be converted into a parent node.
   * @param symbol The symbol that the code represents, as a character.
   * @param code The code that will represent the symbol.
   * @throws IllegalStateException This method will throw an exception if the code has characters
   *          not allowed, or the symbol has already been input into the tree as a code.
   */
  public void addCode(char symbol, String code) throws IllegalStateException {

    char searchChar;
    TreeNode current = root;

    List<Character> nodeList;
    nodeList = root.toList().stream().map(e -> e.getSymbol()).collect(Collectors.toList());
    if (nodeList.contains(symbol)) {
      throw new IllegalStateException("This symbol already input.");
    }

    for (Character c:code.toCharArray()) {
      if (!codeValues.contains(c)) {
        throw new IllegalStateException("This code is not allowed.");
      }
    }

    //Cycle through the string code, if the code doesnt exist, create a path to it
    for (int i = 0; i < code.length(); i++) {
      searchChar = code.charAt(i);
      TreeNode leaf = current.checkNode(searchChar);

      if (leaf != null) {
        current = leaf;
      } else {
        if (i == code.length() - 1) {
          TreeNode newCode = new LeafNode(symbol, searchChar, code);
          current = current.addLeafs(newCode);

        } else {
          TreeNode newCode = new GroupNode(searchChar);
          current = current.addLeafs(newCode);
        }
      }
    }
  }


  /**
   * This method will display all of the symbols and the code associated with it in the format
   * y:xxxx where y is the symbol and xxxx is the code.
   * @return Returns as a string all of the symbols and codes input so far.
   */
  public String allCodes() {
    List<String> leafList;
    leafList = root.toList().stream().map(e -> e.getCodeNameAndSymbol())
            .collect(Collectors.toList());
    String output = "";

    for (int i = 0; i < leafList.size(); i++) {
      output = output + leafList.get(i) + "\n";
    }
    return output;
  }


  /**
   * This method takes a string and decodes it into the symbols based on the code tree. The string
   * cannot have characters not part of the coding characters.
   * @param code Enter the code that you want to decode into symbols.
   * @return Outputs the symbols as a string.
   * @throws IllegalStateException Throws an exception when the code doesn't match any symbol,
   *          or if there is a character input that is not allowed or a blank space.
   */
  public String decode(String code) throws IllegalStateException {

    char searchChar;
    StringBuilder output = new StringBuilder("");
    TreeNode current = root;
    if (code == null) {
      throw new IllegalStateException("No such code exists.");
    }

    for (int i = 0; i < code.length(); i++) {

      searchChar = code.charAt(i);
      TreeNode nextNode = current.checkNode(searchChar);

      if (nextNode == null) {
        throw new IllegalStateException("No such code exists.");
      }

      if (nextNode.getSymbol() != null ) {
        output.append(nextNode.getSymbol());
        current = root;
      } else {
        if (i >= code.length() - 1) {
          throw new IllegalStateException("No such code exists.");
        }
        current = nextNode;
      }

    }
    return output.toString();
  }

  /**
   * This method checks if the tree is complete. This means that the number of nodes at each
   * parent is equal to the number of unique characters allowed in the code. It means that any code
   * with those characters can be decoded.
   * @return Returns a boolean indicating whether the code tree is complete.
   */

  public boolean isCodeComplete() {
    int numberOfNodes = checkStringRepeat(codeValues).size();
    return root.checkNumberofNodes(numberOfNodes);
  }


  //Removes duplicates of a character array
  private static List<Character> checkStringRepeat(List<Character> input) {

    List<Character> noDups = new ArrayList<>();

    for (char c:input) {
      if (noDups.indexOf(c) == -1) {
        noDups.add(c);
      }
    }
    return noDups;
  }



}
