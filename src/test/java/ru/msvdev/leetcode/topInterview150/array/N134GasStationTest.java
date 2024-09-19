package ru.msvdev.leetcode.topInterview150.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N134GasStationTest {

    @ParameterizedTest
    @MethodSource("canCompleteCircuitTestData")
    void canCompleteCircuit1(int[] gas, int[] cost, int output) {
        // region Given
        N134GasStation solution = new N134GasStation();
        // endregion


        // region When
        int integer = solution.canCompleteCircuit1(gas, cost);
        // endregion


        // region Then
        assertEquals(output, integer);
        // endregion
    }


    @ParameterizedTest
    @MethodSource("canCompleteCircuitTestData")
    void canCompleteCircuit2(int[] gas, int[] cost, int output) {
        // region Given
        N134GasStation solution = new N134GasStation();
        // endregion


        // region When
        int integer = solution.canCompleteCircuit2(gas, cost);
        // endregion


        // region Then
        assertEquals(output, integer);
        // endregion
    }


    private static Stream<Arguments> canCompleteCircuitTestData() {
        int n = 100_000;

        int[] gas1 = new int[n];
        Arrays.fill(gas1, 0, n, 0);
        gas1[99_999] = 2;

        int[] cost1 = new int[n];
        Arrays.fill(cost1, 0, n, 0);
        cost1[99_998] = 1;


        int[] gas2 = new int[n];
        Arrays.fill(gas2, 0, n, 1);

        int[] cost2 = new int[n];
        Arrays.fill(cost2, 0, n, 1);
        cost2[50_000] = 2;


        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3),
                Arguments.of(new int[]{2, 3, 4}, new int[]{3, 4, 3}, -1),
                Arguments.of(new int[]{2}, new int[]{2}, 0),
                Arguments.of(new int[]{4}, new int[]{5}, -1),
                Arguments.of(gas1, cost1, 99_999),
                Arguments.of(gas2, cost2, -1)
        );
    }
}