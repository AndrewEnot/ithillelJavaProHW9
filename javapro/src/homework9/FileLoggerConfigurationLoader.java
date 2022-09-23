package homework9;

import static java.lang.Integer.parseInt;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {

  static FileLoggerConfiguration load(File file) {

    //block of subsidiary variables for FileLoggerConfiguration constructor
    String path = null;
    LoggingLevel level = null;
    int size = 0;
    String format = null;

    //block of reading from "file" to array of Strings
    StringBuilder readerA = new StringBuilder();
    try (FileReader reader = new FileReader(file)) {
      int c;
      while ((c = reader.read()) != -1) {
        readerA.append((char) c);
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    String[] attr = readerA.toString().split("\r\n");

    //block of recognition from array of Strings to FileLoggerConfiguration attributes
    for (String s : attr) {
      String trim = s.substring(s.indexOf(" ")).trim();
      if (s.contains("FILE:")) {
        path = trim;
      }
      if (s.contains("LEVEL:")) {
        level = LoggingLevel.valueOf(trim);
      }
      if (s.contains("MAX-SIZE:")) {
        size = parseInt(trim);
      }
      if (s.contains("FORMAT:")) {
        format = trim;
      }
    }
    return new FileLoggerConfiguration(path, level, size, format);
  }
}

