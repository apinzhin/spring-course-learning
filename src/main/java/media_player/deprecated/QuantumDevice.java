package media_player.deprecated;

import lombok.Setter;
import media_player.MediaDevice;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("research")
@Component
public class QuantumDevice implements MediaDevice {


    @Setter
    List<String> mediaFiles;

    @Override
    public void play() {
        System.out.println("Superior new QUANTUM media device is starting now !!!");
    }

    @Override
    public void sayGoodBye() {
    }
}
