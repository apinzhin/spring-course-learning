package media_player;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DiskDevice implements MediaDevice {

    private Disk disk;

    public void init() {
//        System.out.println("Initializing DiskDevice ... " +
//                (disk != null ? "disk found: " + disk.getTitle() : "no disk found"));
//
//        songsOrdered = disk.getSongs();  // doesn't work!!!

    }



    public void setDisk(Disk disk) {
        this.disk = disk;
        songsOrdered = disk.getSongs();
    }

    @Shuffle
    public List<String> songsOrdered;

   // @Benchmark
    //@Transactional
    public void play() {
        System.out.println("--------------- Playing CD ...");
        System.out.println("Title: " + disk.getTitle());

        songsOrdered.forEach(System.out::println);
    }

    public void sayGoodBye() {
        System.out.println("Good Bye from CD ...");
    }

}
