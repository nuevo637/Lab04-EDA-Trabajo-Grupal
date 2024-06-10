import java.util.*;
public class SecondPart {
  public static void main(String[] args) {
    BST<Integer> tree1 = new BST<Integer>();
    tree1.insert(25);
    tree1.insert(10);
    tree1.insert(30);
    tree1.insert(5);
    tree1.insert(20);
    tree1.insert(35);
    tree1.insert(3);
    tree1.insert(15);
    tree1.insert(28);
    tree1.insert(33);
    tree1.insert(1);
    tree1.insert(8);
    tree1.insert(40);
    System.out.println(tree1.inOrder());
    tree1.display();


    BST<Character> tree2 = new BST<Character>();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a word:");
    String word = sc.next().toUpperCase();
    
    for(Character c : word.toCharArray()) {
      tree2.insert(c);
    }
    tree2.display();

  }
}