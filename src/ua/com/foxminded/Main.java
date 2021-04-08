package ua.com.foxminded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String... args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            System.out.print(revers(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String revers(String input) {
        String result = "";
        String[] stringsArray = input.split(" ");
        char tmp;

        for (String string : stringsArray) {
            char[] charsArray = string.toCharArray();
            int indexOffsetToTheRight = 0;
            int indexOffsetToTheLeft = 0;
            for (int i = 0; i < string.length() / 2; i++) {
                if (Character.isLetter(charsArray[i + indexOffsetToTheRight])) {
                    tmp = charsArray[i + indexOffsetToTheRight];
                    if (Character.isLetter(charsArray[string.length() - 1 - i - indexOffsetToTheLeft])) {
                        charsArray[i] = charsArray[string.length() - 1 - i - indexOffsetToTheLeft];
                        charsArray[string.length() - 1 - i - indexOffsetToTheLeft] = tmp;
                    } else {
                        indexOffsetToTheLeft++;
                        charsArray[i + indexOffsetToTheRight] = charsArray[string.length() - 1 - i - indexOffsetToTheLeft];
                        charsArray[string.length() - 1 - i - indexOffsetToTheLeft] = tmp;
                    }
                } else {
                    indexOffsetToTheRight++;
                    if (Character.isLetter(charsArray[i + indexOffsetToTheRight])) {
                        tmp = charsArray[i + indexOffsetToTheRight];
                        if (Character.isLetter(charsArray[string.length() - 1 - i - indexOffsetToTheLeft])) {
                            charsArray[i + indexOffsetToTheRight] = charsArray[string.length() - 1 - i - indexOffsetToTheLeft];
                            charsArray[string.length() - 1 - i - indexOffsetToTheLeft] = tmp;
                        }
                    }
                }
            }
            result = result + String.valueOf(charsArray) + " ";
        }
        return result.trim();
    }
}