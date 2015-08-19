package queues;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by trierra on 8/17/15.
 */
public class DequeTest {
    Deque<String> deque;

    @BeforeMethod
    public void setUp() throws Exception {
        deque = new Deque<>();
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testSize() throws Exception {
        deque.addFirst("1");
        deque.addFirst("2");
        deque.addFirst("3");
        deque.addFirst("3");
        deque.addFirst("3");
        deque.addFirst("3");
        deque.addFirst("3");
        deque.removeFirst();
        Assert.assertTrue(deque.size() == 6);
    }

    @Test
    public void testAddFirst() throws Exception {
        deque.addFirst("1");
        deque.addFirst("2");
        deque.addFirst("3");
        Assert.assertEquals("3", (deque.removeFirst()));
        Assert.assertEquals("2", (deque.removeFirst()));
        Assert.assertEquals("1", (deque.removeFirst()));
    }

    @Test
    public void testAddLast() throws Exception {
        deque.addLast("1");
        deque.addLast("2");
        deque.addLast("2");
        deque.addLast("3");
        deque.addFirst("8");
        Assert.assertEquals("3", deque.removeLast());
        Assert.assertEquals("8", deque.removeFirst());
        Assert.assertEquals("1", deque.removeFirst());
        Assert.assertFalse("1".equals(deque.removeFirst()));
    }

    @Test
    public void testRemoveFirst() throws Exception {

    }

    @Test
    public void testRemoveLast() throws Exception {

    }

    @Test
    public void testMain() throws Exception {

    }

    @Test
    public void testIterator() throws Exception {

    }

    @Test
    public void testForEach() throws Exception {

    }

    @Test
    public void testSpliterator() throws Exception {

    }
}