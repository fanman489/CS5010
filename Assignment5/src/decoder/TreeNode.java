package decoder;

import java.util.List;

/**
 * This class represents a class that will create a list using nodes setup as a tree.
 */

public interface TreeNode {

  /**
   * Add leaf to the tree.
   * @param leaf A leaf node of the list.
   * @return Returns a new tree node structure with the new node added.
   */
  TreeNode addLeafs(TreeNode leaf);

  /**
   * Get the code associated with the node.
   * @return Returns the character of the code.
   */
  Character getCodeName();

  /**
   * Put all the leaf nodes into a list.
   * @return Returns a list containing all of the tree nodes.
   */
  List<TreeNode> toList();

  /**
   * Get the symbol and full code for a leaf node.
   * @return Returns the symbol and the entire code name.
   */
  String getCodeNameAndSymbol();

  /**
   * Check the children of the current node to see if they contain a character. Returns the node
   * if that node exists, otherwise returns nothing.
   * @param code The code to check for.
   * @return Returns the child node if it contains the code, or empty if there is none.
   */
  TreeNode checkNode(char code);


  /**
   * Get the symbol for that node. If it is not a leaf node then it will return null.
   * @return Returns the symbol as a character or null if it is not a leaf node.
   */
  Character getSymbol();

  /**
   * Check the number of children for the node and compares it to a number. It will return a true
   * if the number of children matches, or false if it doesn't.
   * @param compare The number to compare to.
   * @return Returns true if the number of nodes matches.
   */
  boolean checkNumberofNodes(int compare);

}
