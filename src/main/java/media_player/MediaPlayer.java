package media_player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

import static media_player.DeviceType.Type.DISK;


@Service
public class MediaPlayer {

    @Autowired
    @DeviceType(DISK)
    private List<MediaDevice> mediaDevices;

    public MediaPlayer() {

    }



    @PostConstruct
    public void init() {
        System.out.println("Initializing MEDIA PLAYER, media devices found");
        mediaDevices.forEach(e-> System.out.println(e.getClass().getName()));
    }


    public void play() {
        mediaDevices.forEach(mediaDevice -> {
            mediaDevice.play();
        });
    }
}
