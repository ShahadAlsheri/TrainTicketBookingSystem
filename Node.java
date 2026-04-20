public class Node<T> {
//data feild
    T data;    
    Node<T> next;
//a single parameter constructor    
    public Node(T data){
        this.data = data;
        this.next = null;
    }
//double parameter constructor
    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }
}
