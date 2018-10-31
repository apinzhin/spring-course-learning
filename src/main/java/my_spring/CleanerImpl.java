package my_spring;

/**
 *
 */
public class CleanerImpl implements Cleaner {

    @InjectRandomInt(min =3, max = 5)
    private int repeat;

    @Override
    public void clean() {
        for (int i=0; i<repeat; i++) {
            System.out.println("UUUUUUUUUUUUUUUUUUUUU!!!");
        }
    }
}
