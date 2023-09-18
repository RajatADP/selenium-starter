package utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/main/resources/configs/config.properties"
})
public interface Configs extends Config {

    @DefaultValue("qa")
    String environment();

    @DefaultValue("https://www.google.com/")
    @Key("${environment}.url")
    String url();

    @DefaultValue("Yes")
    String failedStepsScreenshot();

    @DefaultValue("1")
    String failedTestRetryCount();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("remote")
    String executionType();

    @DefaultValue("http://localhost:4444/")
    @Key("${environment}.hubUrl")
    String hubUrl();
}
