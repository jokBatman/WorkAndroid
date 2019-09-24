package com.kr.jok.animationtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final LinearLayout layer=findViewById(R.id.layer);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
               n++;
               LinearLayout.LayoutParams param=new LinearLayout.LayoutParams(
                       LinearLayout.LayoutParams.WRAP_CONTENT,
                       LinearLayout.LayoutParams.WRAP_CONTENT
               );
                Button btn=new Button(MainActivity.this);
                btn.setText("Button"+n);
                if(n%2==0) {
                    param.gravity=Gravity.START;
                    layer.addView(btn, 0, param);
                    TranslateAnimation ani=new TranslateAnimation(0,0,layer.getHeight(),0);
                   // TranslateAnimation ani=new TranslateAnimation(layer.getWidth(),0,0,0);
                    ani.setDuration(1000);
                   // btn.setAnimation(ani);
                    btn.startAnimation(ani);
                }
                else {
                    param.gravity=Gravity.END;
                    layer.addView(btn, 0, param);
                    TranslateAnimation ani=new TranslateAnimation(0,0,layer.getHeight(),0);
                  // TranslateAnimation ani=new TranslateAnimation(-layer.getWidth(),0,0,0);
                    ani.setDuration(1000);
                    btn.setAnimation(ani);
                }
            }
        });
        //int size=getResources().getDimensionPixelSize(R.)
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
