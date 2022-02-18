package ua.com.foxminded.anagram;

public class AnagramProvider {

    public static final String SPASE_DELIMITER = " ";

    public String provideAnagram(String sentence) {
        validateSentence(sentence);

        String[] words = sentence.split(SPASE_DELIMITER);
        String[] reversedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reversedWord(words[i]);
        }
        return concat(reversedWords);
    }

    private String concat(String[] reversedWords) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < reversedWords.length; i++) {
            result.append(reversedWords[i]);
            if (i != reversedWords.length - 1) {
                result.append(SPASE_DELIMITER);
            }
        }
        return result.toString();
    }

    private void validateSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Sentence is null");
        }
        if (sentence.equals("\n")) {
            throw new IllegalArgumentException("Sentence is empty");
        }
    }

    private static String reversedWord(String word) {
        char[] wordAsACharacterSet = word.toCharArray();
        int indexOffsetToTheRight = 0;
        int indexOffsetToTheLeft = word.length() - 1;

        while (indexOffsetToTheRight <= indexOffsetToTheLeft) {
            if (!Character.isLetter(wordAsACharacterSet[indexOffsetToTheRight])) {
                indexOffsetToTheRight++;
                continue;
            }
            if (!Character.isLetter(wordAsACharacterSet[indexOffsetToTheLeft])) {
                indexOffsetToTheLeft--;
                continue;
            }

            swapCharacters(wordAsACharacterSet, indexOffsetToTheRight, indexOffsetToTheLeft);

            indexOffsetToTheRight++;
            indexOffsetToTheLeft--;
        }

        return String.valueOf(wordAsACharacterSet);
    }

    private static void swapCharacters(char[] charsArray, int indexOffsetToTheRight, int indexOffsetToTheLeft) {
        char tmp = charsArray[indexOffsetToTheLeft];
        charsArray[indexOffsetToTheLeft] = charsArray[indexOffsetToTheRight];
        charsArray[indexOffsetToTheRight] = tmp;
    }

}
