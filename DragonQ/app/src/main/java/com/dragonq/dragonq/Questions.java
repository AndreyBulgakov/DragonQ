package com.dragonq.dragonq;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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
    ListView list;


    public class MyRun implements Runnable{
        String count;
        String tags;
        public MyRun(String count, String tags) {
            this.count = count.equals("")?"5":count;
            this.tags = tags.equals("")?"ЧГК":tags;
        }

        @Override
        public void run() {
            try {
                setList( new Package().getQuestion(count, tags));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Intent intent = getIntent();

        String count = intent.getStringExtra("count");
        String tags = intent.getStringExtra("tags");

        list = (ListView) findViewById(R.id.lstQuestions);
        Thread thread = new Thread(new MyRun(count, tags));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*questionList = new Question[2];
        questionList[0]=(new Question(1,"text"));
        questionList[1]=(new Question(2,"text"));*/


        list.setClickable(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Question question = (Question) list.getItemAtPosition(position);
                Intent intent = new Intent(Questions.this, QuestionView.class);
                intent.putExtra("id", question.Id);
                intent.putExtra("content", question.Content);
                intent.putExtra("answer", question.Answer);
                intent.putExtra("tags", question.Tags);
                intent.putExtra("comment", question.Comment);
                startActivity(intent);
    /* write you handling code like...
    String st = "sdcard/";
    File f = new File(st+o.toString());
    // do whatever u want to do with 'f' File object
    */
            }
        });

    }

    void setList( Question[] questions){
        Runnable doUpdateGUI = new Runnable() {
            public void run() {
                Context context = getApplicationContext();
                String msg = "Sorry! There is no such tags in our database or Internet connection failed";
                int duration = Toast.LENGTH_LONG;
                Toast.makeText(context, msg, duration).show();
            }
        };

        ArrayAdapterItem adapter = new ArrayAdapterItem(this, R.layout.list_item, questions);
        list.setAdapter(adapter);
        if( adapter.data == null || adapter.data.length <= 0){
            runOnUiThread(doUpdateGUI);
            Intent intent = new Intent(Questions.this, MainScreen.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.finish();
            startActivity(intent);
        }

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
