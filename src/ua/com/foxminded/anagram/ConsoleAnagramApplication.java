package ua.com.foxminded.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ConsoleAnagramApplication {

    public static void main(String... args) throws IOException {
        Reader reader = new BufferedReader(new InputStreamReader(System.in));
        AnagramProvider reversLine = new AnagramProvider();

        String line = readLine(reader);

        System.out.println(reversLine.provideAnagram(line));
    }

    private static String readLine(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] bufferReader = new char[2 << 8];

        int amountOfDataInTheBuffer = reader.read(bufferReader);
        for (int i = 0; i < amountOfDataInTheBuffer; i++) {
            sb.append(bufferReader[i]);
        }
        return sb.toString();
    }

}
