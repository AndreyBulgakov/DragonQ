package com.dragonq.dragonq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class QuestionView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_view);
        final TextView txtId = (TextView) findViewById(R.id.txtId);
        final TextView txtContent = (TextView) findViewById(R.id.txtContent);
        final TextView txtAnswer = (TextView) findViewById(R.id.txtAnswer);
        final TextView txtTags = (TextView) findViewById(R.id.txtTags);
        final TextView txtComment = (TextView) findViewById(R.id.txtComment);
        Intent intent = getIntent();

        String id = intent.getStringExtra("id");
        txtId.setText(id);
        String content = intent.getStringExtra("content");
        txtContent.setText(content);
        String answer = intent.getStringExtra("answer");
        txtContent.setText(content);
        String tags = intent.getStringExtra("tags");
        txtContent.setText(content);
        String comment = intent.getStringExtra("comment");
        txtContent.setText(content);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.question_view, menu);
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
