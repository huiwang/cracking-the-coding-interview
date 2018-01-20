package recursivedp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _08_14_BooleanEvaluationTest {

    private _08_14_BooleanEvaluation s = new _08_14_BooleanEvaluation();


    @Test
    public void withEmptyExpression() {
        assertEquals(0, s.evaluate("", true));
        assertEquals(0, s.evaluate("", false));
    }

    @Test
    public void withOneValue() {
        assertEquals(0, s.evaluate("1", false));
        assertEquals(1, s.evaluate("1", true));
        assertEquals(0, s.evaluate("0", true));
        assertEquals(1, s.evaluate("0", false));
    }


    @Test
    public void withOneOperator() {
        assertEquals(1, s.evaluate("1&1", true));
        assertEquals(0, s.evaluate("1&0", true));
        assertEquals(0, s.evaluate("0&1", true));
        assertEquals(0, s.evaluate("0&0", true));

        assertEquals(0, s.evaluate("1&1", false));
        assertEquals(1, s.evaluate("1&0", false));
        assertEquals(1, s.evaluate("0&1", false));
        assertEquals(1, s.evaluate("0&0", false));

        assertEquals(1, s.evaluate("1|1", true));
        assertEquals(1, s.evaluate("1|0", true));
        assertEquals(1, s.evaluate("0|1", true));
        assertEquals(0, s.evaluate("0|0", true));

        assertEquals(0, s.evaluate("1|1", false));
        assertEquals(0, s.evaluate("1|0", false));
        assertEquals(0, s.evaluate("0|1", false));
        assertEquals(1, s.evaluate("0|0", false));

        assertEquals(0, s.evaluate("1^1", true));
        assertEquals(1, s.evaluate("0^1", true));
        assertEquals(1, s.evaluate("1^0", true));
        assertEquals(0, s.evaluate("0^0", true));

        assertEquals(1, s.evaluate("1^1", false));
        assertEquals(0, s.evaluate("0^1", false));
        assertEquals(0, s.evaluate("1^0", false));
        assertEquals(1, s.evaluate("0^0", false));
    }

    @Test
    public void withMultipleOperators() {
        assertEquals(2, s.evaluate("0|0|1", true));
    }

    @Test
    public void withMoreOperators() {
        assertEquals(2, s.evaluate("1^0|0|1", false));
    }

    @Test
    public void withMoreMoreOperators() {
        assertEquals(10, s.evaluate("0&0&0&1^1|0", true));
    }
}