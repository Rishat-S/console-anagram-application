package ua.com.foxminded.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramProviderTest {

    AnagramProvider anagramProvider = new AnagramProvider();

    @Test
    void providerAnagramIfSentanceIsNullThrowException() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            anagramProvider.provideAnagram(null);
        });

        String expectedMessage = "Sentence is null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void providerAnagramIfEmptySentanceThrowException() {
        String emptySentance = "\n";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            anagramProvider.provideAnagram(emptySentance);
        });

        String expectedMessage = "Sentence is empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void provideAnagramIfSentanceConsistsOfOneWordWithoutSymbols() {
        String actualAnagram = anagramProvider.provideAnagram("efgh");
        String expectedAnagram = "hgfe";

        assertEquals(expectedAnagram, actualAnagram);
    }

    @Test
    void provideAnagramIfSentanceConsistsOfTwoWordsWithoutSymbols() {
        String actualAnagram = anagramProvider.provideAnagram("abcd efgh");
        String expectedAnagram = "dcba hgfe";

        assertEquals(expectedAnagram, actualAnagram);
    }

    @Test
    void provideAnagramIfSentanceConsistsOfOneWordWithSymbols() {
        String actualAnagram = anagramProvider.provideAnagram("efg!h");
        String expectedAnagram = "hgf!e";

        assertEquals(expectedAnagram, actualAnagram);
    }

    @Test
    void provideAnagramIfSentanceConsistsOfTwoWordsWithSymbols() {
        String actualAnagram = anagramProvider.provideAnagram("a1bcd efg!h");
        String expectedAnagram = "d1cba hgf!e";

        assertEquals(expectedAnagram, actualAnagram);
    }

}
