package media_player;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

//        System.out.println("--------------- Get bean by Class ");
//        MediaPlayer mediaPlayer = context.getBean(MediaPlayer.class);
//        mediaPlayer.play();
    }
}
