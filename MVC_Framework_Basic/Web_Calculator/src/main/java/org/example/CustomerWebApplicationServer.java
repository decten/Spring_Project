package org.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
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
            logger.info("[org.example.CustomerWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[org.example.CustomerWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null){
                logger.info("[org.example.CustomerWebApplicationServer] client connected.");

                /*사용자 요청을 메인 Thread가 처리*/
                try(InputStream inputStream = clientSocket.getInputStream(); OutputStream outputStream = clientSocket.getOutputStream() ){
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8 ));
                    DataOutputStream dos = new DataOutputStream(outputStream);

                    String line;
                    while ((line=br.readLine())!=""){
                        System.out.println(line);
                    }
                }

            }

        }
    }
}
