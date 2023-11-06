package eiu.cit.netprog;

import java.net.URL;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class AudioDownload {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.tanbinhtech.com:8443/sample10.wav");
            InputStream is = url.openStream();
            FileOutputStream file = new FileOutputStream(
                    "C:\\Users\\Duc\\Downloads\\phuc\\src\\main\\java\\eiu\\cit\\netprog\\sample102.wav");
            int c;
            while ((c = is.read()) != -1) {
                file.write(c);
            }
            file.close();

        } catch (IOException ex) {
        }

    }

}
