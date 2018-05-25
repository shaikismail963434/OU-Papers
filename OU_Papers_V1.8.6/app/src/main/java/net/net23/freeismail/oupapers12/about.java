package net.net23.freeismail.oupapers12;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class about extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        final  TextView more =(TextView)findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                more.setBackgroundResource(R.drawable.clickedbackground);
                Handler han=new Handler();
                han.postDelayed(new Runnable() {
                    @Override
                    public void run()
                    {
                        more.setBackgroundResource(R.drawable.background);
                    }
                },600);
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/developer?id=coolbase")));
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
                finish();
                startActivity(new Intent(about.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
        }
        return false;
    }
}
