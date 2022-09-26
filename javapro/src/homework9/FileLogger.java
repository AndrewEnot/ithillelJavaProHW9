package homework9;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {

  FileLoggerConfiguration configuration;

  public FileLogger(FileLoggerConfiguration configuration) {
    this.configuration = configuration;
  }

  public void debug(String string) {
    if (configuration.getFile().length() >= configuration.getSize()) {
      throw new FileMaxSizeReachedException("Max size: " + configuration.getSize() + " " +
          "Free space: " + (configuration.getSize() - configuration.getFile().length()) + " " +
          "Path: " + configuration.getFile().getAbsolutePath());
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

  public void info(String string) {
    if (configuration.getFile().length() >= configuration.getSize()) {
      throw new FileMaxSizeReachedException("Max size: " + configuration.getSize() + " " +
          "Free space: " + (configuration.getSize() - configuration.getFile().length()) + " " +
          "Path: " + configuration.getFile().getAbsolutePath());
    }
    LoggingLevel level = LoggingLevel.INFO;
    if (string != null) {
      if (configuration.getLevel().priority >= level.priority) {
        try (FileWriter writer = new FileWriter(configuration.getFile().getAbsolutePath(),
            true)) {
          writer.write(configuration.getFormat() + " " + level + " " + string + "\n");
          writer.flush();
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
      }
    }
  }
}
