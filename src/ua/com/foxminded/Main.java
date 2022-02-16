package ua.com.foxminded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {


    public static void main(String... args) throws IOException {
        Reader reader = new BufferedReader(new InputStreamReader(System.in));
        ReversLine reversLine = new ReversLine();

        String line = readLine(reader);

        String reverseSentance = reversLine.reverseSentance(line);

        System.out.println(reverseSentance);

    }

    private static String readLine(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] bufferReader = new char[2<<8];

        int amountOfDataInTheBuffer = reader.read(bufferReader);
        for (int i = 0; i < amountOfDataInTheBuffer; i++) {
            if (bufferReader[i] == '\n') {
                break;
            }
            sb.append(bufferReader[i]);
        }
        return sb.toString();
    }

}