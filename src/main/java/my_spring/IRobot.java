package my_spring;

/**
 *
 */
public class IRobot {

    private Cleaner cleaner = new Cleaner();
    private Speaker speaker  = new Speaker();

    public void clean() {
        speaker.speak("Начал работать");
        cleaner.clean();
        speaker.speak("Закончил работать");

    }
}
