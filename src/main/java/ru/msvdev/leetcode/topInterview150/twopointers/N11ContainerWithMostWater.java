package ru.msvdev.leetcode.topInterview150.twopointers;

/**
 * 11. Container With Most Water
 * <p>
 * You are given an integer array height of length n. There are n vertical lines drawn such that
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * <p>
 * Constraints:
 * -- n == height.length
 * -- 2 <= n <= 105
 * -- 0 <= height[i] <= 104
 */
public class N11ContainerWithMostWater {

    public int maxArea1(int[] height) {
        int leftIdx = 0;
        int rightIdx = height.length - 1;

        int leftWallHeight = height[leftIdx];
        int rightWallHeight = height[rightIdx];

        int width = rightIdx - leftIdx;
        int maxVolume = width * Math.min(leftWallHeight, rightWallHeight);

        while (width > 0) {
            if (leftWallHeight <= rightWallHeight) {
                leftIdx++;
                leftWallHeight = height[leftIdx];
            } else {
                rightIdx--;
                rightWallHeight = height[rightIdx];
            }

            width--;
            int volume = width * Math.min(leftWallHeight, rightWallHeight);
            if (maxVolume < volume) {
                maxVolume = volume;
            }
        }

        return maxVolume;
    }


    public int maxArea2(int[] height) {
        int leftIdx = 0;
        int rightIdx = height.length - 1;

        int leftWallHeight = height[leftIdx];
        int rightWallHeight = height[rightIdx];

        int width = rightIdx - leftIdx;
        int volume = width * Math.min(leftWallHeight, rightWallHeight);

        while (width > 0) {
            width--;
            if (leftWallHeight <= rightWallHeight) {
                leftIdx++;
                while (leftWallHeight >= height[leftIdx] && width > 0) {
                    width--;
                    leftIdx++;
                }
                leftWallHeight = height[leftIdx];
            } else {
                rightIdx--;
                while (rightWallHeight >= height[rightIdx] && width > 0) {
                    width--;
                    rightIdx--;
                }
                rightWallHeight = height[rightIdx];
            }

            int tmp = width * Math.min(leftWallHeight, rightWallHeight);
            if (volume < tmp) {
                volume = tmp;
            }
        }

        return volume;
    }
}
