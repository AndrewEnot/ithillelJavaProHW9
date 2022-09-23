package homework9;

public enum LoggingLevel {

  FATAL(0),
  ERROR(1),
  WARN(2),
  INFO(3),
  DEBUG(4),
  TRACE(5);

  final int priority;

  LoggingLevel(int priority) {
    this.priority = priority;
  }
}
