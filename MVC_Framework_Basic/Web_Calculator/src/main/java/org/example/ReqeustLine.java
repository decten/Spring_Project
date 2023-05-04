package org.example;

import java.util.Objects;

//    GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
public class ReqeustLine {

    private final String method; // GET
    private final String urlPath; // /calculate?operand1=11&operator=*&operand2=55
    private String queryString; // operand1=11&operator=*&operand2=55

    public ReqeustLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = queryString;
    }

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

    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String requestPath) {
        return urlPath.equals(requestPath);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReqeustLine that = (ReqeustLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath,
            that.urlPath) && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryString);
    }
}
