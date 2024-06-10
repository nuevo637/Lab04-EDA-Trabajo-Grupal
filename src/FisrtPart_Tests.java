public class FisrtPart_Tests {
    public static void main(String[] args) {
        // Crear un árbol binario de búsqueda
        BST<Integer> bst = new BST<>();

        // Insertar elementos en el árbol
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        //Arbol inOrder()
        System.err.println("Arbol inOrder: " + bst.inOrder());

        // Buscar un elemento en el árbol
        System.out.println("Búsqueda de 40: " + bst.search(40));

        // Obtener el mínimo y el máximo elemento en el árbol
        System.out.println("Mínimo: " + bst.getMin());
        System.out.println("Máximo: " + bst.getMax());

        // Obtener el padre de un elemento en el árbol
        System.out.println("Padre de 40: " + bst.parent(40));

        // Obtener los hijos izquierdo y derecho de un elemento en el árbol
        Comparable<Integer>[] hijos = bst.son(30);
        System.out.println("Hijo izquierdo de 30: " + hijos[0]);
        System.out.println("Hijo derecho de 30: " + hijos[1]);
    }
}