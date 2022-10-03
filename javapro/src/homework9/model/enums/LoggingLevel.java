package homework9.model.enums;

public enum LoggingLevel {

  ERROR(0),
  WARN(1),
  INFO(2),
  DEBUG(3),
  TRACE(4);

  public final int priority;

  LoggingLevel(int priority) {
    this.priority = priority;
  }
}
