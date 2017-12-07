package bitmanipulation;

/**
 * A monochrome screen is stored as a single array of bytes, allowing eight consecutive pixels to be stored in one byte.
 * <p>
 * The screen has width w, where w is divisible by 8 (that is, no byte will be split across rows).
 * The height of the screen, of course, can be derived from the length of the array and the width.
 * <p>
 * Implement a function that draws a horizontal line from (x1, y) to ( x2, y).
 * <p>
 * for example, if screen has a width 16 and a height 2. | encoded as 0 and - as 1
 * | | | | | | | | | | | | | | | |
 * | | | | | | | | | | | | | | | |
 * <p>
 * drawing a line from (2, 1) to (13, 1) gives the following result
 * | | | | | | | | | | | | | | | |
 * | | - - - - - - - - - - - - | |
 */
class _05_08_DrawLine {
    byte[] drawLine(byte[] screen, int width, int x1, int x2, int y) {
        throw new UnsupportedOperationException();
    }
}
