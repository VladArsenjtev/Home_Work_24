package ua.vladarsenjtev;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLoggerConfigurationLoader {
    public FileLoggerConfigurationLoader() {
    }

    public FileLoggerConfiguration load(LoggingLevel loggingLevel, int sizeMax, String format) throws Exception {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm.ss_dd.yyyy");
        String dateString = dateFormat.format(date);
        File file = new File("Log_" + dateString + format);
        file.createNewFile();
        new FileLoggerConfiguration(file, loggingLevel, sizeMax, format);
        return new FileLoggerConfiguration(file, loggingLevel, sizeMax, format);
    }
}
