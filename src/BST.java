import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.layout.HierarchicalLayout;
import org.graphstream.ui.view.Viewer;

public class BST<E extends Comparable<E>> {

  private Node<E> root;
  private Graph graph;

  public static final String css = "node { fill-color: black; size: 30px; text-size: 20px; text-color: white; } edge { fill-color: black; size: 2px; arrow-size: 10px, 10px; arrow-shape: arrow; }";

  public BST() {
    root = null;
    graph = new SingleGraph("BST");
    graph.setAttribute("ui.stylesheet", css);
  }

  public boolean isEmpty(){
    return root == null;
  }

  public E search(E x){
    Node<E> res = searchNode(root, x);
    if(res == null) return null;
    return res.data;
  }

  protected Node<E> searchNode(Node<E> actual, E x){
    if(actual == null) return null;
    int resComp = actual.data.compareTo(x);
    if(resComp < 0) return searchNode(actual.right, x);
    if(resComp > 0) return searchNode(actual.left, x);
    return actual;
  }

  public void insert(E x){
    root = insertNode(root, x);
  }

  protected Node<E> insertNode(Node<E> actual, E x){
    if(actual == null){
      graph.addNode(x.toString()).setAttribute("ui.label", x.toString());
      return new Node<E>(x);
    }
    int resComp = actual.data.compareTo(x);
    if(resComp < 0) {
      actual.right = insertNode(actual.right, x);
      String node1 = actual.toString();
      String node2 = actual.right.toString();
      String edge = node1 + node2; 
      if(graph.getEdge(edge) == null)
        graph.addEdge(edge, node1, node2,true);
    }
    if(resComp > 0){
      actual.left = insertNode(actual.left, x);
      String node1 = actual.toString();
      String node2 = actual.left.toString();
      String edge = node1 + node2; 
      if(graph.getEdge(edge) == null)
        graph.addEdge(edge, node1, node2,true);
    }
    return actual;
  }

  @SuppressWarnings("unchecked")
  public E[] son(E x){
    Node<E> parent = searchNode(root, x);
    if(parent == null) 
      return null;
    E[] res = (E[]) new Comparable[2];
    res[0] = parent.left != null ? parent.left.data : null;
    res[1] = parent.right != null ? parent.right.data : null;
    return res;
  }

  public E parent(E x){
    Node<E> res = searchParent(root, null, x);
    if(res == null) return null;
    return res.data;
  }

  protected Node<E> searchParent(Node<E> actual, Node<E> parent, E x){
    if(actual == null) return null;
    int resComp = actual.data.compareTo(x);
    if(resComp < 0) return searchParent(actual.right, actual, x);
    if(resComp > 0) return searchParent(actual.left, actual, x);
    return parent;
    
  }

  public E getMin(){
    if(isEmpty()) return null;
    return getMinNode(root).data;
  }

  protected Node<E> getMinNode(Node<E> actual){
    if(actual.left == null) return actual;
    return getMinNode(actual.left);
  }

  public E getMax(){
    if(isEmpty()) return null;
    return getMaxNode(root).data;
  }

  protected Node<E> getMaxNode(Node<E> actual){
    if(actual.right == null) return actual;
    return getMaxNode(actual.right);
  }

  public String inOrder(){
    return inOrderNode(root);
  }

  public String toASCII() {
    return toASCIINode(root);
  }

  protected String inOrderNode(Node<E> actual){
    if(actual == null) return "";
    return inOrderNode(actual.left) + " " + actual.data + " " + inOrderNode(actual.right);
  }

  protected String toASCIINode(Node<E> actual) {
    if (actual == null) return "";
    return toASCIINode(actual.left) + " " + (char)(int)actual.data  + " " + toASCIINode(actual.right);
}

public void display(){
  System.setProperty("org.graphstream.ui", "swing");
  Viewer view = graph.display(false);
  assignCoordinates(root, 50, 5, 40); 
}

private int assignCoordinates(Node<E> node, int x, int y, int xOffset) {
  if (node != null) {
    graph.getNode(node.toString()).setAttribute("xyz", x, y, 0);
    int leftOffset = assignCoordinates(node.left, x - xOffset, y - 10, xOffset / 2);
    int rightOffset = assignCoordinates(node.right, x + xOffset, y - 10, xOffset / 2);
    return leftOffset + rightOffset;
  }
  return 0;
}

  protected static class Node<E> {
    public E data;
    public Node<E> left;
    public Node<E> right;

    public Node(E data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }
}