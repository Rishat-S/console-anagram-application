package ua.com.foxminded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String...args) {
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
		String[] sArrays = input.split(" ");
		char tmp;
		for (String string : sArrays) {
			char[] charArrays = string.toCharArray();
			for(int i = 0; i < string.length() / 2; i++) {
				if (Character.isLetter(charArrays[i])) {
					tmp = charArrays[i];
					if (Character.isLetter(charArrays[string.length()-1-i])) {
						charArrays[i] = charArrays[string.length()-1-i];
						charArrays[string.length()-1-i] = tmp;
					}
				}
			}
			result = result + String.valueOf(charArrays) + " ";
		}
		return result.trim();
	}
}
