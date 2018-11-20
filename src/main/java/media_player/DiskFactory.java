package media_player;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

import static media_player.DiskType.Type.CD;
import static media_player.DiskType.Type.DVD;

@Configuration
public class DiskFactory {

    private int counter = 0;

    @Value("${title}")
    private String title;

    @Value("#{'${songs}'.split(',')}")
    private List<String> songs;

    @Bean
    @DiskType(CD)
    @Scope(value = "prototype"
    //        , proxyMode = ScopedProxyMode.TARGET_CLASS
    )
    public Disk getCdDisk() {
        counter++;
        System.out.println("DiskFactory - producing CD disk .... " + counter);
        return new Disk("CD: " +  title, songs);
    }

    @Bean
    @DiskType(DVD)
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE
    //        ,proxyMode = ScopedProxyMode.TARGET_CLASS
    )
    public Disk getDvdDisk() {
        counter++;
        System.out.println("DiskFactory - producing DVD disk .... " + counter);
        return new Disk("DVD: " + title, songs);
    }

}
