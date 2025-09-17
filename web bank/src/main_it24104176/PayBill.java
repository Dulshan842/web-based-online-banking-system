package main_it24104176;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class PayBill {

    public static void saveBill(String type, String amt) throws IOException {
        // Absolute path outside Tomcat's webapp
        Path path = Paths.get("C:/Users/Randy Mordred/Desktop/IT24104176/se/web-based-online-banking-system/web bank/web/bills.txt");

        // Log the resolved path
        System.out.println("Resolved path: " + path.toAbsolutePath());

        // Ensure parent directory exists
        Files.createDirectories(path.getParent());

        // Construct the bill line
        String line = type + "," + amt ;

        // Write to file (create if missing, append if exists)
        Files.write(path, List.of(line), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
