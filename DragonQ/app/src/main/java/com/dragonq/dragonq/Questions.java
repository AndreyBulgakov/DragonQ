package com.dragonq.dragonq;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;

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
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        final ListView list = (ListView) findViewById(R.id.lstQuestions);
        questionList = new Question[2];
        questionList[0]=(new Question(1,"text"));
        questionList[1]=(new Question(2,"text"));
        ArrayAdapterItem adapter = new ArrayAdapterItem(this, R.layout.list_item,  questionList);



        // create a new ListView, set the adapter and item click listener



        list.setAdapter(adapter);

        list.setClickable(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Question question = (Question) list.getItemAtPosition(position);
                Intent intent = new Intent(Questions.this, QuestionView.class);
                intent.putExtra("id", question.id);
                intent.putExtra("content", question.content);
                intent.putExtra("answer", question.answer);
                intent.putExtra("tags", question.tags);
                intent.putExtra("comment", question.comment);
                startActivity(intent);
    /* write you handling code like...
    String st = "sdcard/";
    File f = new File(st+o.toString());
    // do whatever u want to do with 'f' File object
    */
            }
        });

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
