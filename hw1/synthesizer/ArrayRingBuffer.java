package synthesizer;
//  Make sure to make this class a part of the synthesizer package;

import java.util.Iterator;

// Make sure to make this class and all of its methods public
// Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        //  Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;

    }

    public int capacity() {
        return this.capacity;
    }

    public int fillCount() {
        return this.fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        //  Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        if (last == capacity - 1) {
            last = 0;
        } else {
            last++;
        }
        fillCount++;

    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        //  Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T res =  rb[first];
        rb[first] = null;
        if (first == capacity - 1) {
            first = 0;
        } else {
            first++;
        }
        fillCount--;
        return res;

    }

    public T peek() {
        //  Return the first item. None of your instance variables should change.
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new ItemIterator();
    }
    private class ItemIterator implements Iterator<T> {
        int ptr;
        int time;

        ItemIterator() {
            ptr = first;
            time = 0;
        }
        public boolean hasNext() {
            if (time < fillCount()) {
                return true;
            }
            return false;
        }
        public T next() {
            T res = rb[ptr];
            if (ptr == capacity - 1) {
                ptr = 0;
            } else {
                ptr++;
            }
            time++;
            return res;
        }
    }


    //  When you get to part 5, implement the needed code to support iteration.
}
