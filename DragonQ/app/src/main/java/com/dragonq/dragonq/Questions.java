package com.dragonq.dragonq;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Questions extends Activity {

    private ProgressDialog pDialog;

    private static String url = "http://echo.jsontest.com/Id/1/Content/Content/Comment/Comment/Answer/Answer/Tags/Tags";

    private static final String TAG_TAGS = "Tags";
    private static final String TAG_ANSWERS = "Answer";
    private static final String TAG_COMMENT = "Comment";
    private static final String TAG_ID = "Id";
    private static final String TAG_CONTENT = "Content";

    JSONArray question = null;

    Question[] questionList;

    public class MyRun implements Runnable{
        @Override
        public void run() {
            try {
                questionList = new Package().getQuestion();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        final ListView list = (ListView) findViewById(R.id.lstQuestions);
        Thread thread = new Thread(new MyRun());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*questionList = new Question[2];
        questionList[0]=(new Question(1,"text"));
        questionList[1]=(new Question(2,"text"));*/
        ArrayAdapterItem adapter = new ArrayAdapterItem(this, R.layout.list_item,  questionList);



        // create a new ListView, set the adapter and item click listener



        list.setAdapter(adapter);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.questions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
