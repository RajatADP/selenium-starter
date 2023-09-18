package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.aeonbits.owner.ConfigFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FrameworkConfigs {

    public static Configs config = ConfigFactory.create(Configs.class);
}
