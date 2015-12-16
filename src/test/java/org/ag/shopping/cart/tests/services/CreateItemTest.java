package org.ag.shopping.cart.tests.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import junit.framework.Assert;
import org.ag.shopping.cart.helpers.RestBase;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static junit.framework.Assert.assertTrue;

/**
 * Created by kusum.maned on 16/12/2015.
 */
public class CreateItemTest extends RestBase {

    private String CONTEXT_PATH = "/items/";
    private JSONObject postRequest;
    private JSONObject putRequest;

    @Test
    public void createItemRestEndPointTest() throws IOException, UnirestException {
        String path = "src/test/resources/requests/createItemRequest.json";
        ClassLoader cl   = this.getClass().getClassLoader();
        URL url  = cl.getResource(path);
        postRequest = new JSONObject(FileUtils.readFileToString(new File(path)));


        //DO POST
        HttpResponse<String> postResponse = doPost(CONTEXT_PATH + "", postRequest.toString());
        assertTrue(postResponse.getStatus() == 201);


        //DO GET
        HttpResponse<String> getResponse = doGet(CONTEXT_PATH + "");
        assertTrue(getResponse.getStatus() == 200);

    }

}
