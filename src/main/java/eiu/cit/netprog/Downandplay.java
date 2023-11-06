package eiu.cit.netprog;

import javax.sound.sampled.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Downandplay {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {

            URL url = new URL("https://www.tanbinhtech.com:8443/sample10.wav");
            InputStream is = url.openStream();
            BufferedInputStream bis = new BufferedInputStream(is);

            // Get an AudioInputStream from the file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bis);

            // Get the audio format of the audio file
            AudioFormat format = audioStream.getFormat();

            // Set up the DataLine.Info for the source data line (the audio output)
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            // Open the source data line and start playing
            SourceDataLine sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(format);
            sourceLine.start();

            // Read and play the audio data
            int bytesRead;
            byte[] audioData = new byte[1024];
            while ((bytesRead = audioStream.read(audioData, 0, audioData.length)) != -1) {
                sourceLine.write(audioData, 0, bytesRead);

            }

            // Close the source data line and the audio input stream when finished
            sourceLine.drain();
            sourceLine.close();
            audioStream.close();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}