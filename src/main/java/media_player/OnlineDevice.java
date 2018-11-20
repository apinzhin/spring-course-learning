package media_player;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@DependsOn("onlineChannelConnector")
public class OnlineDevice implements MediaDevice {

    private List<String> channels;

    @PostConstruct
    public void init() {
        channels = OnlineChannels.channels;
    }

    @Override
    public void play() {
        channels.forEach(System.out::println);
    }

    @Override
    public void sayGoodBye() {

    }
}
