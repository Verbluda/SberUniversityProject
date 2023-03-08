package Homework_1_Profile_module;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class FileReadWrite {
    private static final String PKG_DIRECTORY = "/Users/Verbluda/Java_Sber/Homework_Hairzamanova/src/Homework_1_Profile_module";
    private static final String OUTPUT_FILE_NAME = "output.txt";
    private static final String INPUT_FILE_NAME = "input.txt";

    public static void main(String[] args) {
        try {
            readAndWrite();
        } catch (IOException e) {
            System.out.println("LOG: " + e.getMessage());
        }
    }

    public static void readAndWrite() throws IOException {
        Scanner scanner = new Scanner(new File(PKG_DIRECTORY + "/" + INPUT_FILE_NAME));
        Writer writer = new FileWriter(PKG_DIRECTORY + "/" + OUTPUT_FILE_NAME);

        try (scanner; writer) {
            while (scanner.hasNext()) {
                char[] line = scanner.nextLine().toCharArray();
                for (char c: line) {
                    if (c > 96 && c < 123) {
                        writer.write(c - 32);
                    } else {
                        writer.write(c);
                    }
                }
                writer.write('\n');
            }
        }

    }

}
