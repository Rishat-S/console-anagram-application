package ua.com.foxminded;

public class ReversLine {
    private static int indexOffsetToTheRight;
    private static int indexOffsetToTheLeft;

    public String reverseSentance(String line) {
        String result = "";
        String[] wordsArray = line.split(" ");

        for (String word : wordsArray) {
            result = reverseWord(result, word);
        }
        return result.trim();
    }

    private static String reverseWord(String result, String word) {
        char[] charsArray = word.toCharArray();
        indexOffsetToTheLeft = 0;
        indexOffsetToTheRight = 0;

        for (int index = 0; index < word.length() / 2; index++) {
            char tmp;
            if (Character.isLetter(charsArray[index + indexOffsetToTheRight])) {
                tmp = charsArray[index + indexOffsetToTheRight];
                if (!Character.isLetter(charsArray[word.length() - 1 - index - indexOffsetToTheLeft])) {
                    indexOffsetToTheLeft++;
                }
                charsArray[index + indexOffsetToTheRight] = charsArray[word.length() - 1 - index - indexOffsetToTheLeft];
                charsArray[word.length() - 1 - index - indexOffsetToTheLeft] = tmp;
            } else {
                indexOffsetToTheRight++;
                if (Character.isLetter(charsArray[index + indexOffsetToTheRight])) {
                    tmp = charsArray[index + indexOffsetToTheRight];
                    if (Character.isLetter(charsArray[word.length() - 1 - index - indexOffsetToTheLeft])) {
                        charsArray[index + indexOffsetToTheRight] = charsArray[word.length() - 1 - index - indexOffsetToTheLeft];
                        charsArray[word.length() - 1 - index - indexOffsetToTheLeft] = tmp;
                    }
                }
            }
        }
        result = result + String.valueOf(charsArray) + " ";
        return result;
    }
}
