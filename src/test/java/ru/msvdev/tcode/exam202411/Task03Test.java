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

class Task03Test {

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
        Task03.main(null);
        // endregion

        // region Then
        assertEquals(out, output.toString().trim());
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        """
                                abacabaee
                                abc
                                4
                                """,
                        "caba"
                ),
                Arguments.of(
                        """
                                abacecbaee
                                abc
                                4
                                """,
                        "abac"
                ),
                Arguments.of(
                        """
                                abd
                                abc
                                3
                                """,
                        "-1"
                ),
                Arguments.of(
                        """
                                lfkjndhuypldxtabd
                                abc
                                5
                                """,
                        "-1"
                ),
                Arguments.of(
                        """
                                lfkjndhuypldxtabd
                                abl
                                6
                                """,
                        "-1"
                ),
                Arguments.of(
                        """
                                lfkjndhuypldxtabf
                                abdlxt
                                7
                                """,
                        "ldxtab"
                )
        );
    }
}