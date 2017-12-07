package linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class _02_01_RemoveDupsTest {

    private _02_01_RemoveDups s = new _02_01_RemoveDups();

    @Test
    public void withEmptyList() {
        Assert.assertEquals(LinkedListNode.empty(), s.removeDups(LinkedListNode.empty()));
    }

    @Test
    public void withUniqueList() {
        Assert.assertEquals(LinkedListNode.of(1, 2, 3, 4), s.removeDups(LinkedListNode.of(1, 2, 3, 4)));
    }

    @Test
    public void withDuplications() {
        Assert.assertEquals(LinkedListNode.of(1, 2, 3, 4), s.removeDups(LinkedListNode.of(1, 2, 2, 3, 2, 4)));
    }

}