package ru.msvdev.leetcode.topInterview150.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. Insert Interval
 * <p>
 * You are given an array of non-overlapping intervals where intervals[i] = [starti, endi] represent
 * the start and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another
 * interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
 * and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 * <p>
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * <p>
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * Constraints:
 * -- 0 <= intervals.length <= 10^4
 * -- intervals[i].length == 2
 * -- 0 <= starti <= endi <= 10^5
 * -- intervals is sorted by starti in ascending order.
 * -- newInterval.length == 2
 * -- 0 <= start <= end <= 10^5
 */
public class N57InsertInterval {
    private static final int START = 0;
    private static final int END = 1;

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        final int n = intervals.length;
        if (n == 0) return new int[][]{newInterval};

        int startIdx = Arrays.binarySearch(intervals, newInterval, (x, y) -> Integer.compare(x[START], y[START]));
        int prefixCount = (startIdx < 0) ? -startIdx - 1 : startIdx;
        if (prefixCount > 0 && intervals[prefixCount - 1][END] >= newInterval[START]) {
            prefixCount--;
        }

        int endIdx = Arrays.binarySearch(intervals, newInterval, (x, y) -> Integer.compare(x[END], y[END]));
        int postfixCount = (endIdx < -n) ? 0 : (endIdx < 0) ? n + endIdx : n - endIdx - 1;
        if (postfixCount <= n - 1 && intervals[n - 1 - postfixCount][START] > newInterval[END]) {
            postfixCount++;
        }

        int[][] newIntervals = new int[prefixCount + postfixCount + 1][];

        if (prefixCount == n) {
            newIntervals[prefixCount] = newInterval;

        } else if (postfixCount == n) {
            newIntervals[0] = newInterval;

        } else {
            newIntervals[prefixCount] = new int[]{
                    Math.min(intervals[prefixCount][START], newInterval[START]),
                    Math.max(intervals[n - 1 - postfixCount][END], newInterval[END])
            };
        }

        if (prefixCount > 0) {
            System.arraycopy(intervals, 0,
                    newIntervals, 0,
                    prefixCount);
        }
        if (postfixCount > 0) {
            System.arraycopy(intervals, n - postfixCount,
                    newIntervals, prefixCount + 1,
                    postfixCount);
        }

        return newIntervals;
    }


    public int[][] insert2(int[][] intervals, int[] newInterval) {
        final int n = intervals.length;
        if (n == 0) return new int[][]{newInterval};

        final List<int[]> newIntervals = new ArrayList<>();

        int i = 0;
        while (i < n && intervals[i][END] < newInterval[START]) {
            newIntervals.add(intervals[i]);
            i++;
        }

        if (i == n) {
            newIntervals.add(newInterval);
            return newIntervals.toArray(new int[0][]);
        }

        newInterval[START] = Math.min(newInterval[START], intervals[i][START]);
        while (i < n && intervals[i][START] <= newInterval[END]) {
            newInterval[END] = Math.max(newInterval[END], intervals[i][END]);
            i++;
        }

        newIntervals.add(newInterval);

        while (i < intervals.length) {
            newIntervals.add(intervals[i]);
            i++;
        }

        return newIntervals.toArray(new int[0][]);
    }
}
