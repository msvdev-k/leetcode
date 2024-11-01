package ru.msvdev.leetcode.topInterview150.intervals;

import java.util.Arrays;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * <p>
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes
 * a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact
 * y-coordinates of the balloons.
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along
 * the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend.
 * There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely,
 * bursting any balloons in its path.
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 * <p>
 * Example 1:
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 * <p>
 * Example 2:
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
 * <p>
 * Example 3:
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
 * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 * <p>
 * Constraints:
 * -- 1 <= points.length <= 10^5
 * -- points[i].length == 2
 * -- -2^31 <= xstart < xend <= 2^31 - 1
 */
public class N452MinimumNumberOfArrowsToBurstBalloons {

    private static final int START = 0;
    private static final int END = 1;

    public int findMinArrowShots1(int[][] points) {
        final int n = points.length;
        if (n == 1) return 1;

        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[START], p2[START]));

        int arrows = 1;
        int xEnd = points[0][END];
        for (int i = 1; i < n; i++) {
            final int[] nextDiameter = points[i];
            if (xEnd < nextDiameter[START]) {
                xEnd = nextDiameter[END];
                arrows++;
            } else {
                xEnd = Math.min(xEnd, nextDiameter[END]);
            }
        }

        return arrows;
    }

    public int findMinArrowShots2(int[][] points) {
        final int n = points.length;
        if (n == 1) return 1;

        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[END], p2[END]));

        int arrows = 1;
        int xEnd = points[0][END];
        for (int i = 1; i < n; i++) {
            final int[] nextDiameter = points[i];
            if (xEnd < nextDiameter[START]) {
                xEnd = nextDiameter[END];
                arrows++;
            }
        }

        return arrows;
    }
}
