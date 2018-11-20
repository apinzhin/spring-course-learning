package media_player;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component("connector")
@Lazy
@Profile("prod")
public class OnlineChannelConnector implements Connector {
    
    @PostConstruct
    @SneakyThrows
    public void init() {
        System.out.println("Establishing online channel....");

        Thread.sleep(1000);

        OnlineChannels.channels = Arrays.asList("Radio Jazz", "Vesti FM");

        System.out.println("Online channel up and running!");

    }

}
