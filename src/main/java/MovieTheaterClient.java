import java.io.IOException;
import java.net.Socket;

public class MovieTheaterClient implements Runnable {

    public static final String DEFAULT_HOST = "localhost";
    public static final int DEFAULT_PORT = 5000;
    private Socket socket;

    public MovieTheaterClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        while(true) {
            // TODO the logic of the interaction with the server
        }
    }

    public static void main(String[] args) {

        try(Socket socket = new Socket(DEFAULT_HOST, DEFAULT_PORT)) {

        } catch(IOException e) {
            System.err.println("NETWORK ERROR");
            System.exit(2);
        }
    }
}
