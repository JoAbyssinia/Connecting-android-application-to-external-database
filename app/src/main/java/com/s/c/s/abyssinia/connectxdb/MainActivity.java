package com.s.c.s.abyssinia.connectxdb;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.*;

public class MainActivity extends AppCompatActivity {
    private static final int EDIT_ID = 0;
    Button btn;

    String color,trys;
    TextView ring, list, check, vibe, dcheck, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.pre);
        check = (TextView) findViewById(R.id.chid);
        ring = (TextView) findViewById(R.id.ringId);
        vibe = (TextView) findViewById(R.id.vbid);
        dcheck = (TextView) findViewById(R.id.detail);
        name = (TextView) findViewById(R.id.name);
        list = (TextView) findViewById(R.id.list);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(i);
            }
        });

        assert name != null;
        name.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(MainActivity.this, "hi am in touching " + name.getText().toString(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }

    @Override
    protected void onResume() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        check.setText(Boolean.valueOf(pref.getBoolean("checkbox", false)).toString());
        if (check.getText().toString().equalsIgnoreCase("true")) {
            Toast.makeText(MainActivity.this, check.getText().toString(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "check off", Toast.LENGTH_SHORT).show();
        }

        ring.setText(pref.getString("ringtone", "<unset>"));
        vibe.setText(Boolean.valueOf(pref.getBoolean("vibrate", false)).toString());
        dcheck.setText(Boolean.valueOf(pref.getBoolean("checkbox2", false)).toString());
        name.setText(pref.getString("editText", "<unset>"));
        list.setText(pref.getString("list", "<unset>"));
        color = pref.getString("color", "<unselected>");

        if (color.equalsIgnoreCase("red")) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#E0201B"));
        } else if (color.equalsIgnoreCase("black")) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#000000"));
        } else if (color.equalsIgnoreCase("green")) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#3AD42D"));
        } else if (color.equalsIgnoreCase("blue")) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#0081c8"));
        } else {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#ffffff"));
        }

        if (list.getText().toString().equalsIgnoreCase("phl")) {
            list.setBackgroundColor(Color.parseColor("#126123"));
        } else {
            list.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, EDIT_ID, Menu.NONE, "edit pref")
                .setIcon(R.drawable.ic_sync_black_24dp)
                .setAlphabeticShortcut('e');
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case EDIT_ID:
                startActivity(new Intent(this, PreferenceTry.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
