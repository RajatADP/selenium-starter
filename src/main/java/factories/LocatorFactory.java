package factories;

import enums.LocatorStrategy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import java.util.EnumMap;
import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LocatorFactory {

    public static final EnumMap<LocatorStrategy, Function<String, By>> MAP = new EnumMap<>(LocatorStrategy.class);

    static {
        MAP.put(LocatorStrategy.ID, By::id);
        MAP.put(LocatorStrategy.CSS, By::cssSelector);
        MAP.put(LocatorStrategy.XPATH, By::xpath);
        MAP.put(LocatorStrategy.NAME, By::name);
        MAP.put(LocatorStrategy.LINKTEXT, By::linkText);
        MAP.put(LocatorStrategy.PARTIALLINKTEXT, By::partialLinkText);
    }

    public static By getByLocator(LocatorStrategy strategy, String value) {
        return MAP.get(strategy).apply(value);
    }

}
