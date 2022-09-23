package homework9;

import static homework9.LoggingLevel.DEBUG;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

  public static void main(String[] args) {

    FileLoggerConfiguration config = new FileLoggerConfiguration(DEBUG, 2048,
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    FileLogger attempt = new FileLogger(config);
    int i = 0;
    while (i < 100) {
    attempt.info("attempt " + i);
    attempt.debug("attempt " + i);
    i++;
    }
  }
}
