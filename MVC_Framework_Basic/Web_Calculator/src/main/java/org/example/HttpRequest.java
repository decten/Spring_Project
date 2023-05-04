package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final ReqeustLine reqeustLine;

    public HttpRequest(BufferedReader br) throws IOException {
        this.reqeustLine = new ReqeustLine(br.readLine());
    }

    public boolean isGetRequest() {
        return reqeustLine.isGetRequest();
    }

    public boolean setPath(String path) {
        return reqeustLine.matchPath(path);
    }

    public QueryStrings getQueryString() {
        return null;
    }
}
