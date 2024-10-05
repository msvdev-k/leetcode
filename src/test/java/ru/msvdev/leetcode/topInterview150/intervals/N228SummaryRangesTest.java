package ru.msvdev.leetcode.topInterview150.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.msvdev.test.TestUtils;

import java.util.List;
import java.util.stream.Stream;

class N228SummaryRangesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void summaryRanges(int[] nums, List<String> out) {
        // region Given
        var solution = new N228SummaryRanges();
        // endregion

        // region When
        var answer = solution.summaryRanges(nums);
        // endregion

        // region Then
        System.out.println(answer);
        Assertions.assertTrue(TestUtils.equalsList(out, answer));
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 2, 4, 5, 7}, List.of("0->2", "4->5", "7")),
                Arguments.of(new int[]{0, 2, 3, 4, 6, 8, 9}, List.of("0", "2->4", "6", "8->9")),
                Arguments.of(new int[]{1}, List.of("1")),
                Arguments.of(new int[]{}, List.of()),
                Arguments.of(new int[]{-2147483648,-2147483647,2147483647}, List.of("-2147483648->-2147483647","2147483647"))
        );
    }
}