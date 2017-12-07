package bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class _05_08_DrawLineTest {

    private _05_08_DrawLine s = new _05_08_DrawLine();

    @Test
    public void with1Row8Columns_DrawEntireLine() {
        assertArrayEquals(new byte[]{(byte) 0xff}, s.drawLine(new byte[]{0}, 8, 0, 7, 0));
    }

    @Test
    public void with1Row8Columns_DrawSubLine() {
        assertArrayEquals(new byte[]{(byte) 0x7e}, s.drawLine(new byte[]{0}, 8, 1, 6, 0));
    }

    @Test
    public void with1Row8Columns_DrawSubLine_SomeBitsAlreadySet() {
        assertArrayEquals(new byte[]{(byte) 0xfe}, s.drawLine(new byte[]{(byte) 0x80}, 8, 1, 6, 0));
    }

    @Test
    public void with1Row16Columns() {
        assertArrayEquals(new byte[]{(byte) 0x03, (byte) 0xfc}, s.drawLine(new byte[]{0, 0}, 16, 6, 13, 0));
    }

    @Test
    public void with2Row16Columns() {
        assertArrayEquals(new byte[]{0, 0, (byte) 0x03, (byte) 0xfc}, s.drawLine(new byte[]{0, 0, 0, 0}, 16, 6, 13, 1));
    }
}