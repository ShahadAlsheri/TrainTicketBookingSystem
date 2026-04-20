public class Stack <T>{
//data feild
    private Node<T> top;
//constructor    
    public Stack(){
        top = null;
    }
//a method that add a node to the end of the stack
    public void push(T data){
        top = new Node(data, top);
    }
//a method that delet and return the data of the last node in the stack
    public T pop(){
        if(!isEmpty()){
            Node <T> temp = top;
            top = top.next;
            return temp.data;
        }
        else return null;
    }
//a method that check if the stack is empty 
    public boolean isEmpty(){
        return top == null;
    }
//a method that return the data of the last node in the stack
    public Node<T> top(){
        return top;
    }
}
