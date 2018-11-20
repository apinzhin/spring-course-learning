package media_player;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static media_player.DeviceType.Type.DISK;
import static media_player.DiskType.Type.CD;

@Setter
@Getter
@Component("cdDrive")
@DeviceType(DISK)
public class CdDevice implements MediaDevice {

    private Disk disk;
    private ObjectFactory<Disk> diskFactory;

    @PostConstruct
    public void init() {
//        System.out.println("Initializing CdDevice ... " +
//                (disk != null ? "disk found: " + disk.getTitle() : "no disk found"));
//
//        songsOrdered = disk.getSongs();  // doesn't work!!!

    }


    @Autowired
    @DiskType(CD)
    public void setDisk(ObjectFactory<Disk> diskFactory) {
        this.diskFactory = diskFactory;

      //  songsOrdered = disk.getSongs();
    }

    //@Shuffle
    //public List<String> songsOrdered;

   // @Benchmark
    //@Transactional
    public void play() {
        Disk disk = diskFactory.getObject();

        System.out.println("--------------- Playing CD ...");
        System.out.println("Title: " + disk.getTitle());

        disk.getSongs().forEach(System.out::println);
    }

    @PreDestroy
    public void sayGoodBye() {
        System.out.println("Good Bye from CD ...");
    }

}
