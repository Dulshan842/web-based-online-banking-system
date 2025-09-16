package main_it24104176;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CreateTransaction {

    public static void saveTransaction(ServletContext context, String acc, String amt, String date, String name, String bank, String reason) throws IOException {
        LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate today = LocalDate.now();

        String line = acc + "," + amt + "," + date + "," + name + "," + bank + "," + reason;

        String basePath = "C:/Users/Randy Mordred/Desktop/IT24104176/se/web-based-online-banking-system/web bank/web/";
        String fileName = inputDate.isAfter(today) ? "scheduled.txt" : "created.txt";

        Path path = Paths.get(basePath + fileName);
        Files.createDirectories(path.getParent());
        Files.write(path, List.of(line), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}

