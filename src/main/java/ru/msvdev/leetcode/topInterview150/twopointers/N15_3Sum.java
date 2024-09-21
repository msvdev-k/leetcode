package ru.msvdev.leetcode.topInterview150.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * <p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
 * and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * <p>
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * <p>
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * <p>
 * Constraints:
 * -- 3 <= nums.length <= 3000
 * -- -105 <= nums[i] <= 105
 */
public class N15_3Sum {

    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);

        final List<List<Integer>> triplets = new ArrayList<>();
        final int n = nums.length;

        int oldN1 = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int n1 = nums[i];
            if (n1 == oldN1) {
                continue;
            } else if (n1 > 0) {
                break;
            }
            oldN1 = n1;

            int j = i + 1;
            int k = n - 1;
            int n2 = nums[j];
            int n3 = nums[k];

            while (j < k) {
                int sum = n1 + n2 + n3;
                if (sum < 0) {
                    do {
                        j++;
                    } while (nums[j] == n2 && j < k);
                    n2 = nums[j];

                } else if (sum > 0) {
                    do {
                        k--;
                    } while (nums[k] == n3 && j < k);
                    n3 = nums[k];

                } else {
                    triplets.add(List.of(n1, n2, n3));
                    do {
                        j++;
                    } while (nums[j] == n2 && j < k);
                    n2 = nums[j];
                    do {
                        k--;
                    } while (nums[k] == n3 && j < k);
                    n3 = nums[k];
                }
            }
        }

        return triplets;
    }


    private record Pair(int n1, int n2) {
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        final List<List<Integer>> triplets = new ArrayList<>();
        final List<Pair> cash = new ArrayList<>();
        final int n = nums.length;

        if (n == 3) {
            if (Arrays.stream(nums).sum() == 0) {
                triplets.add(List.of(nums[0], nums[1], nums[2]));
            }
            return triplets;
        }

        Arrays.sort(nums);

        int oldN1 = Integer.MIN_VALUE;
        int oldN2 = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;

            int n1 = nums[i];
            int n2 = nums[j];
            if (n1 == oldN1 && n2 == oldN2) {
                continue;
            } else if (n1 > 0) {
                break;
            }
            if (n1 != oldN1) {
                cash.clear();
            }
            oldN1 = n1;
            oldN2 = n2;

            int k = n - 1;
            int n3 = nums[k];


            while (j < k) {
                int sum = n1 + n2 + n3;
                if (sum < 0) {
                    do {
                        j++;
                    } while (nums[j] == n2 && j < k);
                    n2 = nums[j];

                } else if (sum > 0) {
                    do {
                        k--;
                    } while (nums[k] == n3 && j < k);
                    n3 = nums[k];

                } else {
                    Pair pair = new Pair(n1, n2);
                    if (!cash.contains(pair)) {
                        cash.add(pair);
                        triplets.add(List.of(n1, n2, n3));
                    }
                    do {
                        j++;
                    } while (nums[j] == n2 && j < k);
                    n2 = nums[j];
                    do {
                        k--;
                    } while (nums[k] == n3 && j < k);
                    n3 = nums[k];
                }
            }
        }

        return triplets;
    }


    public List<List<Integer>> threeSum1(int[] nums) {
        final List<List<Integer>> triplets = new ArrayList<>();
        final int n = nums.length;

        if (n == 3) {
            if (Arrays.stream(nums).sum() == 0) {
                triplets.add(List.of(nums[0], nums[1], nums[2]));
            }
            return triplets;
        }

        Arrays.sort(nums);

        int oldN1 = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int n1 = nums[i];
            if (n1 == oldN1) {
                continue;
            } else if (n1 > 0) {
                break;
            }
            oldN1 = n1;

            int oldN2 = Integer.MIN_VALUE;
            for (int j = i + 1; j < n - 1; j++) {
                int n2 = nums[j];
                if (n2 == oldN2) {
                    continue;
                } else if (n1 + n2 > 0) {
                    break;
                }
                oldN2 = n2;

                List<Integer> triplet = binarySearchTriplet(nums, n1, n2, j + 1, n);
                if (triplet != null) {
                    triplets.add(triplet);
                }
            }

        }

        return triplets;
    }

    private List<Integer> binarySearchTriplet(int[] nums, int n1, int n2, int leftIdx, int rightIdx) {
        int idx = (leftIdx + rightIdx) / 2;
        int n3 = nums[idx];
        int sum12 = n1 + n2;
        int sum123 = sum12 + n3;

        while (sum123 != 0 && leftIdx < rightIdx && leftIdx != idx) {
            if (sum123 < 0) {
                leftIdx = idx;
            } else {
                rightIdx = idx;
            }
            idx = (leftIdx + rightIdx) / 2;
            n3 = nums[idx];
            sum123 = sum12 + n3;
        }

        return (sum123 == 0) ? List.of(n1, n2, n3) : null;
    }

}
