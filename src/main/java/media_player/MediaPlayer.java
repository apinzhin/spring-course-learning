package media_player;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MediaPlayer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        MediaDevice device = context.getBean("diskDevice", MediaDevice.class);
        device.play();
    }
}
