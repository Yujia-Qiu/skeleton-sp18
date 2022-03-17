public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private final int INITIAL_CAPACITY = 8;


    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int minusOne(int index) {
        return Math.floorMod(index - 1, items.length);
    }

    public int plusOne(int index) {
        return Math.floorMod(index + 1, items.length);
    }

    public int plusOne(int index, int length) {
        return Math.floorMod(index + 1, length);
    }

    public void reSize() {
        if (size == items.length) {
            expend();
        }
        if (size < items.length / 4 && size > 8) {
            reduce();
        }
    }

    public void expend() {
        reSizeHelper(items.length * 2);
    }

    public void reduce() {
        reSizeHelper(items.length / 2);
    }

    private void reSizeHelper(int capacity) {
        T[] tmp = items;
        int begin = plusOne(nextFirst);
        int end = minusOne(nextLast);
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        for (int i = begin; i != end; i = plusOne(i, tmp.length)) {
            items[nextLast] = tmp[i];
            nextLast = plusOne(nextLast);
        }
        items[nextLast] = tmp[end];
        nextLast = plusOne(nextLast);
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item) {
        reSize();
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    public T getFirst() {
        return items[plusOne(nextFirst)];
    }

    public T removeFirst() {
        reSize();
        T res = getFirst();
        nextFirst = plusOne(nextFirst);
        items[nextFirst] = null;
        size--;
        return res;
    }

    public T getLast() {
        return items[minusOne(nextLast)];
    }

    public T removeLast() {
        reSize();
        T res = getLast();
        nextLast = minusOne(nextLast);
        items[nextLast] = null;
        size--;
        return res;
    }

    public void printDeque() {
        for (int i = plusOne((nextFirst)); i != nextLast; i = plusOne((i))) {
            System.out.print(items[i]);
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        index = Math.floorMod(plusOne(nextFirst) + index, items.length);
        return items[index];
    }
}
