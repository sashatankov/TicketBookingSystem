import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MovieTheaterServer {

    private static final int DEFAULT_PORT = 5000;
    private Socket socket;
    private MovieTheaterModel model;

    public MovieTheaterServer(Socket socket) {

        this.model = new MovieTheaterModel();
        this.socket = socket;

    }


    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT)) {

            while (true) {
                new Thread(new MovieTheaterClient(serverSocket.accept())).start();
            }

        } catch (IOException e) {
            System.err.println("500 INTERNAL SERVER ERROR");
            System.exit(3);
        }
    }
}
