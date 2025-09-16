package main_it24104176;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class PayBill {

    public static void saveBill(ServletContext context, String type, String amt) throws IOException {
        // Resolve the real path inside Tomcat's deployed webapp
        String realPath = context.getRealPath("/transaction/bills.txt");
        Path path = Paths.get(realPath);

        // Ensure parent directory exists
        Files.createDirectories(path.getParent());

        // Construct the bill line
        String line = type + "," + amt;

        // Write to file (append mode)
        Files.write(path, List.of(line), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}

