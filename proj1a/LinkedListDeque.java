
public class LinkedListDeque<T> {

    public class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(T x, Node p, Node n) {
            item = x;
            prev = p;
            next = n;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel =  new Node((T)"null", null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel = new Node((T)"null", null, null);
        sentinel.next = new Node(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;

    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }else{
            return false;
        }
    }

    public void printDeque() {
        Node p = sentinel;
        while(p.next != sentinel) {
            p = p.next;
            System.out.println(p.item);
            System.out.println(" ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if(size == 0) {
            return null;
        }
        T c = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return c;
    }

    public T removeLast() {
        if(size == 0) {
            return null;
        }
        T c = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel. prev = sentinel.prev.prev;
        size--;
        return c;
    }

    public T get(int index) {
        int count = 0;
        Node p = sentinel;
        while(p.next != sentinel) {
            p = p.next;
            if(count == index) {
                return p.item;
            }
            count++;
        }
        return null;
    }

    public T getRecursive(int index) {
        if(index >= size || index < 0) {
            return null;
        }
        int count = 0;
        Node p = sentinel.next;
        return getRecursiveHelper(index, count, p);
    }

    public T getRecursiveHelper(int index, int count, Node p) {
        if(count == index) {
            return p.item;
        }
        return getRecursiveHelper(index, count+1, p.next);
    }

}