package media_player;

import lombok.Setter;

import java.util.List;

@Setter
public class DiskDevice implements MediaDevice {


    private Disk disk;

    public void play() {
        System.out.println("--------------- Playing CD ...");
        System.out.println("Title: " + disk.getTitle());
        disk.getSongs().forEach(System.out::println);

    }

}
