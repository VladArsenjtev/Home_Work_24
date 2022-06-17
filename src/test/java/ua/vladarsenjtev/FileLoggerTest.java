package ua.vladarsenjtev;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLoggerTest {

    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm.ss_dd.yyyy");
    String dateString = dateFormat.format(date);

    @Test
    public void FileLoggerTest_Debug() throws Exception {
        String str = "DEBUG Test";
        FileLogger fileLogger = new FileLogger();
        fileLogger.debug("Test", LoggingLevel.DEBUG);
        String line = reader(fileLogger).toString();
        String[] act = line.split(" ");
        String act1 = act[6] + " " + act[7];
        Assertions.assertEquals(str, act1);
        Files.delete(Path.of("C:\\Projects\\Home_Work_17_Maven\\Log_" + dateString + ".txt"));
    }


    public StringBuilder reader(FileLogger fileLogger) throws Exception {
        StringBuilder listArr = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new FileReader("Log_"
                        + dateString + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listArr.append(line);
            }
        }
        return listArr;
    }
}
