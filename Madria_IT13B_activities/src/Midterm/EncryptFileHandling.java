package Midterm;

import java.io.FileWriter;
import java.io.IOException;

public class EncryptFileHandling {

    public static void main(String[] args) throws IOException {
        String encryptedMessage;
        try (FileWriter myWriter = new FileWriter("C:\\Users\\Dell\\Documents\\Jenny Madria")) {
            int key = 6;
            String message = "I love you!\nGwapa ko!\nBuotan si Ma'am.";
            encryptedMessage = encryptMessage(message, key);
            myWriter.write(encryptedMessage);
            //myWriter.write("Files in Java might be tricky, but it is fun enough!");
        }
        System.out.println("Succesfully wrote to the file.");
        System.out.println(encryptedMessage);
    }

    public static String encryptMessage(String message, int key) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '\n') {
                chars[i] += key;
            }

        }
        return new String(chars);
    }

}
