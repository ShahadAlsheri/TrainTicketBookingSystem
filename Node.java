
package cpcs204_ass3;

/* 
Course : CPCS 204 
Name : Shahad Rafi Alshehri 
University ID : 2306119
Section : 03C
Name of lab instructor : Nojoud Alshehri 
Assignment number :  #3
*/
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
