package decoder;

import java.util.ArrayList;

import java.util.List;


/**
 * This class represents a leaf node in the tree. The leaf node will store the code and the symbol
 * associated with that code. Under the prefix code tree the leaf node cannot be converted to a
 * parent node.
 */
public class LeafNode extends AbstractNode {

  private final char symbol;
  private final String codePath;


  /**
   * Constructor for a new leaf node. It contains the entire code and the
   * symbol that the code represents.
   * @param codedChar The symbol that the code represents.
   * @param name The character of the code associated with this leaf
   * @param path The code associated with this leaf. Represents the path taken to get to the leaf.
   */
  public LeafNode(char codedChar, char name, String path) {
    super(name);
    symbol = codedChar;
    codePath = path;
  }


  /**
   * This prefix tree does not allow adding leaves to an existing leaf, therefore this method
   * will throw an exception.
   * @param leaf A leaf node of the list.
   * @return Returns nothing since children are not allowed to be added to a leaf node.
   * @throws IllegalStateException Throws the exception when attempting to add a leaf to
   *          another leaf.
   */
  public TreeNode addLeafs(TreeNode leaf) throws IllegalStateException {
    throw new IllegalStateException("Cannot insert.");
  }


  /**
   * Converts the nodes into a list for reduce functions.
   * @return Returns a list of TreeNode objects.
   */
  public List<TreeNode> toList() {
    List<TreeNode> result = new ArrayList<>();
    result.add(this);
    return result;
  }


  /**
   * Gets the symbol and the entire code stored in the leaf node and puts them into a string.
   * @return Returns the symbol and code as a string in the format y:xxxx, where y is the symbol
   *          and xxxx is the code.
   */
  public String getCodeNameAndSymbol() {
    return symbol + ":" + this.codePath;
  }


  /**
   * Gets the symbol stored in the leaf.
   * @return Returns the symbol from the leaf.
   */
  @Override
  public Character getSymbol() {
    return symbol;
  }



}
