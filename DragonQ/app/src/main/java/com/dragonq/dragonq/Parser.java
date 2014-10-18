package com.dragonq.dragonq;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Андрей on 18.10.2014.
 */
public class Parser {

    public Question parse(String questionInput) throws FileNotFoundException {
        
        Question question = new Question();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new StringReader(questionInput));
        JsonObject jsonQuestion = element.getAsJsonObject();

        question.id = jsonQuestion.get("Id").getAsInt();
        question.content = jsonQuestion.get("Content").getAsString();
        question.answer = jsonQuestion.get("Answer").getAsString();
        question.comment = jsonQuestion.get("Comment").getAsString();
        question.tags = jsonQuestion.get("Tags").getAsString();

        return question;
    }
    public ArrayList<Question> parseList(String input) throws FileNotFoundException {
        ArrayList<Question> list = new ArrayList<Question>();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new StringReader(input));
        JsonObject object = element.getAsJsonObject();

        JsonArray array = object.getAsJsonArray("Questions");
        Iterator<JsonElement> iterator = array.iterator();
        while (iterator.hasNext()){
            String jsonQuestion = iterator.next().getAsJsonObject().toString();
            Question question = parse(jsonQuestion);
            list.add(question);

        }
        return list;
    }

}