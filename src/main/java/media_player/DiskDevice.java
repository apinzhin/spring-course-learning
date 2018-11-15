package media_player;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Setter
@Getter
@Component
public class DiskDevice implements MediaDevice {


    private Disk disk;

    @PostConstruct
    public void init() {
//        System.out.println("Initializing DiskDevice ... " +
//                (disk != null ? "disk found: " + disk.getTitle() : "no disk found"));
//
//        songsOrdered = disk.getSongs();  // doesn't work!!!

    }


    @Autowired
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

    @PreDestroy
    public void sayGoodBye() {
        System.out.println("Good Bye from CD ...");
    }

}
