package net.net23.freeismail.oupapers12;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class pack extends Activity
{
    private AlertDialog.Builder dialog;
    private AlertDialog dialog1;
    private NotificationCompat.Builder builder2;
    private NotificationManager noti2;
    private LinearLayout layout;
    private TextView top1, top2, top3, top4, top5, top6, top7,top8,one,two, three, four, five, six, seven, eight,
            cse, ece, eee, it, auto, civil, mec, ins, pro,trans, menubar, menubar2, nostream;
    private ImageButton down1,down2, down3, down4, down5, down6, down7, down8,canc1,canc2, canc3, canc4, canc5, canc6, canc7, canc8
            ,eye1,eye2, eye3, eye4, eye5, eye6, eye7, eye8,menu;
    private ProgressBar pb;
    private boolean visible = false,active,loading = false;
    private Animation anim, backanim;
    private ScrollView scroll;
    private int loading1 =0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pack);
        getSharedPreferences("ACTIVE1",MODE_PRIVATE).edit().putBoolean("ACTIVE1",false).commit();
        getSharedPreferences("PAP",MODE_PRIVATE).edit().putBoolean("PAP",false).commit();


        anim = AnimationUtils.loadAnimation(this, R.anim.flow);
        backanim = AnimationUtils.loadAnimation(this, R.anim.backanin);

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Add intializtion

                //Initialization
                top1 = (TextView) findViewById(R.id.top1);
                top2 = (TextView) findViewById(R.id.top2);
                top3 =(TextView)findViewById(R.id.top3);
                top4 = (TextView) findViewById(R.id.top4);
                top5 = (TextView) findViewById(R.id.top5);
                top6 = (TextView) findViewById(R.id.top6);
                top7 = (TextView) findViewById(R.id.top7);
                top8=(TextView)findViewById(R.id.top8);

                scroll =(ScrollView)  findViewById(R.id.scroll);

                eye1 = (ImageButton) findViewById(R.id.eye1);
                eye2=(ImageButton)findViewById(R.id.eye2);
                eye3 =(ImageButton)  findViewById(R.id.eye3);
                eye4 =(ImageButton)findViewById(R.id.eye4);
                eye5 = (ImageButton)findViewById(R.id.eye5);
                eye6 =(ImageButton) findViewById(R.id.eye6);
                eye7 = (ImageButton)findViewById(R.id.eye7);
                eye8 = (ImageButton)findViewById(R.id.eye8);

                canc1 =(ImageButton) findViewById(R.id.cancel1);
                canc2 =(ImageButton) findViewById(R.id.cancel2);
                canc3 = (ImageButton) findViewById(R.id.cancel3);
                canc4 = (ImageButton) findViewById(R.id.cancel4);
                canc5 = (ImageButton) findViewById(R.id.cancel5);
                canc6 = (ImageButton) findViewById(R.id.cancel6);
                canc7 =(ImageButton)findViewById(R.id.cancel7);
                canc8 = (ImageButton) findViewById(R.id.cancel8);

                pb = (ProgressBar) findViewById(R.id.pp);

                down1 = (ImageButton)findViewById(R.id.image1);
                down2 = (ImageButton)findViewById(R.id.image2);
                down3 =(ImageButton) findViewById(R.id.image3);
                down4 = (ImageButton) findViewById(R.id.image4);
                down5 = (ImageButton)findViewById(R.id.image5);
                down6 = (ImageButton) findViewById(R.id.image6);
                down7 =(ImageButton)findViewById(R.id.image7);
                down8 = (ImageButton) findViewById(R.id.image8);

                one =  (TextView)findViewById(R.id.button1);
                two =  (TextView)findViewById(R.id.button2);
                three =(TextView) findViewById(R.id.button3);
                four = (TextView) findViewById(R.id.button4);
                five = (TextView)findViewById(R.id.button5);
                six = (TextView)findViewById(R.id.button6);
                seven = (TextView)findViewById(R.id.button7);
                eight = (TextView)findViewById(R.id.button8);

                nostream = (TextView) findViewById(R.id.streamnotselected);
                layout =(LinearLayout)  findViewById(R.id.branchmenu);
                menu =(ImageButton)  findViewById(R.id.menu);
                cse =  (TextView)findViewById(R.id.cse);
                ece = (TextView) findViewById(R.id.ece);
                mec = (TextView)findViewById(R.id.mec);
                auto = (TextView) findViewById(R.id.auto);
                eee = (TextView)findViewById(R.id.eee);
                civil = (TextView)findViewById(R.id.civil);
                it =(TextView) findViewById(R.id.it);
                ins = (TextView) findViewById(R.id.ins);
                pro =(TextView) findViewById(R.id.pro);
                trans = (TextView) findViewById(R.id.trans);
                menubar =  (TextView)findViewById(R.id.menubar);
                menubar2 =(TextView) findViewById(R.id.manubar2);


                //Visiblity
                top1.setVisibility(View.GONE);
                top2.setVisibility(View.GONE);
                top3.setVisibility(View.GONE);
                top4.setVisibility(View.GONE);
                top5.setVisibility(View.GONE);
                top6.setVisibility(View.GONE);
                top7.setVisibility(View.GONE);
                top8.setVisibility(View.GONE);

                pb.setVisibility(View.GONE);
                nostream.setVisibility(View.GONE);
                layout.setVisibility(View.GONE);
                trans.setVisibility(View.GONE);
                eye1.setVisibility(View.GONE);


                //Setting up color of progree bar
                pb.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.pro), PorterDuff.Mode.SRC_IN);


                //Setting button
                if (!isMyServiceRunning(service.class)) {
                    getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "").commit();
                }

                //Setting scroll
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        scroll.scrollTo(0, getSharedPreferences("SCROLL2", MODE_PRIVATE).getInt("SCROLL2", 0));
                    }
                }, 50);


                //Click Listeners
                eye1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        eye1();
                    }
                });
                eye2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        eye2();
                    }
                });
                eye3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        eye3();
                    }
                });
                eye4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        eye4();
                    }
                });
                eye5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        eye5();
                    }
                });
                eye6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        eye6();
                    }
                });
                eye7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        eye7();
                    }
                });
                eye8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        eye8();
                    }
                });

                canc1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        canc();
                    }
                });
                canc2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        canc();
                    }
                });
                canc3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        canc();
                    }
                });
                canc4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        canc();
                    }
                });
                canc5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        canc();
                    }
                });
                canc6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        canc();
                    }
                });
                canc7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        canc();
                    }
                });
                canc8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        canc();
                    }
                });

                down1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down11();
                    }
                });
                down2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down12();
                    }
                });
                down3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down21();
                    }
                });
                down4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down22();
                    }
                });
                down5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down31();
                    }
                });
                down6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down32();
                    }
                });
                down7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down41();
                    }
                });
                down8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down42();
                    }
                });

                one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down11();
                    }
                });
                two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down12();
                    }
                });
                three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down21();
                    }
                });
                four.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down22();
                    }
                });
                five.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down31();
                    }
                });
                six.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down32();
                    }
                });
                seven.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down41();
                    }
                });
                eight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        down42();
                    }
                });
                menubar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!loading)
                            if (visible)
                            {
                                visible = false;
                                trans.setVisibility(View.GONE);
                                layout.startAnimation(backanim);
                                layout.setVisibility(View.GONE);
                            }
                    }
                });
                menubar2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!loading)
                            if (visible) {
                                visible = false;
                                trans.setVisibility(View.GONE);
                                layout.startAnimation(backanim);
                                layout.setVisibility(View.GONE);
                            }
                    }
                });
                ins.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Handler han = new Handler();
                        if (!menubar2.getText().toString().equals("INS"))
                        {
                            try {
                                trans.setClickable(false);
                                loading = true;
                                pb.setVisibility(View.VISIBLE);
                                han.postDelayed(
                                        new Runnable() {
                                            @Override
                                            public void run() {
                                                trans.setClickable(true);
                                                loading = false;
                                                trans.setVisibility(View.GONE);
                                                pb.setVisibility(View.GONE);
                                            }
                                        }, 500);
                                getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", 0).commit();
                                Handler h = new Handler();
                                h.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        scroll.scrollTo(0, getSharedPreferences("SCROLL2", MODE_PRIVATE).getInt("SCROLL2", 0));
                                    }
                                }, 50);
                                getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "INS").commit();
                                menubar2.setText("INS");
                                buttonnamer();
                            } catch (Exception e) {
                            }
                        } else {
                            trans.setClickable(true);
                            trans.setVisibility(View.GONE);
                            pb.setVisibility(View.GONE);
                        }
                        cse.setClickable(false);
                        it.setClickable(false);
                        auto.setClickable(false);
                        ece.setClickable(false);
                        mec.setClickable(false);
                        civil.setClickable(false);
                        eee.setClickable(false);
                        ins.setClickable(false);
                        pro.setClickable(false);
                        ins.setBackgroundResource(R.drawable.clickedmenu);
                        visible = false;
                        layout.startAnimation(backanim);
                        han.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                cse.setClickable(true);
                                it.setClickable(true);
                                auto.setClickable(true);
                                ece.setClickable(true);
                                mec.setClickable(true);
                                civil.setClickable(true);
                                eee.setClickable(true);
                                ins.setClickable(true);
                                pro.setClickable(true);
                                layout.setVisibility(View.GONE);
                                ins.setBackgroundColor(Color.WHITE);
                            }
                        }, 190);
                    }
                });
                pro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Handler han = new Handler();
                        if (!menubar2.getText().toString().equals("PRO"))

                        {
                            trans.setClickable(false);
                            loading = true;
                            pb.setVisibility(View.VISIBLE);

                            han.postDelayed(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            trans.setClickable(true);
                                            loading = false;
                                            trans.setVisibility(View.GONE);
                                            pb.setVisibility(View.GONE);
                                        }
                                    }, 500);
                            getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", 0).commit();
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    scroll.scrollTo(0, getSharedPreferences("SCROLL2", MODE_PRIVATE).getInt("SCROLL2", 0));
                                }
                            }, 50);
                            getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "PRO").commit();
                            menubar2.setText("PRO");
                            buttonnamer();
                        } else {
                            trans.setClickable(true);
                            trans.setVisibility(View.GONE);
                            pb.setVisibility(View.GONE);
                        }
                        pro.setBackgroundResource(R.drawable.clickedmenu);
                        cse.setClickable(false);
                        it.setClickable(false);
                        auto.setClickable(false);
                        ece.setClickable(false);
                        mec.setClickable(false);
                        civil.setClickable(false);
                        eee.setClickable(false);
                        pro.setClickable(false);
                        ins.setClickable(false);
                        visible = false;
                        layout.startAnimation(backanim);
                        han.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                cse.setClickable(true);
                                it.setClickable(true);
                                auto.setClickable(true);
                                ece.setClickable(true);
                                mec.setClickable(true);
                                civil.setClickable(true);
                                eee.setClickable(true);
                                pro.setClickable(true);
                                ins.setClickable(true);
                                layout.setVisibility(View.GONE);
                                pro.setBackgroundColor(Color.WHITE);
                            }
                        }, 190);
                    }
                });
                mec.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Handler han = new Handler();
                        if (!menubar2.getText().toString().equals("MEC"))

                        {
                            trans.setClickable(false);
                            loading = true;
                            pb.setVisibility(View.VISIBLE);

                            han.postDelayed(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            trans.setClickable(true);
                                            loading = false;
                                            trans.setVisibility(View.GONE);
                                            pb.setVisibility(View.GONE);
                                        }
                                    }, 500);
                            getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", 0).commit();
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    scroll.scrollTo(0, getSharedPreferences("SCROLL2", MODE_PRIVATE).getInt("SCROLL2", 0));
                                }
                            }, 50);
                            getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "MEC").commit();
                            menubar2.setText("MEC");
                            buttonnamer();
                        } else {
                            trans.setClickable(true);
                            trans.setVisibility(View.GONE);
                            pb.setVisibility(View.GONE);
                        }
                        mec.setBackgroundResource(R.drawable.clickedmenu);
                        cse.setClickable(false);
                        it.setClickable(false);
                        auto.setClickable(false);
                        ece.setClickable(false);
                        mec.setClickable(false);
                        civil.setClickable(false);
                        eee.setClickable(false);
                        pro.setClickable(false);
                        ins.setClickable(false);
                        visible = false;
                        layout.startAnimation(backanim);
                        han.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                cse.setClickable(true);
                                it.setClickable(true);
                                auto.setClickable(true);
                                ece.setClickable(true);
                                mec.setClickable(true);
                                civil.setClickable(true);
                                eee.setClickable(true);
                                pro.setClickable(true);
                                ins.setClickable(true);
                                layout.setVisibility(View.GONE);
                                mec.setBackgroundColor(Color.WHITE);
                            }
                        }, 190);
                    }
                });
                auto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Handler han = new Handler();
                        if (!menubar2.getText().toString().equals("AE")) {
                            trans.setClickable(false);
                            loading = true;
                            pb.setVisibility(View.VISIBLE);

                            han.postDelayed(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            trans.setClickable(true);
                                            loading = false;
                                            trans.setVisibility(View.GONE);
                                            pb.setVisibility(View.GONE);
                                        }
                                    }, 500);
                            getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", 0).commit();
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    scroll.scrollTo(0, getSharedPreferences("SCROLL2", MODE_PRIVATE).getInt("SCROLL2", 0));
                                }
                            }, 50);
                            getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "AE").commit();
                            menubar2.setText("AE");
                            buttonnamer();
                        } else {
                            trans.setClickable(true);
                            trans.setVisibility(View.GONE);
                            pb.setVisibility(View.GONE);
                        }
                        auto.setBackgroundResource(R.drawable.clickedmenu);
                        cse.setClickable(false);
                        it.setClickable(false);
                        auto.setClickable(false);
                        ece.setClickable(false);
                        mec.setClickable(false);
                        civil.setClickable(false);
                        eee.setClickable(false);
                        pro.setClickable(false);
                        ins.setClickable(false);
                        layout.startAnimation(backanim);
                        visible = false;
                        han.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                cse.setClickable(true);
                                it.setClickable(true);
                                auto.setClickable(true);
                                ece.setClickable(true);
                                mec.setClickable(true);
                                civil.setClickable(true);
                                eee.setClickable(true);
                                pro.setClickable(true);
                                ins.setClickable(true);
                                layout.setVisibility(View.GONE);
                                auto.setBackgroundColor(Color.WHITE);
                            }
                        }, 190);
                    }
                });
                eee.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Handler han = new Handler();
                        if (!menubar2.getText().toString().equals("EEE")) {
                            trans.setClickable(false);
                            loading = true;
                            pb.setVisibility(View.VISIBLE);
                            han.postDelayed(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            trans.setClickable(true);
                                            loading = false;
                                            trans.setVisibility(View.GONE);
                                            pb.setVisibility(View.GONE);
                                        }
                                    }, 500);
                            getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", 0).commit();
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    scroll.scrollTo(0, getSharedPreferences("SCROLL2", MODE_PRIVATE).getInt("SCROLL2", 0));
                                }
                            }, 50);
                            getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "EEE").commit();
                            menubar2.setText("EEE");
                            buttonnamer();
                        } else {
                            trans.setClickable(true);
                            trans.setVisibility(View.GONE);
                            pb.setVisibility(View.GONE);
                        }
                        eee.setBackgroundResource(R.drawable.clickedmenu);
                        cse.setClickable(false);
                        it.setClickable(false);
                        auto.setClickable(false);
                        ece.setClickable(false);
                        mec.setClickable(false);
                        civil.setClickable(false);
                        eee.setClickable(false);
                        pro.setClickable(false);
                        ins.setClickable(false);
                        visible = false;
                        layout.startAnimation(backanim);
                        han.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                cse.setClickable(true);
                                it.setClickable(true);
                                auto.setClickable(true);
                                ece.setClickable(true);
                                mec.setClickable(true);
                                civil.setClickable(true);
                                eee.setClickable(true);
                                pro.setClickable(true);
                                ins.setClickable(true);
                                layout.setVisibility(View.GONE);
                                eee.setBackgroundColor(Color.WHITE);
                            }
                        }, 190);
                    }
                });
                civil.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Handler han = new Handler();
                        if (!menubar2.getText().toString().equals("CE"))

                        {
                            trans.setClickable(false);
                            loading = true;
                            pb.setVisibility(View.VISIBLE);

                            han.postDelayed(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            trans.setClickable(true);
                                            loading = false;
                                            trans.setVisibility(View.GONE);
                                            pb.setVisibility(View.GONE);
                                        }
                                    }, 500);
                            getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", 0).commit();
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    scroll.scrollTo(0, getSharedPreferences("SCROLL2", MODE_PRIVATE).getInt("SCROLL2", 0));
                                }
                            }, 50);
                            getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "CE").commit();
                            menubar2.setText("CE");
                            buttonnamer();
                        } else {
                            trans.setClickable(true);
                            trans.setVisibility(View.GONE);
                            pb.setVisibility(View.GONE);
                        }
                        civil.setBackgroundResource(R.drawable.clickedmenu);
                        cse.setClickable(false);
                        it.setClickable(false);
                        auto.setClickable(false);
                        ece.setClickable(false);
                        mec.setClickable(false);
                        civil.setClickable(false);
                        eee.setClickable(false);
                        pro.setClickable(false);
                        ins.setClickable(false);
                        visible = false;
                        layout.startAnimation(backanim);
                        han.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                cse.setClickable(true);
                                it.setClickable(true);
                                auto.setClickable(true);
                                ece.setClickable(true);
                                mec.setClickable(true);
                                civil.setClickable(true);
                                eee.setClickable(true);
                                pro.setClickable(true);
                                ins.setClickable(true);
                                layout.setVisibility(View.GONE);
                                civil.setBackgroundColor(Color.WHITE);
                            }
                        }, 190);
                    }
                });
                it.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Handler han = new Handler();
                        if (!menubar2.getText().toString().equals("IT")) {
                            trans.setClickable(false);
                            loading = true;
                            pb.setVisibility(View.VISIBLE);
                            han.postDelayed(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            trans.setClickable(true);
                                            loading = false;
                                            trans.setVisibility(View.GONE);
                                            pb.setVisibility(View.GONE);
                                        }
                                    }, 500);
                            getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", 0).commit();
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    scroll.scrollTo(0, getSharedPreferences("SCROLL2", MODE_PRIVATE).getInt("SCROLL2", 0));
                                }
                            }, 50);
                            getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "IT").commit();
                            menubar2.setText("IT");
                            buttonnamer();
                        } else {
                            trans.setClickable(true);
                            trans.setVisibility(View.GONE);
                            pb.setVisibility(View.GONE);
                        }
                        it.setBackgroundResource(R.drawable.clickedmenu);
                        cse.setClickable(false);
                        it.setClickable(false);
                        auto.setClickable(false);
                        ece.setClickable(false);
                        mec.setClickable(false);
                        civil.setClickable(false);
                        eee.setClickable(false);
                        pro.setClickable(false);
                        ins.setClickable(false);
                        visible = false;
                        layout.startAnimation(backanim);
                        han.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                cse.setClickable(true);
                                it.setClickable(true);
                                auto.setClickable(true);
                                ece.setClickable(true);
                                mec.setClickable(true);
                                civil.setClickable(true);
                                eee.setClickable(true);
                                pro.setClickable(true);
                                ins.setClickable(true);
                                layout.setVisibility(View.GONE);
                                it.setBackgroundColor(Color.WHITE);
                            }
                        }, 190);
                    }
                });
                cse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Handler han = new Handler();
                        if (!menubar2.getText().toString().equals("CSE"))

                        {
                            trans.setClickable(false);
                            loading = true;
                            pb.setVisibility(View.VISIBLE);

                            han.postDelayed(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            trans.setClickable(true);
                                            loading = false;
                                            trans.setVisibility(View.GONE);
                                            pb.setVisibility(View.GONE);
                                        }
                                    }, 500);
                            getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", 0).commit();
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    scroll.scrollTo(0, getSharedPreferences("SCROLL2", MODE_PRIVATE).getInt("SCROLL2", 0));
                                }
                            }, 50);
                            getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "CSE").commit();
                            menubar2.setText("CSE");
                            buttonnamer();
                        } else {
                            trans.setClickable(true);
                            trans.setVisibility(View.GONE);
                            pb.setVisibility(View.GONE);
                        }
                        cse.setBackgroundResource(R.drawable.clickedmenu);
                        cse.setClickable(false);
                        it.setClickable(false);
                        auto.setClickable(false);
                        ece.setClickable(false);
                        mec.setClickable(false);
                        civil.setClickable(false);
                        eee.setClickable(false);
                        pro.setClickable(false);
                        ins.setClickable(false);
                        visible = false;
                        layout.startAnimation(backanim);
                        han.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                cse.setClickable(true);
                                it.setClickable(true);
                                auto.setClickable(true);
                                ece.setClickable(true);
                                mec.setClickable(true);
                                civil.setClickable(true);
                                eee.setClickable(true);
                                pro.setClickable(true);
                                ins.setClickable(true);
                                layout.setVisibility(View.GONE);
                                cse.setBackgroundColor(Color.WHITE);
                            }
                        }, 190);
                    }
                });
                ece.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Handler han = new Handler();
                        if (!menubar2.getText().toString().equals("ECE"))

                        {
                            trans.setClickable(false);
                            loading = true;
                            pb.setVisibility(View.VISIBLE);

                            han.postDelayed(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            trans.setClickable(true);
                                            loading = false;
                                            trans.setVisibility(View.GONE);
                                            pb.setVisibility(View.GONE);
                                        }
                                    }, 500);
                            getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", 0).commit();
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    scroll.scrollTo(0, getSharedPreferences("SCROLL2", MODE_PRIVATE).getInt("SCROLL2", 0));
                                }
                            }, 50);
                            getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "ECE").commit();
                            menubar2.setText("ECE");
                            buttonnamer();
                        } else {
                            trans.setClickable(true);
                            trans.setVisibility(View.GONE);
                            pb.setVisibility(View.GONE);
                        }
                        ece.setBackgroundResource(R.drawable.clickedmenu);
                        cse.setClickable(false);
                        it.setClickable(false);
                        auto.setClickable(false);
                        ece.setClickable(false);
                        mec.setClickable(false);
                        civil.setClickable(false);
                        eee.setClickable(false);
                        pro.setClickable(false);
                        ins.setClickable(false);
                        visible = false;
                        layout.startAnimation(backanim);
                        han.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                cse.setClickable(true);
                                it.setClickable(true);
                                auto.setClickable(true);
                                ece.setClickable(true);
                                mec.setClickable(true);
                                civil.setClickable(true);
                                eee.setClickable(true);
                                pro.setClickable(true);
                                ins.setClickable(true);
                                layout.setVisibility(View.GONE);
                                ece.setBackgroundColor(Color.WHITE);
                            }
                        }, 190);
                    }

                });
                menu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        if (!loading)
                            if (!visible)
                            {
                                NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                                noti1.cancel(0);
                                trans.setVisibility(View.VISIBLE);
                                layout.setVisibility(View.VISIBLE);
                                layout.startAnimation(anim);
                                visible = true;
                            } else
                            {
                                trans.setVisibility(View.GONE);
                                layout.startAnimation(backanim);
                                visible = false;
                                layout.setVisibility(View.GONE);
                            }
                    }
                });
                trans.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (!loading) {
                            visible = false;
                            layout.startAnimation(backanim);
                            trans.setVisibility(View.GONE);
                            layout.setVisibility(View.GONE);
                        }
                        return false;
                    }
                });
               /* trans.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!loading) {
                            visible = false;
                            layout.startAnimation(backanim);
                            trans.setVisibility(View.GONE);
                            layout.setVisibility(View.GONE);
                        }
                    }
                });*/

                //Calling background
                new background1().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });
    }
    @Override
    protected void onStart()
    {

        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        noti1.cancel(0);
        buttonnamer();
        active = true;
        super.onStart();
    }

    @Override
    protected void onStop()
    {
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        noti1.cancel(0);
        active = false;
        super.onStop();
        getSharedPreferences("ACTIVE2",MODE_PRIVATE).edit().putBoolean("ACTIVE2",visible).commit();
    }
    public class background1 extends AsyncTask<String,Void,Long>
    {
        @Override
        protected void onPreExecute()
        {
            //Setting menu
            if(getSharedPreferences("ACTIVE2",MODE_PRIVATE).getBoolean("ACTIVE2",false))
            {

                visible = true;
                trans.setVisibility(View.VISIBLE);
                layout.setVisibility(View.VISIBLE);
                nostream.setVisibility(View.VISIBLE);
            }

            //Notifivation1
            builder2 = new NotificationCompat.Builder(pack.this);
            builder2.setSmallIcon(R.drawable.logo);
            Intent intent2 = new Intent(pack.this, see.class);
            TaskStackBuilder stackBuil2 = TaskStackBuilder.create(pack.this);
            stackBuil2.addParentStack(see.class);
            stackBuil2.addNextIntent(intent2);
            PendingIntent pendingintnet2 = stackBuil2.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            builder2.setContentIntent(pendingintnet2);
            noti2 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            //Setting dialog
            dialog = new AlertDialog.Builder(pack.this);
            dialog.setView(View.INVISIBLE);
            dialog.setMessage("Stop downloading?");
            dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            dialog1 = dialog.create();
            dialog1.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    dialog1.getButton(android.app.AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                    dialog1.getButton(android.app.AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                }
            });

            String string = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            if (string.equals(""))
            {
                visible = true;
                trans.setVisibility(View.VISIBLE);
                layout.setVisibility(View.VISIBLE);
                layout.startAnimation(anim);
                nostream.setVisibility(View.VISIBLE);
            }
            else {
                menubar2.setText(string);
            }
            super.onPreExecute();
        }

        @Override
        protected Long doInBackground(String... strings)
        {

            return null;
        }
    }
    private void looper()
    {
        Handler han = new Handler();
        han.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                String number = getSharedPreferences("BUTTON", MODE_PRIVATE).getString("BUTTON", "");
                String perc = getSharedPreferences("PERC", MODE_PRIVATE).getString("PERC", "");
                String con2 = getSharedPreferences("DOWN", MODE_PRIVATE).getString("DOWN", "");
                builder2.setContentTitle(con2 + " package");
                if (getSharedPreferences("STOP", MODE_PRIVATE).getString("STOP", "").equals("STOP"))
                {
                    builder2.setContentText("Stopping...");
                } else if (perc.equals("ST"))
                    builder2.setContentText("Starting...");
                else if (perc.length() >= 1 && !perc.equals("SO"))
                {
                    builder2.setContentText(perc + "% completed");
                }
                noti2.notify(1, builder2.build());

                if (perc.equals("99"))
                {
                    dialog1.cancel();
                }
                if (perc.equals("100"))
                {
                    NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    noti1.cancel(1);
                    if (visible) {
                        menu.setClickable(false);
                        trans.setVisibility(View.GONE);
                        layout.startAnimation(backanim);
                        visible = false;
                        layout.setVisibility(View.GONE);
                    }
                    menu.setClickable(true);
                    //noti0
                    String con1 = getSharedPreferences("SEE", MODE_PRIVATE).getString("SEE", "");
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(pack.this);
                    builder.setSmallIcon(R.drawable.logo);
                    builder.setContentTitle(con1 + " package");
                    builder.setContentTitle(con1 + " package");
                    builder.setContentText("Downloaded");
                    builder.setVibrate(new long[]{500, 500});
                    builder.setLights(Color.WHITE, 3000, 3000);
                    builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
                    Intent intent = new Intent(pack.this, pack.class);
                    TaskStackBuilder stackBuil = TaskStackBuilder.create(pack.this);
                    stackBuil.addParentStack(pack.class);
                    stackBuil.addNextIntent(intent);
                    PendingIntent pendingintnet = stackBuil.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                    builder.setContentIntent(pendingintnet);
                    noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    noti1.notify(0, builder.build());

                    getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", "").commit();
                    dialog1.cancel();
                    String con = getSharedPreferences("DOWN", MODE_PRIVATE).getString("DOWN", "");
                    getSharedPreferences("EYE", MODE_PRIVATE).edit().putString(con, "YES").commit();
                    String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                    getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "").commit();

                    //scroll
                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            scroll.scrollTo(0, getSharedPreferences("SCROLL3", MODE_PRIVATE).getInt("SCROLL3", 0));
                        }
                    }, 50);

                    //Progress bar
                    pb.setVisibility(View.VISIBLE);
                    trans.setVisibility(View.VISIBLE);
                    trans.setClickable(false);
                    loading = true;
                    Handler han = new Handler();
                    han.postDelayed(
                            new Runnable() {
                                @Override
                                public void run() {
                                    trans.setClickable(true);
                                    loading = false;
                                    trans.setVisibility(View.GONE);
                                    pb.setVisibility(View.GONE);
                                }
                            }, 1000);
                    if (number.equals("1"))
                    {
                        one.setText("BE  1 - 1");
                        down1.setVisibility(View.GONE);
                        canc1.setVisibility(View.GONE);
                        eye1.setVisibility(View.VISIBLE);
                    }
                    if (number.equals("2"))
                    {
                        two.setText("  " + name + " 1 - 2   ");
                        down2.setVisibility(View.GONE);
                        canc2.setVisibility(View.GONE);
                        eye2.setVisibility(View.VISIBLE);
                    }
                    else if (number.equals("3")) {
                        three.setText("  " + name + " 2 - 1   ");
                        down3.setVisibility(View.GONE);
                        canc3.setVisibility(View.GONE);
                        eye3.setVisibility(View.VISIBLE);
                    } else if (number.equals("4")) {
                        four.setText("  " + name + " 2 - 2   ");
                        down4.setVisibility(View.GONE);
                        canc4.setVisibility(View.GONE);
                        eye4.setVisibility(View.VISIBLE);
                    } else if (number.equals("5")) {
                        five.setText("  " + name + " 3 - 1   ");
                        down5.setVisibility(View.GONE);
                        canc5.setVisibility(View.GONE);
                        eye5.setVisibility(View.VISIBLE);
                    } else if (number.equals("6")) {
                        six.setText("  " + name + " 3 - 2   ");
                        down6.setVisibility(View.GONE);
                        canc6.setVisibility(View.GONE);
                        eye6.setVisibility(View.VISIBLE);
                    } else if (number.equals("7")) {
                        seven.setText("  " + name + " 4 - 1   ");
                        down7.setVisibility(View.GONE);
                        canc7.setVisibility(View.GONE);
                        eye7.setVisibility(View.VISIBLE);
                    } else if (number.equals("8")) {
                        eight.setText("  " + name + " 4 - 2   ");
                        down8.setVisibility(View.GONE);
                        canc8.setVisibility(View.GONE);
                        eye8.setVisibility(View.VISIBLE);
                    }
                    String down = getSharedPreferences("DOWN", MODE_PRIVATE).getString("DOWN", "");
                    String menu1 = getSharedPreferences("MENU1", MODE_PRIVATE).getString("MENU1", "");
                    if (!menu1.equals(""))
                    {
                        if (menu1.equals("CSE"))
                            down = "CSE11";
                        else if (menu1.equals("IT"))
                            down = "IT11";
                        else if (menu1.equals("AE"))
                            down = "AE11";
                        else if (menu1.equals("ECE"))
                            down = "ECE11";
                        else if (menu1.equals("EEE"))
                            down = "EEE11";
                        else if (menu1.equals("MEC"))
                            down = "MEC11";
                        else if (menu1.equals("CE"))
                            down = "CE11";
                        else if (menu1.equals("INS"))
                            down = "INS11";
                        else if (menu1.equals("PRO"))
                            down = "PRO11";
                    }
                    if (down.startsWith("CSE")) {
                        menubar2.setText("CSE");
                        getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "CSE").commit();
                    } else if (down.startsWith("IT")) {
                        menubar2.setText("IT");
                        getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "IT").commit();
                    } else if (down.startsWith("MEC")) {
                        menubar2.setText("MEC");
                        getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "MEC").commit();
                    } else if (down.startsWith("ECE")) {
                        menubar2.setText("ECE");
                        getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "ECE").commit();
                    } else if (down.startsWith("EEE")) {
                        menubar2.setText("EEE");
                        getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "EEE").commit();
                    } else if (down.startsWith("AE")) {
                        menubar2.setText("AE");
                        getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "AE").commit();
                    } else if (down.startsWith("PRO")) {
                        menubar2.setText("PRO");
                        getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "PRO").commit();
                    } else if (down.startsWith("INS")) {
                        menubar2.setText("INS");
                        getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "INS").commit();
                    } else if (down.startsWith("CE")) {
                        menubar2.setText("CE");
                        getSharedPreferences("MENU", MODE_PRIVATE).edit().putString("MENU", "CE").commit();
                    }


                    getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "").commit();
                    buttonnamer();
                } else
                {
                    String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                    String down = getSharedPreferences("DOWN", MODE_PRIVATE).getString("DOWN", "");
                    if (perc.equals("ST")) {
                        if (number.equals("1") && down.startsWith(down))
                            one.setText("Starting...");
                        else  if (number.equals("2") && down.startsWith(menu))
                            two.setText("Starting...");
                        else if (number.equals("3") && down.startsWith(menu))
                            three.setText("Starting...");
                        else if (number.equals("4") && down.startsWith(menu))
                            four.setText("Starting...");
                        else if (number.equals("5") && down.startsWith(menu))
                            five.setText("Starting...");
                        else if (number.equals("6") && down.startsWith(menu))
                            six.setText("Starting...");
                        else if (number.equals("7") && down.startsWith(menu))
                            seven.setText("Starting...");
                        else if (number.equals("8") && down.startsWith(menu))
                            eight.setText("Starting...");
                    } else if (perc.equals("SO")) {
                        if (number.equals("1") && down.startsWith(down))
                            one.setText("Stopping...");
                      else  if (number.equals("2") && down.startsWith(menu))
                            two.setText("Stopping...");
                        else if (number.equals("3") && down.startsWith(menu))
                            three.setText("Stopping...");
                        else if (number.equals("4") && down.startsWith(menu))
                            four.setText("Stopping...");
                        else if (number.equals("5") && down.startsWith(menu))
                            five.setText("Stopping...");
                        else if (number.equals("6") && down.startsWith(menu))
                            six.setText("Stopping...");
                        else if (number.equals("7") && down.startsWith(menu))
                            seven.setText("Stopping...");
                        else if (number.equals("8") && down.startsWith(menu))
                            eight.setText("Stopping...");

                    } else if (perc.length() >= 1) {
                        if (number.equals("1") && down.startsWith(down))
                            one.setText(perc + "% completed");
                        else if (number.equals("2") && down.startsWith(menu))
                            two.setText(perc + "% completed");
                        else if (number.equals("3") && down.startsWith(menu))
                            three.setText(perc + "% completed");
                        else if (number.equals("4") && down.startsWith(menu))
                            four.setText(perc + "% completed");
                        else if (number.equals("5") && down.startsWith(menu))
                            five.setText(perc + "% completed");
                        else if (number.equals("6") && down.startsWith(menu))
                            six.setText(perc + "% completed");
                        else if (number.equals("7") && down.startsWith(menu))
                            seven.setText(perc + "% completed");
                        else if (number.equals("8") && down.startsWith(menu))
                            eight.setText(perc + "% completed");
                    }
                }
                if (isMyServiceRunning(service.class))
                {
                    loading1=1;
                    looper();
                }
                else
                    {
                    getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "").commit();
                        Handler han1=new Handler();
                        han1.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                               loading1=0;
                            }
                        },100);
                    buttonnamer();
                    if (!getSharedPreferences("ERROR", MODE_PRIVATE).getString("ERROR", "").equals("ERROR"))
                    {
                        final NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        Handler han = new Handler();
                        han.postDelayed(new Runnable() {
                            @Override
                            public void run()

                            {
                                noti1.cancel(1);
                            }
                        }, 70);
                    }
                    if(dialog1.isShowing())
                    dialog1.cancel();
                }
            }
        }, 500);
    }
    private boolean isMyServiceRunning(Class<?> serviceClass)
    {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
    private boolean isconnected(Context baseContext) {
        ConnectivityManager conn = (ConnectivityManager) baseContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conn != null) {
            NetworkInfo net = conn.getActiveNetworkInfo();
            if (net != null)
                if (net.isConnected())
                    return true;
        }
        return false;
    }
    public void buttonnamer() {
        String button = getSharedPreferences("BUTTON", MODE_PRIVATE).getString("BUTTON", "");
        String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
        if (menu.equals("")) {
            eye1.setVisibility(View.GONE);
            eye2.setVisibility(View.GONE);
            eye3.setVisibility(View.GONE);
            eye4.setVisibility(View.GONE);
            eye5.setVisibility(View.GONE);
            eye6.setVisibility(View.GONE);
            eye7.setVisibility(View.GONE);
            eye8.setVisibility(View.GONE);

            canc1.setVisibility(View.GONE);
            canc2.setVisibility(View.GONE);
            canc3.setVisibility(View.GONE);
            canc4.setVisibility(View.GONE);
            canc5.setVisibility(View.GONE);
            canc6.setVisibility(View.GONE);
            canc7.setVisibility(View.GONE);
            canc8.setVisibility(View.GONE);

            down1.setVisibility(View.GONE);
            down2.setVisibility(View.GONE);
            down3.setVisibility(View.GONE);
            down4.setVisibility(View.GONE);
            down5.setVisibility(View.GONE);
            down6.setVisibility(View.GONE);
            down7.setVisibility(View.GONE);
            down8.setVisibility(View.GONE);

            one.setVisibility(View.GONE);
            two.setVisibility(View.GONE);
            three.setVisibility(View.GONE);
            four.setVisibility(View.GONE);
            five.setVisibility(View.GONE);
            six.setVisibility(View.GONE);
            seven.setVisibility(View.GONE);
            eight.setVisibility(View.GONE);
            nostream.setVisibility(View.VISIBLE);
        } else
        {
            one.setVisibility(View.VISIBLE);
            two.setVisibility(View.VISIBLE);
            three.setVisibility(View.VISIBLE);
            four.setVisibility(View.VISIBLE);
            five.setVisibility(View.VISIBLE);
            six.setVisibility(View.VISIBLE);
            seven.setVisibility(View.VISIBLE);
            eight.setVisibility(View.VISIBLE);

            canc1.setVisibility(View.GONE);
            canc2.setVisibility(View.GONE);
            canc3.setVisibility(View.GONE);
            canc4.setVisibility(View.GONE);
            canc5.setVisibility(View.GONE);
            canc6.setVisibility(View.GONE);
            canc7.setVisibility(View.GONE);
            canc8.setVisibility(View.GONE);

            eye1.setVisibility(View.GONE);
            eye2.setVisibility(View.GONE);
            eye3.setVisibility(View.GONE);
            eye4.setVisibility(View.GONE);
            eye5.setVisibility(View.GONE);
            eye6.setVisibility(View.GONE);
            eye7.setVisibility(View.GONE);
            eye8.setVisibility(View.GONE);

            down1.setVisibility(View.VISIBLE);
            down2.setVisibility(View.VISIBLE);
            down3.setVisibility(View.VISIBLE);
            down4.setVisibility(View.VISIBLE);
            down5.setVisibility(View.VISIBLE);
            down6.setVisibility(View.VISIBLE);
            down7.setVisibility(View.VISIBLE);
            down8.setVisibility(View.VISIBLE);
            one.setText("  BE 1 - 1   ");
            one.setBackgroundResource(R.drawable.background);
            two.setBackgroundResource(R.drawable.background);
            three.setBackgroundResource(R.drawable.background);
            four.setBackgroundResource(R.drawable.background);
            five.setBackgroundResource(R.drawable.background);
            six.setBackgroundResource(R.drawable.background);
            seven.setBackgroundResource(R.drawable.background);
            eight.setBackgroundResource(R.drawable.background);
            nostream.setVisibility(View.GONE);
        }
        if (menu.equals("CSE"))
        {
            two.setText("  CSE 1 - 2   ");
            three.setText("  CSE 2 - 1   ");
            four.setText("  CSE 2 - 2   ");
            five.setText("  CSE 3 - 1   ");
            six.setText("  CSE 3 - 2   ");
            seven.setText("CSE 4 - 1   ");
            eight.setText("  CSE 4 - 2   ");
        } else if (menu.equals("ECE"))
        {
            two.setText("  ECE 1 - 2   ");
            three.setText("  ECE 2 - 1   ");
            four.setText("  ECE 2 - 2   ");
            five.setText("  ECE 3 - 1   ");
            six.setText("  ECE 3 - 2   ");
            seven.setText("  ECE 4 - 1   ");
            eight.setText("  ECE 4 - 2   ");
        } else if (menu.equals("IT"))
        {
            two.setText("  IT 1 - 2   ");
            three.setText("  IT 2 - 1   ");
            four.setText("  IT 2 - 2   ");
            five.setText("  IT 3 - 1   ");
            six.setText("  IT 3 - 2   ");
            seven.setText("  IT 4 - 1   ");
            eight.setText("  IT 4 - 2   ");
        } else if (menu.equals("EEE"))
        {
            two.setText("  EEE 1 - 2   ");
            three.setText("  EEE 2 - 1   ");
            four.setText("  EEE 2 - 2   ");
            five.setText("  EEE 3 - 1   ");
            six.setText("  EEE 3 - 2   ");
            seven.setText("  EEE 4 - 1  ");
            eight.setText("  EEE 4 - 2   ");
        } else if (menu.equals("AE"))
        {
            two.setText("  AE 1 - 2   ");
            three.setText("  AE 2 - 1   ");
            four.setText("  AE 2 - 2   ");
            five.setText("  AE 3 - 1   ");
            six.setText("  AE 3 - 2   ");
            seven.setText("  AE 4 - 1   ");
            eight.setText("  AE 4 - 2   ");
        } else if (menu.equals("MEC"))
        {
            two.setText("  MEC 1 - 2   ");
            three.setText("  MEC 2 - 1   ");
            four.setText("  MEC 2 - 2   ");
            five.setText("  MEC 3 - 1   ");
            six.setText("  MEC 3 - 2   ");
            seven.setText("  MEC 4 - 1   ");
            eight.setText("  MEC 4 - 2   ");
        } else if (menu.equals("CE"))
        {
            two.setText("  CE 1 - 2   ");
            three.setText("  CE 2 - 1   ");
            four.setText("  CE 2 - 2   ");
            five.setText("  CE 3 - 1   ");
            six.setText("  CE 3 - 2   ");
            seven.setText("  CE 4 - 1   ");
            eight.setText("  CE 4 - 2   ");
        } else if (menu.equals("INS"))
        {
            two.setText("  INS 1 - 2   ");
            three.setText("  INS 2 - 1   ");
            four.setText("  INS 2 - 2   ");
            five.setText("  INS 3 - 1   ");
            six.setText("  INS 3 - 2   ");
            seven.setText("  INS 4 - 1   ");
            eight.setText("  INS 4 - 2   ");
        } else if (menu.equals("PRO"))
        {
            two.setText("  PRO 1 - 2   ");
            three.setText("  PRO 2 - 1   ");
            four.setText("  PRO 2 - 2   ");
            five.setText("  PRO 3 - 1   ");
            six.setText("  PRO 3 - 2   ");
            seven.setText("  PRO 4 - 1   ");
            eight.setText("  PRO 4 - 2   ");
        }
        if (isMyServiceRunning(service.class))
        {
            if(isMyServiceRunning(percser.class))
                startService(new Intent(pack.this,percser.class));
            String down = getSharedPreferences("DOWN", MODE_PRIVATE).getString("DOWN", "");
            if (button.equals("1"))
            {
                String perc = getSharedPreferences("PERC", MODE_PRIVATE).getString("PERC", "");
                if (perc.equals("ST"))
                {
                    one.setText("Starting...");
                } else if (perc.equals("SO")) {
                    one.setText("Stopping...");
                } else if (perc.length() >= 1) {

                    one.setText(perc + "% completed");
                }
                looper();
                one.setBackgroundResource(R.drawable.clickedbackground);
                canc1.setVisibility(View.VISIBLE);
                eye1.setVisibility(View.GONE);
                down1.setVisibility(View.GONE);
            }
            else if (button.equals("2") && down.startsWith(menu))
            {
                String perc = getSharedPreferences("PERC", MODE_PRIVATE).getString("PERC", "");
                if (perc.equals("ST"))
                {
                    two.setText("Starting...");
                } else if (perc.equals("SO"))
                {
                    two.setText("Stopping...");
                } else if (perc.length() >= 1)
                {
                    two.setText(perc + "% completed");
                }
                two.setBackgroundResource(R.drawable.clickedbackground);
                looper();
                canc2.setVisibility(View.VISIBLE);
                eye2.setVisibility(View.GONE);
                down2.setVisibility(View.GONE);
            }
            else if (button.equals("3") && down.startsWith(menu))
            {
                String perc = getSharedPreferences("PERC", MODE_PRIVATE).getString("PERC", "");
                if (perc.equals("ST")) {
                    three.setText("Starting...");
                } else if (perc.equals("SO")) {
                    three.setText("Stopping...");
                } else if (perc.length() >= 1) {

                    three.setText(perc + "% completed");
                }
                three.setBackgroundResource(R.drawable.clickedbackground);
                looper();
                canc3.setVisibility(View.VISIBLE);
                eye3.setVisibility(View.GONE);
                down3.setVisibility(View.GONE);
            }
            else if (button.equals("4") && down.startsWith(menu))
            {
                String perc = getSharedPreferences("PERC", MODE_PRIVATE).getString("PERC", "");
                if (perc.equals("ST")) {
                    four.setText("Starting...");
                } else if (perc.equals("SO")) {
                    four.setText("Stopping...");
                } else if (perc.length() >= 1) {

                    four.setText(perc + "% completed");
                }
                four.setBackgroundResource(R.drawable.clickedbackground);
                looper();
                canc4.setVisibility(View.VISIBLE);
                eye4.setVisibility(View.GONE);
                down4.setVisibility(View.GONE);
            } else if (button.equals("5") && down.startsWith(menu))
            {
                String perc = getSharedPreferences("PERC", MODE_PRIVATE).getString("PERC", "");
                if (perc.equals("ST")) {
                    five.setText("Starting...");
                } else if (perc.equals("SO")) {
                    five.setText("Stopping...");
                } else if (perc.length() >= 1) {

                    five.setText(perc + "% completed");
                }
                five.setBackgroundResource(R.drawable.clickedbackground);
                looper();
                canc5.setVisibility(View.VISIBLE);
                eye5.setVisibility(View.GONE);
                down5.setVisibility(View.GONE);
            } else if (button.equals("6") && down.startsWith(menu))
            {
                String perc = getSharedPreferences("PERC", MODE_PRIVATE).getString("PERC", "");
                if (perc.equals("ST")) {
                    six.setText("Starting...");
                } else if (perc.equals("SO")) {
                    six.setText("Stopping...");
                } else if (perc.length() >= 1) {

                    six.setText(perc + "% completed");
                }
                six.setBackgroundResource(R.drawable.clickedbackground);
                looper();
                canc6.setVisibility(View.VISIBLE);
                eye6.setVisibility(View.GONE);
                down6.setVisibility(View.GONE);
            } else if (button.equals("7") && down.startsWith(menu))
            {
                String perc = getSharedPreferences("PERC", MODE_PRIVATE).getString("PERC", "");
                if (perc.equals("ST")) {
                    seven.setText("Starting...");
                } else if (perc.equals("SO")) {
                    seven.setText("Stopping...");
                } else if (perc.length() >= 1) {

                    seven.setText(perc + "% completed");
                }
                seven.setBackgroundResource(R.drawable.clickedbackground);
                looper();
                canc7.setVisibility(View.VISIBLE);
                eye7.setVisibility(View.GONE);
                down7.setVisibility(View.GONE);
            } else if (button.equals("8") && down.startsWith(menu))
            {
                String perc = getSharedPreferences("PERC", MODE_PRIVATE).getString("PERC", "");
                if (perc.equals("ST")) {
                    eight.setText("Starting...");
                } else if (perc.equals("SO")) {
                    eight.setText("Stopping...");
                } else if (perc.length() >= 1)
                {
                    eight.setText(perc + "% completed");
                }
                eight.setBackgroundResource(R.drawable.clickedbackground);
                looper();
                canc8.setVisibility(View.VISIBLE);
                eye8.setVisibility(View.GONE);
                down8.setVisibility(View.GONE);
            }
        }
        String eyet = getSharedPreferences("EYE", MODE_PRIVATE).getString("BE 1 - 1", "");
        if (eyet.equals("YES"))
        {
            one.setBackgroundResource(R.drawable.background);
            eye1.setVisibility(View.VISIBLE);
            canc1.setVisibility(View.GONE);
            down1.setVisibility(View.GONE);
        }
        // Log.d("menu",menu);
        String eyes2 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 1 - 2", "");
        String eyes3 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 2 - 1", "");
        String eyes4 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 2 - 2", "");
        String eyes5 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 3 - 1", "");
        //Log.d("eye5",eyes5);
        String eyes6 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 3 - 2", "");
        String eyes7 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 4 - 1", "");
        String eyes8 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 4 - 2", "");

        if (eyes2.equals("YES"))
        {
            two.setBackgroundResource(R.drawable.background);
            eye2.setVisibility(View.VISIBLE);
            canc2.setVisibility(View.GONE);
            down2.setVisibility(View.GONE);
        }
        if (eyes3.equals("YES"))
        {
            three.setBackgroundResource(R.drawable.background);
            eye3.setVisibility(View.VISIBLE);
            canc3.setVisibility(View.GONE);
            down3.setVisibility(View.GONE);
        }
        if (eyes4.equals("YES")) {
            four.setBackgroundResource(R.drawable.background);
            eye4.setVisibility(View.VISIBLE);
            canc4.setVisibility(View.GONE);
            down4.setVisibility(View.GONE);
        }
        if (eyes5.equals("YES")) {
            five.setBackgroundResource(R.drawable.background);
            eye5.setVisibility(View.VISIBLE);
            canc5.setVisibility(View.GONE);
            down5.setVisibility(View.GONE);
        }
        if (eyes6.equals("YES")) {
            six.setBackgroundResource(R.drawable.background);
            eye6.setVisibility(View.VISIBLE);
            canc6.setVisibility(View.GONE);
            down6.setVisibility(View.GONE);
        }
        if (eyes7.equals("YES")) {
            seven.setBackgroundResource(R.drawable.background);
            eye7.setVisibility(View.VISIBLE);
            canc7.setVisibility(View.GONE);
            down7.setVisibility(View.GONE);
        }
        if (eyes8.equals("YES")) {
            eight.setBackgroundResource(R.drawable.background);
            eye8.setVisibility(View.VISIBLE);
            canc8.setVisibility(View.GONE);
            down8.setVisibility(View.GONE);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (!loading)
            {
                if (visible)
                {
                    visible = false;
                    layout.startAnimation(backanim);
                    trans.setVisibility(View.GONE);
                    layout.setVisibility(View.GONE);
                }
                else
                {
                        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
                        startActivity(new Intent(pack.this, HighActivity.class));
                        overridePendingTransition(R.anim.leftin, R.anim.rightout);
                }
            }
        }
        return false;
    }
    public void down11()
    {
        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        noti1.cancel(0);
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        String button = getSharedPreferences("BUTTON", MODE_PRIVATE).getString("BUTTON", "");
        if (button.equals("1"))
        {
            String eyes2 = getSharedPreferences("EYE", MODE_PRIVATE).getString("BE 1 - 1", "");
            if (eyes2.equals("YES"))
            {
                top1.setVisibility(View.VISIBLE);
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW","BE 1 - 1").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
            else {
                if (isMyServiceRunning(service.class)&&loading1==0)
                {
                    String down = getSharedPreferences("DOWN", MODE_PRIVATE).getString("DOWN", "");
                    if (!down.equals("BE 1 - 1"))
                        if (getSharedPreferences("STOP", MODE_PRIVATE).getString("STOP", "").equals("STOP")) {
                            Toast.makeText(getBaseContext(), "Hold on a second", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (!button.equals("1"))
        {
            String eyet = getSharedPreferences("EYE", MODE_PRIVATE).getString("BE 1 - 1", "");
            if (!eyet.equals("YES"))
            {
                if (isconnected(getBaseContext()))
                {
                    if (!isMyServiceRunning(service.class)&&loading1==0)
                    {
                        getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", "ST").commit();
                        getSharedPreferences("STOP", MODE_PRIVATE).edit().putString("STOP", "").commit();
                        getSharedPreferences("SCROLL3", MODE_PRIVATE).edit().putInt("SCROLL3", scroll.getScrollY()).commit();
                        startService(new Intent(pack.this, service.class));
                        down1.setVisibility(View.GONE);
                        eye1.setVisibility(View.GONE);
                        canc1.setVisibility(View.VISIBLE);
                        one.setBackgroundResource(R.drawable.clickedbackground);
                        one.setText("Starting...");
                        getSharedPreferences("DOWN", MODE_PRIVATE).edit().putString("DOWN", "BE 1 - 1").commit();
                        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                        getSharedPreferences("MENU1", MODE_PRIVATE).edit().putString("MENU1", name).commit();
                        getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "1").commit();
                        looper();
                    } else {
                        Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                    }

                } else
                {
                    Toast.makeText(getBaseContext(), "No network", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                top1.setVisibility(View.VISIBLE);
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", "BE 1 - 1").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
        }
    }

    public void down12()
    {
        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        noti1.cancel(0);
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        String button = getSharedPreferences("BUTTON", MODE_PRIVATE).getString("BUTTON", "");
        if (button.equals("2"))
        {
            String menu2 = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes2 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu2 + " 1 - 2", "");
            if (eyes2.equals("YES"))
            {
                top2.setVisibility(View.VISIBLE);
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 1 - 2").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
            else
            {
                if (isMyServiceRunning(service.class))
                {
                    String down = getSharedPreferences("DOWN", MODE_PRIVATE).getString("DOWN", "");
                    String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                    if (!down.startsWith(menu))
                        if (getSharedPreferences("STOP", MODE_PRIVATE).getString("STOP", "").equals("STOP")) {
                            Toast.makeText(getBaseContext(), "Hold on a second", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                }
            }
        }
        else if (!button.equals("2"))
        {
            String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 1 - 2", "");
            if (!eyes.equals("YES"))
            {
                if (isconnected(getBaseContext()))
                {
                    if (!isMyServiceRunning(service.class)&&loading1==0)
                    {
                        getSharedPreferences("MENU1", MODE_PRIVATE).edit().putString("MENU1", "").commit();
                        getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", "ST").commit();
                        getSharedPreferences("STOP", MODE_PRIVATE).edit().putString("STOP", "").commit();
                        getSharedPreferences("SCROLL3", MODE_PRIVATE).edit().putInt("SCROLL3", scroll.getScrollY()).commit();
                        startService(new Intent(pack.this, service.class));
                        down2.setVisibility(View.GONE);
                        eye2.setVisibility(View.GONE);
                        canc2.setVisibility(View.VISIBLE);
                        two.setBackgroundResource(R.drawable.clickedbackground);
                        two.setText("Starting...");
                        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                        getSharedPreferences("DOWN", MODE_PRIVATE).edit().putString("DOWN", name + " 1 - 2").commit();
                        getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "2").commit();
                        looper();
                    } else
                    {
                        Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getBaseContext(), "No network", Toast.LENGTH_SHORT).show();
                }
            } else {
                top2.setVisibility(View.VISIBLE);
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 1 - 2").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
        }
    }
    public void down21() {
        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        noti1.cancel(0);
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        String button = getSharedPreferences("BUTTON", MODE_PRIVATE).getString("BUTTON", "");
        if (button.equals("3"))
        {
            String menu2 = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes2 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu2 + " 2 - 1", "");
            if (eyes2.equals("YES"))
            {
                top3.setVisibility(View.VISIBLE);
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 2 - 1").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
            else
            {
                if (isMyServiceRunning(service.class))
                {
                    String down = getSharedPreferences("DOWN", MODE_PRIVATE).getString("DOWN", "");
                    String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                    if (!down.startsWith(menu))
                        if (getSharedPreferences("STOP", MODE_PRIVATE).getString("STOP", "").equals("STOP")) {
                            Toast.makeText(getBaseContext(), "Hold on a second", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (!button.equals("3"))
        {
            String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 2 - 1", "");
            if (!eyes.equals("YES")) {
                if (isconnected(getBaseContext())) {
                    if (!isMyServiceRunning(service.class)&&loading1==0)
                    {
                        getSharedPreferences("MENU1", MODE_PRIVATE).edit().putString("MENU1", "").commit();
                        getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", "ST").commit();
                        getSharedPreferences("STOP", MODE_PRIVATE).edit().putString("STOP", "").commit();
                        getSharedPreferences("SCROLL3", MODE_PRIVATE).edit().putInt("SCROLL3", scroll.getScrollY()).commit();
                        startService(new Intent(pack.this, service.class));
                        down3.setVisibility(View.GONE);
                        eye3.setVisibility(View.GONE);
                        canc3.setVisibility(View.VISIBLE);
                        three.setBackgroundResource(R.drawable.clickedbackground);
                        three.setText("Starting...");
                        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                        getSharedPreferences("DOWN", MODE_PRIVATE).edit().putString("DOWN", name + " 2 - 1").commit();
                        getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "3").commit();
                        looper();
                    } else {
                        Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getBaseContext(), "No network", Toast.LENGTH_SHORT).show();
                }
            } else {
                top3.setVisibility(View.VISIBLE);
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 2 - 1").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
        }
    }
    public void down22() {
        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        noti1.cancel(0);
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        String button = getSharedPreferences("BUTTON", MODE_PRIVATE).getString("BUTTON", "");
        if (button.equals("4"))
        {
            String menu2 = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes2 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu2 + " 2 - 2", "");
            if (eyes2.equals("YES"))
            {
                top4.setVisibility(View.VISIBLE);
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 2 - 2").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
            else {
                if (isMyServiceRunning(service.class)) {
                    String down = getSharedPreferences("DOWN", MODE_PRIVATE).getString("DOWN", "");
                    String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                    if (!down.startsWith(menu))
                        if (getSharedPreferences("STOP", MODE_PRIVATE).getString("STOP", "").equals("STOP")) {
                            Toast.makeText(getBaseContext(), "Hold on a second", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (!button.equals("4")) {
            String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 2 - 2", "");
            if (!eyes.equals("YES")) {
                if (isconnected(getBaseContext())) {
                    if (!isMyServiceRunning(service.class)&&loading1==0) {
                        getSharedPreferences("MENU1", MODE_PRIVATE).edit().putString("MENU1", "").commit();
                        getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", "ST").commit();
                        getSharedPreferences("STOP", MODE_PRIVATE).edit().putString("STOP", "").commit();
                        getSharedPreferences("SCROLL3", MODE_PRIVATE).edit().putInt("SCROLL3", scroll.getScrollY()).commit();
                        startService(new Intent(pack.this, service.class));
                        down4.setVisibility(View.GONE);
                        eye4.setVisibility(View.GONE);
                        canc4.setVisibility(View.VISIBLE);
                        four.setBackgroundResource(R.drawable.clickedbackground);
                        four.setText("Starting...");
                        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                        getSharedPreferences("DOWN", MODE_PRIVATE).edit().putString("DOWN", name + " 2 - 2").commit();
                        getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "4").commit();
                        looper();
                    } else
                    {
                        Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                    }

                } else
                {
                    Toast.makeText(getBaseContext(), "No network", Toast.LENGTH_SHORT).show();
                }
            } else
            {
                top4.setVisibility(View.VISIBLE);
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 2 - 2").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
        }
    }
    public void down31() {
        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        noti1.cancel(0);
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        String button = getSharedPreferences("BUTTON", MODE_PRIVATE).getString("BUTTON", "");
        if (button.equals("5"))
        {
            String menu2 = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes2 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu2 + " 3 - 1", "");
            if (eyes2.equals("YES"))
            {
                top5.setVisibility(View.VISIBLE);
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 3 - 1").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
            else {
                if (isMyServiceRunning(service.class)) {
                    String down = getSharedPreferences("DOWN", MODE_PRIVATE).getString("DOWN", "");
                    String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                    if (!down.startsWith(menu))
                        if (getSharedPreferences("STOP", MODE_PRIVATE).getString("STOP", "").equals("STOP")) {
                            Toast.makeText(getBaseContext(), "Hold on a second", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (!button.equals("5")) {
            String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 3 - 1", "");
            if (!eyes.equals("YES")) {
                if (isconnected(getBaseContext())) {
                    if (!isMyServiceRunning(service.class)&&loading1==0)
                    {
                        getSharedPreferences("MENU1", MODE_PRIVATE).edit().putString("MENU1", "").commit();
                        getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", "ST").commit();
                        getSharedPreferences("STOP", MODE_PRIVATE).edit().putString("STOP", "").commit();
                        getSharedPreferences("SCROLL3", MODE_PRIVATE).edit().putInt("SCROLL3", scroll.getScrollY()).commit();
                        startService(new Intent(pack.this, service.class));
                        down5.setVisibility(View.GONE);
                        eye5.setVisibility(View.GONE);
                        canc5.setVisibility(View.VISIBLE);
                        five.setBackgroundResource(R.drawable.clickedbackground);
                        five.setText("Starting...");
                        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                        getSharedPreferences("DOWN", MODE_PRIVATE).edit().putString("DOWN", name + " 3 - 1").commit();
                        getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "5").commit();
                        looper();
                    } else {
                        Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(getBaseContext(), "No network", Toast.LENGTH_SHORT).show();
                }
            } else {
                top5.setVisibility(View.VISIBLE);
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 3 - 1").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
        }
    }
    public void down32()
    {
        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        noti1.cancel(0);
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        String button = getSharedPreferences("BUTTON", MODE_PRIVATE).getString("BUTTON", "");
        if (button.equals("6"))
        {
            String menu2 = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes2 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu2 + " 3 - 2", "");
            if (eyes2.equals("YES"))
            {
                top6.setVisibility(View.VISIBLE);
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 3 - 2").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
            else {
                if (isMyServiceRunning(service.class))
                {
                    String down = getSharedPreferences("DOWN", MODE_PRIVATE).getString("DOWN", "");
                    String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                    if (!down.startsWith(menu))
                        if (getSharedPreferences("STOP", MODE_PRIVATE).getString("STOP", "").equals("STOP")) {
                            Toast.makeText(getBaseContext(), "Hold on a second", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (!button.equals("6")) {
            String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 3 - 2", "");
            if (!eyes.equals("YES")) {
                if (isconnected(getBaseContext())) {
                    if (!isMyServiceRunning(service.class)&&loading1==0) {

                        getSharedPreferences("MENU1", MODE_PRIVATE).edit().putString("MENU1", "").commit();
                        getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", "ST").commit();
                        getSharedPreferences("STOP", MODE_PRIVATE).edit().putString("STOP", "").commit();
                        getSharedPreferences("SCROLL3", MODE_PRIVATE).edit().putInt("SCROLL3", scroll.getScrollY()).commit();
                        startService(new Intent(pack.this, service.class));
                        down6.setVisibility(View.GONE);
                        eye6.setVisibility(View.GONE);
                        canc6.setVisibility(View.VISIBLE);
                        six.setBackgroundResource(R.drawable.clickedbackground);
                        six.setText("Starting...");
                        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                        getSharedPreferences("DOWN", MODE_PRIVATE).edit().putString("DOWN", name + " 3 - 2").commit();
                        getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "6").commit();
                        looper();
                    } else {
                        Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(getBaseContext(), "No network", Toast.LENGTH_SHORT).show();
                }
            } else {
                top6.setVisibility(View.VISIBLE);
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 3 - 2").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
        }

    }
    public void down41() {
        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        noti1.cancel(0);
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        String button = getSharedPreferences("BUTTON", MODE_PRIVATE).getString("BUTTON", "");
        if (button.equals("7"))
        {
            String menu2 = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes2 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu2 + " 4 - 1", "");
            if (eyes2.equals("YES"))
            {
                top7.setVisibility(View.VISIBLE);
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 4 - 1").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
            else {
                if (isMyServiceRunning(service.class)) {
                    String down = getSharedPreferences("DOWN", MODE_PRIVATE).getString("DOWN", "");
                    String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                    if (!down.startsWith(menu))
                        if (getSharedPreferences("STOP", MODE_PRIVATE).getString("STOP", "").equals("STOP")) {
                            Toast.makeText(getBaseContext(), "Hold on a second", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (!button.equals("7")) {
            String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 4 - 1", "");
            if (!eyes.equals("YES")) {
                if (isconnected(getBaseContext()))
                {
                    if (!isMyServiceRunning(service.class)&&loading1==0)
                    {
                        getSharedPreferences("MENU1", MODE_PRIVATE).edit().putString("MENU1", "").commit();
                        getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", "ST").commit();
                        getSharedPreferences("STOP", MODE_PRIVATE).edit().putString("STOP", "").commit();
                        getSharedPreferences("SCROLL3", MODE_PRIVATE).edit().putInt("SCROLL3", scroll.getScrollY()).commit();
                        startService(new Intent(pack.this, service.class));
                        down7.setVisibility(View.GONE);
                        eye7.setVisibility(View.GONE);
                        canc7.setVisibility(View.VISIBLE);
                        seven.setBackgroundResource(R.drawable.clickedbackground);
                        seven.setText("Starting...");
                        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                        getSharedPreferences("DOWN", MODE_PRIVATE).edit().putString("DOWN", name + " 4 - 1").commit();
                        getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "7").commit();
                        looper();
                    } else {
                        Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getBaseContext(), "No network", Toast.LENGTH_SHORT).show();
                }
            } else {
                top7.setVisibility(View.VISIBLE);
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 4 - 1").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
        }
    }
    public void down42() {
        NotificationManager noti1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        noti1.cancel(0);
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        String button = getSharedPreferences("BUTTON", MODE_PRIVATE).getString("BUTTON", "");
        if (button.equals("8"))
        {
            String menu2 = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes2 = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu2 + " 4 - 2", "");
            if (eyes2.equals("YES"))
            {
                top8.setVisibility(View.VISIBLE);
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 4 - 2").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
            else
                {
                if (isMyServiceRunning(service.class)) {
                    String down = getSharedPreferences("DOWN", MODE_PRIVATE).getString("DOWN", "");
                    String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                    if (!down.startsWith(menu))
                        if (getSharedPreferences("STOP", MODE_PRIVATE).getString("STOP", "").equals("STOP")) {
                            Toast.makeText(getBaseContext(), "Hold on a second", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (!button.equals("8")) {
            String menu = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
            String eyes = getSharedPreferences("EYE", MODE_PRIVATE).getString(menu + " 4 - 2", "");
            if (!eyes.equals("YES")) {
                if (isconnected(getBaseContext()))
                {
                    if (!isMyServiceRunning(service.class)&&loading1==0)
                    {
                        getSharedPreferences("MENU1", MODE_PRIVATE).edit().putString("MENU1", "").commit();
                        getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", "ST").commit();
                        getSharedPreferences("STOP", MODE_PRIVATE).edit().putString("STOP", "").commit();
                        getSharedPreferences("SCROLL3", MODE_PRIVATE).edit().putInt("SCROLL3", scroll.getScrollY()).commit();
                        startService(new Intent(pack.this, service.class));
                        down8.setVisibility(View.GONE);
                        eye8.setVisibility(View.GONE);
                        canc8.setVisibility(View.VISIBLE);
                        eight.setBackgroundResource(R.drawable.clickedbackground);
                        eight.setText("Starting...");
                        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                        getSharedPreferences("DOWN", MODE_PRIVATE).edit().putString("DOWN", name + " 4 - 2").commit();
                        getSharedPreferences("BUTTON", MODE_PRIVATE).edit().putString("BUTTON", "8").commit();
                        looper();
                    }
                    else
                        {
                        Toast.makeText(getBaseContext(), "Please wait until download completes", Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(getBaseContext(), "No network", Toast.LENGTH_SHORT).show();
                }
            } else {
                top8.setVisibility(View.VISIBLE);
                String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
                getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
                getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 4 - 2").commit();
                getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
                startActivity(new Intent(pack.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);
            }
        }
    }

    public void eye1()
    {
    top1.setVisibility(View.VISIBLE);
    getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
    getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
    getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
    getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", "BE 1 - 1").commit();
    getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
    startActivity(new Intent(pack.this, HighActivity.class));
    overridePendingTransition(R.anim.leftin, R.anim.rightout);
}
    public void eye2() {
        top2.setVisibility(View.VISIBLE);
        getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
        getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 1 - 2").commit();
        getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
        startActivity(new Intent(pack.this, HighActivity.class));
        overridePendingTransition(R.anim.leftin, R.anim.rightout);
    }
    public void eye3() {
        top3.setVisibility(View.VISIBLE);
        getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
        getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 2 - 1").commit();
        getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
        startActivity(new Intent(pack.this, HighActivity.class));
        overridePendingTransition(R.anim.leftin, R.anim.rightout);
    }
    public void eye4() {
        top4.setVisibility(View.VISIBLE);
        getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
        getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 2 - 2").commit();
        getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
        startActivity(new Intent(pack.this, HighActivity.class));
        overridePendingTransition(R.anim.leftin, R.anim.rightout);
    }
    public void eye5() {
        top5.setVisibility(View.VISIBLE);
        getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
        getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 3 - 1").commit();
        getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
        startActivity(new Intent(pack.this, HighActivity.class));
        overridePendingTransition(R.anim.leftin, R.anim.rightout);
    }
    public void eye6() {
        top6.setVisibility(View.VISIBLE);
        getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
        getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 3 - 2").commit();
        getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
        startActivity(new Intent(pack.this, HighActivity.class));
        overridePendingTransition(R.anim.leftin, R.anim.rightout);
    }
    public void eye7() {
        top7.setVisibility(View.VISIBLE);
        getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
        getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 4 - 1").commit();
        getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
        startActivity(new Intent(pack.this, HighActivity.class));
        overridePendingTransition(R.anim.leftin, R.anim.rightout);
    }
    public void eye8() {
        top8.setVisibility(View.VISIBLE);
        getSharedPreferences("WHAT", MODE_PRIVATE).edit().putString("WHAT", "PAPERS").commit();
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        getSharedPreferences("SCROLL1", MODE_PRIVATE).edit().putInt("SCROLL1", 0).commit();
        String name = getSharedPreferences("MENU", MODE_PRIVATE).getString("MENU", "");
        getSharedPreferences("VIEW", MODE_PRIVATE).edit().putString("VIEW", name + " 4 - 2").commit();
        getSharedPreferences("ANIM", MODE_PRIVATE).edit().putBoolean("ANIM", true).commit();
        startActivity(new Intent(pack.this, HighActivity.class));
        overridePendingTransition(R.anim.leftin, R.anim.rightout);
    }

    public void canc() {
        getSharedPreferences("SCROLL2", MODE_PRIVATE).edit().putInt("SCROLL2", scroll.getScrollY()).commit();
        dialog.setView(View.VISIBLE);
        dialog.setMessage("Stop downloading?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getSharedPreferences("PERC", MODE_PRIVATE).edit().putString("PERC", "SO").commit();
                getSharedPreferences("STOP", MODE_PRIVATE).edit().putString("STOP", "STOP").commit();
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialog1 = dialog.create();
        dialog1.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                dialog1.getButton(android.app.AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                dialog1.getButton(android.app.AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
            }
        });
        dialog1.show();
    }
}
