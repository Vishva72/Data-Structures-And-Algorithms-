public class LinkList <T>implements List<T>{

    Node<T>head;
    Node<T>tail;
    static int COUNT;

    public static class Node<T>{
        T data;
        Node<T>next;
        Node(T data){
            this.data = data;
            next = null;
        }

    }

    public LinkList(){
        this.head = null;
        this.tail = null;
    }

    @Override
    public void Insert(T element) {
        Node<T>newNode = new Node<T>(element);
//        inserting first Node
        if(head == null){
            head = tail= newNode;
            COUNT++;

        }
        tail.next = newNode;
        COUNT++;
    }

    @Override
    public T deleteFirst() {
        if(isEmpty()){
            throw new NullPointerException("No node to delete in linklist");
        }
        if(head == tail){
            Node<T>temp = head;
            head=tail = null;
            return temp.data;
        }
        Node<T> temp = head;
        temp.next = null;
        head = head.next;
        return temp.data;
    }

    @Override
    public T deleteLast() {
        if(isEmpty()){
            throw new NullPointerException("No node to delete in linklist");
        }
        if(head == tail){
            Node<T>temp = head;
            head=tail = null;
            return temp.data;
        }
        Node<T>temp=head;
        while(temp.next == tail){
            temp = temp.next;
        }
        tail = temp;
        temp = tail.next;
        tail.next = null;
        return temp.data;

    }

    @Override
    public T deleteAtIndex(int idx) {
        if(idx > COUNT){
            throw new IndexOutOfBoundsException("Index does not exists");
        }
        if(idx == 1){
            deleteFirst();
        }
        if(idx == COUNT){
            deleteLast();
        }
        int i = 1;
        Node<T>curr = head;
        Node<T>previous = null;
        while(i != idx){
            previous = curr;
            curr= curr.next;
            i++;
        }
        previous.next = curr.next;
        curr.next = null;
        return curr.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }


}
