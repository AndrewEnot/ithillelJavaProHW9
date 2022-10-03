package homework9.model.api;

import homework9.model.enums.LoggingLevel;

public abstract class Stdoutlogger {

  private StdoutLoggerConfiguration configuration;

  public Stdoutlogger(StdoutLoggerConfiguration configuration) {
    this.configuration = configuration;
  }

  public Stdoutlogger() {
  }

  public abstract void logging(LoggingLevel level, String string);

}
