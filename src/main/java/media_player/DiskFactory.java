package media_player;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DiskFactory {

    @Value("${title}")
    private String title;

    @Value("#{'${songs}'.split(',')}")
    private List<String> songs;

    @Bean(name = "queenDisk")
    public Disk getDisk() {
        System.out.println("DiskFactory - producing disk ....");
        return new Disk(title, songs);
    }

}
