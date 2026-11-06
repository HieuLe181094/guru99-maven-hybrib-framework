package commons;

import java.net.PortUnreachableException;

public class GlobalContaints {
    // Short/long Timeout
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;

    // App Server Url
    public static  final String DEV_URL = "https://demo.guru99.com/";

    // Admin User/ Pass - GURU99
    public static final String GURU_ADMIN_USER = "mngr669166";
    public static final String GURU_ADMIN_PASSWORD = "avahEsa";

    // OS info
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String SEPERATOR = System.getProperty("file.separator");
}
