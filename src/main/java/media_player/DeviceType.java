package media_player;

import org.springframework.beans.factory.annotation.Qualifier;
import sun.plugin2.os.windows.FLASHWINFO;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface DeviceType {

    Type value();

    public enum Type {
        DISK,
        FLASH
    }

}
