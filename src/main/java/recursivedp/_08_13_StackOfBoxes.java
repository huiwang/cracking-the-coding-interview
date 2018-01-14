package recursivedp;

import java.util.Comparator;
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
        boxes.sort(Comparator.comparing(b -> -b.h));
        int[] cache = new int[boxes.size()];
        int max = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int h = doCreateStack(boxes, i, cache);
            max = Math.max(max, h);
        }
        return max;
    }

    private int doCreateStack(List<Box> boxes, int bottom, int[] cache) {
        if (cache[bottom] > 0) return cache[bottom];
        if (bottom == boxes.size()) return 0;
        int max = 0;
        Box current = boxes.get(bottom);
        for (int i = bottom + 1; i < boxes.size(); i++) {
            Box next = boxes.get(i);
            if (next.canPutAbove(current)) {
                int h = doCreateStack(boxes, i, cache);
                max = Math.max(max, h);
            }
        }
        int total = current.h + max;
        cache[bottom] = total;
        return total;
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

        boolean canPutAbove(Box that) {
            return that.h > h && that.w > w && that.d > d;
        }
    }
}
