package media_player;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static media_player.DiskType.Type.CD;
import static media_player.DiskType.Type.DVD;

@Configuration
public class DiskFactory {

    @Value("${title}")
    private String title;

    @Value("#{'${songs}'.split(',')}")
    private List<String> songs;

    @Bean
    @DiskType(CD)
    public Disk getCdDisk() {
        System.out.println("DiskFactory - producing CD disk ....");
        return new Disk("CD: " +  title, songs);
    }

    @Bean
    @DiskType(DVD)
    public Disk getDvdDisk() {
        System.out.println("DiskFactory - producing DVD disk ....");
        return new Disk("DVD: " + title, songs);
    }

}
