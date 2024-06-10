import java.util.Scanner;
public class FirstPart {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    //INPUT
    System.out.println("INGRESE SU PALABRA EN MAYUSCULAS:");
    String palabra = sc.next();
    BST<Integer> arbol = new BST<>();
        for (char c : palabra.toCharArray()) {
            arbol.insert((int)c);
        }
        
    //OUTPUT
    System.out.println(arbol.inOrder());
    System.out.println(arbol.toASCII());
    }
}
