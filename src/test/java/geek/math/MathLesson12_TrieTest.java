package geek.math;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathLesson12_TrieTest {
    MathLesson12_Trie trie = new MathLesson12_Trie();

    @Before
    public void setUp() throws Exception {
        trie.put("test", "this is a test");
        trie.put("taste", "the favour you got with your tone");
        trie.put("try", "give it a try");
        trie.put("trie", "it is pronounced as tree");
        trie.put("a", "one");
        trie.put("zebra", "a kind of horse with stripe");
        trie.put("tester", "the person does the test");
        trie.put("banana", "a kind of fruit");
        trie.put("church", "a place");
        trie.put("drive", "go forward by riding on something");
        trie.put("driver", "the person drives");
        trie.put("synchronisation", "sync");
        trie.put("atmosphericsurveillance", "atmospheric surveillance");
        System.out.println(trie.toString());
        System.out.println(trie.bfsTraverse().toString());
    }

    @Test
    public void put() {
        trie.put("my", "another form of me describing the belonging");
        assertNotNull(trie.find("my"));
    }

    @Test
    public void find() {
        assertNotNull(trie.find("trie"));
    }
}