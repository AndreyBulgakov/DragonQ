package com.dragonq.dragonq;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Андрей on 18.10.2014.
 */
public class Parser {

    public Question[] parse(String questionInput) throws FileNotFoundException {
        
        Question[] questions = new Gson().fromJson(questionInput, Question[].class);

        return questions;
    }
}