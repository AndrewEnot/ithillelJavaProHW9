package homework9.model.services.consolelog;

import homework9.model.enums.LoggingLevel;
import homework9.model.api.Stdoutlogger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger extends Stdoutlogger {

  private ConsoleLoggerConfiguration configuration;


  public ConsoleLogger(ConsoleLoggerConfiguration configuration) {
    this.configuration = configuration;
  }

  public ConsoleLoggerConfiguration getConfiguration() {
    return configuration;
  }

  public void setConfiguration(
      ConsoleLoggerConfiguration configuration) {
    this.configuration = configuration;
  }

  public void logging(LoggingLevel level, String string) {

    if (string != null) {
      if (configuration.getLevel() != null) {
        if (configuration.getLevel().priority >= level.priority) {
          String date = LocalDateTime.now().format(DateTimeFormatter.
              ofPattern("yyyy-MM-dd HH:mm:ss"));
          System.out.printf((configuration.getFormat()) + " " + date + " " + level + " " + string);
        }
      }
    }
  }
}
