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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerWebApplicationServer {

    private final int port;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
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

                /* 1. 사용자 요청을 메인 Thread가 처리*/
//                try(InputStream inputStream = clientSocket.getInputStream(); OutputStream outputStream = clientSocket.getOutputStream() ){
//                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8 ));
//                    DataOutputStream dos = new DataOutputStream(outputStream);
//
//                    HttpRequest httpRequest = new HttpRequest(br);
//
//                    //    GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
//                    if(httpRequest.isGetRequest() && httpRequest.setPath("/calculate")){
//                        QueryStrings queryStrings = httpRequest.getQueryString();
//
//                        int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
//                        String operator = queryStrings.getValue("operator");
//                        int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));
//
//                        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
//                        byte[] body = String.valueOf(result).getBytes();
//
//                        HttpResponse httpResponse = new HttpResponse(dos);
//                        httpResponse.response200Header("application/json", body.length);
//                        httpResponse.responseBody(body);
//                    }
//                }
                /* 2. 사용자 요청이 들어올 때마다 Thread를 새로 생성*/
//                new Thread(new ClientRequestHandler(clientSocket)).start();

                /* 3. Thread Pool 사용 */
                executorService.execute(new ClientRequestHandler(clientSocket));
            }

        }
    }
}
