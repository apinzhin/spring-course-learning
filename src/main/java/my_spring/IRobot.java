package my_spring;

import javax.annotation.PostConstruct;

/**
 *
 */
public class IRobot {

    @InjectByType
    private Cleaner cleaner;
    @InjectByType
    private Speaker speaker;

    @PostConstruct
    public void init() {
        System.out.println("Готов к работе, cleaner = " + cleaner.getClass().getSimpleName());
    }

    @Benchmark
    public void clean() {
        speaker.speak("Начал работать");
        cleaner.clean();
        speaker.speak("Закончил работать");

    }
}
