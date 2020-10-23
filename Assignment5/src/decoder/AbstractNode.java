package decoder;


/**
 * This represents the abstract methods of a node tree that will code and decode prefix trees.
 * Every node has a coding character, and leaves contain the coding character
 * and a decoded symbol. The parents contains arrays pointing to the children nodes.
 */

public abstract class AbstractNode implements TreeNode {

  private final Character codeName;

  /**
   * The constructor for a node. It associated the coding character with the node.
   * @param name Enter the character code for the node.
   */
  public AbstractNode(Character name) {
    codeName = name;
  }


  /**
   * Gets the coding character for a specific node.
   * @return Returns the code character.
   */
  public Character getCodeName() {
    return codeName;
  }


  /**
   * Gets the full code for a symbol by combining all of the coding characters along the
   * way to reach the leaf. For non-leaf nodes, this returns null.
   * @return Returns the full code path and the symbol, which is null for non-leaf nodes.
   */
  public String getCodeNameAndSymbol() {
    return null;
  }

  /**
   * This returns the symbol of the node. For non-leaf nodes this is null.
   * @return Returns the symbol as a character.
   */
  public Character getSymbol() {
    return null;
  }

  /**
   * Check the children nodes for a specific character. For non-parent nodes, this returns null.
   * @param check The character to check for.
   * @return Returns true if the child exists, or null otherwise.
   */
  public TreeNode checkNode(char check) {
    return null;
  }


  /**
   * Checks the number of nodes for the parent. Returns true if it equals the input parameter, or
   * false if it does not. For leaf nodes it will always return true.
   * @param compare The number to compare to, this is the number of distinct characters in the code
   *                list.
   * @return Returns true is the number of nodes for parent nodes matches the integer input. For
   *          children it will return true.
   */
  public boolean checkNumberofNodes(int compare) {
    return true;
  }




}
