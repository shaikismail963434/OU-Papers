package net.net23.freeismail.oupapers12;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class see extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see);
        getSharedPreferences("ACTIVE1", MODE_PRIVATE).edit().putBoolean("ACTIVE1", false).commit();
        String down=getSharedPreferences("SEE",MODE_PRIVATE).getString("SEE","");
        String menu1=getSharedPreferences("MENU1", MODE_PRIVATE).getString("MENU1","");
        if(!menu1.equals(""))
        {
            if(menu1.equals("CSE"))
            down="CSE11";
            else if(menu1.equals("IT"))
            down="IT";
            else if(menu1.equals("AE"))
                down="AE";
            else if(menu1.equals("ECE"))
                down="ECE";
            else if(menu1.equals("EEE"))
                down="EEE";
            else if(menu1.equals("MEC"))
                down="MEC";
            else if(menu1.equals("CE"))
                down="CE";
            else if(menu1.equals("INS"))
                down="INS";
            else if(menu1.equals("PRO"))
                down="PRO";
            if(!isMyServiceRunning(service.class))
            getSharedPreferences("MENU1", MODE_PRIVATE).edit().putString("MENU1","").commit();
        }
            if (down.startsWith("CSE"))
                getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "CSE").commit();
            else if (down.startsWith("IT"))
                getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "IT").commit();
            else if (down.startsWith("MEC"))
                getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "MEC").commit();
            else if (down.startsWith("ECE"))
                getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "ECE").commit();
            else if (down.startsWith("EEE"))
                getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "EEE").commit();
            else if (down.startsWith("AE"))
                getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "AE").commit();
            else if (down.startsWith("PRO"))
                getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "PRO").commit();
            else if (down.startsWith("INS"))
                getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "INS").commit();
            else if (down.startsWith("CE"))
                getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "CE").commit();
        startActivity(new Intent(see.this,pack.class));
    }

    private boolean isMyServiceRunning(Class<?> serviceClass)
    {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE))
        {
            if (serviceClass.getName().equals(service.service.getClassName()))
            {
                return true;
            }
        }
        return false;
    }
}
