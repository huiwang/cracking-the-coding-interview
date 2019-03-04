package geek.math;

import geek.math.MathLesson10_DynamicProgramming;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathLesson10_DynamicProgrammingTest {

    @Test
    public void getStrDistance() {
        assertEquals(1, MathLesson10_DynamicProgramming.getStrDistance("mouse", "mouuse"));
        assertEquals(0, MathLesson10_DynamicProgramming.getStrDistance("test", "test"));
        assertEquals(1, MathLesson10_DynamicProgramming.getStrDistance("extension", "extention"));
        assertEquals(2, MathLesson10_DynamicProgramming.getStrDistance("paxye", "pamne"));
        assertEquals(-1, MathLesson10_DynamicProgramming.getStrDistance(null, null));
    }

    @Test
    public void getLeastNotes() {
        int[] values = {2, 3, 7};
        assertEquals(-1, MathLesson10_DynamicProgramming.getLeastNotes(null, 1));
        assertEquals(-1, MathLesson10_DynamicProgramming.getLeastNotes(new int[]{}, 7));
        assertEquals(0, MathLesson10_DynamicProgramming.getLeastNotes(values, 1));
        assertEquals(1, MathLesson10_DynamicProgramming.getLeastNotes(values, 2));
        assertEquals(1, MathLesson10_DynamicProgramming.getLeastNotes(values, 3));
        assertEquals(2, MathLesson10_DynamicProgramming.getLeastNotes(values, 6));
        assertEquals(1, MathLesson10_DynamicProgramming.getLeastNotes(values, 7));
        assertEquals(3, MathLesson10_DynamicProgramming.getLeastNotes(values, 8));
        assertEquals(2, MathLesson10_DynamicProgramming.getLeastNotes(values, 9));
        assertEquals(2, MathLesson10_DynamicProgramming.getLeastNotes(values, 10));
    }
}