package net.net23.freeismail.oupapers12;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;

public class first extends Activity
{
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        //Firebase
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "id");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "name");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        getSharedPreferences("1.8.8", MODE_PRIVATE).edit().putString("1.8.8", "1.8.8").commit();
        final TextView bb;
        bb=(TextView)findViewById(R.id.started);
        bb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getSharedPreferences("Name",MODE_PRIVATE).edit().putString("Name","Name3").commit();
                bb.setBackgroundResource(R.drawable.clickedbackground);
                startActivity(new Intent(first.this,MainActivity.class));
                overridePendingTransition(R.anim.rightin,R.anim.leftout);
            }
        });
    }
    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event)
    {
        if ((KeyCode == KeyEvent.KEYCODE_BACK))
        {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            {
                finishAffinity();
            }
            else
                System.exit(0);
        }
        return super.onKeyDown(KeyCode, event);
    }
}
