package com.dragonq.dragonq;

/**
 * Created by Андрей on 18.10.2014.
 */
public class Question {
    Integer id;
    String content;
    String answer;
    String comment;
    String tags;

    public Question() {
    }

    public Question(int id,String content) {
        this.id = id;
        this.content = content;
    }
}
