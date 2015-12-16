package org.ag.shopping.cart.helpers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.javafx.binding.StringFormatter;

/**
 * Created by kusum.maned on 16/12/2015.
 */
public class RestBase {

    private HttpResponse<String> postResponse;
    private HttpResponse<String> getResponse;
    private HttpResponse<String> putResponse;

    private String baseUrl = "";
    private String restEndPointUrl = "";

    public RestBase(){
        baseUrl = "http://localhost:4444/items";
    }

    public HttpResponse<String> doGet(String path) throws UnirestException {
        getResponse = Unirest.get(baseUrl+path)
                .header("Accept", "application/json")
                .asString();

        return getResponse;
    }


    public HttpResponse<String> doPost(String path, String body) throws UnirestException {
        postResponse = Unirest.post(baseUrl+path)
                .header("Content-Type", "application/json")
                .body(body)
                .asString();

        return postResponse;
    }

    public HttpResponse<String> doPut(String path, String body) throws UnirestException {
        postResponse = Unirest.put(baseUrl+path)
                .header("Content-Type", "application/json")
                .body(body)
                .asString();

        return putResponse;
    }


}
