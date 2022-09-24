package homework9;

import static java.lang.Integer.parseInt;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileLoggerConfigurationLoader {

  static FileLoggerConfiguration load(File file) {

    Properties readerA = new Properties();
    try (FileReader reader = new FileReader(file)) {
      readerA.load(reader);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return new FileLoggerConfiguration(readerA.getProperty("FILE"),
        LoggingLevel.valueOf(readerA.getProperty("LEVEL")),
        parseInt(readerA.getProperty("SIZE")),
        readerA.getProperty("FORMAT"));

  }
}

