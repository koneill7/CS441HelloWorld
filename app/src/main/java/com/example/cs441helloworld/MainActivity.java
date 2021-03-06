package com.example.cs441helloworld;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView fullGrown;
    Button helloButton;
    ImageView helloPuppy;
    ImageView helloDog;
    Button feedPuppy;
    boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        helloButton = (Button) findViewById(R.id.hello_button);
        feedPuppy = (Button) findViewById(R.id.feed_puppy);
        helloPuppy = (ImageView)findViewById(R.id.hello_image);
        helloDog = (ImageView)findViewById(R.id.dog_image);
        fullGrown = (TextView) findViewById(R.id.full_grown);

    }
    public void onHelloClick(View view){
        if(clicked == false){
            helloPuppy.setVisibility(View.VISIBLE);
            clicked = true;
        }
        feedPuppy.setVisibility(View.VISIBLE);


    }
    public void onFeedClick(View view){

            if(helloPuppy.getLayoutParams().height >= 500){
                helloDog.setVisibility(View.VISIBLE);
                helloPuppy.setVisibility(View.INVISIBLE);
                fullGrown.setVisibility(View.VISIBLE);
            }
            else{
                helloPuppy.getLayoutParams().height = helloPuppy.getLayoutParams().height + 50;
                helloPuppy.getLayoutParams().width = helloPuppy.getLayoutParams().width + 50;
                helloPuppy.requestLayout();
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}