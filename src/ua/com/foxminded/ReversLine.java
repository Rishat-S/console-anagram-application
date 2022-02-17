package ua.com.foxminded;

public class ReversLine {
    private static int indexOffsetToTheRight;
    private static int indexOffsetToTheLeft;

    public String reverseSentance(String line) {
        StringBuilder result = new StringBuilder();
        String[] wordsArray = line.split(" ");

        for (String word : wordsArray) {
            result.append(reverseWord(word))
                    .append(" ");
        }
        return result.toString().trim();
    }

    private static String reverseWord(String word) {
        char[] charsArray = word.toCharArray();
        indexOffsetToTheRight = 0;
        indexOffsetToTheLeft = word.length() - 1;

        while (indexOffsetToTheRight <= indexOffsetToTheLeft) {
            if (!Character.isLetter(charsArray[indexOffsetToTheRight])) {
                indexOffsetToTheRight++;
                continue;
            }
            if (!Character.isLetter(charsArray[indexOffsetToTheLeft])) {
                indexOffsetToTheLeft--;
                continue;
            }

            switchCharacters(charsArray);

            indexOffsetToTheRight++;
            indexOffsetToTheLeft--;
        }

        return String.valueOf(charsArray);
    }

    private static void switchCharacters(char[] charsArray) {
        char tmp = charsArray[indexOffsetToTheLeft];
        charsArray[indexOffsetToTheLeft] = charsArray[indexOffsetToTheRight];
        charsArray[indexOffsetToTheRight] = tmp;
    }

}
