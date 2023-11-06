package logger;
import org.apache.log4j.Logger;

public class CustomLogger {
    public static Logger logger = Logger.getLogger(CustomLogger.class);

    public static void main(String[] args) {

        logger.debug("My Debug Log");
        logger.info("My Info Log");
        logger.warn("My Warn Log");
        logger.error("My error log");
        logger.fatal("My fatal log");
    }

}
