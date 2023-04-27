import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerWebApplicationServer {

    private final int port;
    private static final Logger logger = LoggerFactory.getLogger(
        CustomerWebApplicationServer.class);


    public CustomerWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomerWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomerWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null){
                logger.info("[CustomerWebApplicationServer] client connected.");

            }

        }
    }
}
