package my_spring;

/**
 *
 */
public class IRobot {

    private Cleaner cleaner = ObjectFactory.getInstance().createObject(Cleaner.class);
    private Speaker speaker  = ObjectFactory.getInstance().createObject(Speaker.class);

    public void clean() {
        speaker.speak("Начал работать");
        cleaner.clean();
        speaker.speak("Закончил работать");

    }
}
