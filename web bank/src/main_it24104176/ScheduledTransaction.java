package main_it24104176;


import javax.servlet.ServletContext;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class ScheduledTransaction {

    public static void deleteTransaction(ServletContext context, String id, String date) throws IOException {
        // Resolve the real path inside Tomcat's deployed context
        String realPath = context.getRealPath("C:/Users/Randy Mordred/Desktop/IT24104176/web-based-online-banking-system/web bank/web/scheduled.txt");
        Path path = Paths.get(realPath);

        // Read all lines from the file
        List<String> lines = Files.readAllLines(path);

        // Filter out the matching transaction
        List<String> updated = lines.stream()
                .filter(line -> !(line.contains(id) && line.contains(date)))
                .collect(Collectors.toList());

        // Overwrite the file with updated content
        Files.write(path, updated, StandardOpenOption.TRUNCATE_EXISTING);
    }
}


