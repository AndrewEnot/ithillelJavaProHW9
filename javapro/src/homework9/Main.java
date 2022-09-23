package homework9;

import java.io.File;
import java.util.Random;

public class Main {

  public static void main(String[] args) {

    FileLogger attempt =
        new FileLogger(FileLoggerConfigurationLoader.load(new File("config.txt")));

    //Block for generation of outer messages
    int i = 0;
    LoggingLevel level = null;
    while (i < 100) {
      int j = new Random().nextInt(6);
      switch (j) {
        case 0 -> level = LoggingLevel.FATAL;
        case 1 -> level = LoggingLevel.ERROR;
        case 2 -> level = LoggingLevel.WARN;
        case 3 -> level = LoggingLevel.INFO;
        case 4 -> level = LoggingLevel.DEBUG;
        case 5 -> level = LoggingLevel.TRACE;
      }
      attempt.logging(level, "attempt " + i);
      i++;
    }
  }
}
