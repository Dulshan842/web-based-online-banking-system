package main_it24104176;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CreateTransaction {

    public static void saveTransaction(ServletContext context, String acc, String amt, String date, String name, String bank, String reason) throws IOException {
        // Parse input date
        LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate today = LocalDate.now();

        // Construct the transaction line
        String line = acc + "," + amt + "," + date + "," + name + "," + bank + "," + reason;

        // Choose file based on date
        Path path;
        if (inputDate.isAfter(today)) {
            // Future date → scheduled.txt
            path = Paths.get("C:/Users/Randy Mordred/Desktop/IT24104176/web-based-online-banking-system/web bank/web/scheduled.txt");
        } else {
            // Today or past → created.txt
            path = Paths.get("C:/Users/Randy Mordred/Desktop/IT24104176/web-based-online-banking-system/web bank/web/created.txt");
        }

        // Ensure parent directory exists
        Files.createDirectories(path.getParent());

        // Write to file (append mode)
        Files.write(path, List.of(line), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
