package constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.time.Duration;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FrameworkConstants {
    public static final String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public static final Duration EXPLICITWAITTIMEOUT = Duration.ofSeconds(10);
    public static final int RETRYCOUNT = 0;
    public static final String REPORTPATH = System.getProperty("user.dir") +  File.separator + "/src/main/java/report";
    public static final String REPORTNAME = "DemoProject";
    public static final String DOCUMENTNAME = "Sample App";
}
