package homework9;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {

  FileLoggerConfiguration configuration;

  public FileLogger(FileLoggerConfiguration configuration) {
    this.configuration = configuration;
  }

  void debug(String string) {
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
