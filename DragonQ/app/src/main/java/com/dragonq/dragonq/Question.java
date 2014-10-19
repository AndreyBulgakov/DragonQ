package com.dragonq.dragonq;

/**
 * Created by Андрей on 18.10.2014.
 */
public class Question {
    Integer Id;
    String Content;
    String Answer;
    String Comment;
    String Tags;

    public Question() {
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public Question(int id,String content) {
        this.Id = id;
        this.Content = content;
    }
}
