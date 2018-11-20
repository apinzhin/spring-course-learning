import media_player.CdDevice;
import media_player.Connector;
import media_player.OnlineChannels;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({"research", "test"})
@ContextConfiguration(classes = TestMediaPlayerConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MediaPlyerTest {

    @Autowired
    private CdDevice cdDevice;

    @Autowired
    Connector connector;

    @BeforeClass
    public static void before() {
        System.setProperty("hasInternet", "true");
    }

    @Test
    public void testShuffle() {
        assertEquals(cdDevice.getSongsOrdered().size(), cdDevice.getDisk().getSongs().size());
    }

    @Test
    public void testConnector() {
        assertEquals(OnlineChannels.channels.get(0), "Open channel: Radio Test");
    }

}
