package ru.msvdev.leetcode.topInterview150.hashmap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.msvdev.test.TestUtils;

import java.util.List;
import java.util.stream.Stream;

class N49GroupAnagramsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void groupAnagrams1(String[] strs, List<List<String>> out) {
        // region Given
        var solution = new N49GroupAnagrams();
        // endregion

        // region When
        var answer = solution.groupAnagrams1(strs);
        // endregion

        // region Then
        Assertions.assertTrue(TestUtils.equalsListList(out, answer));
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void groupAnagrams2(String[] strs, List<List<String>> out) {
        // region Given
        var solution = new N49GroupAnagrams();
        // endregion

        // region When
        var answer = solution.groupAnagrams2(strs);
        // endregion

        // region Then
        Assertions.assertTrue(TestUtils.equalsListList(out, answer));
        // endregion
    }


    @ParameterizedTest
    @MethodSource("testData")
    void groupAnagrams3(String[] strs, List<List<String>> out) {
        // region Given
        var solution = new N49GroupAnagrams();
        // endregion

        // region When
        var answer = solution.groupAnagrams3(strs);
        // endregion

        // region Then
        Assertions.assertTrue(TestUtils.equalsListList(out, answer));
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea"))
                ),
                Arguments.of(
                        new String[]{""},
                        List.of(List.of(""))
                ),
                Arguments.of(
                        new String[]{"a"},
                        List.of(List.of("a"))
                )
        );
    }


}