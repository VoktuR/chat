package logs;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {

    public Logger() {}

    public static void writeToFile(String message) {
        try {
            Date date = new Date();
            BufferedWriter bfw = new BufferedWriter(
                    new FileWriter(
                            new File("./src/logs/ChatLogs.txt"),
                            true
                    )
            );

            bfw.newLine();
            bfw.write(
                    String.format(
                            "[Logger] %s - %s",
                            date.toString(), message
                    )
            );
            bfw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(int messagesLimit) {
        String finalText = "";
        try {
            BufferedReader bfr = new BufferedReader(
                    new FileReader(
                            new File("./src/logs/ChatLogs.txt")
                    )
            );
            String currentLine;
            List<String> lineArr = new ArrayList<>();
            while ((currentLine = bfr.readLine()) != null) {
                lineArr.add(currentLine);
            }

            while (lineArr.size() > messagesLimit) {
                lineArr.remove(0);
            }

            for (String line : lineArr) {
                finalText = finalText.concat(line + '\n');
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalText;
    }

    public static void soutAllFromFile() {
        try {
            BufferedReader bfr = new BufferedReader(
                    new FileReader(
                            new File("./src/logs/ChatLogs.txt")
                    )
            );

            bfr.lines().forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


