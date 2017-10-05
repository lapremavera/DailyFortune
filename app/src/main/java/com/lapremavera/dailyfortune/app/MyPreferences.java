package com.lapremavera.dailyfortune.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.lapremavera.dailyfortune.R;

public class MyPreferences {


    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "DailyFortune";
    private static final String IS_FIRSTTIME = "IsFirstTime";
    public static final String Username = "name";


    public MyPreferences(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public boolean isFirstTime() {
        return pref.getBoolean(IS_FIRSTTIME, true);
    }

    public void setOld(boolean b) {
        if (b) {
            editor.putBoolean(IS_FIRSTTIME, false);
            editor.commit();
        }

    }
    public String getUsername() {
        return pref.getString(Username, "");
    }
    public void setUsername(String name) {
        editor.putString(Username, name);
        editor.commit();
    }




}
