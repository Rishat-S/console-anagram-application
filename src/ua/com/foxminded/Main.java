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

        for (String string : stringsArray) {
            char[] charsArray = string.toCharArray();
            int indexOffsetToTheRight = 0;
            int indexOffsetToTheLeft = 0;
            for (int idex = 0; idex < string.length() / 2; idex++) {
            	char tmp;
                if (Character.isLetter(charsArray[idex + indexOffsetToTheRight])) {
                    tmp = charsArray[idex + indexOffsetToTheRight];
                    if (Character.isLetter(charsArray[string.length() - 1 - idex - indexOffsetToTheLeft])) {
                        charsArray[idex + indexOffsetToTheRight] = charsArray[string.length() - 1 - idex - indexOffsetToTheLeft];
                        charsArray[string.length() - 1 - idex - indexOffsetToTheLeft] = tmp;
                    } else {
                        indexOffsetToTheLeft++;
                        charsArray[idex + indexOffsetToTheRight] = charsArray[string.length() - 1 - idex - indexOffsetToTheLeft];
                        charsArray[string.length() - 1 - idex - indexOffsetToTheLeft] = tmp;
                    }
                } else {
                    indexOffsetToTheRight++;
                    if (Character.isLetter(charsArray[idex + indexOffsetToTheRight])) {
                        tmp = charsArray[idex + indexOffsetToTheRight];
                        if (Character.isLetter(charsArray[string.length() - 1 - idex - indexOffsetToTheLeft])) {
                            charsArray[idex + indexOffsetToTheRight] = charsArray[string.length() - 1 - idex - indexOffsetToTheLeft];
                            charsArray[string.length() - 1 - idex - indexOffsetToTheLeft] = tmp;
                        }
                    }
                }
            }
            result = result + String.valueOf(charsArray) + " ";
        }
        return result.trim();
    }
}