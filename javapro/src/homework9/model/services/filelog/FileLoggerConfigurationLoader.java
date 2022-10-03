package homework9.model.services.filelog;

import static java.lang.Integer.parseInt;

import homework9.model.api.StdoutLoggerConfigurationLoader;
import homework9.model.enums.LoggingLevel;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileLoggerConfigurationLoader implements StdoutLoggerConfigurationLoader {

  private FileLoggerConfiguration configuration;

  public FileLoggerConfigurationLoader(FileLoggerConfiguration configuration) {
    this.configuration = configuration;
  }

  public static FileLoggerConfiguration load(File file) {
    if (file.length() == 0) {
      return new FileLoggerConfiguration(
          null,
          null,
          null,
          -1);
    }
    Properties config = new Properties();
    try (FileReader reader = new FileReader(file)) {
      config.load(reader);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return new FileLoggerConfiguration(
        LoggingLevel.valueOf(config.getProperty("LEVEL")),
        config.getProperty("FORMAT"),
        config.getProperty("FILE"),
        parseInt(config.getProperty("SIZE")));
  }
}

