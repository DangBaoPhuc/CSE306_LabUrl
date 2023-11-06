package eiu.cit.netprog;

import java.io.File;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.sound.sampled.LineUnavailableException;

import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * AudioPlayer
 */
public class AudioPlayer {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // File audioFile = new File("C:\\Users\\admin\\Downloads\\sample1.wav");
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream( new File("C:\\Users\\Duc\\Downloads\\phuc\\src\\main\\java\\eiu\\cit\\n" + //
                    "etprog\\sample102.wav").getAbsoluteFile());
            Clip audioClip;
            try {
                audioClip = AudioSystem.getClip();
                audioClip.open(audio);
                audioClip.start();
                
                while (!audioClip.isRunning()) {
                    Thread.sleep(10);
                }
                while (audioClip.isRunning()) {
                    Thread.sleep(10);

                }
                audioClip.close();
            } catch (LineUnavailableException | InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (UnsupportedAudioFileException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}