import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Scanner;

public class HandsOn8 {
    public static void main(String[] args) {
        System.out.println("Ketik teks untuk disimpan atau ketik 'exit' untuk berhenti.");

        try (Scanner sc = new Scanner(System.in);
             BufferedWriter bw = Files.newBufferedWriter(Paths.get("user_input.txt"), 
                 StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            
            while (true) {
                System.out.print("Enter text: ");
                String text = sc.nextLine();
                
                if (text.equalsIgnoreCase("exit")) {
                    break;
                }
                String timestampedText = "[" + LocalDateTime.now() + "] " + text;
                bw.write(timestampedText);
                bw.newLine();
                bw.flush();
                System.out.println("Saved!");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

