import java.util.*;
public class SecondPart {
  public static void main(String[] args) {
    BST<Integer> tree = new BST<Integer>();
    tree.insert(25);
    tree.insert(10);
    tree.insert(30);
    tree.insert(5);
    tree.insert(20);
    tree.insert(35);
    tree.insert(3);
    tree.insert(15);
    tree.insert(28);
    tree.insert(33);
    tree.insert(1);
    tree.insert(8);
    tree.insert(40);
    System.out.println(tree.inOrder());
    tree.display();
  }
}