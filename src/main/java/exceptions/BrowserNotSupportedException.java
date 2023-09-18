package exceptions;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BrowserNotSupportedException extends RuntimeException {
    public BrowserNotSupportedException(String ex) {
        super(ex);
    }
}
