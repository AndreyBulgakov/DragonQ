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
    public List<Question> getQuestion() throws IOException {
        List <Question> list = new ArrayList<Question>();

        String url =  "http://echo.jsontest.com/Id/1/Content/Content/Comment/Comment/Answer/Answer/Tags/Tags";
        /*String paramValue = "4052102";
        String paramName = "t";
        Connection connection = Jsoup.connect(url);
        Map<String, String> paramsMap = new HashMap<String,String>();
        paramsMap.put(paramName, paramValue);
        Document document = connection.data(paramsMap).get();
        document.body();*/
        String json = Jsoup.connect(url).ignoreContentType(true).execute().body();
        list.add(new Parser().parse(json));

        return list;
    }
}
