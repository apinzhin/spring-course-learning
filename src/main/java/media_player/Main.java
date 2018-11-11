package media_player;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        System.out.println("--------------- Get bean by Class ");
        MediaPlayer mediaPlayer = context.getBean(MediaPlayer.class);
        mediaPlayer.play();
    }


    //    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//
//        System.out.println("--------------- Get bean by Id ");
//        MediaDevice device = context.getBean("diskDevice", MediaDevice.class);
//        device.play();
//
//        System.out.println("--------------- Get bean by Class ");
//        FlashDevice flashDevice = context.getBean(FlashDevice.class);
//        flashDevice.play();
//
//        System.out.println("--------------- Get beans by Interface ");
//        Map<String, MediaDevice> devices= context.getBeansOfType(MediaDevice.class);
//        devices.values().forEach(MediaDevice::play);
//    }


}
