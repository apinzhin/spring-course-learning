package media_player;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Component("connector")
@Profile("test")
public class MockConnector extends OnlineChannelConnector {


    private ArrayList<String> channels;

    @Value("${channels}")
    public void setChannels(String[] channelsArr) {
        channels = Lists.newArrayList(channelsArr);
    }

    @PostConstruct
    @SneakyThrows
    public void init() {
        System.out.println("Mock channel....");

        OnlineChannels.channels = channels.stream().map(e-> "Open channel: " + e).collect(Collectors.toList());
    }

}
