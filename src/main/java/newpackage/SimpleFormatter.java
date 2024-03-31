package newpackage;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class SimpleFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        // Just return the message itself, with a newline
        return record.getMessage() + System.lineSeparator();
    }
}
