package homework9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class FileLogger {

  FileLoggerConfiguration configuration;
  int index;

  public FileLogger(FileLoggerConfiguration configuration) {
    this.configuration = configuration;
  }

  void debug(String string) {
    if (configuration.getFile().length() > configuration.getSize()) {
      index++;
      configuration.setFile(new File("log_" + configuration.getLevel() + "_" +
          LocalDate.now() + "_" + index + ".txt"));
    }
    LoggingLevel level = LoggingLevel.DEBUG;
    if (string != null) {
      if (configuration.getLevel().priority >= level.priority) {
        try (FileWriter writer = new FileWriter(configuration.getFile().getAbsolutePath(), true)) {
          writer.write(configuration.getFormat() + " " + level + " " + string + "\n");
          writer.flush();
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
      }
    }
  }

  void info(String string) {
    if (configuration.getFile().length() > configuration.getSize()) {
      index++;
      configuration.setFile(new File("log_" + configuration.getLevel() + "_" +
          LocalDate.now() + "_" + index + ".txt"));
    }
    LoggingLevel level = LoggingLevel.INFO;
    if (string != null) {
      if (configuration.getLevel().priority >= level.priority) {
        try (FileWriter writer = new FileWriter(configuration.getFile().getAbsolutePath(), true)) {
          writer.write(configuration.getFormat() + " " + level + " " + string + "\n");
          writer.flush();
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
      }
    }
  }
}
