package ru.msvdev.leetcode.topInterview150.array;

/**
 * 135. Candy
 * <p>
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array
 * ratings.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 * <p>
 * Example 1:
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * <p>
 * Example 2:
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 * <p>
 * Constraints:
 * -- n == ratings.length
 * -- 1 <= n <= 2 * 104
 * -- 0 <= ratings[i] <= 2 * 104
 */
public class N135Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;

        int candies = 1;
        int currentMinCandies = 1;

        int leftHigherRatingIdx = 0;
        int leftMaxCandies = 1;

        for (int i = 1; i < n; i++) {
            int leftRating = ratings[i - 1];
            int rightRating = ratings[i];

            if (leftRating < rightRating) {
                currentMinCandies++;
                candies += currentMinCandies;
                leftHigherRatingIdx = i;
                leftMaxCandies = currentMinCandies;

            } else if (leftRating == rightRating) {
                currentMinCandies = 1;
                candies += 1;
                leftHigherRatingIdx = i;
                leftMaxCandies = 1;

            } else {
                currentMinCandies = 1;
                leftMaxCandies--;

                candies += i - leftHigherRatingIdx + (leftMaxCandies > 0 ? 0 : 1);
            }
        }

        return candies;
    }
}
