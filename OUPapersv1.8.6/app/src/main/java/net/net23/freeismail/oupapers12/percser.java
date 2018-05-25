package net.net23.freeismail.oupapers12;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;


import java.io.File;

public class percser extends Service
{
        @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        looper();
        return START_STICKY;
    }
    private void looper()
    {
                    if (!isMyServiceRunning(service.class))
                    {
                        final File file = new File("/data/data/net.net23.freeismail.oupapers12");
                        final File[] filearray = file.listFiles();
                        for (int ll = 0; ll < filearray.length; ll++)
                        {
                            if (filearray[ll].getName().endsWith(".zip"))
                            {
                                filearray[ll].delete();
                            }
                        }

                        if(!getSharedPreferences("ERROR",MODE_PRIVATE).getString("ERROR","").equals("ERROR"))
                        {
                            final NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                            Handler han = new Handler();
                            han.postDelayed(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    noti1.cancel(1);
                                }
                            }, 70);
                        }
                        stopSelf();
                }
                else
                    {
                        Handler han = new Handler();
                        han.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                looper();
                            }
                        }, 500);
                    }
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
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
