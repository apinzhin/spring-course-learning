package my_spring;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        ObjectFactory.getInstance().createObject(IRobot.class).clean();
    }

}
