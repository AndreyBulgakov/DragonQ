package com.dragonq.dragonq;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Андрей on 18.10.2014.
 */
public class Parser {
    public Question parse(String filename) throws FileNotFoundException {
        Question question = new Question();
        JsonObject object = new JsonObject();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new FileReader(filename));
        object = element.getAsJsonObject();
        question.id = object.get("Id").getAsInt();
        question.content = object.get("Content").getAsString();
        question.answer = object.get("Answer").getAsString();
        question.comment = object.get("comment").getAsString();
        question.tags = object.get("Tags").getAsString();
        return question;
    }
}