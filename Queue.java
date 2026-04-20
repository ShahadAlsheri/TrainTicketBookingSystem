public class Queue <T> {
//data feild
    private Node<T> front;
    private Node<T> rear;
//constructor    
    public Queue(){
        front = null;
        rear = null;
    }
//a method that add a node to the end of the queue
    public void enqueue(T data){
        if(front == null){
            front = new Node(data,front);
            rear = front;
        }
        else{
            rear.next= new Node(data, rear.next);
            rear = rear.next;
        }
    }
//a method that delet and return the data of the first node in the queue
    public T dequeue(){
        if(!isEmpty()){
            T data = front.data;
            if(front.next == null){
                front = front.next;
                rear = rear.next;
            }
            else front = front.next;
            return data;
        }
        else return null;
    }
// a method that check if the queue is empty 
    public boolean isEmpty(){
        return front==null;
    }
// a method that return the first node in the queue
    public Node<T> peak(){
        return front;
    }
// a method that return the last node in the queue
    public Node<T> rear(){
        return rear;
    }
}
