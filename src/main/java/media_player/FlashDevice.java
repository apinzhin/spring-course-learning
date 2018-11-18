package media_player;

import com.google.common.collect.Lists;
import lombok.Setter;
import media_player.deprecated.DeprecatedClass;
import media_player.deprecated.QuantumDevice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.List;

import static media_player.DeviceType.Type.FLASH;

@Setter
@DeprecatedClass(newClass = QuantumDevice.class)

@Component
@DeviceType(FLASH)
public class FlashDevice implements MediaDevice {

//    @Value("#{'${mediaFiles}'.split(',')}")
    private List<String> mediaFiles;

    @Value("${mediaFiles}")
    public void setMediaFiles(String[] mediaFiles) {
        this.mediaFiles =Lists.newArrayList(mediaFiles);
    }

    @Override
    public void play() {
        System.out.println("----------- Playing from Flash  ...");
        mediaFiles.forEach(System.out::println);
    }

    @PreDestroy
    @Override
    public void sayGoodBye() {
        System.out.println("Good Bye from Flash drive...");
    }


}
