public class CircularQueue {
    int front;
    int rear;
    int[]queue;
    int SIZE;

    public CircularQueue(int size){
        SIZE = size;
        queue = new int[SIZE];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty(){
        return rear == -1 && front == -1 ;
    }

//    public boolean isFull(){
//        return
//    }

}
