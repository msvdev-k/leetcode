package ru.msvdev.leetcode.topInterview150.binarysearch;

/**
 * 4. Median of Two Sorted Arrays
 * <p>
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * Constraints:
 * -- nums1.length == m
 * -- nums2.length == n
 * -- 0 <= m <= 1000
 * -- 0 <= n <= 1000
 * -- 1 <= m + n <= 2000
 * -- -1e6 <= nums1[i], nums2[i] <= 1e6
 */
public class N4MedianOfTwoSortedArrays {

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        // Sort: m <= n
        final int[] M, N;
        if (nums1.length > nums2.length) {
            M = nums2;
            N = nums1;
        } else {
            M = nums1;
            N = nums2;
        }

        final int m = M.length;
        final int n = N.length;
        final int halfCount = (m + n + 1) >>> 1;

        int minCountFromM = 0;
        int maxCountFromM = m;

        while (minCountFromM <= maxCountFromM) {
            int countFromM = (minCountFromM + maxCountFromM) >>> 1;
            int countFromN = halfCount - countFromM;

            int lM = (countFromM == 0) ? Integer.MIN_VALUE : M[countFromM - 1];
            int rM = (countFromM == m) ? Integer.MAX_VALUE : M[countFromM];

            int lN = (countFromN == 0) ? Integer.MIN_VALUE : N[countFromN - 1];
            int rN = (countFromN == n) ? Integer.MAX_VALUE : N[countFromN];

            if (lM <= rN && lN <= rM) {
                if ((n + m) % 2 == 0) {
                    double median = (lM > lN) ? lM : lN;
                    median += (rM < rN) ? rM : rN;
                    return median / 2.0;

                } else {
                    return (lM > lN) ? lM : lN;
                }
            }

            if (lM > rN) {
                maxCountFromM = countFromM - 1;

            } else {
                minCountFromM = countFromM + 1;
            }
        }

        return Double.MIN_VALUE;
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // Sort: m <= n
        final int[] M, N;
        if (nums1.length > nums2.length) {
            M = nums2;
            N = nums1;
        } else {
            M = nums1;
            N = nums2;
        }

        final int m = M.length;
        final int n = N.length;
        final int halfCount = (m + n + 1) >>> 1;

        int minCountFromM = 0;
        int maxCountFromM = m;

        while (minCountFromM <= maxCountFromM) {
            int countFromM = (minCountFromM + maxCountFromM) >>> 1;
            int countFromN = halfCount - countFromM;

            int lM = (countFromM == 0) ? Integer.MIN_VALUE : M[countFromM - 1];
            int rM = (countFromM == m) ? Integer.MAX_VALUE : M[countFromM];

            int lN = (countFromN == 0) ? Integer.MIN_VALUE : N[countFromN - 1];
            int rN = (countFromN == n) ? Integer.MAX_VALUE : N[countFromN];

            if (lM <= rN && lN <= rM) {
                return ((n + m) % 2 == 0) ?
                        (Math.max(lM, lN) + Math.min(rM, rN)) / 2.0 :
                        Math.max(lM, lN);
            }

            if (lM > rN) {
                maxCountFromM = countFromM - 1;

            } else {
                minCountFromM = countFromM + 1;
            }
        }

        return Double.MIN_VALUE;
    }
}

