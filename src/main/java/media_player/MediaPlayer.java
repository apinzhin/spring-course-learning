package media_player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
public class MediaPlayer {

    @Autowired
    @Qualifier("diskDevice")
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
