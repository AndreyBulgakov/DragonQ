package com.dragonq.dragonq;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Андрей on 18.10.2014.
 */
public class Package implements Gettarable {
    @Override
    public Question[] getQuestion() throws IOException {
        //String url =  "http://echo.jsontest.com/Id/1/Content/Content/Comment/Comment/Answer/Answer/Tags/Tags";
        String url =  "http://91.225.131.178:60165/api/values?qNum=5&tags=common";
        /*String paramValue = "4052102";
        String paramName = "t";
        Connection connection = Jsoup.connect(url);
        Map<String, String> paramsMap = new HashMap<String,String>();
        paramsMap.put(paramName, paramValue);
        Document document = connection.data(paramsMap).get();
        document.body();*/
        String json = Jsoup.connect(url).ignoreContentType(true).execute().body();
        Question[] questions = new Parser().parse(json);

        return questions;
    }
}
