package eiu.cit.netprog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Downthenplay {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.tanbinhtech.com:8443/sample10.wav");
            InputStream is = url.openStream();
            FileOutputStream file = new FileOutputStream(
                    "C:\\Users\\admin\\lab-streams\\src\\main\\java\\eiu\\cit\\netprog\\sample102.wav");
            int c;
            while ((c = is.read()) != -1) {
                file.write(c);
            }
            file.close();

        } catch (IOException ex) {
        }
        try {
            AudioInputStream audio = AudioSystem
                    .getAudioInputStream(
                            new File("C:\\\\Users\\\\admin\\\\lab-streams\\\\src\\\\main\\\\java\\\\eiu\\\\cit\\\\n" + //
                                    "etprog\\\\sample102.wav").getAbsoluteFile());
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
