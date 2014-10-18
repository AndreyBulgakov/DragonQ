package com.dragonq.dragonq;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;


public class MainScreen extends Activity {

    String js;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_screen);
        final Button button = (Button) findViewById(R.id.btnGetQuestion);
        text= (EditText) findViewById(R.id.editText4);
        Thread thread = new Thread(new MyRan());
        thread.start();

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //Intent intent = new Intent(MainScreen.this, Questions.class);
                //startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
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

    public class MyRan implements Runnable{
        @Override
        public void run() {
            try {
                js = new Package().getQuestion().iterator().next().content;
                text.setText("Wait");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
