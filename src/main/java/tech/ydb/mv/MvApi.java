package tech.ydb.mv;

import tech.ydb.mv.svc.MvService;
import java.io.PrintStream;
import java.util.Properties;
import tech.ydb.mv.model.MvDictionarySettings;
import tech.ydb.mv.model.MvHandlerSettings;
import tech.ydb.mv.model.MvMetadata;
import tech.ydb.mv.model.MvScanSettings;

/**
 * YDB Materializer controlling API.
 *
 * @author zinal
 */
public interface MvApi extends AutoCloseable {

    static MvApi newInstance(YdbConnector ydb) {
        return new MvService(ydb);
    }

    /**
     * @return YDB connector being used
     */
    YdbConnector getYdb();

    /**
     * @return The complete metadata object being used
     */
    MvMetadata getMetadata();

    /**
     * Apply default settings being read from properties.
     * @param props Input properties object
     */
    void applyDefaults(Properties props);

    /**
     * @return The copy of current default handler settings
     */
    MvHandlerSettings getHandlerSettings();

    /**
     * Set the new defaults for handler settings.
     * @param defaultSettings
     */
    void setHandlerSettings(MvHandlerSettings defaultSettings);

    /**
    * @return The copy of current dictionary processing settings.
     */
    MvDictionarySettings getDictionarySettings();

    /**
     * Set the new defaults for dictionary processing settings.
     * @param defaultSettings
     */
    void setDictionarySettings(MvDictionarySettings defaultSettings);

    /**
     * @return The copy of the current scan settings.
     */
    MvScanSettings getScanSettings();

    /**
     * Set the new defaults for scan settings.
     * @param defaultSettings
     */
    void setScanSettings(MvScanSettings defaultSettings);

    /**
     * @return true, if at least one handler is active, and false otherwise.
     */
    boolean isRunning();

    /**
     * Stop all the handlers which are running.
     */
    void shutdown();

    /**
     * Start the specified handler.
     * @param handlerName The handler to be started
     * @return true, if the handler was started, false if it was already running
     */
    boolean startHandler(String handlerName);

    /**
     * Stop the specified handler.
     * @param handlerName The handler to be stopped
     * @return true, if the handler was stopped, and false, if it was not actually started
     */
    boolean stopHandler(String handlerName);

    /**
     * Start the full scan for the specified target in the specified handler.
     * For illegal arguments, exceptions are thrown.
     *
     * @param handlerName Name of the handler
     * @param targetName Name of the target
     * @return true, if the handler was started, false if it was already running
     */
    boolean startScan(String handlerName, String targetName);

    /**
     * Stop the full scan for the specified target in the specified handler.
     *
     * @param handlerName Name of the handler
     * @param targetName Name of the target
     * @return true, if the scan was stopped, and false, if it was not actually started
     */
    boolean stopScan(String handlerName, String targetName);

    /**
     * Print the list of issues in the current context
     *
     * @param pw The output print stream
     */
    void printIssues(PrintStream pw);

    /**
     * Generate the set of SQL statements and print.
     *
     * @param pw The output print stream
     */
    void printSql(PrintStream pw);

    /**
     * Start the default handlers (as listed in the properties) and return.
     */
    void startDefaultHandlers();

    /**
     * Start the default handlers (as listed in the properties) and continue
     * to run until the termination is requested via shutdown().
     */
    void runDefaultHandlers();

}
