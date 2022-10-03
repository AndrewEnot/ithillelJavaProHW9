package homework9.model.services.filelog;

import homework9.model.enums.LoggingLevel;
import homework9.model.api.StdoutLoggerConfiguration;
import java.io.File;
import java.time.LocalDate;

public class FileLoggerConfiguration extends StdoutLoggerConfiguration {

  private File file;
  private int size;

  public FileLoggerConfiguration(LoggingLevel level, String format, String path, int size) {
    super(level, format);
    this.file = new File(path, "log_" + level + "_" + LocalDate.now() + ".txt");
    this.size = size;
  }

  public File getFile() {
    return file;
  }

  public int getSize() {
    return size;
  }

  public void setFile(File file) {
    this.file = file;
  }
}