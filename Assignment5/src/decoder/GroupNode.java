package decoder;

import java.util.ArrayList;

import java.util.LinkedList;

import java.util.List;

/**
 * This class represents a parent node in the node tree. In addition to the character code, it
 * also has a list of the children.
 */

public class GroupNode extends AbstractNode {

  private List<TreeNode> children;

  /**
   * Constructor for the parent node, which populates the code character and creates an empty
   * list of children.
   * @param name This the code character associated with the node.
   */
  public GroupNode(char name) {
    super(name);
    children = new LinkedList<TreeNode>();
  }

  //Private constructor used to generate a root node for an empty tree.
  protected GroupNode() {
    super(null);
    children = new LinkedList<TreeNode>();
  }


  /**
   * This method will adds a child node to the selected parent node.
   * @param node This is the child node to add.
   * @return Returns the node entered into the tree.
   * @throws IllegalStateException This will throw an exception if a leaf of the same code
   *          already exists.
   */
  public TreeNode addLeafs(TreeNode node) throws IllegalStateException {

    if (checkLeafsForAdding(node.getCodeName())) {
      this.children.add(node);
    } else {
      throw new IllegalStateException("Cannot add this node."
              + node.getCodeName() + " " + this.getCodeName());
    }
    return node;
  }

  //Check if the leaf note we want to add will overwrite a leaf node.
  private boolean checkLeafsForAdding(char nameCheck) {
    for (int i = 0; i < this.children.size(); i++) {
      if (this.children.get(i).getCodeName() == nameCheck
              && this.children.get(i).getSymbol() != null) {
        return false;
      }
    }

    return true;
  }


  /**
   * Combined all of the nodes into a list for fold purposes.
   * @return Returns the list of nodes.
   */
  public List<TreeNode> toList() {

    List<TreeNode> result = new ArrayList<TreeNode>();
    for (TreeNode e:children) {
      result.addAll(e.toList());
    }
    return result;
  }


  /**
   * Checks the children nodes for the character specified and returns the child node if
   * there is a match or will return nothing if there is not a match.
   * @param check The character to check for.
   * @return Returns the node if found, or null if not found.
   */
  @Override
  public TreeNode checkNode(char check) {

    if (children != null) {
      for (TreeNode node:children) {
        if (node.getCodeName() == check) {
          return node;
        }
      }
    }
    return null;
  }


  /**
   * Checks the number of nodes in the parent and compares it to the integer input.
   * @param compare The number to compare to, this is the number of distinct characters in the code
   *                list.
   * @return Returns false if the number of nodes is not equal, or true if it is.
   */
  @Override
  public boolean checkNumberofNodes(int compare) {
    int size = children.size();

    if (size - compare != 0) {
      return false;
    }
    for (TreeNode eachLeaf:children) {
      if (!eachLeaf.checkNumberofNodes(compare)) {
        return false;
      }
    }

    return true;
  }



}
