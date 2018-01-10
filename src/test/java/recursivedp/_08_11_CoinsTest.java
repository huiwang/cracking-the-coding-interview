package recursivedp;

import org.junit.Assert;
import org.junit.Test;

public class _08_11_CoinsTest {

    private final _08_11_Coins s = new _08_11_Coins();

    @Test
    public void withZeroCent() {
        Assert.assertEquals(1, s.makeChangeWithQuarterDimeNickelPenny(0));
    }

    @Test
    public void withOneCent() {
        Assert.assertEquals(1, s.makeChangeWithQuarterDimeNickelPenny(2));
    }

    @Test
    public void withTwoCents() {
        Assert.assertEquals(1, s.makeChangeWithQuarterDimeNickelPenny(3));
    }

    @Test
    public void with25Cents() {
        //25
        //10 10 5
        //10 10 1 1 1 1 1
        //10 5 5 5
        //10 5 5 1 1 1 1 1
        //10 5 1 1 1 1 1 1 1 1 1 1
        //10 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
        //5 5 5 5 5
        //5 5 5 5 1 1 1 1 1
        //5 5 5 1 1 1 1 1 1 1 1 1 1
        //5 5 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
        //5 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
        //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
        Assert.assertEquals(13, s.makeChangeWithQuarterDimeNickelPenny(25));
    }

    @Test
    public void with100Cents() {
        Assert.assertEquals(242, s.makeChangeWithQuarterDimeNickelPenny(100));
    }

}