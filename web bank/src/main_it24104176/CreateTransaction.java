package main_it24104176;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class CreateTransaction {

    public static void saveTransaction(ServletContext context, String acc, String amt, String date, String name, String bank, String reason) throws IOException {
        // Resolve the real path inside Tomcat's deployed webapp
        String realPath = context.getRealPath("C:/Users/Randy Mordred/Desktop/IT24104176/web-based-online-banking-system/web bank/web/created.txt");

        Path path = Paths.get(realPath);

        // Ensure parent directory exists
        Files.createDirectories(path.getParent());

        // Construct the transaction line
        String line = acc + "," + amt + "," + date + "," + name + "," + bank + "," + reason;

        // Write to file (append mode)
        Files.write(path, List.of(line), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}


