package homework9;

import java.io.File;
import java.time.LocalDate;

public class FileLoggerConfiguration {

  private File file;
  private LoggingLevel level;
  private int size;
  private String format;

  public FileLoggerConfiguration(LoggingLevel level, int size, String format) {
    this.file = new File("log_" + level + "_" + LocalDate.now() + ".txt");
    this.level = level;
    this.size = size;
    this.format = format;
  }

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }

  public LoggingLevel getLevel() {
    return level;
  }

  public void setLevel(LoggingLevel level) {
    this.level = level;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }
}