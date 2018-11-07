package media_player;

import java.util.List;

public class DiskDevice implements MediaDevice {


    private String title;
    private List<String> songs;

    public void play() {
        System.out.println("Playing CD ...");
        System.out.println("Title: " + title);
        songs.forEach(System.out::println);

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSongs(List songs) {
        this.songs = songs;
    }
}
