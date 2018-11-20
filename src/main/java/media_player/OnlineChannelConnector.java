package media_player;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@Lazy
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
