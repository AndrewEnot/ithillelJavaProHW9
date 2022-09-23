package homework9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {

  FileLoggerConfiguration configuration;
  int index;

  public FileLogger(FileLoggerConfiguration configuration) {
    this.configuration = configuration;
  }

  void logging(LoggingLevel level, String string) {

    //this block create new logfile when the old one is full
    if (configuration.getFile().length() > configuration.getSize()) {
      index++;
      configuration.setFile(new File("log_" + configuration.getLevel() + "_" +
          LocalDate.now() + "_" + index + ".txt"));
    }

    if (string != null) {
      if (configuration.getLevel().priority >= level.priority) {
        try (FileWriter writer = new FileWriter(configuration.getFile().getAbsolutePath(),
            true)) {
          writer.write(configuration.getFormat().
              replaceAll("TIME",
                  LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).
              replaceAll("LEVEL", level.toString()).
              replaceAll("MESSAGE", string) + "\n");
          writer.flush();
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
      }
    }
  }
}
