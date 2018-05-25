package net.net23.freeismail.oupapers12;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                if (getSharedPreferences("Name", MODE_PRIVATE).getString("Name", "").equals(""))
                {
                    startActivity(new Intent(MainActivity.this, first.class));
                    finish();
                }
                else
                {
                    getSharedPreferences("ACTIVE1", MODE_PRIVATE).edit().putBoolean("ACTIVE1", false).commit();
                    getSharedPreferences("PAP", MODE_PRIVATE).edit().putBoolean("PAP", false).commit();
                    getSharedPreferences("LEN", MODE_PRIVATE).edit().putString("LEN", "").commit();
                    startActivity(new Intent(MainActivity.this, HighActivity.class));
                    finish();
                }
            }
        });
    }
}