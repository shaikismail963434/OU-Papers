package net.net23.freeismail.oupapers12;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class HighActivity extends Activity
{
    private RelativeLayout r;
    private LinearLayout layout,papersmenu;
    private TextView github,paperstrans,shiftpapers,redownload1,nothing1,nothing,viewpackage,trans22,
            redownload,pack,delete,about,share,menubar,show,syallbm,paperm,top1,top2,top3,trans,
            transpa3,trans2, deleteNoti,deletGothca,shareNoti,shareGotcha,shareCancel,rateNoti,rateGotcha,
            rateCancel, top4,top5,top6,top7,top8,top9,top10,top11,top12,top13,top14,top15,top16,top17,top18,
            top19,top20;
    private ImageView arrow,shifter,menu,deletesub,delsubcancel;
    private Button one,two,three,four,five,six,seven,eight,nine,ten,ele,twe,thir,fourt,
            fifteen,sixteen,seventeen,eighteen,nineteen,twenty;
    private Animation anim,backanim,shakeleft,smalltobig;
    private ScrollView scroll;
    private View v;
    private Bitmap b;
    private String PapersFolder,status,folder,path,buff[] =new String [20],view1;
    private boolean done,dtwo,dthree,dfour,dfive,dsix,dseven,deight,dnine,dten,dele,dtwe,dthir,
            dfourt,dfifteen,dsixteen,dsventeen,deighteen,dnineten,dtwenty,active=false,pap=false,
            twof,fourf,sixf,eightf,tenf,twf,forf,sixteenf,eightteenf,twentyf,shaking,corres,
            deleted=false;
    private int shareno;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_activity);

        //Animations Intialization
        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);
        anim = AnimationUtils.loadAnimation(this, R.anim.flow);
        backanim = AnimationUtils.loadAnimation(this, R.anim.backanin);
        shakeleft = AnimationUtils.loadAnimation(this, R.anim.shakeleft);

                //Component Intialization
                top1 = (TextView) findViewById(R.id.top1);
                top2 = (TextView) findViewById(R.id.top2);
                top3 = (TextView) findViewById(R.id.top3);
                top4 = (TextView) findViewById(R.id.top4);
                top5 = (TextView) findViewById(R.id.top5);
                top6 = (TextView) findViewById(R.id.top6);
                top7 = (TextView) findViewById(R.id.top7);
                top8 =(TextView) findViewById(R.id.top8);
                top9 = (TextView)findViewById(R.id.top9);
                top10 =(TextView) findViewById(R.id.top10);
                top11 =(TextView) findViewById(R.id.top11);
                top12 = (TextView)findViewById(R.id.top12);
                top13 = (TextView)findViewById(R.id.top13);
                top14 = (TextView) findViewById(R.id.top14);
                top15 = (TextView)findViewById(R.id.top15);
                top16 = (TextView) findViewById(R.id.top16);
                top17 = (TextView)findViewById(R.id.top17);
                top18 = (TextView)findViewById(R.id.top18);
                top19 = (TextView) findViewById(R.id.top19);
                top20 = (TextView)findViewById(R.id.top20);

                deleteNoti=(TextView)findViewById(R.id.deleteNoti);
                deletGothca=(TextView)findViewById(R.id.deletGotcha);
                shareNoti=(TextView)findViewById(R.id.shareNoti);
                shareGotcha=(TextView)findViewById(R.id.shareGotcha);
                shareCancel=(TextView)findViewById(R.id.shareCancel);
                rateNoti=(TextView)findViewById(R.id.rateNoti);
                rateGotcha=(TextView)findViewById(R.id.rateGotcha);
                rateCancel=(TextView)findViewById(R.id.rateCancel);

                r =  (RelativeLayout)findViewById(R.id.activity_main);
                nothing1 =(TextView)  findViewById(R.id.nothing1);
                redownload1 =(TextView) findViewById(R.id.redownload1);
                redownload = (TextView)findViewById(R.id.redownload);
                show = (TextView)findViewById(R.id.textView7);
                trans22 =  (TextView)findViewById(R.id.trans22);
                arrow = (ImageView)findViewById(R.id.arrow);
                transpa3 =  (TextView)findViewById(R.id.transpa3);
                paperstrans = (TextView) findViewById(R.id.papertrans);
                paperm = (TextView) findViewById(R.id.papersm);
                syallbm = (TextView)findViewById(R.id.syalllm);
                shifter = (ImageView)findViewById(R.id.selectsyallbus);
                shiftpapers = (TextView) findViewById(R.id.syallusorpapers);
                papersmenu = (LinearLayout) findViewById(R.id.papersmenu);
                nothing =(TextView)findViewById(R.id.streamnotselected);
                viewpackage = (TextView) findViewById(R.id.feed);
                trans2 = (TextView) findViewById(R.id.transpa2);
                layout = (LinearLayout) findViewById(R.id.linear);
                one =  (Button)findViewById(R.id.button);
                two = (Button) findViewById(R.id.button1);
                three = (Button)findViewById(R.id.button2);
                four = (Button) findViewById(R.id.button3);
                five =(Button) findViewById(R.id.button4);
                six =(Button)findViewById(R.id.button5);
                seven = (Button) findViewById(R.id.button6);
                eight = (Button) findViewById(R.id.button7);
                nine = (Button) findViewById(R.id.button8);
                ten =  (Button)findViewById(R.id.button9);
                ele = (Button) findViewById(R.id.button10);
                twe =  (Button)findViewById(R.id.button11);
                thir = (Button) findViewById(R.id.button12);
                fourt =(Button)  findViewById(R.id.button13);
                fifteen =(Button)  findViewById(R.id.button14);
                sixteen = (Button) findViewById(R.id.button15);
                seventeen = (Button) findViewById(R.id.button16);
                eighteen =(Button)findViewById(R.id.button17);
                nineteen = (Button)findViewById(R.id.button18);
                twenty =  (Button)findViewById(R.id.button19);
                pack = (TextView)findViewById(R.id.pack1);
                github=(TextView)findViewById(R.id.github);
                about =(TextView)findViewById(R.id.aboutus1);
                trans = (TextView) findViewById(R.id.transpa);
                menu = (ImageView) findViewById(R.id.menu1);
                share =(TextView) findViewById(R.id.share);
                menubar =(TextView) findViewById(R.id.textView2);
                scroll = (ScrollView) findViewById(R.id.scroll);
                delete =  (TextView)findViewById(R.id.delete1);
                deletesub =(ImageView) findViewById(R.id.deletebutton);
                delsubcancel = (ImageView) findViewById(R.id.deletecancel);
                shareno=getSharedPreferences("SHARE1", MODE_PRIVATE).getInt("SHARE1", 1);


                //variable intialization
                final Handler han = new Handler();

                corres = false;
                done = false;
                dtwo = false;
                dthree = false;
                dfour = false;
                dfive = false;
                dsix = false;
                dseven = false;
                deight = false;
                dnine = false;
                dten = false;
                dele = false;
                dtwe = false;
                dthir = false;
                dfour = false;
                dfifteen = false;
                dsixteen = false;
                dsventeen = false;
                deighteen = false;
                dnineten = false;
                dtwenty = false;
                shaking = false;
                view1 = getSharedPreferences("VIEW", MODE_PRIVATE).getString("VIEW", "");
                deleted = getSharedPreferences("ANIM", MODE_PRIVATE).getBoolean("ANIM", false);
                status = getSharedPreferences("WHAT", MODE_PRIVATE).getString("WHAT", "");


                //Visibility settings
                nothing1.setVisibility(View.GONE);
                redownload1.setVisibility(View.GONE);
                trans22.setVisibility(View.GONE);
                paperstrans.setVisibility(View.GONE);
                shifter.setVisibility(View.GONE);
                shiftpapers.setVisibility(View.GONE);
                papersmenu.setVisibility(View.GONE);
                viewpackage.setVisibility(View.GONE);
                nothing.setVisibility(View.GONE);
                layout.setVisibility(View.GONE);
                one.setVisibility(View.GONE);
                two.setVisibility(View.GONE);
                three.setVisibility(View.GONE);
                four.setVisibility(View.GONE);
                five.setVisibility(View.GONE);
                six.setVisibility(View.GONE);
                seven.setVisibility(View.GONE);
                eight.setVisibility(View.GONE);
                nine.setVisibility(View.GONE);
                ten.setVisibility(View.GONE);
                ele.setVisibility(View.GONE);
                twe.setVisibility(View.GONE);
                thir.setVisibility(View.GONE);
                fourt.setVisibility(View.GONE);
                fifteen.setVisibility(View.GONE);
                sixteen.setVisibility(View.GONE);
                seventeen.setVisibility(View.GONE);
                eighteen.setVisibility(View.GONE);
                nineteen.setVisibility(View.GONE);
                twenty.setVisibility(View.GONE);
                trans2.setVisibility(View.GONE);
                delsubcancel.setVisibility(View.GONE);
                deletesub.setVisibility(View.GONE);
                trans.setVisibility(View.GONE);


                //Click Listeners
                redownload.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        active=false;
                        redownload.setClickable(false);
                        redownload.setBackgroundResource(R.drawable.clickedmenu);
                        han.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                redownload.setClickable(true);
                                redownload.setBackgroundColor(Color.WHITE);
                            }
                        }, 190);

                        if (isconnected(getBaseContext()))
                        {
                            if (!isMyServiceRunning(service.class))
                            {
                                active=false;
                                layout.startAnimation(backanim);
                                han.postDelayed(new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        layout.setVisibility(View.GONE);
                                    }
                                }, 190);
                                final String[] button = new String[1];
                                final String button1[] = new String[1];
                                String button2 = null, name2 = null;
                                final String[] name = {null};
                                final String ss = getSharedPreferences("VIEW", MODE_PRIVATE).getString("VIEW", "");
                                if (ss.length() == 9)
                                {
                                    button2 = ss.charAt(4) + " - " + ss.charAt(8);
                                    name2 = ss.substring(0, 3);
                                } else if (ss.length() == 8)
                                {
                                    button2 = ss.charAt(3) + " - " + ss.charAt(7);
                                    name2 = ss.substring(0, 2);
                                }
                                AlertDialog.Builder dialog = new AlertDialog.Builder(HighActivity.this);
                                dialog.setMessage("Are you sure?\n" + "Note: " + name2 + " " + button2
                                        + " package will be deleted and downloaded again");
                                final String finalName = name2;
                                final String finalButton = button2;
                                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i)
                                    {
                                        trans.setVisibility(View.GONE);
                                        final ProgressDialog dialog = new ProgressDialog(HighActivity.this);
                                        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                        dialog.setMessage("Processing please wait...");
                                        dialog.setIndeterminate(true);
                                        dialog.setCanceledOnTouchOutside(false);
                                        dialog.show();
                                        getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "").commit();
                                        if (ss.length() == 9) {
                                            button[0] = "" + ss.charAt(4);
                                            button1[0] = "" + ss.charAt(8);
                                            name[0] = ss.substring(0, 3);
                                        } else if (ss.length() == 8) {
                                            button[0] = "" + ss.charAt(3);
                                            button1[0] = "" + ss.charAt(7);
                                            name[0] = ss.substring(0, 2);
                                        }
                                            getSharedPreferences("EYE", MODE_PRIVATE).edit().putString(name[0] + " " + button[0] + " - " + button1[0], "").commit();
                                        File file = new File(PapersFolder);
                                        looper(file);
                                        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
                                        getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", "").commit();


                                        //start donwloading
                                        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                                        noti1.cancel(0);
                                        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", 0).commit();
                                        getSharedPreferences("MENU1", MODE_PRIVATE).edit().putString("MENU1", "").commit();
                                        getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", "ST").commit();
                                        getSharedPreferences("STOP", MODE_PRIVATE).edit().putString("STOP", "").commit();

                                        startService(new Intent(HighActivity.this, service.class));
                                        getSharedPreferences("DOWN", MODE_PRIVATE).edit().putString("DOWN", finalName
                                                + " " + finalButton).commit();
                                        if (finalButton.equals("1 - 1"))
                                        {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "1").commit();
                                        }
                                       else  if (finalButton.equals("1 - 2"))
                                        {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "2").commit();
                                        }
                                        else if (finalButton.equals("2 - 1"))
                                        {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "3").commit();
                                        } else if (finalButton.equals("2 - 2")) {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "4").commit();
                                        } else if (finalButton.equals("3 - 1")) {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "5").commit();
                                        } else if (finalButton.equals("3 - 2")) {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "6").commit();
                                        } else if (finalButton.equals("4 - 1")) {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "7").commit();
                                        } else if (finalButton.equals("4 - 2")) {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "8").commit();
                                        }
                                        if(!finalName.startsWith("BE"))
                                        getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", finalName).commit();
                                        Handler han = new Handler();
                                        han.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                one.setVisibility(View.GONE);
                                                two.setVisibility(View.GONE);
                                                three.setVisibility(View.GONE);
                                                four.setVisibility(View.GONE);
                                                five.setVisibility(View.GONE);
                                                six.setVisibility(View.GONE);
                                                seven.setVisibility(View.GONE);
                                                eight.setVisibility(View.GONE);
                                                nine.setVisibility(View.GONE);
                                                ten.setVisibility(View.GONE);
                                                ele.setVisibility(View.GONE);
                                                twe.setVisibility(View.GONE);
                                                thir.setVisibility(View.GONE);
                                                fourt.setVisibility(View.GONE);
                                                fifteen.setVisibility(View.GONE);
                                                sixteen.setVisibility(View.GONE);
                                                seventeen.setVisibility(View.GONE);
                                                eighteen.setVisibility(View.GONE);
                                                nineteen.setVisibility(View.GONE);
                                                twenty.setVisibility(View.GONE);
                                                viewpackage.setVisibility(View.VISIBLE);
                                                nothing.setVisibility(View.VISIBLE);
                                                menubar.setText("OU Papers");
                                                shifter.setVisibility(View.GONE);
                                                shiftpapers.setVisibility(View.GONE);
                                                dialog.cancel();
                                                startActivity(new Intent(HighActivity.this, pack.class));
                                                overridePendingTransition(R.anim.rightin, R.anim.leftout);
                                                Toast.makeText(getBaseContext(), "Downloading started", Toast.LENGTH_SHORT).show();
                                            }
                                        }, 1000);
                                    }
                                });
                                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i)
                                    {
                                        trans.setVisibility(View.GONE);
                                    }
                                });
                                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                    @Override
                                    public void onCancel(DialogInterface dialogInterface)
                                    {
                                        trans.setVisibility(View.GONE);
                                    }
                                });
                                final AlertDialog dialog1 = dialog.create();
                                dialog1.setOnShowListener(new DialogInterface.OnShowListener() {
                                    @Override
                                    public void onShow(DialogInterface dialogInterface) {
                                        dialog1.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                                        dialog1.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                                    }
                                });
                                dialog1.show();
                            }
                            else
                            {
                                active = false;
                                layout.startAnimation(backanim);
                                han.postDelayed(new Runnable()
                                {
                                    @Override
                                    public void run() {
                                        trans.setVisibility(View.GONE);
                                        layout.setVisibility(View.GONE);
                                    }
                                },190);
                                Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                            }
                        } else
                        {
                            active = false;
                            layout.startAnimation(backanim);
                            han.postDelayed(new Runnable()
                            {
                                @Override
                                public void run() {
                                    trans.setVisibility(View.GONE);
                                    layout.setVisibility(View.GONE);
                                }
                            },190);
                            Toast.makeText(getBaseContext(), "No network", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                deletGothca.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        deleteNoti.setVisibility(View.GONE);
                        deletGothca.setVisibility(View.GONE);
                        getSharedPreferences("FIRST",MODE_PRIVATE).edit().putString("FIRST","").commit();
                    }
                });
                shareGotcha.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        getSharedPreferences("SHARE1", MODE_PRIVATE).edit().putInt("SHARE1", 37).commit();
                        getSharedPreferences("SHAREL", MODE_PRIVATE).edit().putString("SHAREL", "").commit();
                        shareGotcha.setVisibility(View.GONE);
                        shareNoti.setVisibility(View.GONE);
                        shareCancel.setVisibility(View.GONE);
                        Toast.makeText(getBaseContext(),"Loading, please wait...",Toast.LENGTH_SHORT).show();
                        haveStoragePermission();
                    }
                });

                shareCancel.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        getSharedPreferences("SHARE1", MODE_PRIVATE).edit().putInt("SHARE1", 37).commit();
                        getSharedPreferences("SHAREL", MODE_PRIVATE).edit().putString("SHAREL", "").commit();
                        shareGotcha.setVisibility(View.GONE);
                        shareNoti.setVisibility(View.GONE);
                        shareCancel.setVisibility(View.GONE);
                    }
                });
                rateGotcha.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        getSharedPreferences("SHARE1", MODE_PRIVATE).edit().putInt("SHARE1", 101).commit();
                        getSharedPreferences("SHARER", MODE_PRIVATE).edit().putString("SHARER","" ).commit();
                        rateGotcha.setVisibility(View.GONE);
                        rateNoti.setVisibility(View.GONE);
                        rateCancel.setVisibility(View.GONE);
                        rateit();
                    }
                });
                rateCancel.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        getSharedPreferences("SHARE1", MODE_PRIVATE).edit().putInt("SHARE1", 101).commit();
                        getSharedPreferences("SHARER", MODE_PRIVATE).edit().putString("SHARER","" ).commit();
                        rateGotcha.setVisibility(View.GONE);
                        rateNoti.setVisibility(View.GONE);
                        rateCancel.setVisibility(View.GONE);
                    }
                });
                transpa3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
                    }
                });
                trans22.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                    }
                });
                paperstrans.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent)
                    {
                        pap=false;
                        paperstrans.setVisibility(View.GONE);
                        papersmenu.setVisibility(View.GONE);
                        return false;
                    }
                });
                paperm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        getSharedPreferences("FIRST", MODE_PRIVATE).edit().putString("FIRST", "Y").commit();
                        pap=false;
                        arrow.setVisibility(View.GONE);
                        transpa3.setVisibility(View.GONE);
                        show.setVisibility(View.GONE);
                        paperstrans.setVisibility(View.GONE);
                        paperm.setBackgroundResource(R.drawable.clickedmenu);
                        papersmenu.setVisibility(View.GONE);
                        if (!status.equals("PAPERS")) {
                            one.setVisibility(View.GONE);
                            two.setVisibility(View.GONE);
                            three.setVisibility(View.GONE);
                            four.setVisibility(View.GONE);
                            five.setVisibility(View.GONE);
                            six.setVisibility(View.GONE);
                            seven.setVisibility(View.GONE);
                            eight.setVisibility(View.GONE);
                            nine.setVisibility(View.GONE);
                            ten.setVisibility(View.GONE);
                            ele.setVisibility(View.GONE);
                            twe.setVisibility(View.GONE);
                            thir.setVisibility(View.GONE);
                            fourt.setVisibility(View.GONE);
                            fifteen.setVisibility(View.GONE);
                            sixteen.setVisibility(View.GONE);
                            seventeen.setVisibility(View.GONE);
                            eighteen.setVisibility(View.GONE);
                            nineteen.setVisibility(View.GONE);
                            twenty.setVisibility(View.GONE);
                            deleted = true;
                            status = "PAPERS";
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
                            shiftpapers.setText(" Papers ");
                            getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                            loadnames();
                        }
                    }
                });
                syallbm.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        getSharedPreferences("FIRST", MODE_PRIVATE).edit().putString("FIRST", "Y").commit();
                        pap=false;
                        arrow.setVisibility(View.GONE);
                        transpa3.setVisibility(View.GONE);
                        show.setVisibility(View.GONE);
                        paperstrans.setVisibility(View.GONE);
                        syallbm.setBackgroundResource(R.drawable.clickedmenu);
                        papersmenu.setVisibility(View.GONE);
                        if (!status.equals("SYLLABUS"))
                        {
                            one.setVisibility(View.GONE);
                            two.setVisibility(View.GONE);
                            three.setVisibility(View.GONE);
                            four.setVisibility(View.GONE);
                            five.setVisibility(View.GONE);
                            six.setVisibility(View.GONE);
                            seven.setVisibility(View.GONE);
                            eight.setVisibility(View.GONE);
                            nine.setVisibility(View.GONE);
                            ten.setVisibility(View.GONE);
                            ele.setVisibility(View.GONE);
                            twe.setVisibility(View.GONE);
                            thir.setVisibility(View.GONE);
                            fourt.setVisibility(View.GONE);
                            fifteen.setVisibility(View.GONE);
                            sixteen.setVisibility(View.GONE);
                            seventeen.setVisibility(View.GONE);
                            eighteen.setVisibility(View.GONE);
                            nineteen.setVisibility(View.GONE);
                            twenty.setVisibility(View.GONE);
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
                            deleted = true;
                            status = "SYLLABUS";
                            shiftpapers.setText("Syllabus");
                            getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "SYLLABUS").commit();
                            loadnames();
                        }
                    }
                });
                shifter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        getSharedPreferences("FIRST", MODE_PRIVATE).edit().putString("FIRST", "Y").commit();
                        pap=true;
                        done = false;
                        dtwo = false;
                        dthree = false;
                        dfour = false;
                        dfive = false;
                        dsix = false;
                        dseven = false;
                        deight = false;
                        dnine = false;
                        dten = false;
                        dele = false;
                        dtwe = false;
                        dthir = false;
                        dfour = false;
                        dfifteen = false;
                        dsixteen = false;
                        dsventeen = false;
                        deighteen = false;
                        dnineten = false;
                        dtwenty = false;
                        paperm.setBackgroundColor(Color.WHITE);
                        syallbm.setBackgroundColor(Color.WHITE);
                        viewer();
                    }
                });
                shiftpapers.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        getSharedPreferences("FIRST", MODE_PRIVATE).edit().putString("FIRST", "Y").commit();
                        pap=true;
                        done = false;
                        dtwo = false;
                        dthree = false;
                        dfour = false;
                        dfive = false;
                        dsix = false;
                        dseven = false;
                        deight = false;
                        dnine = false;
                        dten = false;
                        dele = false;
                        dtwe = false;
                        dthir = false;
                        dfour = false;
                        dfifteen = false;
                        dsixteen = false;
                        dsventeen = false;
                        deighteen = false;
                        dnineten = false;
                        dtwenty = false;
                        paperm.setBackgroundColor(Color.WHITE);
                        syallbm.setBackgroundColor(Color.WHITE);
                        viewer();
                    }
                });
                viewpackage.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                        getSharedPreferences("ACTIVE2",MODE_PRIVATE).edit().putBoolean("ACTIVE2",false).commit();
                        viewpackage.setBackgroundResource(R.drawable.clickedbackground);
                        startActivity(new Intent(HighActivity.this, pack.class));
                        overridePendingTransition(R.anim.rightin, R.anim.leftout);
                    }
                });
                redownload1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        redownload1.setBackgroundResource(R.drawable.clickedbackground);
                        han.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                redownload1.setBackgroundResource(R.drawable.background);
                            }
                        }, 100);
                        if (isconnected(getBaseContext()))
                        {
                            if (!isMyServiceRunning(service.class))
                            {
                                final String[] button = new String[1];
                                final String button1[] = new String[1];
                                String button2 = null, name2 = null;
                                final String[] name = {null};
                                final String ss = getSharedPreferences("VIEW", MODE_PRIVATE).getString("VIEW", "");
                                if (ss.length() == 9) {
                                    button2 = ss.charAt(4) + " - " + ss.charAt(8);
                                    name2 = ss.substring(0, 3);
                                } else if (ss.length() == 8) {
                                    button2 = ss.charAt(3) + " - " + ss.charAt(7);
                                    name2 = ss.substring(0, 2);
                                } else if (ss.length() == 4) {
                                    button2 = "1";
                                    name2 = "BE";
                                }
                                AlertDialog.Builder dialog = new AlertDialog.Builder(HighActivity.this);
                                dialog.setMessage("Are you sure?\n" + "Note: " + name2 + " " + button2
                                        + " package will be deleted and downloaded again");
                                final String finalName = name2;
                                final String finalButton = button2;
                                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i)
                                    {
                                        final ProgressDialog dialog = new ProgressDialog(HighActivity.this);
                                        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                        dialog.setMessage("Processing please wait...");
                                        dialog.setIndeterminate(true);
                                        dialog.setCanceledOnTouchOutside(false);
                                        dialog.show();
                                        getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "").commit();
                                        if (ss.length() == 9) {
                                            button[0] = "" + ss.charAt(4);
                                            button1[0] = "" + ss.charAt(8);
                                            name[0] = ss.substring(0, 3);
                                        } else if (ss.length() == 8) {
                                            button[0] = "" + ss.charAt(3);
                                            button1[0] = "" + ss.charAt(7);
                                            name[0] = ss.substring(0, 2);
                                        }
                                            getSharedPreferences("EYE", MODE_PRIVATE).edit().putString(name[0] + " " + button[0] + " - " + button1[0], "").commit();
                                        File file = new File(PapersFolder);
                                        looper(file);
                                        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
                                        getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", "").commit();

                                        //start donwloading

                                        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                                        noti1.cancel(0);
                                        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", 0).commit();
                                        getSharedPreferences("MENU1", MODE_PRIVATE).edit().putString("MENU1", "").commit();
                                        getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", "ST").commit();
                                        getSharedPreferences("STOP", MODE_PRIVATE).edit().putString("STOP", "").commit();

                                        startService(new Intent(HighActivity.this, service.class));
                                        getSharedPreferences("DOWN", MODE_PRIVATE).edit().putString("DOWN", finalName
                                                + " " + finalButton).commit();
                                        if (finalButton.equals("1 - 1"))
                                        {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "1").commit();
                                        }
                                        else if (finalButton.equals("1 - 2")) {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "2").commit();
                                        }
                                        else if (finalButton.equals("2 - 1")) {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "3").commit();
                                        } else if (finalButton.equals("2 - 2")) {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "4").commit();
                                        } else if (finalButton.equals("3 - 1")) {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "5").commit();
                                        } else if (finalButton.equals("3 - 2")) {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "6").commit();
                                        } else if (finalButton.equals("4 - 1")) {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "7").commit();
                                        } else if (finalButton.equals("4 - 2")) {
                                            getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "8").commit();
                                        }
                                        getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", finalName).commit();
                                        Handler han = new Handler();
                                        han.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                one.setVisibility(View.GONE);
                                                two.setVisibility(View.GONE);
                                                three.setVisibility(View.GONE);
                                                four.setVisibility(View.GONE);
                                                five.setVisibility(View.GONE);
                                                six.setVisibility(View.GONE);
                                                seven.setVisibility(View.GONE);
                                                eight.setVisibility(View.GONE);
                                                nine.setVisibility(View.GONE);
                                                ten.setVisibility(View.GONE);
                                                ele.setVisibility(View.GONE);
                                                twe.setVisibility(View.GONE);
                                                thir.setVisibility(View.GONE);
                                                fourt.setVisibility(View.GONE);
                                                fifteen.setVisibility(View.GONE);
                                                sixteen.setVisibility(View.GONE);
                                                seventeen.setVisibility(View.GONE);
                                                eighteen.setVisibility(View.GONE);
                                                nineteen.setVisibility(View.GONE);
                                                twenty.setVisibility(View.GONE);
                                                nothing1.setVisibility(View.GONE);
                                                redownload1.setVisibility(View.GONE);
                                                viewpackage.setVisibility(View.VISIBLE);
                                                nothing.setVisibility(View.VISIBLE);
                                                menubar.setText("OU Papers");
                                                shifter.setVisibility(View.GONE);
                                                shiftpapers.setVisibility(View.GONE);
                                                dialog.cancel();
                                                startActivity(new Intent(HighActivity.this, pack.class));
                                                overridePendingTransition(R.anim.rightin, R.anim.leftout);
                                                Toast.makeText(getBaseContext(), "Downloading started", Toast.LENGTH_SHORT).show();
                                            }
                                        }, 1000);
                                    }
                                });
                                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i)
                                    {

                                    }
                                });
                                final AlertDialog dialog1 = dialog.create();
                                dialog1.setOnShowListener(new DialogInterface.OnShowListener()
                                {
                                    @Override
                                    public void onShow(DialogInterface dialogInterface) {
                                        dialog1.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                                        dialog1.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                                    }
                                });
                                dialog1.show();
                            } else
                            {
                                Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                            }
                        } else
                        {
                            Toast.makeText(getBaseContext(), "No network", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                deletesub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        getSharedPreferences("LEN",MODE_PRIVATE).edit().putString("LEN","00000000000000000000").commit();
                        final int[] reloop = {0};
                        String kak = "";

                        if (status.equals("PAPERS"))
                        {
                            kak = "syllabus";
                        } else {
                            kak = "papers";
                        }
                        if (view1.startsWith("BE") || view1.startsWith("INS")|| view1.startsWith("PRO")||view1.endsWith("1 - 2"))
                        {
                            final AlertDialog.Builder dialog = new AlertDialog.Builder(HighActivity.this);
                            dialog.setMessage("Are you sure you wanna delete subject(s)?");
                            dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    deleted = true;
                                    getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
                                    final ProgressDialog dialog1 = new ProgressDialog(HighActivity.this);
                                    dialog1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                    dialog1.setMessage("Removing please wait...");
                                    dialog1.setIndeterminate(true);
                                    dialog1.setCanceledOnTouchOutside(false);
                                    dialog1.show();
                                    if (done) {
                                        File dfile1 = new File(PapersFolder + "/" + one.getText());
                                        looper(dfile1);
                                    }
                                    if (dtwo) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + two.getText());
                                        looper(dfile1);
                                    }
                                    if (dthree) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + three.getText());
                                        looper(dfile1);
                                    }
                                    if (dfour) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + four.getText());
                                        looper(dfile1);
                                    }
                                    if (dfive) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + five.getText());
                                        looper(dfile1);
                                    }
                                    if (dsix) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + six.getText());
                                        looper(dfile1);
                                    }
                                    if (dseven) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + seven.getText());
                                        looper(dfile1);
                                    }
                                    if (deight) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + eight.getText());
                                        looper(dfile1);
                                    }
                                    if (dnine) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + nine.getText());
                                        looper(dfile1);
                                    }
                                    if (dten) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + ten.getText());
                                        looper(dfile1);
                                    }
                                    if (dele) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + ele.getText());
                                        looper(dfile1);
                                    }
                                    if (dtwe) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + twe.getText());
                                        looper(dfile1);
                                    }
                                    if (dthir) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + thir.getText());
                                        looper(dfile1);
                                    }
                                    if (dfourt) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + fourt.getText());
                                        looper(dfile1);
                                    }
                                    if (dfifteen) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + fifteen.getText());
                                        looper(dfile1);
                                    }
                                    if (dsixteen) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + sixteen.getText());
                                        looper(dfile1);
                                    }
                                    if (dsventeen) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + seventeen.getText());
                                        looper(dfile1);
                                    }
                                    if (deighteen) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + eighteen.getText());
                                        looper(dfile1);
                                    }
                                    if (dnineten) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + nineteen.getText());
                                        looper(dfile1);
                                    }
                                    if (dtwenty) {
                                        File dfile1;
                                        dfile1 = new File(PapersFolder + "/" + twenty.getText());
                                        looper(dfile1);
                                    }
                                    done = false;
                                    dtwo = false;
                                    dthree = false;
                                    dfour = false;
                                    dfive = false;
                                    dsix = false;
                                    dseven = false;
                                    deight = false;
                                    dnine = false;
                                    dten = false;
                                    dele = false;
                                    dtwe = false;
                                    dthir = false;
                                    dfour = false;
                                    dfifteen = false;
                                    dsixteen = false;
                                    dsventeen = false;
                                    deighteen = false;
                                    dnineten = false;
                                    dtwenty = false;

                                    corres = false;
                                    Handler han = new Handler();
                                    han.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            dialog1.dismiss();
                                            stopanimation();
                                            Toast.makeText(getBaseContext(), "Operation successful", Toast.LENGTH_SHORT).show();

                                            one.setVisibility(View.GONE);
                                            two.setVisibility(View.GONE);
                                            three.setVisibility(View.GONE);
                                            four.setVisibility(View.GONE);
                                            five.setVisibility(View.GONE);
                                            six.setVisibility(View.GONE);
                                            seven.setVisibility(View.GONE);
                                            eight.setVisibility(View.GONE);
                                            nine.setVisibility(View.GONE);
                                            ten.setVisibility(View.GONE);
                                            ele.setVisibility(View.GONE);
                                            twe.setVisibility(View.GONE);
                                            thir.setVisibility(View.GONE);
                                            fourt.setVisibility(View.GONE);
                                            fifteen.setVisibility(View.GONE);
                                            sixteen.setVisibility(View.GONE);
                                            seventeen.setVisibility(View.GONE);
                                            eighteen.setVisibility(View.GONE);
                                            nineteen.setVisibility(View.GONE);
                                            twenty.setVisibility(View.GONE);
                                            loadnames();
                                        }
                                    }, 700);
                                }
                            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    corres = false;
                                }
                            }).create();


                            final AlertDialog dialog1 = dialog.create();
                            dialog1.setOnShowListener(new DialogInterface.OnShowListener() {
                                @Override
                                public void onShow(DialogInterface dialogInterface) {
                                    dialog1.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                                    dialog1.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                                }
                            });
                            dialog1.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                @Override
                                public void onCancel(DialogInterface dialogInterface) {
                                    corres = false;
                                }
                            });
                            dialog1.show();
                        } else
                        {
                            boolean[] checkedValues = new boolean[5];
                            checkedValues[0] = true;
                            corres=true;
                            final CharSequence[] items = {"Delete respective " + kak + " too? (if exists)"};
                            final AlertDialog dialog = new AlertDialog.Builder(HighActivity.this)
                                    .setTitle("Delete").setMultiChoiceItems(items, checkedValues, new DialogInterface.OnMultiChoiceClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                                            if (isChecked)
                                            {
                                                corres = true;
                                            } else
                                                corres = false;
                                        }
                                    }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            deleted = true;
                                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
                                            final ProgressDialog dialog1 = new ProgressDialog(HighActivity.this);
                                            dialog1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                            dialog1.setMessage("Removing please wait...");
                                            dialog1.setIndeterminate(true);
                                            dialog1.setCanceledOnTouchOutside(false);
                                            dialog1.show();
                                            Handler han = new Handler();
                                            han.postDelayed(new Runnable()
                                            {
                                                @Override
                                                public void run()
                                                {
                                                    dialog1.dismiss();
                                                    stopanimation();
                                                    Toast.makeText(getBaseContext(), "Operation successful", Toast.LENGTH_SHORT).show();

                                                    one.setVisibility(View.GONE);
                                                    two.setVisibility(View.GONE);
                                                    three.setVisibility(View.GONE);
                                                    four.setVisibility(View.GONE);
                                                    five.setVisibility(View.GONE);
                                                    six.setVisibility(View.GONE);
                                                    seven.setVisibility(View.GONE);
                                                    eight.setVisibility(View.GONE);
                                                    nine.setVisibility(View.GONE);
                                                    ten.setVisibility(View.GONE);
                                                    ele.setVisibility(View.GONE);
                                                    twe.setVisibility(View.GONE);
                                                    thir.setVisibility(View.GONE);
                                                    fourt.setVisibility(View.GONE);
                                                    fifteen.setVisibility(View.GONE);
                                                    sixteen.setVisibility(View.GONE);
                                                    seventeen.setVisibility(View.GONE);
                                                    eighteen.setVisibility(View.GONE);
                                                    nineteen.setVisibility(View.GONE);
                                                    twenty.setVisibility(View.GONE);
                                                    loadnames();
                                                }
                                            }, 700);
                                            if (done) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/01" + one.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + one.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + one.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + one.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + one.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }

                                            }
                                            if (dtwo) {

                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/02" + two.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + two.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + two.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + two.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + two.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dthree) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/03" + three.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + three.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + three.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + three.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + three.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dfour) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/04" + four.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + four.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + four.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + four.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + four.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dfive) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/05" + five.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + five.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + five.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + five.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + five.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dsix) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/06" + six.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + six.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + six.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + six.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + six.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dseven) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/07" + seven.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + seven.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + seven.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + seven.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + seven.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (deight) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/08" + eight.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + eight.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + eight.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + eight.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + eight.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dnine) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/09" + nine.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + nine.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + nine.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + nine.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + nine.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dten) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/10" + ten.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + ten.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + ten.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + ten.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + ten.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dele) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/11" + ele.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + ele.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + ele.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + ele.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + ele.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dtwe) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/12" + twe.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + twe.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + twe.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + twe.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + twe.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dthir) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/13" + thir.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + thir.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + thir.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + thir.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + thir.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dfourt) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/14" + fourt.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + fourt.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + fourt.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + fourt.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + fourt.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dfifteen) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/15" + fifteen.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + fifteen.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + fifteen.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + fifteen.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + fifteen.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dsixteen) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/16" + sixteen.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + sixteen.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + sixteen.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + sixteen.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + sixteen.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dsventeen) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/17" + seventeen.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + seventeen.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + seventeen.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + seventeen.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + seventeen.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (deighteen) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/18" + eighteen.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + eighteen.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + eighteen.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + eighteen.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + eighteen.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dnineten) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/19" + nineteen.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + nineteen.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + nineteen.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + nineteen.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + nineteen.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            if (dtwenty) {
                                                File dfile1;
                                                if (status.equals("SYLLABUS")) {
                                                    reloop[0] = 1;
                                                    String path1 = PapersFolder + "/ZSYL/20" + twenty.getText() + ".html";
                                                    File dfile = new File(path1);
                                                    dfile.delete();
                                                    if (corres) {
                                                        dfile1 = new File(PapersFolder + "/" + twenty.getText());
                                                        looper(dfile1);
                                                    }
                                                } else {
                                                    dfile1 = new File(PapersFolder + "/" + twenty.getText());
                                                    looper(dfile1);
                                                    if (corres) {
                                                        reloop[0] = 1;
                                                        int kk;
                                                        for (kk = 1; kk <= 20; kk++) {
                                                            String dip1 = "" + kk;
                                                            String path1;
                                                            if (dip1.length() == 1)
                                                                path1 = path + "/ZSYL/0" + kk + twenty.getText() + ".html";
                                                            else
                                                                path1 = path + "/ZSYL/" + kk + twenty.getText() + ".html";
                                                            File dfile = new File(path1);
                                                            if (dfile.exists())
                                                                dfile.delete();
                                                        }
                                                    }
                                                }
                                            }
                                            done = false;
                                            dtwo = false;
                                            dthree = false;
                                            dfour = false;
                                            dfive = false;
                                            dsix = false;
                                            dseven = false;
                                            deight = false;
                                            dnine = false;
                                            dten = false;
                                            dele = false;
                                            dtwe = false;
                                            dthir = false;
                                            dfour = false;
                                            dfifteen = false;
                                            dsixteen = false;
                                            dsventeen = false;
                                            deighteen = false;
                                            dnineten = false;
                                            dtwenty = false;

                                            corres = false;
                                            if (reloop[0] == 1)
                                            {
                                                String pa = PapersFolder + "/ZSYL";
                                                File dfile2 = new File(pa);
                                                File[] list1 = dfile2.listFiles();
                                                for (int kl = 0; kl < list1.length; kl++) {
                                                    String name = list1[kl].getName();
                                                    Log.d("name",""+name);
                                                    String acname = name.substring(2, name.indexOf('.'));
                                                    String ext = name.substring(name.indexOf('.'), name.length());
                                                    int kl1 = kl + 1;
                                                    String dip1 = "" + kl1;
                                                    File to;
                                                    if (dip1.length() == 1)
                                                    {
                                                        to = new File(dfile2, "0" + kl1 + acname + ext);
                                                    } else
                                                    {
                                                        to = new File(dfile2, kl1 + acname + ext);
                                                    }
                                                    list1[kl].renameTo(to);
                                                    reloop[0] = 0;
                                                }
                                            }
                                        }
                                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            corres = false;
                                        }
                                    }).create();

                            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                                @Override
                                public void onShow(DialogInterface dialogInterface) {
                                    dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                                    dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                                }
                            });
                            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                @Override
                                public void onCancel(DialogInterface dialogInterface) {
                                    corres = false;
                                }
                            });
                            dialog.show();
                        }
                    }
                });
                delsubcancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        done = false;
                        dtwo = false;
                        dthree = false;
                        dfour = false;
                        dfive = false;
                        dsix = false;
                        dseven = false;
                        deight = false;
                        dnine = false;
                        dten = false;
                        dele = false;
                        dtwe = false;
                        dthir = false;
                        dfour = false;
                        dfifteen = false;
                        dsixteen = false;
                        dsventeen = false;
                        deighteen = false;
                        dnineten = false;
                        dtwenty = false;
                        stopanimation();
                    }
                });
                menubar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (active)
                        {
                            active = false;
                            layout.startAnimation(backanim);
                            trans.setVisibility(View.GONE);
                            layout.setVisibility(View.GONE);
                        }
                    }
                });
                share.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        active=false;
                        share.setBackgroundResource(R.drawable.clickedmenu);
                        share.setClickable(false);
                        han.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                share.setBackgroundColor(Color.WHITE);
                                share.setClickable(true);
                            }
                        }, 190);
                        active = false;
                        layout.startAnimation(backanim);
                        han.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                layout.setVisibility(View.GONE);
                                trans.setVisibility(View.GONE);
                            }
                        }, 190);
                        han.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                haveStoragePermission();
                            }
                        }, 250);
                    }
                });
                pack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        active=false;
                        getSharedPreferences("ACTIVE2",MODE_PRIVATE).edit().putBoolean("ACTIVE2",false).commit();
                        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                        pack.setBackgroundResource(R.drawable.clickedmenu);
                        startActivity(new Intent(HighActivity.this, pack.class));
                        overridePendingTransition(R.anim.rightin, R.anim.leftout);
                    }
                });
               github.setOnClickListener(new View.OnClickListener()
              {
            @Override
            public void onClick(View v)
            {
                active=false;
                github.setBackgroundResource(R.drawable.clickedmenu);
                github.setClickable(false);
                han.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        github.setBackgroundColor(Color.WHITE);
                        github.setClickable(true);
                    }
                }, 190);
                active = false;
                layout.startAnimation(backanim);
                han.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        layout.setVisibility(View.GONE);
                        trans.setVisibility(View.GONE);
                    }
                }, 190);
                getSharedPreferences("ACTIVE2",MODE_PRIVATE).edit().putBoolean("ACTIVE2",false).commit();
                getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://github.com/shaikismail963434/OU-Papers")));
                }
                  });
                about.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        active=false;
                        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                        about.setBackgroundResource(R.drawable.clickedmenu);
                        startActivity(new Intent(HighActivity.this, about.class));
                        overridePendingTransition(R.anim.rightin, R.anim.leftout);
                    }
                });
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        active=false;
                        delete.setBackgroundResource(R.drawable.clickedmenu);
                        delete.setClickable(false);
                        han.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                delete.setBackgroundColor(Color.WHITE);
                                delete.setClickable(true);
                            }
                        }, 190);
                        active = false;
                        layout.startAnimation(backanim);
                        han.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                layout.setVisibility(View.GONE);
                            }
                        }, 190);


                        final String[] button = new String[1];
                        final String button1[] = new String[1];
                        String button2 = null, name2 = null;
                        final String[] name = {null};
                        final String ss = getSharedPreferences("VIEW", MODE_PRIVATE).getString("VIEW", "");
                        // Log.d("ss", ss);
                        if (ss.length() == 9) {
                            button2 = ss.charAt(4) + " - " + ss.charAt(8);
                            name2 = ss.substring(0, 3);
                        } else if (ss.length() == 8) {
                            button2 = ss.charAt(3) + " - " + ss.charAt(7);
                            name2 = ss.substring(0, 2);
                        }
                        AlertDialog.Builder dialog = new AlertDialog.Builder(HighActivity.this);
                        dialog.setMessage("Delete " + name2 + " " + button2 + " package?");
                        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                redownload1.setVisibility(View.GONE);
                                nothing1.setVisibility(View.GONE);
                                trans.setVisibility(View.GONE);
                                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "").commit();
                                final ProgressDialog dialog = new ProgressDialog(HighActivity.this);
                                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                dialog.setMessage("Removing please wait...");
                                dialog.setIndeterminate(true);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.show();
                                if (ss.length() == 9) {
                                    button[0] = "" + ss.charAt(4);
                                    button1[0] = "" + ss.charAt(8);
                                    name[0] = ss.substring(0, 3);
                                } else if (ss.length() == 8) {
                                    button[0] = "" + ss.charAt(3);
                                    button1[0] = "" + ss.charAt(7);
                                    name[0] = ss.substring(0, 2);
                                }
                                    getSharedPreferences("EYE", MODE_PRIVATE).edit().putString(name[0] + " " + button[0] + " - " + button1[0], "").commit();
                                File file = new File(PapersFolder);
                                looper(file);
                                getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
                                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", "").commit();
                                Handler han = new Handler();
                                han.postDelayed(new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        shifter.setVisibility(View.GONE);
                                        shiftpapers.setVisibility(View.GONE);
                                        dialog.dismiss();
                                        Toast.makeText(getBaseContext(), "Operation successful", Toast.LENGTH_SHORT).show();
                                        redownload.setVisibility(View.GONE);
                                        delete.setVisibility(View.GONE);
                                        nothing.setVisibility(View.VISIBLE);
                                        viewpackage.setVisibility(View.VISIBLE);
                                        menubar.setText("OU Papers");

                                        one.setVisibility(View.GONE);
                                        two.setVisibility(View.GONE);
                                        three.setVisibility(View.GONE);
                                        four.setVisibility(View.GONE);
                                        five.setVisibility(View.GONE);
                                        six.setVisibility(View.GONE);
                                        seven.setVisibility(View.GONE);
                                        eight.setVisibility(View.GONE);
                                        nine.setVisibility(View.GONE);
                                        ten.setVisibility(View.GONE);
                                        ele.setVisibility(View.GONE);
                                        twe.setVisibility(View.GONE);
                                        thir.setVisibility(View.GONE);
                                        fourt.setVisibility(View.GONE);
                                        fifteen.setVisibility(View.GONE);
                                        sixteen.setVisibility(View.GONE);
                                        seventeen.setVisibility(View.GONE);
                                        eighteen.setVisibility(View.GONE);
                                        nineteen.setVisibility(View.GONE);
                                        twenty.setVisibility(View.GONE);

                                        loadnames();
                                    }
                                }, 700);
                            }
                        });
                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                trans.setVisibility(View.GONE);
                            }
                        });
                        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialogInterface)
                            {
                                trans.setVisibility(View.GONE);
                            }
                        });
                        final AlertDialog dialog1 = dialog.create();
                        dialog1.setOnShowListener(new DialogInterface.OnShowListener() {
                            @Override
                            public void onShow(DialogInterface dialogInterface) {
                                dialog1.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                                dialog1.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                            }
                        });
                        dialog1.show();
                    }
                });
                menu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                        if (!active)
                        {

                            active = true;
                            trans.setVisibility(View.VISIBLE);
                            layout.setVisibility(View.VISIBLE);
                            layout.startAnimation(anim);
                        }
                        else
                        {
                            trans.setVisibility(View.GONE);
                            layout.startAnimation(backanim);
                            active = false;
                            layout.setVisibility(View.GONE);
                        }
                    }
                });
                trans.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        active = false;
                        layout.startAnimation(backanim);
                        trans.setVisibility(View.GONE);
                        layout.setVisibility(View.GONE);
                        return false;
                    }
                });
                one.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        if (!shaking)
                        {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = one.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "1").commit();
                            top1.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!done) {
                                done = true;
                                one.setBackgroundResource(R.drawable.clickedbackground);

                            } else {
                                done = false;
                                one.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }

                    }

                });
                two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = two.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "2").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top2.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dtwo) {
                                dtwo = true;
                                two.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dtwo = false;
                                two.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }
                    }
                });
                three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = three.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "3").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top3.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dthree) {
                                dthree = true;
                                three.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dthree = false;
                                three.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }
                    }
                });
                four.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = four.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "4").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top4.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dfour) {
                                dfour = true;
                                four.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dfour = false;
                                four.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }
                    }
                });
                five.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = five.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "5").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }

                            top5.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dfive) {
                                dfive = true;
                                five.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dfive = false;
                                five.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }
                    }
                });
                six.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = six.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "6").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top6.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dsix) {
                                dsix = true;
                                six.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dsix = false;
                                six.setBackgroundResource(R.drawable.background);

                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }
                    }
                });
                seven.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = seven.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "7").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top7.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dseven) {
                                dseven = true;
                                seven.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dseven = false;
                                seven.setBackgroundResource(R.drawable.background);

                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }
                    }
                });
                eight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = eight.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "8").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top8.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!deight) {
                                deight = true;
                                eight.setBackgroundResource(R.drawable.clickedbackground);

                            } else {
                                deight = false;
                                eight.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }
                    }
                });
                nine.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {

                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = nine.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "9").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top9.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dnine) {
                                dnine = true;
                                nine.setBackgroundResource(R.drawable.clickedbackground);

                            } else {
                                dnine = false;
                                nine.setBackgroundResource(R.drawable.background);

                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }
                    }
                });
                ten.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = ten.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "10").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top10.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dten) {
                                dten = true;

                                ten.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dten = false;
                                ten.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }
                    }
                });
                ele.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = ele.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "11").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top11.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dele) {
                                dele = true;
                                ele.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dele = false;
                                ele.setBackgroundResource(R.drawable.background);

                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }
                    }
                });
                twe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = twe.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "12").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top12.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dtwe) {
                                dtwe = true;
                                twe.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dtwe = false;
                                twe.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }
                    }
                });
                thir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = thir.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "13").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top13.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dthir) {
                                dthir = true;
                                thir.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dthir = false;
                                thir.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }
                    }
                });
                fourt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = fourt.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "14").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top14.setVisibility(View.VISIBLE);
                           startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dfourt) {
                                dfourt = true;
                                fourt.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dfourt = false;
                                fourt.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }
                    }
                });
                fifteen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = fifteen.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "15").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top15.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dfifteen) {
                                dfifteen = true;
                                fifteen.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dfifteen = false;
                                fifteen.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }

                    }

                });
                sixteen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = sixteen.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "16").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top16.setVisibility(View.VISIBLE);
                           startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dsixteen) {
                                dsixteen = true;
                                sixteen.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dsixteen = false;
                                sixteen.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }

                    }

                });
                seventeen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = seventeen.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "17").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top17.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dsventeen) {
                                dsventeen = true;
                                seventeen.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dsventeen = false;
                                seventeen.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }

                    }

                });
                eighteen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {

                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = eighteen.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "18").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top18.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!deighteen) {
                                deighteen = true;
                                eighteen.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                deighteen = false;
                                eighteen.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }

                    }

                });
                nineteen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = nineteen.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "19").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top19.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dnineten) {
                                dnineten = true;
                                nineteen.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dnineten = false;
                                nineteen.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }

                    }

                });
                twenty.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!shaking) {
                            getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                            String subject = twenty.getText().toString();
                            if (status.equals("PAPERS"))
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/" + subject).commit();
                            else if (status.equals("SYLLABUS")) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "20").commit();
                                getSharedPreferences("ROOT", MODE_PRIVATE).edit().putString("ROOT", folder + "/ZSYL").commit();
                            }
                            top20.setVisibility(View.VISIBLE);
                            startActivity(new Intent(HighActivity.this, papers.class));
                            overridePendingTransition(R.anim.rightin, R.anim.leftout);
                        } else {
                            if (!dtwenty) {
                                dtwenty = true;
                                twenty.setBackgroundResource(R.drawable.clickedbackground);
                            } else {
                                dtwenty = false;
                                twenty.setBackgroundResource(R.drawable.background);
                                if (!done && !dtwo && !dthree && !dfour && !dfive && !dsix && !dseven && !deight && !dnine && !dten && !dele && !dtwe && !dthir && !dfourt
                                        && !dfifteen && !dsixteen && !dsventeen && !deighteen && !dnineten && !dtwenty)
                                    stopanimation();
                            }
                        }

                    }

                });
                one.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking)
                        {
                            done = true;
                            one.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                two.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dtwo = true;
                            two.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                three.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dthree = true;
                            three.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                four.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dfour = true;
                            four.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                five.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dfive = true;
                            five.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                six.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dsix = true;
                            six.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                seven.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dseven = true;
                            seven.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                eight.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            deight = true;
                            eight.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                nine.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dnine = true;
                            nine.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                ten.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dten = true;
                            ten.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                ele.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dele = true;
                            ele.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                twe.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dtwe = true;
                            twe.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                thir.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dthir = true;
                            thir.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                fourt.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dfourt = true;
                            fourt.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                fifteen.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dfifteen = true;
                            fifteen.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                sixteen.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dsixteen = true;
                            sixteen.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                seventeen.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dsventeen = true;
                            seventeen.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                eighteen.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            deighteen = true;
                            eighteen.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                nineteen.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking)
                        {
                            dnineten = true;
                            nineteen.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });
                twenty.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (!shaking) {
                            dtwenty = true;
                            twenty.setBackgroundResource(R.drawable.clickedbackground);
                            startanimation();
                            return true;
                        }
                        return false;
                    }
                });

        //Deleting Content

        if(getSharedPreferences("1.8.6",MODE_PRIVATE).getString("1.8.6","").equals(""))
        {
            int lock = 0;
            File ff = new File("/data/data/net.net23.freeismail.oupapers12/");
            File[] root1 = ff.listFiles();
            if (root1.length >= 1)
            {
                for (int ii = 0; ii < root1.length; ii++)
                {
                    if (root1[ii].getName().toString().startsWith("AE") || root1[ii].getName().toString().startsWith("CE") ||
                            root1[ii].getName().toString().startsWith("CSE") || root1[ii].getName().toString().startsWith("ECE") ||
                            root1[ii].getName().toString().startsWith("EEE") || root1[ii].getName().toString().startsWith("IT") ||
                            root1[ii].getName().toString().startsWith("INS") || root1[ii].getName().toString().startsWith("MEC") ||
                            root1[ii].getName().toString().startsWith("PRO") || root1[ii].getName().toString().startsWith("BE")) {
                        looper(root1[ii]);
                        lock = 1;
                    }
                }
            }
            view1 = "";
            String ss = getSharedPreferences("VIEW", MODE_PRIVATE).getString("VIEW", "");
            final String[] button = new String[1];
            final String button1[] = new String[1];
            final String[] name = {null};
            if (ss.length() == 9) {
                button[0] = "" + ss.charAt(4);
                button1[0] = "" + ss.charAt(8);
                name[0] = ss.substring(0, 3);
            }
            else if (ss.length() == 8) {
                button[0] = "" + ss.charAt(3);
                button1[0] = "" + ss.charAt(7);
                name[0] = ss.substring(0, 2);
            }
            getSharedPreferences("EYE", MODE_PRIVATE).edit().putString(name[0] + " " + button[0] + " - " + button1[0],
                    "").commit();
            getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", "").commit();
            getSharedPreferences("1.8.6", MODE_PRIVATE).edit().putString("1.8.6", "1.8.6").commit();
            if (lock == 1)
            {
                final ProgressDialog pb = new ProgressDialog(HighActivity.this);
                pb.setMessage("Processing...");
                pb.show();
                pb.setCancelable(false);
                Handler han1 = new Handler();
                han1.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        nothing.setVisibility(View.VISIBLE);
                        viewpackage.setVisibility(View.VISIBLE);
                        pb.cancel();
                        AlertDialog.Builder dialog = new AlertDialog.Builder(HighActivity.this);
                        dialog.setCancelable(false);
                        dialog.setMessage("Data have been removed to sync with update !!");
                        dialog.setPositiveButton("Alright", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {}
                        });
                        final AlertDialog dialog1 = dialog.create();
                        dialog1.show();
                    }
                }, 2000);
            }
            else
            {
                nothing.setVisibility(View.VISIBLE);
                viewpackage.setVisibility(View.VISIBLE);
            }
        }
            else
            {
                //Background working
               new assigned().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                new background().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }

    }
    public class assigned extends AsyncTask<String,Void,Long>
    {
        @Override
        protected Long doInBackground(String... strings)
        {
            if(shareno>= 36)
            {
                if(!getSharedPreferences("SHAREL", MODE_PRIVATE).getString("SHAREL", "").equals("LOOP"))
                    getSharedPreferences("SHAREL", MODE_PRIVATE).edit().putString("SHAREL", "").commit();
            }
            if(shareno>=100)
            {
                if(!getSharedPreferences("SHARER", MODE_PRIVATE).getString("SHARER", "").equals("LOOP"))
                    getSharedPreferences("SHARER", MODE_PRIVATE).edit().putString("SHARER", "").commit();
            }
            //Setting page
            getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "1").commit();

            return null;
        }
    }
    public class background extends AsyncTask<String,Void,Long>
    {
        @Override
        protected Long doInBackground(String... strings)
        {
            return null;
        }
        @Override
        protected void onPreExecute()
        {
            if(getSharedPreferences("ACTIVE1",MODE_PRIVATE).getBoolean("ACTIVE1",false))
            {
                active = true;
                trans.setVisibility(View.VISIBLE);
                layout.setVisibility(View.VISIBLE);
            }
            else  if(getSharedPreferences("PAP",MODE_PRIVATE).getBoolean("PAP",false))
            {
                pap=true;
                paperm.setBackgroundColor(Color.WHITE);
                syallbm.setBackgroundColor(Color.WHITE);
                paperstrans.setVisibility(View.VISIBLE);
                papersmenu.setVisibility(View.VISIBLE);
            }
                if (view1.equals(""))
                {
                    nothing.setVisibility(View.VISIBLE);
                    menubar.setText("OU Papers");
                    redownload.setVisibility(View.GONE);
                    delete.setVisibility(View.GONE);
                    viewpackage.setVisibility(View.VISIBLE);
                }
                else
                {
                    if(view1.startsWith("BE") || view1.startsWith("INS")||
                            view1.startsWith("PRO")||view1.endsWith("1 - 2"))
                    {
                        menubar.setText(view1+"  Papers");
                        shifter.setVisibility(View.GONE);
                        shiftpapers.setVisibility(View.GONE);
                    }
                    else
                    {
                        menubar.setText(view1);
                        shifter.setVisibility(View.VISIBLE);
                        if(status.equals("SYLLABUS"))
                            shiftpapers.setText(" Syllabus ");
                        else
                            shiftpapers.setText(" Papers ");
                        shiftpapers.setVisibility(View.VISIBLE);
                    }
                    redownload.setVisibility(View.VISIBLE);
                    redownload.setText("Redownload " + view1 + " ");
                    delete.setVisibility(View.VISIBLE);
                    delete.setText("Delete " + view1 + " ");
                }
                if(deleted)
                {
                    Handler han1 = new Handler();
                    han1.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            loadnames();
                        }
                    }, 50);
                }
                else
                {
                    loadnames();
                }
            String len= getSharedPreferences("LEN",MODE_PRIVATE).getString("LEN","00000000000000000000");
            int callstarter=0;
            if(len.length()>=1)
            for(int kk=0;kk<20;kk++)
            {
                if(len.charAt(kk)=='1')
                {
                    if(kk==0)
                    {
                        callstarter=1;
                        done=true;
                        one.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==1)
                    {
                        callstarter=1;
                                dtwo = true;
                                two.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==2)
                    {
                        callstarter=1;
                                dthree = true;
                                three.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==3)
                    {
                        callstarter=1;
                                dfour = true;
                                four.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==4)
                    {
                        callstarter=1;
                                dfive = true;
                                five.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==5)
                    {
                        callstarter=1;
                                dsix = true;
                                six.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==6)
                    {
                        callstarter=1;
                                dseven = true;
                                seven.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==7)
                    {
                        callstarter=1;
                                deight = true;
                                eight.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==8)
                    {
                        callstarter=1;
                                dnine = true;
                                nine.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==9)
                    {
                        callstarter=1;
                                dten = true;
                                ten.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==10)
                    {
                        callstarter=1;
                                dele = true;
                                ele.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==11)
                    {
                        callstarter=1;
                                dtwe = true;
                                twe.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==12)
                    {
                        callstarter=1;
                                dthir = true;
                                thir.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==13)
                    {
                        callstarter=1;
                                dfourt = true;
                                fourt.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==14)
                    {
                        callstarter=1;
                                dfifteen = true;
                                fifteen.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==15)
                    {
                        callstarter=1;
                                dsixteen = true;
                                sixteen.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==16)
                    {
                        callstarter=1;
                                dsventeen = true;
                                seventeen.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==17)
                    {
                        callstarter=1;
                                deighteen = true;
                                eighteen.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==18)
                    {
                        callstarter=1;
                                dnineten = true;
                                nineteen.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    if(kk==19)
                    {
                        callstarter = 1;
                        dtwenty = true;
                        twenty.setBackgroundResource(R.drawable.clickedbackground);
                    }
                    shaking=true;
                    if(callstarter==1)
                    startanimation();
                }
            }
            //Checking for Share
            if (shareno == 36
                    ||getSharedPreferences("SHAREL", MODE_PRIVATE).getString("SHAREL", "").equals("LOOP"))
            {

                getSharedPreferences("SHAREL", MODE_PRIVATE).edit().putString("SHAREL", "LOOP").commit();
                shareGotcha.setVisibility(View.VISIBLE);
                shareNoti.setVisibility(View.VISIBLE);
                shareCancel.setVisibility(View.VISIBLE);
            }

            //Checking for Rate
            if (shareno== 100
                    ||getSharedPreferences("SHARER", MODE_PRIVATE).getString("SHARER", "").equals("LOOP"))
            {
                getSharedPreferences("SHARE1", MODE_PRIVATE).edit().putInt("SHARE1", 101).commit();
                getSharedPreferences("SHARER", MODE_PRIVATE).edit().putString("SHARER", "LOOP").commit();
                rateGotcha.setVisibility(View.VISIBLE);
                rateNoti.setVisibility(View.VISIBLE);
                rateCancel.setVisibility(View.VISIBLE);
            }
            super.onPreExecute();
        }
    }
    public boolean haveStoragePermission()
    {
        v = r.getRootView();
        v.setDrawingCacheEnabled(true);
        b = v.getDrawingCache();
        if (Build.VERSION.SDK_INT >= 23)
        {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED)
            {
              //  Log.e("Permission error", "You have permission");
                new sharewithdynamicimage().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                return true;
            }
            else
            {
               // Log.e("Permission error", "You have asked for permission");
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                final Handler han = new Handler();
                han.postDelayed(new Runnable()
                {
                    @Override
                    public void run() {
                        han.removeCallbacks(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                sharewithstaticimage();
                            }
                        });
                        haveStoragePermission();
                    }
                }, 300);
                return false;
            }
        }
        else
        {
           // Log.e("Permission error", "You already have the permission");
         new sharewithdynamicimage().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            return true;
        }
    }
    private void sharewithstaticimage()
    {
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.ou_papers);
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/ou_papers.jpg";
        OutputStream out ;
        File file=new File(path);
        try {
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        path=file.getPath();
        Uri bmpUri = Uri.parse("file://"+path);
        Intent shareIntent;
        shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
        shareIntent.putExtra(Intent.EXTRA_TEXT, "OU Papers is an android app which consists" +
                " of previous years question papers & syllabus of OU of all streams in systematic order, " +
                "using this app you can download required question papers & syllabus and view them offline." + "" +
                " Use the following link to download the app:    " +
                "https://play.google.com/store/apps/details?id=net.net23.freeismail.oupapers12&hl=en" +
                "    " +
                "  Or Visit oupapers.epizy.com to download papers.                                     " +
                "Happy learning !!");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "OU Papers");
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent,"Share with"));
    }
    public class sharewithdynamicimage extends AsyncTask<String,Void,Long>
    {
        @Override
        protected Long doInBackground(String... strings)
        {
            //Taking images
            String path = Environment.getExternalStorageDirectory().toString()+"/Pictures";
            File pict = new File(path);
            if(pict.exists())
                pict.mkdir();
            File myPath = new File(pict.getPath(),"ou_papers.jpg");
            FileOutputStream fos;
            try
            {
                fos = new FileOutputStream(myPath);
                b.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
                fos.close();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            path=myPath.getPath();
            Uri bmpUri = Uri.parse("file://"+path);
            Intent shareIntent;
            shareIntent = new Intent(android.content.Intent.ACTION_SEND);
            shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
            shareIntent.putExtra(Intent.EXTRA_TEXT, "OU Papers is an android app which consists" +
                    " of previous years question papers & syllabus of OU of all streams in systematic order, " +
                    "using this app you can download required question papers & syllabus and view them offline." + "" +
                    " Use the following link to download the app:    " +
                    "https://play.google.com/store/apps/details?id=net.net23.freeismail.oupapers12&hl=en" +
                    "    " +
                    "  Or Visit oupapers.epizy.com to download papers.                                     " +
                    "Happy learning !!");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "OU Papers");
            shareIntent.setType("image/*");
            startActivity(Intent.createChooser(shareIntent,"Share with"));
            return null;
        }
    }
    private void loadnames()
    {
        File file=null;
        Handler h = new Handler();
        h.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                scroll.scrollTo(0, getSharedPreferences("SCROLL1",MODE_PRIVATE).getInt("SCROLL1",0));
            }
        }, 50);
        twof=false;
        fourf=false;
        sixf=false;
        eightf=false;
        tenf=false;
        twf=false;
        forf=false;
        sixteenf=false;
        eightteenf=false;
        twentyf=false;

        int jj1 = 0;
        for (; jj1 < 20; jj1++)
        {
            buff[jj1] = "";
        }
        File[] list=null;
        try
        {
            if (view1.length() == 9)
                folder = view1.substring(0, 3) + view1.charAt(4) + view1.charAt(8);
            else if (view1.length() == 8)
                folder = view1.substring(0, 2) + view1.charAt(3) + view1.charAt(7);

            path = Environment.getExternalStorageDirectory().toString()+"/OU Papers/" + folder;
            File donot=new File(Environment.getExternalStorageDirectory().toString()+"/OU Papers/Do_Not_Manipulate_This_Folder(s).txt");
            if(!donot.exists())
                donot.createNewFile();
            PapersFolder=path;
            if(status.equals("SYLLABUS"))
            {
                try
                {
                path = path + "/ZSYL";
                file = new File(path);

                list = file.listFiles();
                for (int ik = 0; ik < list.length; ik++)
                {
                     String temp = list[ik].getName();
                    temp = temp.substring(0, temp.indexOf('.'));
                    String temp1 = temp.substring(2, temp.length());
                    if (temp.startsWith("01"))
                        buff[0] = temp1;
                    else if (temp.startsWith("02"))
                        buff[1] = temp1;
                    else if (temp.startsWith("03"))
                        buff[2] = temp1;
                    else if (temp.startsWith("04"))
                        buff[3] = temp1;
                    else if (temp.startsWith("05"))
                        buff[4] = temp1;
                    else if (temp.startsWith("06"))
                        buff[5] = temp1;
                    else if (temp.startsWith("07"))
                        buff[6] = temp1;
                    else if (temp.startsWith("08"))
                        buff[7] = temp1;
                    else if (temp.startsWith("09"))
                        buff[8] = temp1;
                    else if (temp.startsWith("10"))
                        buff[9] = temp1;
                    else if (temp.startsWith("11"))
                        buff[10] = temp1;
                    else if (temp.startsWith("12"))
                        buff[11] = temp1;
                    else if (temp.startsWith("13"))
                        buff[12] = temp1;
                    else if (temp.startsWith("14"))
                        buff[13] = temp1;
                    else if (temp.startsWith("15"))
                        buff[14] = temp1;
                    else if (temp.startsWith("16"))
                        buff[15] = temp1;
                    else if (temp.startsWith("17"))
                        buff[16] = temp1;
                    else if (temp.startsWith("18"))
                        buff[17] = temp1;
                    else if (temp.startsWith("19"))
                        buff[18] = temp1;
                    else if (temp.startsWith("20"))
                        buff[19] = temp1;
                }
            }
                catch (Exception e)
                {
                   }
            }
            else
            {
                file = new File(PapersFolder);

                list = file.listFiles();
                for (int ik = 0; ik < list.length; ik++)
                {
                    if (!list[ik].getName().toString().equals("ZSYL"))
                    {
                        buff[ik] = list[ik].getName();
                    }
                }
            }
        }
        catch (Exception e)
        {
        }
        for (int jj = 0; jj < 20; jj++)
        {
            if (!buff[jj].matches(""))
            {
                if (jj == 0)
                {
                    one.setText(buff[jj]);
                    one.setVisibility(View.VISIBLE);
                    two.setVisibility(View.INVISIBLE);
                    if (deleted)
                    {
                        trans22.setVisibility(View.VISIBLE);
                        Handler han = new Handler();
                        han.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                trans22.setVisibility(View.GONE);
                            }
                        }, 750);
                        one.startAnimation(smalltobig);
                    }
                } else if (jj == 1)
                {
                    twof = true;
                    two.setText(buff[jj]);
                    two.setVisibility(View.VISIBLE);
                    if (deleted)
                        two.startAnimation(smalltobig);

                } else if (jj == 2) {
                    three.setText(buff[jj]);
                    three.setVisibility(View.VISIBLE);
                    four.setVisibility(View.INVISIBLE);
                    if (deleted)
                        three.startAnimation(smalltobig);

                } else if (jj == 3)
                {
                    fourf = true;
                    four.setText(buff[jj]);
                    four.setVisibility(View.VISIBLE);
                    if (deleted)
                        four.startAnimation(smalltobig);

                } else if (jj == 4) {
                    five.setText(buff[jj]);
                    five.setVisibility(View.VISIBLE);
                    six.setVisibility(View.INVISIBLE);
                    if (deleted)
                        five.startAnimation(smalltobig);

                } else if (jj == 5) {
                    six.setText(buff[jj]);
                    sixf = true;
                    six.setVisibility(View.VISIBLE);
                    if (deleted)
                        six.startAnimation(smalltobig);
                } else if (jj == 6) {
                    seven.setText(buff[jj]);
                    seven.setVisibility(View.VISIBLE);
                    eight.setVisibility(View.INVISIBLE);
                    if (deleted)
                        seven.startAnimation(smalltobig);
                } else if (jj == 7) {
                    eightf = true;
                    eight.setText(buff[jj]);
                    eight.setVisibility(View.VISIBLE);
                    if (deleted)
                        eight.startAnimation(smalltobig);

                } else if (jj == 8) {
                    nine.setText(buff[jj]);
                    nine.setVisibility(View.VISIBLE);
                    ten.setVisibility(View.INVISIBLE);
                    if (deleted)
                        nine.startAnimation(smalltobig);
                } else if (jj == 9) {
                    tenf = true;
                    ten.setText(buff[jj]);
                    ten.setVisibility(View.VISIBLE);
                    if (deleted)
                        ten.startAnimation(smalltobig);
                } else if (jj == 10) {
                    ele.setText(buff[jj]);
                    ele.setVisibility(View.VISIBLE);
                    twe.setVisibility(View.INVISIBLE);
                    if (deleted)
                        ele.startAnimation(smalltobig);
                } else if (jj == 11) {
                    twf = true;
                    twe.setText(buff[jj]);
                    twe.setVisibility(View.VISIBLE);
                    if (deleted)
                        twe.startAnimation(smalltobig);
                } else if (jj == 12) {
                    thir.setText(buff[jj]);
                    thir.setVisibility(View.VISIBLE);
                    fourt.setVisibility(View.INVISIBLE);
                    if (deleted)
                        thir.startAnimation(smalltobig);

                } else if (jj == 13) {
                    forf = true;
                    fourt.setText(buff[jj]);
                    fourt.setVisibility(View.VISIBLE);
                    if (deleted)
                        fourt.startAnimation(smalltobig);
                }
                else if (jj == 14)
                {
                    fifteen.setText(buff[jj]);
                    fifteen.setVisibility(View.VISIBLE);
                    sixteen.setVisibility(View.INVISIBLE);
                    if (deleted)
                        fifteen.startAnimation(smalltobig);
                } else if (jj == 15)
                {
                    sixteenf = true;
                    sixteen.setText(buff[jj]);
                    sixteen.setVisibility(View.VISIBLE);
                    if (deleted)
                        sixteen.startAnimation(smalltobig);

                } else if (jj == 16) {
                    seventeen.setText(buff[jj]);
                    seventeen.setVisibility(View.VISIBLE);
                    eighteen.setVisibility(View.INVISIBLE);
                    if (deleted)
                        seventeen.startAnimation(smalltobig);

                } else if (jj == 17) {
                    eightf = true;
                    eighteen.setText(buff[jj]);
                    eighteen.setVisibility(View.VISIBLE);
                    if (deleted)
                        eighteen.startAnimation(smalltobig);

                } else if (jj == 18) {
                    nineteen.setText(buff[jj]);
                    nineteen.setVisibility(View.VISIBLE);
                    twenty.setVisibility(View.INVISIBLE);
                    if (deleted)
                        nineteen.startAnimation(smalltobig);

                } else if (jj == 20) {
                    twenty.setText(buff[jj]);
                    twentyf = true;
                    twenty.setVisibility(View.VISIBLE);
                    if (deleted)
                        twenty.startAnimation(smalltobig);
                }
            }
        }
        try
        {
            if (list.length > 0)
            {
                String not=getSharedPreferences("FIRST",MODE_PRIVATE).getString("FIRST","NOT");
                if(not.equals("NOT"))
                {
                    deleteNoti.setVisibility(View.VISIBLE);
                    deletGothca.setVisibility(View.VISIBLE);
                }
                else if(not.equals("")&&deleteNoti.getVisibility()==View.GONE)
                {
                    if (view1.startsWith("BE") || view1.startsWith("INS")||
                            view1.startsWith("PRO")|| view1.endsWith("1 - 2"))
                    {
                    }
                    else
                    {
                        Handler han = new Handler();
                        if (deleted)
                        {
                            han.postDelayed(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    transpa3.setVisibility(View.VISIBLE);
                                    papersmenu.setVisibility(View.VISIBLE);
                                    arrow.setVisibility(View.VISIBLE);
                                    show.setVisibility(View.VISIBLE);
                                }
                            }, 1000);
                        }
                        else
                        {
                            transpa3.setVisibility(View.VISIBLE);
                            papersmenu.setVisibility(View.VISIBLE);
                            arrow.setVisibility(View.VISIBLE);
                            show.setVisibility(View.VISIBLE);
                        }

                    }
                }
            }
        }
        catch (Exception e)
        {
        }
        try
        {
            if (list.length == 0||list[0].getName().equals("ZSYL"))
            {
                if (view1.startsWith("BE") || view1.startsWith("INS")||
                        view1.startsWith("PRO")|| view1.endsWith("1 - 2"))
                {
                    getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "").commit();
                    String ss = getSharedPreferences("VIEW", MODE_PRIVATE).getString("VIEW", "");
                        final String[] button = new String[1];
                        final String button1[] = new String[1];
                        final String[] name = {null};
                        if (ss.length() == 9) {
                            button[0] = "" + ss.charAt(4);
                            button1[0] = "" + ss.charAt(8);
                            name[0] = ss.substring(0, 3);
                        } else if (ss.length() == 8) {
                            button[0] = "" + ss.charAt(3);
                            button1[0] = "" + ss.charAt(7);
                            name[0] = ss.substring(0, 2);
                    }
                        getSharedPreferences("EYE", MODE_PRIVATE).edit().putString(name[0] + " " + button[0] + " - " + button1[0], "").commit();
                    delete.setVisibility(View.GONE);
                    redownload.setVisibility(View.GONE);
                    getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", "").commit();
                    nothing.setVisibility(View.VISIBLE);
                    viewpackage.setVisibility(View.VISIBLE);
                    menubar.setText("OU Papers");
                    file.delete();
                }
                else
                {
                    int del = 0;
                    int del2 = 0;
                    File f = new File(PapersFolder + "/ZSYL");
                    File[] list1 = f.listFiles();
                    if (list1.length == 0)
                    {
                        redownload1.setVisibility(View.VISIBLE);
                        redownload1.setText("Redownload " + view1);
                        nothing1.setVisibility(View.VISIBLE);
                        del = 1;
                    }
                    File f2 = new File(PapersFolder);
                    File[] list2 = f2.listFiles();
                    int i, k = 0;
                    for (i = 0; i < list2.length; i++)
                    {
                        if (!list2[i].getName().toString().equals("ZSYL"))
                            k++;
                    }
                    if (k == 0)
                    {
                        redownload1.setVisibility(View.VISIBLE);
                        redownload1.setText("Redownload " + view1);
                        nothing1.setVisibility(View.VISIBLE);
                        del2 = 1;
                    }
                    if (del == 1 && del2 == 1)
                    {
                        nothing1.setVisibility(View.GONE);
                        redownload1.setVisibility(View.GONE);
                        shifter.setVisibility(View.GONE);
                        shiftpapers.setVisibility(View.GONE);
                        getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "").commit();
                        String ss = getSharedPreferences("VIEW", MODE_PRIVATE).getString("VIEW", "");
                        final String[] button = new String[1];
                        final String button1[] = new String[1];
                        final String[] name = {null};
                        if (ss.length() == 9) {
                            button[0] = "" + ss.charAt(4);
                            button1[0] = "" + ss.charAt(8);
                            name[0] = ss.substring(0, 3);
                        } else if (ss.length() == 8) {
                            button[0] = "" + ss.charAt(3);
                            button1[0] = "" + ss.charAt(7);
                            name[0] = ss.substring(0, 2);
                        }
                        getSharedPreferences("EYE", MODE_PRIVATE).edit().putString(name[0] + " " + button[0] + " - " + button1[0], "").commit();
                        delete.setVisibility(View.GONE);
                        redownload.setVisibility(View.GONE);
                        getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", "").commit();
                        nothing.setVisibility(View.VISIBLE);
                        viewpackage.setVisibility(View.VISIBLE);
                        menubar.setText("OU Papers");
                        file.delete();
                    }
                }
            }
            else
            {
                nothing1.setVisibility(View.GONE);
                redownload1.setVisibility(View.GONE);
            }
        }
        catch(Exception e)
        {}
        getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", false).commit();
        deleted=false;
        }
    private void viewer()
    {
        paperstrans.setVisibility(View.VISIBLE);
        papersmenu.setVisibility(View.VISIBLE);
        if(shaking)
        {
            stopanimation();
        }
        if (active)
        {
            active = false;
            layout.startAnimation(backanim);
            trans.setVisibility(View.GONE);
            layout.setVisibility(View.GONE);
        }
    }
    private void stopanimation()
    {
        getSharedPreferences("LEN",MODE_PRIVATE).edit().putString("LEN","00000000000000000000").commit();
        shaking=false;
        menu.setVisibility(View.VISIBLE);
        deletesub.setVisibility(View.INVISIBLE);
        delsubcancel.setVisibility(View.INVISIBLE);
        one.setBackgroundResource(R.drawable.background);
        two.setBackgroundResource(R.drawable.background);
        three.setBackgroundResource(R.drawable.background);
        four.setBackgroundResource(R.drawable.background);
        five.setBackgroundResource(R.drawable.background);
        six.setBackgroundResource(R.drawable.background);
        seven.setBackgroundResource(R.drawable.background);
        eight.setBackgroundResource(R.drawable.background);
        nine.setBackgroundResource(R.drawable.background);
        ten.setBackgroundResource(R.drawable.background);
        ele.setBackgroundResource(R.drawable.background);
        twe.setBackgroundResource(R.drawable.background);
        thir.setBackgroundResource(R.drawable.background);
        fourt.setBackgroundResource(R.drawable.background);
        fifteen.setBackgroundResource(R.drawable.background);
        sixteen.setBackgroundResource(R.drawable.background);
        seventeen.setBackgroundResource(R.drawable.background);
        eighteen.setBackgroundResource(R.drawable.background);
        nineteen.setBackgroundResource(R.drawable.background);
        twenty.setBackgroundResource(R.drawable.background);

        one.clearAnimation();
        two.clearAnimation();
        three.clearAnimation();
        four.clearAnimation();
        five.clearAnimation();
        six.clearAnimation();
        seven.clearAnimation();
        eight.clearAnimation();
        nine.clearAnimation();
        ten.clearAnimation();
        ele.clearAnimation();
        twe.clearAnimation();
        thir.clearAnimation();
        fourt.clearAnimation();
        fifteen.clearAnimation();
        sixteen.clearAnimation();
        seventeen.clearAnimation();
        eighteen.clearAnimation();
        nineteen.clearAnimation();
        twenty.clearAnimation();
    }
    private boolean isMyServiceRunning(Class<?> serviceClass)
    {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE))
        {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
    private void startanimation()
    {
        if(!shaking)
        {
            shaking=true;
        }
        deletesub.setVisibility(View.VISIBLE);
        delsubcancel.setVisibility(View.VISIBLE);
        one.startAnimation(shakeleft);
        if(twof)
            two.startAnimation(shakeleft);
        three.startAnimation(shakeleft);
        if(fourf)
            four.startAnimation(shakeleft);
        five.startAnimation(shakeleft);
        if(sixf)
            six.startAnimation(shakeleft);
        seven.startAnimation(shakeleft);
        if(eightf)
            eight.startAnimation(shakeleft);
        nine.startAnimation(shakeleft);
        if(tenf)
            ten.startAnimation(shakeleft);
        ele.startAnimation(shakeleft);
        if(twf)
            twe.startAnimation(shakeleft);
        thir.startAnimation(shakeleft);
        if(forf)
            fourt.startAnimation(shakeleft);
        fifteen.startAnimation(shakeleft);
        if(sixteenf)
            sixteen.startAnimation(shakeleft);
        seventeen.startAnimation(shakeleft);
        if(eightteenf)
            eighteen.startAnimation(shakeleft);
        nineteen.startAnimation(shakeleft);
        if(twentyf)
            twenty.startAnimation(shakeleft);
    }
    @Override
    protected void onPause()
    {
        int[] len=new int[20];
        if(done)
            len[0]=1;
        if(dtwo)
            len[1]=1;
        if(dthree)
            len[2]=1;
        if(dfour)
            len[3]=1;
        if(dfive)
            len[4]=1;
        if(dsix)
            len[5]=1;
        if(dseven)
            len[6]=1;
        if(deight)
            len[7]=1;
        if(dnine)
            len[8]=1;
        if(dten)
            len[9]=1;
        if(dele)
            len[10]=1;
        if(dtwe)
            len[11]=1;
        if(dthir)
            len[12]=1;
        if(dfourt)
            len[13]=1;
        if(dfifteen)
            len[14]=1;
        if(dsixteen)
            len[15]=1;
        if(dsventeen)
            len[16]=1;
        if(deighteen)
            len[17]=1;
        if(dnineten)
            len[18]=1;
        if(dtwenty)
            len[19]=1;

            String len1 = ""+ len[0]+len[1]+ len[2]+ len[3]+ len[4]+ len[5]+ len[6]+ len[7]+
                    len[8]+ len[9]+ len[10]+ len[11]+ len[12]+ len[13]+ len[14]+ len[15]
                    + len[16]+ len[17]+ len[18] +len[19];
        getSharedPreferences("LEN",MODE_PRIVATE).edit().putString("LEN",len1).commit();
        getSharedPreferences("ACTIVE1",MODE_PRIVATE).edit().putBoolean("ACTIVE1",active).commit();
        getSharedPreferences("PAP",MODE_PRIVATE).edit().putBoolean("PAP",pap).commit();
        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
        super.onPause();
    }
    private void looper(File delete)
    {
        try {
            if (delete.isDirectory())
            {
                for (File fil : delete.listFiles())
                {
                    looper(fil);
                }
            }
            delete.delete();
        }
        catch(Exception e)
        {
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if (!shaking)
            {
                if (active)
                {
                    active = false;
                    layout.startAnimation(backanim);
                    trans.setVisibility(View.GONE);
                    layout.setVisibility(View.GONE);
                }
                else if(pap)
                {
                    pap=false;
                    paperstrans.setVisibility(View.GONE);
                    papersmenu.setVisibility(View.GONE);
                }
                else
                {

                    getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", scroll.getScrollY()).commit();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                    {
                        finishAffinity();
                    } else
                        System.exit(0);
                }
            }
            else
            {
                done=false;
                dtwo=false;
                dthree=false;
                dfour=false;
                dfive=false;
                dsix=false;
                dseven=false;
                deight=false;
                dnine=false;
                dten=false;
                dele=false;
                dtwe=false;
                dthir=false;
                dfour=false;
                dfifteen=false;
                dsixteen=false;
                dsventeen=false;
                deighteen=false;
                dnineten=false;
                dtwenty=false;
                stopanimation();

                shaking=false;
                stopanimation();
            }
        }
        return false;
    }
    public void rateit()
    {
        Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try
        {
            startActivity(goToMarket);
        }
        catch (ActivityNotFoundException e)
        {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
        }
    }
    private boolean isconnected(Context baseContext)
    {
        ConnectivityManager conn=(ConnectivityManager) baseContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(conn!=null)
        {
            NetworkInfo net=conn.getActiveNetworkInfo();
            if(net!=null)
                if(net.isConnected())
                    return true;
        }
        return false;
    }
}

