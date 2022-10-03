package homework9.model.api;

import homework9.model.enums.LoggingLevel;

public abstract class StdoutLoggerConfiguration {

  private LoggingLevel level;
  private String format;

  public StdoutLoggerConfiguration(LoggingLevel level, String format) {
    this.level = level;
    this.format = format;
  }

  public LoggingLevel getLevel() {
    return level;
  }

  public String getFormat() {
    return format;
  }
}