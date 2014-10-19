package com.dragonq.dragonq;

import android.util.Log;

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
    String paramCount;
    final String paramCounName = "qNum";
    String paramTags;
    final String paramTagsName = "tags";
    @Override
    public Question[] getQuestion() throws IOException {
        //String url =  "http://echo.jsontest.com/Id/1/Content/Content/Comment/Comment/Answer/Answer/Tags/Tags";
        String url =  "http://91.225.131.178:60165/api/values";
        Connection connection = Jsoup.connect(url);
        Map<String, String> paramsMap = new HashMap<String,String>();
        paramsMap.put(paramTagsName, paramTags);
        paramsMap.put(paramCounName, paramCount);


        String json = Jsoup.connect(url)
                .data(paramsMap)
                .ignoreContentType(true)
                .execute()
                .body();
        Log.d("My Message", json);
        Question[] questions = new Parser().parse(json);

        return questions;
    }

    public Question[] getQuestion(String count, String tags) throws IOException {
        //String url =  "http://echo.jsontest.com/Id/1/Content/Content/Comment/Comment/Answer/Answer/Tags/Tags";
        String url =  "http://91.225.131.178:60165/api/values";
        paramCount = count;
        paramTags = tags;
        Connection connection = Jsoup.connect(url);
        Map<String, String> paramsMap = new HashMap<String,String>();
        paramsMap.put(paramTagsName, paramTags);
        paramsMap.put(paramCounName, paramCount);


        String json = Jsoup.connect(url)
                .data(paramsMap)
                .ignoreContentType(true)
                .execute()
                .body();
        Question[] questions = new Parser().parse(json);

        return questions;
    }
}
