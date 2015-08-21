package queues;

import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

    Item[] a;
    int N;

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < max; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    // construct an empty randomized queue
    public RandomizedQueue() {
        a = (Item[]) new Object[10];
        N = 0;
    }

    // is the queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the queue
    public int size() {
        return N;
    }

    // add the item
    public void enqueue(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        Random random = new Random();
        int randElem = random.nextInt(N);

        Item temp = a[randElem];
        a[randElem] = a[--N];
        a[N] = null;

        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return temp;
    }

    // return (but do not remove) a random item
    public Item sample() {
        Random random = new Random();
        int randElem = random.nextInt(a.length);
        return a[randElem];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int i;

        public RandomizedQueueIterator() {
            this.i = N;
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }

    // unit testing
    public static void main(String[] args) {

    }
}