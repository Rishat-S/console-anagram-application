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
		StringBuilder result = new StringBuilder();
		String[] sArrays = input.split(" ");
		for (String string : sArrays) {
			char[] charArrays = string.toCharArray();
			for(int i = string.length() - 1; i >= 0; i--) {
				result.append(charArrays[i]);
			}
			result.append(" ");
		}
		
		return result.toString().trim();
	}
}
