package ua.com.foxminded;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Write an application that reverses all the words of input text:
 * E.g. "abcd efgh" => "dcba hgfe"
 * All non-letter symbols should stay on the same places:
 * E.g. "a1bcd efg!h" => "d1cba hgf!e"
 * Use Latin alphabet for test only.
 **/

class MainTest {

    ReversLine reversLine = new ReversLine();


    @Test
    void testRevers() {
        String rev = reversLine.reverseSentance("abcd efgh");
        assertEquals("dcba hgfe", rev);
    }

    @Test
    void testReversWithSymbols() {
        String rev = reversLine.reverseSentance("a1bcd efg!h");
        assertEquals("d1cba hgf!e", rev);
    }

}
