package homework9.model.controller;

import homework9.model.api.Stdoutlogger;
import homework9.model.enums.LoggingType;
import homework9.model.services.consolelog.ConsoleLogger;
import homework9.model.services.consolelog.ConsoleLoggerConfigurationLoader;
import homework9.model.services.filelog.FileLogger;
import homework9.model.services.filelog.FileLoggerConfigurationLoader;
import java.io.File;

public class LoggerManager {

  private Stdoutlogger logger;
  private LoggingType type;
  private Object source;

  public LoggerManager(LoggingType type, Object source) {
    this.type = type;
    this.source = source;
    switch (type) {
      case FILE -> this.logger = new FileLogger(FileLoggerConfigurationLoader.load((File) source));
      case CONSOLE -> this.logger = new ConsoleLogger(ConsoleLoggerConfigurationLoader.load(
          (String[]) source));
    }
  }

  public Stdoutlogger getLogger() {
    return logger;
  }

  public LoggingType getType() {
    return type;
  }

  public Object getSource() {
    return source;
  }
}

