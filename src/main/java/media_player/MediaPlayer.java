package media_player;

import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.List;

public class MediaPlayer {

    @Setter
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
