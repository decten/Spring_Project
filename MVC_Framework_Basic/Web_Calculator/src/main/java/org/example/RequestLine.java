package org.example;

import java.util.Objects;

//    GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
public class RequestLine {

    private final String method; // GET
    private final String urlPath; // /calculate?operand1=11&operator=*&operand2=55
    private QueryStrings queryStrings; // operand1=11&operator=*&operand2=55

    public RequestLine(String method, String urlPath, String queryStrings) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryStrings);
    }

    public RequestLine(String reqeustLine) {
        String[] tokens = reqeustLine.split(" ");
        this.method = tokens[0];

        String[] urlTokens = tokens[1].split("\\?");
        this.urlPath = urlTokens[0];
        //쿼리 스트링이 존재하는 경우
        if(urlTokens.length == 2){
            this.queryStrings = new QueryStrings(urlTokens[1]);
        }
    }

    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String requestPath) {
        return urlPath.equals(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath,
            that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }
}
