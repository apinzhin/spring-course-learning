package media_player;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class OnlineChannelConnector {
    
    @PostConstruct
    @SneakyThrows
    public void init() {
        System.out.println("Establishing online channel....");

        Thread.sleep(1000);

        OnlineChannels.channels = Arrays.asList("Radio Jazz", "Vesti FM");

        System.out.println("Online channel up and running!");

    }

}
