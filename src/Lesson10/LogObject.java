/*

По задумке LogOblect - класс, описывающий одну строку из файла логов

 */

package Lesson10;

public class LogObject {

    private String timeStamp;
    private String level;
    private String logger;
    private String message;
    private String source;

    public LogObject(String timestamp, String level, String logger, String message, String source) {
        this.timeStamp = timestamp;
        this.level = level;
        this.logger = logger;
        this.message = message;
        this.source = source;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public static void print(LogObject[] logObjects) {
        for (int i = 0; i < logObjects.length; i++) {
            System.out.println(logObjects[i].toString());
        }
    }

    @Override
    public String toString() {
        return "timeStamp=" + timeStamp +
                "; level=" + level +
                "; logger=" + logger +
                "; message=" + message +
                ", source='" + source +  ";";
    }


}
