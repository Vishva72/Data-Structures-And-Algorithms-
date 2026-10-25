public interface List <T>{
    void Insert(T element);
    T deleteFirst();
    T deleteLast();
    T deleteAtIndex(int index);
    boolean isEmpty();
}
