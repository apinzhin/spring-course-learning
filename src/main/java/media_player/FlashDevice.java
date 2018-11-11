package media_player;

import lombok.Setter;
import media_player.deprecated.DeprecatedClass;
import media_player.deprecated.QuantumDevice;

import java.util.List;

@Setter
@DeprecatedClass(newClass = QuantumDevice.class)
public class FlashDevice implements MediaDevice {

    private List<String> mediaFiles;

    @Override
    public void play() {
        System.out.println("----------- Playing from Flash  ...");
        mediaFiles.forEach(System.out::println);
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Good Bye from Flash drive...");
    }


}
