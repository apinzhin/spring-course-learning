package media_player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.List;

import static media_player.DeviceType.Type.DISK;
import static media_player.DiskType.Type.DVD;

@Component("dvdDrive")
@DeviceType(DISK)
@Scope("prototype")
public class DvdDevice implements MediaDevice {


    private Disk disk;

    @Autowired
    @DiskType(DVD)
//    @Qualifier("dvd_disk")
    public void setDisk(Disk disk) {
        this.disk = disk;
        songsOrdered = disk.getSongs();
    }

    @Shuffle
    public List<String> songsOrdered;


    public void play() {
        System.out.println("--------------- Playing DVD ...");
        System.out.println("Title: " + disk.getTitle());

        songsOrdered.forEach(System.out::println);
    }

    @PreDestroy
    public void sayGoodBye() {
        System.out.println("Good Bye from DVD ...");
    }
}
