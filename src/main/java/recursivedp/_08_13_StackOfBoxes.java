package recursivedp;

import java.util.List;

/**
 * You have a stack of n boxes, with widths wi, heights hi, and depths di.
 * The boxes cannot be rotated and can only be stacked on top of one another
 * if each box in the stack is strictly larger than the box above it
 * in width, height, and depth.
 * <p>
 * Implement a method to compute the height of the tallest possible stack.
 * The height of a stack is the sum of the heights of each box.
 */
public class _08_13_StackOfBoxes {

    int createStack(List<Box> boxes) {
        throw new UnsupportedOperationException();
    }


    static class Box {
        int w;
        int h;
        int d;

        Box(int w, int h, int d) {
            this.w = w;
            this.h = h;
            this.d = d;
        }
    }
}
