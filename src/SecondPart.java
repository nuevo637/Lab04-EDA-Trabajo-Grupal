public class SecondPart {

  public static void main(String[] args) {

    BST<Integer> tree = new BST<Integer>();
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(7);
    tree.insert(12);
    tree.insert(17);
    tree.insert(1);
    tree.insert(4);
    tree.insert(6);
    tree.insert(8);
    tree.insert(20);
    System.out.println(tree.inOrder());
    tree.display();
  }
}