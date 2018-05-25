package net.net23.freeismail.oupapers12;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;

import android.os.Environment;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class service extends Service
{
    private static String file1=null;
    private long total;
    private int lenghtOfFile=10083899  ;
    private FileOutputStream output;
    private InputStream input;
    private String ur,file;
    private String data1;
    private DownloadFileFomURL a;
    private String year;
    @Override
    public int onStartCommand(Intent intent1, int flags, int startId)
    {
        String down=getSharedPreferences("DOWN",MODE_PRIVATE).getString("DOWN", "");
        getSharedPreferences("SEE",MODE_PRIVATE).edit().putString("SEE",down).commit();
        getSharedPreferences("ERROR", MODE_PRIVATE).edit().putString("ERROR", "").commit();
        startService(new Intent(service.this,percser.class));
        a=new DownloadFileFomURL();
        if(down.length()==9)
        {
         year= down.substring(0,3)+down.charAt(4)+down.charAt(8);
        }
        else  if(down.length()==8)
        {
            year= down.substring(0,2)+down.charAt(3)+down.charAt(7);
        }
        else if(down.length()==4)
        {
            year=down.substring(0,2)+down.charAt(3);
        }
        if(year.equals("BE11"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1LyFayambrAADlOgt1Z6stuL19m1xDWBr";
            file = "BE11";
            lenghtOfFile= 32434183      ;
        }

        //AE
        else if (year.equals("AE12"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1WEXFgfedJQ_vylC0An-P04F-81jv_W0h";
            file = "AE12";
            lenghtOfFile= 8996161    ;
        }
        else if(year.equals("AE21"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1VPYI3NvqUJ2ePIpPbHa3siQ41AAN8BBp";
            file = "AE21";
            lenghtOfFile=  25034331      ;
        }
        else if(year.equals("AE22"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1864VOV1l5rR4kMN10agqcHikhlz9f0Nt";
            file = "AE22";
            lenghtOfFile= 25343752      ;
        }
        else if(year.equals("AE31"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1rAodPrlmLn65afcdRxIW6Lgp7FQGl8MF";
            file = "AE31";
            lenghtOfFile=29731582    ;
        }
        else if(year.equals("AE32"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1HT9ABtaKGUmtXbumYhhTepZiwH1TERvD";
            file = "AE32";
            lenghtOfFile= 29826451     ;
        }
        else if(year.equals("AE41"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1IhrlGIU1ZKb7lx2cuuPrlnkE4mnxGOTJ";
            file = "AE41";
            lenghtOfFile=28253032         ;
        }
        else if(year.equals("AE42"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1BvdhfcIVUzYqAZPrwW1ffpD4WZ9KuaJl";
            file = "AE42";
            lenghtOfFile= 7553964       ;
        }

        //CE
        else if (year.equals("CE12"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1pknOL7sQEbsK7ihHCdth2ozGiB8uLww5";
            file = "CE12";
            lenghtOfFile= 8996161  ;
        }
        else if(year.equals("CE21"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1Sbsv9715TuBX3qFdj5bNSd5ZkSIB9IXx";
            file = "CE21";
            lenghtOfFile=32925872      ;
        }
        else if(year.equals("CE22"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1V6pOe7GQZTz_Doi91MZ8fP5Q1w9vAJuY";
            file = "CE22";
            lenghtOfFile=26132438     ;

        }
        else if(year.equals("CE31"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1gKfOhDne3hsTQHL_XFH_kX0mYp8_glIJ";
            file = "CE31";
            lenghtOfFile=38262703    ;
        }
        else if(year.equals("CE32"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1t_9nlkW_Qp0Arp-tnoIAkCRxNtxTwBFG";
            file = "CE32";
            lenghtOfFile=40283275      ;
        }
        else if(year.equals("CE41"))
        {
            ur = "https://docs.google.com/uc?export=download&id=19kNnX2E-Bf-uPWn9sz_nuYVhd7jzfLsg";
            file = "CE41";
            lenghtOfFile= 52221661    ;
        }
        else if(year.equals("CE42"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1e1Wjfti66Xyg6gU5EX5ADJBR5W_1dovI";
            file = "CE42";
            lenghtOfFile= 28107658      ;
        }

        //CSE
        else if (year.equals("CSE12"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1xsq9ivYsRtU2kDIKuI9W3tXhU-nuPUId";
            file = "CSE12";
            lenghtOfFile= 11844997     ;
        }
        else if(year.equals("CSE21"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1Y5twwZs-IpbFKm3YrfHzfXTEx26yDie8";
            file = "CSE21";
            lenghtOfFile= 25728029      ;
        }
        else if(year.equals("CSE22"))
        {
            ur ="https://docs.google.com/uc?export=download&id=194otDu-ZUPQvv1ZN9ZwDxLJPr2rEUBCU";
            file = "CSE22";
            lenghtOfFile=31973290      ;
        }
        else if(year.equals("CSE31"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1f-VfdxRo4LYUf1VnjsfX0DUVrZSxerQF";
            file = "CSE31";
            lenghtOfFile= 25308247     ;
        }
        else if(year.equals("CSE32"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1lK7zMQtNf9bRg_GBuXUnLuU8b2UGvDki";
            file = "CSE32";
            lenghtOfFile= 34842726         ;
        }
        else if(year.equals("CSE41"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1nUcYi6B3cIAWvkVSRZiTE0-Mf0PJqrXC";
            file = "CSE41";
            lenghtOfFile= 20335139    ;
        }
        else if(year.equals("CSE42"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1Oi4I43rvUYUldo8yGPmy5G28KA8Lx8WX";
            file = "CSE42";
            lenghtOfFile=30215305    ;
        }

        //ECE
        else if (year.equals("ECE12"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1PM1rLooM-WrKn-DOYvncWtsCDQpfeF77";
            file = "ECE12";
            lenghtOfFile=9172850      ;
        }
        else if(year.equals("ECE21"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1l968-JFlASTeZ6KM5Pw3qI1eRytGxvxy";
            file = "ECE21";
            lenghtOfFile=34436986      ;
        }
        else if(year.equals("ECE22"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1kPCS5g6ZDdExqzgkuudn0ajwTV3l-WH1";
            file = "ECE22";
            lenghtOfFile=22874112    ;
        }
        else if(year.equals("ECE31"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1NvmOVJR5Rk9htcfgzpTXe7w-1agEObl_";
            file = "ECE31";
            lenghtOfFile= 23085411      ;
        }
        else if(year.equals("ECE32"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1x3YUP2pRoGXXRU6npgUMIhl52eBOwbwi";
            file = "ECE32";
            lenghtOfFile= 23995797      ;
        }
        else if(year.equals("ECE41"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1TnPQkUB4D4NXahAqmZ_ZwqrLQlBw-F1E";
            file = "ECE41";
            lenghtOfFile=   34965179    ;
        }
        else if(year.equals("ECE42"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1TJ0hIQCKGRbau5c0cIYl2TserzgproWu";
            file = "ECE42";
            lenghtOfFile=  25796731     ;
        }

        //EEE
        else if (year.equals("EEE12"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1d6wBIM9YhlRJ1IBLSDounBHRP7MNOPX6";
            file = "EEE12";
            lenghtOfFile= 8553094      ;
        }
        else if(year.equals("EEE21"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1r6Q79sMCMykTHWNci2u7BiD95eSqdyEf";
            file = "EEE21";
            lenghtOfFile= 28236926      ;
        }
        else if(year.equals("EEE22"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1CJ3ZuxY8X-e5yP_jkAxATAORBrOvwhay";
            file = "EEE22";
            lenghtOfFile= 33039379      ;
        }
        else if(year.equals("EEE31"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1EKwPBW3Rwxsjj4EfyjFsWyMBSlvflnmJ";
            file = "EEE31";
            lenghtOfFile= 32346585     ;
        }
        else if(year.equals("EEE32"))
        {
            ur = "https://docs.google.com/uc?export=download&id=15JjEOwYRosb3VSTNPRbdX-IzoSEXOgBx";
            file = "EEE32";
            lenghtOfFile= 26188482      ;
        }
        else if(year.equals("EEE41"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1QEVTxd6FKghftk3YV7YDDJd7CCdibVSa";
            file = "EEE41";
            lenghtOfFile= 34434078        ;
        }
        else if(year.equals("EEE42"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1XUc6TGmiGsA-ftRfi5DnL5P1Cmq4kIQX";
            file = "EEE42";
            lenghtOfFile=23389178       ;
        }

        //INS
        else if (year.equals("INS12"))
        {

            ur = "https://docs.google.com/uc?export=download&id=1RnAksnjPWIRMvwABpCwUjTKqICU-M5RP";
            file = "INS12";
            lenghtOfFile= 8553094   ;
        }
        else if(year.equals("INS21"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1KvaZ3M7tpfScDinCShW1Vs9QvwHg6r1u";
            file = "INS21";
            lenghtOfFile=21111582     ;
        }
        else if(year.equals("INS22"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1DqZtzstyPgryUGKAmS6KxYEzWLQIQoJr";
            file = "INS22";
            lenghtOfFile= 23599852     ;
        }
        else if(year.equals("INS31"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1nHersvk0s4LYXfztdl5qs5f8KSs21f2-";
            file = "INS31";
            lenghtOfFile=16714612     ;
        }
        else if(year.equals("INS32"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1aFKpiW0KzB42AzYK-gEf8XHCuGw-tQCZ";
            file = "INS32";
            lenghtOfFile=17005888      ;
        }
        else if(year.equals("INS41"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1la172yC3OTYYedyyi3mIwY1Fel9H63N2";
            file = "INS41";
            lenghtOfFile= 7306131       ;
        }
        else if(year.equals("INS42"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1sFN2eLsRZSjzfpQP_A0tPBJfrDxizRmf";
            file = "INS42";
            lenghtOfFile=  9289535    ;
        }
        //IT
        else if (year.equals("IT12"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1V6Hotm4NWhast5xGfitthRbHYKyDKNFP";
            file = "IT12";
            lenghtOfFile= 11844941        ;
        }
        else if(year.equals("IT21"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1iKXUoP5jzqP0j6M_mcNtQJx0S9JjiCuE";
            file = "IT21";
            lenghtOfFile=26819265   ;
        }
        else if(year.equals("IT22"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1yms111xxst8sKsdQH4zukrUugy5uyByP";
            file = "IT22";
            lenghtOfFile=26673581       ;
        }
        else if(year.equals("IT31"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1EI-J3M9TVgzFr7GABPo1pbXfheJRQfqL";
            file = "IT31";
            lenghtOfFile=29311632   ;
        }
        else if(year.equals("IT32")) {
            ur = "https://docs.google.com/uc?export=download&id=1tqsSo7HxiA06HBzn8e4qCxykYTxNx2D0";
            file = "IT32";
            lenghtOfFile =34357486      ;
        }
        else if(year.equals("IT41"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1SKYwgqgV39tGB2dve6I35H9CI0KVmB8B";
            file = "IT41";
            lenghtOfFile=27968429    ;
        }
        else if(year.equals("IT42"))
        {
            ur = "https://docs.google.com/uc?export=download&id=16IkHhnrh4U8r0Oz8S89lBcjBvipb7os5";
            file = "IT42";
            lenghtOfFile=20475684     ;
        }

        //MEC
        else if (year.equals("MEC12"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1kqWQaaOx7Gsz1n7jNuM6_DW9k1rYziOr";
            file = "MEC12";

            lenghtOfFile=  8996203     ;
        }
        else if(year.equals("MEC21"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1rfRWJ6YKmuKakKTNBNFbrxS5RQ0zdswR";
            file = "MEC21";
            lenghtOfFile= 24355271       ;
        }
        else if(year.equals("MEC22"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1uoOPJ1aNlJCMru5DqhH8iGTBfQx-EmSL";
            file = "MEC22";
            lenghtOfFile= 25055630    ;
        }
        else if(year.equals("MEC31"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1aNqsedmcsoKVQJ_B678Oo7x9psoqdckZ";
            file = "MEC31";
            lenghtOfFile= 25773346    ;
        }
        else if(year.equals("MEC32"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1yWZArdd2VrgUIW0P_yrxdSEeXabEzXpJ";
            file = "MEC32";
            lenghtOfFile= 31243752    ;
        }
        else if(year.equals("MEC41"))
        {
            ur = "https://docs.google.com/uc?export=download&id=15RL3AGcogO2VQtuoRgcmZH0ow3Bp9ZoT";
            file = "MEC41";
            lenghtOfFile=32367171      ;
        }
        else if(year.equals("MEC42"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1cKSRq3AaKL5vz9t99mcPdce9Ph0j9j0J";
            file = "MEC42";
            lenghtOfFile=9630298      ;
        }

        //PRO
        else if (year.equals("PRO12"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1DNxScY1QoAbt78dg2IhLQj0r6DO1xRs7";
            file = "PRO12";
            lenghtOfFile=8996203     ;
        }
        else if(year.equals("PRO21"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1zRbSLRaB95V74YevVO4CLdB2lrlHEmMD";
            file = "PRO21";
            lenghtOfFile= 25043340    ;
        }
        else if(year.equals("PRO22"))
        {
            ur ="https://docs.google.com/uc?export=download&id=17i4b_jEWcE9O5WAfB2jzJFScf8JWZ63k";
            file = "PRO22";
            lenghtOfFile= 23496636      ;
        }
        else if(year.equals("PRO31"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1y-xAEoObuqpHgyahiyIsUwlbpj4rUisJ";
            file = "PRO31";
            lenghtOfFile=25440289     ;
        }
        else if(year.equals("PRO32"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1vu4DjPZBNaVPXEbJ56GdgK49F6w_YRI1";
            file = "PRO32";
            lenghtOfFile=21270472         ;
        }
        else if(year.equals("PRO41"))
        {
            ur ="https://docs.google.com/uc?export=download&id=1KYvLCmQZibHinWHn0UH-B6KSM4RvvXs0";
            file = "PRO41";
            lenghtOfFile=31583582    ;
        }
        else if(year.equals("PRO42"))
        {
            ur = "https://docs.google.com/uc?export=download&id=1IECHJrv6ea3TXRtvXe9YzlDp7N0vIfUQ";
            file = "PRO42";
            lenghtOfFile=10038351       ;
        }
        new DownloadFileFomURL().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        return super.START_NOT_STICKY;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
    public class DownloadFileFomURL extends AsyncTask<String,Void, Long>
    {
        @Override
        protected Long doInBackground(String... f_url)
        {
            int kk=0;
            int count;
            try
            {
                file1=file;
                URL url = new URL(ur);
                URLConnection conection = url.openConnection();
                conection.setConnectTimeout(15000);
                conection.setReadTimeout(15000);
                conection.connect();
                input = new BufferedInputStream(url.openStream(), 8192);
                data1="/data/data/net.net23.freeismail.oupapers12/";
                getSharedPreferences("ROOT",MODE_PRIVATE).edit().putString("ROOT",data1+file+".zip").commit();
                getSharedPreferences("ROOT1",MODE_PRIVATE).edit().putString("ROOT1","/data/data/net.net23.freeismail.oupapers12").commit();
                output = new FileOutputStream(data1+file+".zip");
                byte data[] = new byte[1024];
                total = 0;


                while ((count = input.read(data)) != -1&&kk!=1)
                {
                    //Log.d("while",""+kk);
                    if(getSharedPreferences("STOP",MODE_PRIVATE).getString("STOP","").equals("STOP"))
                    {
                       // Log.d("STopped","Stopped");
                        File delete=new File(data1+file+".zip");
                        delete.delete();
                        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        noti1.cancel(0);
                        kk=1;
                        getSharedPreferences("PERC",MODE_PRIVATE).edit().putString("PERC","").commit();
                        output.flush();
                        output.close();
                       // Log.d("here1","here1");
                        if(input!=null)
                        {
                          //  Log.d("Not","null");
                            //input.close();
                        }
                        a.cancel(true);
                        stopSelf();
                        getSharedPreferences("STOP",MODE_PRIVATE).edit().putString("STOP","").commit();
                        getSharedPreferences("MENU1", MODE_PRIVATE).edit().putString("MENU1","").commit();
                    }
                    else
                    {
                        total += count;
                       // Log.d("here2","here2");
                        output.write(data, 0, count);
                      //  Log.d("result", "" + (int) ((total * 100) / lenghtOfFile));
                    }
                    if((int) ((total * 100) / lenghtOfFile)<0)
                    {
                       // Log.d("less","less");
                        String con=getSharedPreferences("DOWN",MODE_PRIVATE).getString("DOWN","");
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(service.this);
                        builder.setSmallIcon(R.drawable.logo);
                        builder.setContentTitle(con+" papers");
                        builder.setContentText("Downloading terminated!!");
                        builder.setVibrate(new long[]{500, 500});
                        builder.setLights(Color.WHITE, 3000, 3000);
                        builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
                        Intent intent = new Intent(service.this, pack.class);
                        TaskStackBuilder stackBuil = TaskStackBuilder.create(service.this);
                        stackBuil.addParentStack(pack.class);
                        stackBuil.addNextIntent(intent);
                        PendingIntent pendingintnet = stackBuil.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                        builder.setContentIntent(pendingintnet);
                        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        noti1.notify(0, builder.build());
                        getSharedPreferences("ERROR", MODE_PRIVATE).edit().putString("ERROR", "ERROR").commit();
                    }
                    if((int) ((total * 100) / lenghtOfFile)==100)
                    {
                      unzip(new File(data1+file+".zip"),new File("/data/data/net.net23.freeismail.oupapers12"));
                        File delete=new File(data1+file+".zip");
                        delete.delete();
                        getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", ""+100).commit();
                    }
                    if((int) ((total * 100) / lenghtOfFile)!=100)
                    getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", "" + (int) ((total * 100) / lenghtOfFile)).commit();
                }
                if(kk!=1)
                {
                    output.flush();
                    output.close();
                   // Log.d("here","here");
                    if(input!=null)
                    {
                      //  input.close();
                    }
                    a.cancel(true);
                    stopSelf();
                }
            }
          /*  catch (ConnectionClosedException e)
            {
                //Log.d("CLoede","Closed");
                String con=getSharedPreferences("DOWN",MODE_PRIVATE).getString("DOWN","");
                NotificationCompat.Builder builder = new NotificationCompat.Builder(service.this);
                builder.setSmallIcon(R.drawable.logo);
                builder.setContentTitle(con+" papers");
                builder.setContentText("Request timed out!!");
                builder.setVibrate(new long[]{500, 500});
                builder.setLights(Color.WHITE, 3000, 3000);
                builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
                Intent intent = new Intent(service.this, pack.class);
                TaskStackBuilder stackBuil = TaskStackBuilder.create(service.this);
                stackBuil.addParentStack(pack.class);
                stackBuil.addNextIntent(intent);
                PendingIntent pendingintnet = stackBuil.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingintnet);
                NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                noti1.notify(0, builder.build());
            }*/
            catch (Exception e)
            {
              //  Log.d("Error",e.getMessage().toString());
                getSharedPreferences("MENU1", MODE_PRIVATE).edit().putString("MENU1","").commit();
                File delete=new File(data1+file+".zip");
                delete.delete();
                if(kk!=1)
                {
                    String con=getSharedPreferences("DOWN",MODE_PRIVATE).getString("DOWN","");
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(service.this);
                        builder.setSmallIcon(R.drawable.logo);
                    builder.setContentTitle(con+" papers");
                    builder.setContentText("Downloading terminated!!");
                    builder.setVibrate(new long[]{500, 500});
                    builder.setLights(Color.WHITE, 3000, 3000);
                    builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
                    Intent intent = new Intent(service.this, pack.class);
                    TaskStackBuilder stackBuil = TaskStackBuilder.create(service.this);
                    stackBuil.addParentStack(pack.class);
                    stackBuil.addNextIntent(intent);
                    PendingIntent pendingintnet = stackBuil.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                    builder.setContentIntent(pendingintnet);
                    NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    noti1.notify(0, builder.build());
                    try
                    {
                        output.flush();
                        output.close();
                        if(input!=null)
                        {
                            //  input.close();
                        }
                    }
                    catch(IOException e1)
                    {}
                    catch(Exception e3)
                    {}
                }
                stopSelf();
            }
            stopSelf();
            return null;
        }

    }

    public void unzip(File zipFile, File targetDirectory) throws IOException
    {
        ZipInputStream zis = new ZipInputStream(
                new BufferedInputStream(new FileInputStream(zipFile)));
        try
        {
            ZipEntry ze;
            int count;
            byte[] buffer = new byte[8192];
            while ((ze = zis.getNextEntry()) != null)
            {
                File file = new File(targetDirectory, ze.getName());
                File dir = ze.isDirectory() ? file : file.getParentFile();
                if (!dir.isDirectory() && !dir.mkdirs())
                    throw new FileNotFoundException("Failed to ensure directory: " +
                            dir.getAbsolutePath());
                if (ze.isDirectory())
                    continue;
                FileOutputStream fout = new FileOutputStream(file);
                try {
                    while ((count = zis.read(buffer)) != -1)
                        fout.write(buffer, 0, count);
                } finally {
                    fout.close();
                }
            }
        }
        finally
        {
            zis.close();
        }
    }
    @Override
    public void onTaskRemoved(Intent root)
    {

        stopSelf();
        super.onTaskRemoved(root);
    }
}

