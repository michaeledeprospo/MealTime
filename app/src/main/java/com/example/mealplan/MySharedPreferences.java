package com.example.mealplan;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {
    private static MySharedPreferences sSharedPrefs;
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;

    private MySharedPreferences(Context context) {
        mPref = context.getSharedPreferences("NAME", Context.MODE_PRIVATE);
    }


    public static MySharedPreferences getInstance(Context context) {
        if (sSharedPrefs == null) {
            sSharedPrefs = new MySharedPreferences(context.getApplicationContext());
        }
        return sSharedPrefs;
    }
    public void putString(String key, String val) {
        mEditor = mPref.edit();
        mEditor.putString(key, val);
        mEditor.commit();
    }
    public String getString(String key) {
        return mPref.getString(key, "defaultValue");
    }
}
