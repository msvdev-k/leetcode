package ru.msvdev.leetcode.topInterview150.intervals;

import java.util.Arrays;

/**
 * 56. Merge Intervals
 * <p>
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * <p>
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * <p>
 * Constraints:
 * -- 1 <= intervals.length <= 10^4
 * -- intervals[i].length == 2
 * -- 0 <= starti <= endi <= 10^4
 */
public class N56MergeIntervals {

    private static final int START = 0;
    private static final int END = 1;

    public int[][] merge(int[][] intervals) {
        final int n = intervals.length;
        if (n == 1) return intervals;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[START], i2[START]));

        int lastIntervalIdx = 0;
        int[] lastInterval = intervals[lastIntervalIdx];
        for (int i = 1; i < n; i++) {
            final int[] nextInterval = intervals[i];
            if (lastInterval[END] >= nextInterval[START]) {
                if (lastInterval[END] < nextInterval[END]) {
                    lastInterval[END] = nextInterval[END];
                }
            } else {
                lastIntervalIdx++;
                intervals[lastIntervalIdx] = nextInterval;
                lastInterval = nextInterval;
            }
        }

        return Arrays.copyOf(intervals, lastIntervalIdx + 1);
    }
}
