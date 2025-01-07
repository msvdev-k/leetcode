package ru.msvdev.tcode.exam202411;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task06Test {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setSetUpStreams() {
        System.setOut(new PrintStream(output));
    }


    @AfterEach
    void clearUpStreams() {
        System.setIn(null);
        System.setOut(null);
    }


    @ParameterizedTest
    @MethodSource("testData")
    void mainTest(String input, String out) {
        // region Given
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);
        // endregion

        // region When
        Task06.main(null);
        // endregion

        // region Then
        assertEquals(out, output.toString().trim());
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        """
                                5
                                10 2 3 5
                                5 4
                                0
                                4
                                15 3
                                """,
                        "25"
                ),
                Arguments.of(
                        """
                                6
                                2 2
                                2 3
                                15 4
                                1 5
                                2 6
                                0
                                """,
                        "22"
                )
        );
    }
}