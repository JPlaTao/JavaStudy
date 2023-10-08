package am;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    String name;
    String singerOrBand;
    double duration;

    public void play(){
        System.out.println("play " + name);
    }

    public void info(){
        System.out.println(singerOrBand);
    }

    private void dur(){
        System.out.println(duration);
    }
}
