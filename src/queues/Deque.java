
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<Item> {
        private Item item;

        private Node<Item> next;
        private Node<Item> prev;

        public Node() {

        }

        public Node(Item item) {
            this.item = item;
        }

        public Item getItem() {
            return item;
        }

        public Node<Item> getNext() {
            return next;
        }

        public void setNext(Node<Item> next) {
            this.next = next;
        }

        public Node<Item> getPrev() {
            return prev;
        }

        public void setPrev(Node<Item> prev) {
            this.prev = prev;
        }
    }

    public Deque() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (isEmpty()) {
            this.first = new Node<Item>(item);
            this.last = this.first;
            size++;
        } else if (this.size == 1) {
            this.first = new Node<Item>(item);
            this.first.setNext(last);
            this.last.setPrev(this.first);
            size++;
        } else {
            Node<Item> oldFirst = this.first;
            this.first = new Node<Item>(item);
            oldFirst.setPrev(this.first);
            first.setNext(oldFirst);
            oldFirst = null;
            size++;
        }
    }

    public void addLast(Item item) {
        if (isEmpty()) {
            this.last = new Node<Item>(item);
            this.first = this.last;
            size++;
        } else if (this.size == 1) {
            this.last = new Node<Item>(item);
            this.last.setPrev(this.first);
            this.first.setNext(this.last);
            size++;
        } else {
            Node<Item> oldLast = this.last;
            this.last = new Node<Item>(item);
            oldLast.setNext(this.last);
            this.last.setPrev(oldLast);
            size++;
        }
    }

    public Item removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = first.getItem();
        this.first = first.getNext();
        size--;
        if (isEmpty()) {
            this.last = null;
        } else {
            this.first.prev = null;
        }
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = last.getItem();
        this.last = last.getPrev();
        size--;
        if (isEmpty()) {
            this.first = null;
        } else {
            this.last.next = null;
        }
        return item;
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        deque.addLast("1");
        deque.addLast("2");
        deque.addLast("3");
        deque.addLast("4");

    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }


    private class DequeIterator implements Iterator<Item> {
        Node<Item> current = first;

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
