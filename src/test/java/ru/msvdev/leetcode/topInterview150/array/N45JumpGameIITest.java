package ru.msvdev.leetcode.topInterview150.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N45JumpGameIITest {

    @ParameterizedTest
    @MethodSource("jumpTestData")
    void jump1(int[] nums, int output) {
        // region Given
        N45JumpGameII n45JumpGameII = new N45JumpGameII();
        // endregion


        // region When
        int jumps = n45JumpGameII.jump1(nums);
        // endregion


        // region Then
        Assertions.assertEquals(output, jumps);
        // endregion
    }


    @ParameterizedTest
    @MethodSource("jumpTestData")
    void jump2(int[] nums, int output) {
        // region Given
        N45JumpGameII n45JumpGameII = new N45JumpGameII();
        // endregion


        // region When
        int jumps = n45JumpGameII.jump2(nums);
        // endregion


        // region Then
        Assertions.assertEquals(output, jumps);
        // endregion
    }


    private static Stream<Arguments> jumpTestData() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 1, 4}, 2),
                Arguments.of(new int[]{2, 3, 0, 1, 4}, 2),
                Arguments.of(new int[]{4, 3, 0, 1, 4}, 1),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{1, 1, 1, 1}, 3),
                Arguments.of(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}, 2)
        );
    }
}