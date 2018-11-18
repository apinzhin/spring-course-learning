package media_player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component("dvdDrive")
@Qualifier("diskDevice")
public class DvdDiskDevice implements MediaDevice {

    private Disk disk;

    @Autowired
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
