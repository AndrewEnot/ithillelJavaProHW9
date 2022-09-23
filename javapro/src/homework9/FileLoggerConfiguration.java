package homework9;

import java.io.File;

public class FileLoggerConfiguration {

  private File file;
  private LoggingLevel level;
  private long size;
  private String format;

  public FileLoggerConfiguration(File file, LoggingLevel level, long size, String format) {
    this.file = file;
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

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }
}