package homework9;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

  public static void main(String[] args) {

    FileLoggerConfiguration config = new FileLoggerConfiguration(new File("config.txt"),
        LoggingLevel.DEBUG, 2048, LocalDateTime.now().format(DateTimeFormatter.ofPattern(
        "yyyy-MM-dd HH:mm:ss")));

    FileLogger attempt = new FileLogger(config);

    attempt.info("attempt 1");
    attempt.debug("attempt 2");
    attempt.info("attempt 3");
    attempt.info("attempt 4");
    attempt.debug("attempt 5");
    attempt.debug("attempt 6");

  }
}
