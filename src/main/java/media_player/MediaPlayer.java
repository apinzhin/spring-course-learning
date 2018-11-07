package media_player;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class MediaPlayer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        System.out.println("--------------- Get bean by Id ");
        MediaDevice device = context.getBean("diskDevice", MediaDevice.class);
        device.play();

        System.out.println("--------------- Get bean by Class ");
        FlashDevice flashDevice = context.getBean(FlashDevice.class);
        flashDevice.play();

        System.out.println("--------------- Get beans by Interface ");
        Map<String, MediaDevice> devices= context.getBeansOfType(MediaDevice.class);
        devices.values().forEach(MediaDevice::play);
    }
}
