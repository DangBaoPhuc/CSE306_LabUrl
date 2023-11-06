package eiu.cit.netprog;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Onlinemp3play {
    public static void main(String[] args) {
        URL url;
        try {
            url = new URL("https://download.samplelib.com/mp3/sample-3s.mp3");
            InputStream is = url.openStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            Player mp3Player = new Player(bis);
            mp3Player.play();
        } catch (IOException | JavaLayerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
