// Class AbstrcatTree.java
// Textbook, Listing 25.4, Page 936
// Name: Michael Rizig
// Class: CS 3305/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: IntelliJ Idea

public abstract class AbstractTree<E> implements Tree<E> {
  @Override /** Inorder traversal from the root*/
  public void inorder() {
  }

  @Override /** Postorder traversal from the root */
  public void postorder() {
  }

  @Override /** Preorder traversal from the root */
  public void preorder() {
  }

  @Override /** Return true if the tree is empty */
  public boolean isEmpty() {
    return getSize() == 0;
  }
}
