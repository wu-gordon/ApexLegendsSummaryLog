package ui.gui;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class PlayMusic {

    public PlayMusic() {
    }

    public void musicPlayer(String filepath) {
        InputStream music;
        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audioStream = new AudioStream(music);
            AudioPlayer.player.start(audioStream);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The song isn't playing btw.");
        }
    }


}
