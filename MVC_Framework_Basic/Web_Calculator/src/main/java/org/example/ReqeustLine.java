package org.example;

//    GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
public class ReqeustLine {

    private final String method; // GET
    private final String urlPath; // /calculate?operand1=11&operator=*&operand2=55
    private String queryString;

    public ReqeustLine(String reqeustLine) {
        String[] tokens = reqeustLine.split(" ");
        this.method = tokens[0];

        String[] urlTokens = tokens[1].split("\\?");
        this.urlPath = urlTokens[0];
        //쿼리 스트링이 존재하는 경우
        if(urlTokens.length == 2){
            this.queryString = urlTokens[1];
        }
    }
}
