package media_player;

import lombok.Setter;

import java.util.List;

public class MediaPlayer {

    @Setter
    private List<MediaDevice> mediaDevices;

    public MediaPlayer() {
        System.out.println("Initializing MEDIA PLAYER, media devices found");
        mediaDevices.forEach(e-> System.out.println(e.getClass().getName()));
        mediaDevices.forEach(MediaDevice::play);
    }



    public void init() {

    }



}
