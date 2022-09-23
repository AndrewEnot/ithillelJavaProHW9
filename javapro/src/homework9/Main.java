package homework9;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

  public static void main(String[] args) {

    FileLoggerConfiguration config = new FileLoggerConfiguration(new File("config.txt"),
        LoggingLevel.INFO, 2048, LocalDateTime.now().format(DateTimeFormatter.ofPattern(
        "yyyy-MM-dd HH:mm:ss")));

    FileLogger attempt = new FileLogger(config);
    try {
      int i = 0;
      while (i < 1000){
      attempt.info("attempt " + i);
      attempt.debug("attempt " + i);
      i++;
      }
    } catch (FileMaxSizeReachedException e) {
      System.out.println("Max size: " + config.getSize() + " " + "Free space: " +
          (config.getSize() - config.getFile().length()) + " " + "Path: " +
          config.getFile().getAbsolutePath());
    }
  }
}
