package media_player;

import lombok.Setter;

@Setter
public class DiskDevice implements MediaDevice {

    private Disk disk;

    public void init() {
        System.out.println("Initializing DiskDevice ... " +
                (disk != null ? "disk found: " + disk.getTitle() : "no disk found"));
    }

    public void play() {
        System.out.println("--------------- Playing CD ...");
        System.out.println("Title: " + disk.getTitle());
        disk.getSongs().forEach(System.out::println);

    }

}
