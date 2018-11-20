import media_player.CdDevice;
import media_player.MediaPlayerConfig;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({"research", "test"})
@ContextConfiguration(classes = MediaPlayerConfig.class)
public class MediaPlyerTest {

    @Autowired
    private CdDevice cdDevice;

    @BeforeClass
    public static void before() {
        System.setProperty("hasInternet", "true");
    }

    @Test
    public void testShuffle() {
        assertEquals(cdDevice.getSongsOrdered().size(), cdDevice.getDisk().getSongs().size());
    }

}
