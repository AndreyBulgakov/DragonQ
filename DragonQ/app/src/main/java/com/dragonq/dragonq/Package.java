package com.dragonq.dragonq;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 18.10.2014.
 */
public class Package implements Gettarable {
    @Override
    public List<Question> getQuestion() throws IOException {
        List <Question> list = new ArrayList<Question>();

        String url = "";

        Document document = Jsoup.connect(url).get();
        String jsonfile = document.toString();


        return null;
    }
}
