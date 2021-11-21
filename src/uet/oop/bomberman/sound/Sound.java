package uet.oop.bomberman.sound;
import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import uet.oop.bomberman.BombermanGame;

public class Sound {
    public static void play() {
        try {
            //AudioClip player = new AudioClip(Sound.class.getResource("sound/" + sound + ".wav").toExternalForm());
            //AudioClip player = new AudioClip(Sound.class.getClassLoader().getResource("ace.wav").toExternalForm());

            Sound obj = new Sound();
            Class class1 = obj.getClass();
            URL url = class1.getResource("/src/uet/oop/bomberman/sound/inp.txt");
            System.out.println(url);
            //Absolute path : "D:/Desktop/Bomberman/src/uet/oop/bomberman/sound/horizonalmove.wav"
            //System.out.println(u.toString());
            //player.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
