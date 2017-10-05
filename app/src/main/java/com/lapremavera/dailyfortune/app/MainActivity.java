package com.lapremavera.dailyfortune.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lapremavera.dailyfortune.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyPreferences pref = new MyPreferences(MainActivity.this);
        if (!pref.isFirstTime()) {
            Intent i = new Intent(getApplicationContext(),FortuneActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(i);
            finish();
        }
        Button btn_startService = (Button) findViewById(R.id.button2);
        final Intent serviceIntent = new Intent(MainActivity.this, BackgroundService.class);
        btn_startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(serviceIntent);
            }
        });

        Button btn_stopService =(Button) findViewById(R.id.button3);
        btn_stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(serviceIntent);

            }
        });
    }
    public void SaveUserName(View v) {
        EditText username = (EditText) findViewById(R.id.EditText);
        MyPreferences pref = new MyPreferences(MainActivity.this);
        pref.setUsername(username.getText().toString().trim());
        Intent i = new Intent(getApplicationContext(),FortuneActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);
        finish();
    }

}
