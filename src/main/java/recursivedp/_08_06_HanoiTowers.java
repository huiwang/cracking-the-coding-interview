package recursivedp;

import java.util.ArrayList;
import java.util.List;

/**
 * In the classic problem of the towers of Hanoi,
 * you have 3 towers and N disks of different sizes which can slide onto any tower.
 * The puzzle starts with disks sorted in ascending order of size from top to bottom
 * (i.e., each disk sits on top of an even larger one).
 * You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto another tower.
 * (3) A disk cannot be placed on top of a smaller disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 */
class _08_06_HanoiTowers {

    private static final int LEFT = 1; // id(left) = 1
    private static final int RIGHT = 3; // id(right) = 3
    private static final int SUM = 6; // id(center) = 2

    List<Integer> leftToRight(int n) {
        return move(n, LEFT, RIGHT);
    }

    private List<Integer> move(int n, int from, int to) {
        if (n == 1) {
            List<Integer> moves = new ArrayList<>();
            moves.add(from);
            moves.add(to);
            return moves;
        }
        int buffer = SUM - from - to;
        List<Integer> moves = move(n - 1, from, buffer);
        moves.add(from);
        moves.add(to);
        moves.addAll(move(n - 1, buffer, to));
        return moves;
    }
}
