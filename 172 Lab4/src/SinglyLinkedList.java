public class SinglyLinkedList<T> {
    enum Type{
        DNA,RNA,Null;
    }
    public Type stringToType(String s) {
        if(s.equals("DNA")) {
            return Type.DNA;
        }
        else if(s.equals("RNA")) {
            return Type.RNA;
        }
        else {
            return Type.Null;
        }
    }

    public String typeToString(Type type) {
        if(type.equals(Type.DNA)) {
            return "DNA";
        }
        else if(type.equals(Type.RNA)) {
            return "RNA";
        }
        else {
            return "Null";
        }
    }

    //Implement a node
    private static class Node<T>{
        private T element;
        private Node<T> next;
        public Node(T element, Node<T> next) {
            this.element=element;
            this.next=next;
        }
        public T getElement() {
            return element;
        }
        public Node<T> getNext(){
            return next;
        }
        public void setNext(Node<T> next) {
            this.next=next;
        }
    }
    // List implementation
    private Node<T> head=null;
    private Node<T> tail=null;
    private int size=0;
    private Type type;
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type=type;
    }
    public SinglyLinkedList() {

    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size==0;
    }
    public T first() {
        if(isEmpty()) {
            return null;
        }
        return head.getElement();
    }
    public T last() {
        if(isEmpty()) {
            return null;
        }
        return tail.getElement();
    }
    public void addFirst(T e) {
        head=new Node<T>(e,head);
        if(size==0) {
            tail=head;
        }
        size++;
    }
    public void addLast(T e) {
        Node<T> newNode=new Node<>(e,null);
        if(isEmpty()) {
            head=newNode;
        }else {
            tail.setNext(newNode);
        }
        tail=newNode;
        size++;
    }
    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }
        T answer=head.getElement();
        head=head.getNext();
        size--;
        if(size==0) {
            tail=null;
        }
        return answer;
    }
    public String toString() {
        StringBuilder a=new StringBuilder();
        Node<T> b=head;
        for(int i=0;i<size;i++) {
            a.append(b.getElement());
            b=b.getNext();
        }
        return a.toString();
    }
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

    }
}