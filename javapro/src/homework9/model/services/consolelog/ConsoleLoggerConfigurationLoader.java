package homework9.model.services.consolelog;

import homework9.model.api.StdoutLoggerConfigurationLoader;
import homework9.model.enums.LoggingLevel;

public class ConsoleLoggerConfigurationLoader implements StdoutLoggerConfigurationLoader {

  private ConsoleLoggerConfiguration configuration;

  public ConsoleLoggerConfigurationLoader(ConsoleLoggerConfiguration configuration) {
    this.configuration = configuration;
  }

  public static ConsoleLoggerConfiguration load(String[] string) {
    if (string.length == 0) {
      return new ConsoleLoggerConfiguration(
          null,
          null);
    }
    return new ConsoleLoggerConfiguration(
        LoggingLevel.valueOf(string[0]),
        string[1]);
  }

}

