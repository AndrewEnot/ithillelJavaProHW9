package homework9;

public enum LoggingLevel {

  INFO(0),
  DEBUG(1);

  final int priority;

  LoggingLevel(int priority) {
    this.priority = priority;
  }
}
