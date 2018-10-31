package my_spring;

/**
 *
 */
public class IRobot {

    @InjectByType
    private Cleaner cleaner;
    @InjectByType
    private Speaker speaker;

    public void clean() {
        speaker.speak("Начал работать");
        cleaner.clean();
        speaker.speak("Закончил работать");

    }
}
