package com.s.c.s.abyssinia.connectxdb;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ${yohannes} on 07/03/2018.
 */
public class PreferenceTry extends PreferenceActivity {
    String trys;
    Button btn ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        trys = pref.getString("list","select");
        btn = new Button(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(trys.isEmpty())){
                    Toast.makeText(PreferenceTry.this, "intent is work", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
