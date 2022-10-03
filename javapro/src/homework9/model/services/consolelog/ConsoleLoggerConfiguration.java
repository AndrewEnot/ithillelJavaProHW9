package homework9.model.services.consolelog;

import homework9.model.enums.LoggingLevel;
import homework9.model.api.StdoutLoggerConfiguration;

public class ConsoleLoggerConfiguration extends StdoutLoggerConfiguration {

  public ConsoleLoggerConfiguration(LoggingLevel level, String format) {
    super(level, format);
  }

}