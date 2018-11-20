package media_player;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component("connector")
@Profile("test")
public class MockConnector extends OnlineChannelConnector {

    @PostConstruct
    @SneakyThrows
    public void init() {
        System.out.println("Mock channel....");

        OnlineChannels.channels = Arrays.asList("Radio Test 1", "Radio Test 2");
    }

}
