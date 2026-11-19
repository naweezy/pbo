import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;

public class HandsOn7 {
    public static void main(String[] args) {
        Path source = Paths.get("report.txt");
        Path backup = Paths.get("backup/report.txt");
        Path logFile = Paths.get("log.txt");

        try {
            Files.write(source, List.of("Report Generated", "Status: OK"));
            System.out.println("File report.txt dibuat.");

            if (Files.notExists(backup.getParent())) {
                Files.createDirectories(backup.getParent());
            }
            if (Files.exists(source)) {
                Files.copy(source, backup, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Backup created successfully!");
                
                String log = "Backup report.txt berhasil dibuat pada " + LocalDateTime.now();
                Files.write(logFile, List.of(log));
                System.out.println("Log berhasil dibuat.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

