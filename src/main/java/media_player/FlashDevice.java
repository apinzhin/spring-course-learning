package media_player;

import lombok.Setter;

import java.util.List;

@Setter
public class FlashDevice implements MediaDevice {

    private List<String> mediaFiles;

    @Override
    public void play() {
        System.out.println("----------- Playing from Flash  ...");
        mediaFiles.forEach(System.out::println);
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Good Bye from Flash drive...");
    }


}
