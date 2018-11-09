package media_player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Disk {

    private String title;
    private List<String> songs;

    public List<String> getSongs() {
        return songs;
    }
}
