package my_spring;

/**
 *
 */
public class IRobot {

    private Cleaner cleaner = new CleanerImpl();
    private Speaker speaker  = new SpeakerImpl();

    public void clean() {
        speaker.speak("Начал работать");
        cleaner.clean();
        speaker.speak("Закончил работать");

    }
}
