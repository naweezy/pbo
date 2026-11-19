import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HandsOn6 {
    public static void main(String[] args) {
        Path path = Paths.get("employees.txt");
        List<String> employeeList = new ArrayList<>();

        if (Files.notExists(path)) {
            System.out.println("File employees.txt tidak ditemukan! Buat dulu file-nya.");
            return;
        }

        try (BufferedReader br = Files.newBufferedReader(path)) {
            br.lines().forEach(line -> {
                System.out.println("Membaca: " + line);
                employeeList.add(line); 
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path copyPath = Paths.get("copy_employees.txt");
        try {
            Files.write(copyPath, employeeList);
            System.out.println("Berhasil disalin ke copy_employees.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

