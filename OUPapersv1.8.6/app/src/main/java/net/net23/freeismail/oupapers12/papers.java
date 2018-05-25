package net.net23.freeismail.oupapers12;


import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Scroller;
import android.widget.TextView;
import java.io.File;
import java.lang.reflect.Field;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public class papers extends ActionBarActivity
//ActionBarActivity
{
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private static WebView
            web1, web2, web3, web4, web5, web6, web7, web8, web9, web10, web11, web12,
            web13, web14, web15, web16, web17, web18, web19, web20;
    public boolean l1=true,l2=true,l3=true,l4=true,l5=true,l6=true,l7=true,l8=true
            ,l9=true,l10=true,l11=true,l12=true,l13=true,l14=true,l15=true,l16=true,
            l17=true,l18=true,l19=true,l20=true;
    private ViewPager mViewPager;
    private String path1;
    private  static String buff1[] = new String[20],staticpath;
    private  File[] array;
    private int status;
    private static int static1;
    private int noofpapers;
    private ProgressBar pp;
    private TextView tt,swipenoti,gotcha;
    private TabLayout tabLayout=null;
    private  static   View rootView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.papers);
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
                    swipenoti = (TextView) findViewById(R.id.swipeNoti);
                    gotcha = (TextView) findViewById(R.id.Gotcha);
                    tabLayout = (TabLayout) findViewById(R.id.tabs);
                    pp = (ProgressBar) findViewById(R.id.pp1);
                    tt = (TextView) findViewById(R.id.tt);
                    pp.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.pro), PorterDuff.Mode.SRC_IN);
                    tt.setVisibility(View.GONE);
                    pp.setVisibility(View.GONE);
                    swipenoti.setVisibility(View.GONE);
                    gotcha.setVisibility(View.GONE);


                    gotcha.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view)
                        {
                            swipenoti.setVisibility(View.GONE);
                            gotcha.setVisibility(View.GONE);
                            getSharedPreferences("SWIPE", MODE_PRIVATE).edit().putString("SWIPE", "S").commit();
                        }
                    });
                    if (getSharedPreferences("SWIPE", MODE_PRIVATE).getString("SWIPE", "").equals(""))
                    {

                        gotcha.setVisibility(View.VISIBLE);
                        swipenoti.setVisibility(View.VISIBLE);
                    }
                    if (getSharedPreferences("WHAT", MODE_PRIVATE).getString("WHAT", "").toString().equals("SYLLABUS")) {
                        status = 1;
                    }
                    static1 = status;
                    path1 = getSharedPreferences("ROOT", MODE_PRIVATE).getString("ROOT", "");
                    staticpath =  Environment.getExternalStorageDirectory().toString()+"/OU Papers/"  + path1;
                    try {
                        String path2 = Environment.getExternalStorageDirectory().toString()+"/OU Papers/"  + path1;
                        File f = new File(path2);
                        array = f.listFiles();
                        noofpapers = array.length;
                        mViewPager = (ViewPager) findViewById(R.id.container);
                        mViewPager.setOffscreenPageLimit(noofpapers - 1);
                        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                            @Override
                            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                            }

                            @Override
                            public void onPageSelected(int position) {
                                getSharedPreferences("PAGE", MODE_PRIVATE).edit().putString("PAGE", "" + (position + 1)).commit();
                            }

                            @Override
                            public void onPageScrollStateChanged(int state) {
                            }
                        });

                        try {
                            Field mScroller;
                            mScroller = ViewPager.class.getDeclaredField("mScroller");
                            mScroller.setAccessible(true);
                            Interpolator sInterpolator = new AccelerateInterpolator();
                            FixedSpeedScroller scroller = new FixedSpeedScroller(mViewPager.getContext(), sInterpolator);
                            //  scroller.setFixedDuration(5000);
                            mScroller.set(mViewPager, scroller);
                        } catch (NoSuchFieldException e) {
                        } catch (IllegalArgumentException e) {
                        } catch (IllegalAccessException e) {
                        }


                        for (int ll = 0; ll < array.length; ll++)
                        {
                            String temp = array[ll].getName();
                            temp = temp.substring(0, temp.indexOf('.'));
                            String temp1 = temp.substring(2, temp.length());
                            if (temp.startsWith("01")) {
                                l1 = false;
                                buff1[0] = temp1;
                            } else if (temp.startsWith("02")) {
                                l2 = false;
                                buff1[1] = temp1;
                            } else if (temp.startsWith("03")) {
                                l3 = false;
                                buff1[2] = temp1;
                            } else if (temp.startsWith("04")) {
                                l4 = false;
                                buff1[3] = temp1;
                            } else if (temp.startsWith("05")) {
                                l5 = false;
                                buff1[4] = temp1;
                            } else if (temp.startsWith("06")) {
                                l6 = false;
                                buff1[5] = temp1;
                            } else if (temp.startsWith("07")) {
                                l7 = false;
                                buff1[6] = temp1;
                            } else if (temp.startsWith("08")) {
                                l8 = false;
                                buff1[7] = temp1;
                            } else if (temp.startsWith("09")) {
                                l9 = false;
                                buff1[8] = temp1;
                            } else if (temp.startsWith("10")) {
                                l10 = false;
                                buff1[9] = temp1;
                            } else if (temp.startsWith("11")) {
                                l11 = false;
                                buff1[10] = temp1;
                            } else if (temp.startsWith("12")) {
                                l12 = false;
                                buff1[11] = temp1;
                            } else if (temp.startsWith("13")) {
                                l13 = false;
                                buff1[12] = temp1;
                            } else if (temp.startsWith("14")) {
                                l14 = false;
                                buff1[13] = temp1;
                            } else if (temp.startsWith("15")) {
                                l15 = false;
                                buff1[14] = temp1;
                            } else if (temp.startsWith("16")) {
                                l16 = false;
                                buff1[15] = temp1;
                            } else if (temp.startsWith("17")) {
                                l17 = false;
                                buff1[16] = temp1;
                            } else if (temp.startsWith("18")) {
                                l18 = false;
                                buff1[17] = temp1;
                            } else if (temp.startsWith("19")) {
                                l19 = false;
                                buff1[18] = temp1;
                            } else if (temp.startsWith("20")) {
                                l20 = false;
                                buff1[19] = temp1;
                            }
                        }
                    } catch (Exception e) {
                    }
                    loop();
                }
            });
        }
        catch(Exception e)
        {}
    }
    //Loading
    public static class PlaceholderFragment extends Fragment
    {
        private static final String ARG_SECTION_NUMBER = "section_number";
        public static PlaceholderFragment newInstance(int sectionNumber)
        {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)
        {

            try
            {
                int kk = getArguments().getInt(ARG_SECTION_NUMBER);
                if (kk == 1)
                {
                    rootView = inflater.inflate(R.layout.fragment_main, container, false);
                    web1 = (WebView) rootView.findViewById(R.id.web1);
                    web1.setWebViewClient(new WebViewClient());
                    WebSettings webs1 = web1.getSettings();
                    webs1.setBuiltInZoomControls(true);
                    webs1.setDisplayZoomControls(false);
                    web1.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web1.setHorizontalScrollBarEnabled(false);
                    web1.setVerticalScrollBarEnabled(false);
                    webs1.setUseWideViewPort(true);
                    webs1.setLoadWithOverviewMode(true);

                    if (static1 == 0) {
                        web1.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='01" + buff1[0] + ".jpg' width='100%' />", "text/html", "utf-8", null);

                    } else {
                        File f1 = new File(staticpath + "/01" + buff1[0] + ".html");
                        web1.loadUrl("file:///" + f1);
                    }
                } else if (kk == 2) {
                    rootView = inflater.inflate(R.layout.second_frag, container, false);
                    web2 = (WebView) rootView.findViewById(R.id.web2);
                    web2.setWebViewClient(new WebViewClient());
                    WebSettings webs2 = web2.getSettings();
                    webs2.setBuiltInZoomControls(true);
                    webs2.setDisplayZoomControls(false);
                    web2.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web2.setHorizontalScrollBarEnabled(false);
                    web2.setVerticalScrollBarEnabled(false);
                    webs2.setUseWideViewPort(true);
                    webs2.setLoadWithOverviewMode(true);

                    if (static1 == 0) {
                        web2.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='02" + buff1[1] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/02" + buff1[1] + ".html");
                        web2.loadUrl("file:///" + f1);
                    }
                } else if (kk == 3) {

                    rootView = inflater.inflate(R.layout.three, container, false);
                    web3 = (WebView) rootView.findViewById(R.id.web3);
                    web3.setWebViewClient(new WebViewClient());
                    WebSettings webs3 = web3.getSettings();
                    webs3.setBuiltInZoomControls(true);
                    webs3.setDisplayZoomControls(false);
                    web3.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web3.setHorizontalScrollBarEnabled(false);
                    web3.setVerticalScrollBarEnabled(false);
                    webs3.setUseWideViewPort(true);
                    webs3.setLoadWithOverviewMode(true);

                    if (static1 == 0) {
                        web3.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='03" + buff1[2] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/03" + buff1[2] + ".html");
                        web3.loadUrl("file:///" + f1);
                    }
                } else if (kk == 4) {

                    rootView = inflater.inflate(R.layout.four, container, false);
                    web4 = (WebView) rootView.findViewById(R.id.web4);
                    web4.setWebViewClient(new WebViewClient());
                    WebSettings webs4 = web4.getSettings();
                    webs4.setBuiltInZoomControls(true);
                    webs4.setDisplayZoomControls(false);
                    web4.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web4.setHorizontalScrollBarEnabled(false);
                    web4.setVerticalScrollBarEnabled(false);
                    webs4.setUseWideViewPort(true);
                    webs4.setLoadWithOverviewMode(true);

                    if (static1 == 0) {
                        web4.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='04" + buff1[3] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/04" + buff1[3] + ".html");
                        web4.loadUrl("file:///" + f1);
                    }
                } else if (kk == 5) {

                    rootView = inflater.inflate(R.layout.five, container, false);
                    web5 = (WebView) rootView.findViewById(R.id.web5);
                    web5.setWebViewClient(new WebViewClient());
                    WebSettings webs5 = web5.getSettings();
                    webs5.setBuiltInZoomControls(true);
                    webs5.setDisplayZoomControls(false);
                    web5.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web5.setHorizontalScrollBarEnabled(false);
                    web5.setVerticalScrollBarEnabled(false);
                    webs5.setUseWideViewPort(true);
                    webs5.setLoadWithOverviewMode(true);

                    if (static1 == 0) {
                        web5.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='05" + buff1[4] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/05" + buff1[4] + ".html");
                        web5.loadUrl("file:///" + f1);
                    }
                } else if (kk == 6) {

                    rootView = inflater.inflate(R.layout.six, container, false);
                    web6 = (WebView) rootView.findViewById(R.id.web6);
                    web6.setWebViewClient(new WebViewClient());
                    WebSettings webs6 = web6.getSettings();
                    webs6.setBuiltInZoomControls(true);
                    webs6.setDisplayZoomControls(false);
                    web6.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web6.setHorizontalScrollBarEnabled(false);
                    web6.setVerticalScrollBarEnabled(false);
                    webs6.setUseWideViewPort(true);
                    webs6.setLoadWithOverviewMode(true);

                    if (static1 == 0) {
                        web6.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='06" + buff1[5] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/06" + buff1[5] + ".html");
                        web6.loadUrl("file:///" + f1);
                    }
                } else if (kk == 7) {
                    rootView = inflater.inflate(R.layout.seven, container, false);
                    web7 = (WebView) rootView.findViewById(R.id.web7);
                    web7.setWebViewClient(new WebViewClient());
                    WebSettings webs7 = web7.getSettings();
                    webs7.setBuiltInZoomControls(true);
                    webs7.setDisplayZoomControls(false);
                    web7.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web7.setHorizontalScrollBarEnabled(false);
                    web7.setVerticalScrollBarEnabled(false);
                    webs7.setUseWideViewPort(true);
                    webs7.setLoadWithOverviewMode(true);

                    if (static1 == 0) {
                        web7.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='07" + buff1[6] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/07" + buff1[6] + ".html");
                        web7.loadUrl("file:///" + f1);
                    }
                } else if (kk == 8) {
                    rootView = inflater.inflate(R.layout.eight, container, false);
                    web8 = (WebView) rootView.findViewById(R.id.web8);
                    web8.setWebViewClient(new WebViewClient());
                    WebSettings webs8 = web8.getSettings();
                    webs8.setBuiltInZoomControls(true);
                    webs8.setDisplayZoomControls(false);
                    web8.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web8.setHorizontalScrollBarEnabled(false);
                    web8.setVerticalScrollBarEnabled(false);
                    webs8.setUseWideViewPort(true);
                    webs8.setLoadWithOverviewMode(true);

                    if (static1 == 0) {
                        web8.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='08" + buff1[7] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/08" + buff1[7] + ".html");
                        web8.loadUrl("file:///" + f1);
                    }
                } else if (kk == 9) {
                    rootView = inflater.inflate(R.layout.nine, container, false);
                    web9 = (WebView) rootView.findViewById(R.id.web9);
                    web9.setWebViewClient(new WebViewClient());
                    WebSettings webs9 = web9.getSettings();
                    webs9.setBuiltInZoomControls(true);
                    webs9.setDisplayZoomControls(false);
                    web9.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web9.setHorizontalScrollBarEnabled(false);
                    web9.setVerticalScrollBarEnabled(false);
                    webs9.setUseWideViewPort(true);
                    webs9.setLoadWithOverviewMode(true);

                    if (static1 == 0) {
                        web9.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='09" + buff1[8] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/09" + buff1[8] + ".html");
                        web9.loadUrl("file:///" + f1);
                    }
                } else if (kk == 10) {

                    rootView = inflater.inflate(R.layout.ten, container, false);
                    web10 = (WebView) rootView.findViewById(R.id.web10);
                    web10.setWebViewClient(new WebViewClient());
                    WebSettings webs10 = web10.getSettings();
                    webs10.setBuiltInZoomControls(true);
                    webs10.setDisplayZoomControls(false);
                    web10.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web10.setHorizontalScrollBarEnabled(false);
                    web10.setVerticalScrollBarEnabled(false);
                    webs10.setUseWideViewPort(true);
                    webs10.setLoadWithOverviewMode(true);

                    if (static1 == 0) {
                        web10.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='10" + buff1[9] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/10" + buff1[9] + ".html");
                        web10.loadUrl("file:///" + f1);
                    }
                } else if (kk == 11) {
                    rootView = inflater.inflate(R.layout.ele, container, false);
                    web11 = (WebView) rootView.findViewById(R.id.web11);
                    web11.setWebViewClient(new WebViewClient());
                    WebSettings webs11 = web11.getSettings();
                    webs11.setBuiltInZoomControls(true);
                    webs11.setDisplayZoomControls(false);
                    web11.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web11.setHorizontalScrollBarEnabled(false);
                    web11.setVerticalScrollBarEnabled(false);
                    webs11.setUseWideViewPort(true);
                    webs11.setLoadWithOverviewMode(true);
                    if (static1 == 0) {
                        web11.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='11" + buff1[10] + ".jpg' width='100%' />", "text/html", "utf-8", null);

                    } else {
                        File f1 = new File(staticpath + "/11" + buff1[10] + ".html");
                        web11.loadUrl("file:///" + f1);
                    }
                } else if (kk == 12) {
                    rootView = inflater.inflate(R.layout.twe, container, false);
                    web12 = (WebView) rootView.findViewById(R.id.web12);
                    web12.setWebViewClient(new WebViewClient());
                    WebSettings webs12 = web12.getSettings();
                    webs12.setBuiltInZoomControls(true);
                    webs12.setDisplayZoomControls(false);
                    web12.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web12.setHorizontalScrollBarEnabled(false);
                    web12.setVerticalScrollBarEnabled(false);
                    webs12.setUseWideViewPort(true);
                    webs12.setLoadWithOverviewMode(true);
                    if (static1 == 0) {
                        web12.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='12" + buff1[11] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/12" + buff1[11] + ".html");
                        web12.loadUrl("file:///" + f1);
                    }
                } else if (kk == 13) {
                    rootView = inflater.inflate(R.layout.thir, container, false);
                    web13 = (WebView) rootView.findViewById(R.id.web13);
                    web13.setWebViewClient(new WebViewClient());
                    WebSettings webs13 = web13.getSettings();
                    webs13.setBuiltInZoomControls(true);
                    webs13.setDisplayZoomControls(false);
                    web13.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web13.setHorizontalScrollBarEnabled(false);
                    web13.setVerticalScrollBarEnabled(false);
                    webs13.setUseWideViewPort(true);
                    webs13.setLoadWithOverviewMode(true);
                    if (static1 == 0) {
                        web13.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='13" + buff1[12] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/13" + buff1[12] + ".html");
                        web13.loadUrl("file:///" + f1);
                    }
                } else if (kk == 14) {
                    rootView = inflater.inflate(R.layout.fourtee, container, false);
                    web14 = (WebView) rootView.findViewById(R.id.web14);
                    web14.setWebViewClient(new WebViewClient());
                    WebSettings webs14 = web14.getSettings();
                    webs14.setBuiltInZoomControls(true);
                    webs14.setDisplayZoomControls(false);
                    web14.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web14.setHorizontalScrollBarEnabled(false);
                    web14.setVerticalScrollBarEnabled(false);
                    webs14.setUseWideViewPort(true);
                    webs14.setLoadWithOverviewMode(true);
                    if (static1 == 0) {
                        web14.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='14" + buff1[13] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/14" + buff1[13] + ".html");
                        web14.loadUrl("file:///" + f1);
                    }
                } else if (kk == 15) {
                    rootView = inflater.inflate(R.layout.fifteen, container, false);
                    web15 = (WebView) rootView.findViewById(R.id.web15);
                    web15.setWebViewClient(new WebViewClient());
                    WebSettings webs15 = web15.getSettings();
                    webs15.setBuiltInZoomControls(true);
                    webs15.setDisplayZoomControls(false);
                    web15.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web15.setHorizontalScrollBarEnabled(false);
                    web15.setVerticalScrollBarEnabled(false);
                    webs15.setUseWideViewPort(true);
                    webs15.setLoadWithOverviewMode(true);
                    if (static1 == 0) {
                        web15.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='15" + buff1[14] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/15" + buff1[14] + ".html");
                        web15.loadUrl("file:///" + f1);
                    }
                } else if (kk == 16) {
                    rootView = inflater.inflate(R.layout.sixteen, container, false);
                    web16 = (WebView) rootView.findViewById(R.id.web16);
                    web16.setWebViewClient(new WebViewClient());
                    WebSettings webs16 = web16.getSettings();
                    webs16.setBuiltInZoomControls(true);
                    webs16.setDisplayZoomControls(false);
                    web16.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web16.setHorizontalScrollBarEnabled(false);
                    web16.setVerticalScrollBarEnabled(false);
                    webs16.setUseWideViewPort(true);
                    webs16.setLoadWithOverviewMode(true);
                    if (static1 == 0) {
                        web16.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='16" + buff1[15] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/16" + buff1[15] + ".html");
                        web16.loadUrl("file:///" + f1);
                    }
                } else if (kk == 17) {
                    rootView = inflater.inflate(R.layout.seventeen, container, false);
                    web17 = (WebView) rootView.findViewById(R.id.web17);
                    web17.setWebViewClient(new WebViewClient());
                    WebSettings webs17 = web17.getSettings();
                    webs17.setBuiltInZoomControls(true);
                    webs17.setDisplayZoomControls(false);
                    web17.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web17.setHorizontalScrollBarEnabled(false);
                    web17.setVerticalScrollBarEnabled(false);
                    webs17.setUseWideViewPort(true);
                    webs17.setLoadWithOverviewMode(true);
                    if (static1 == 0) {
                        web17.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='17" + buff1[16] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/17" + buff1[16] + ".html");
                        web17.loadUrl("file:///" + f1);
                    }
                } else if (kk == 18) {
                    rootView = inflater.inflate(R.layout.eightrrn, container, false);
                    web18 = (WebView) rootView.findViewById(R.id.web18);
                    web18.setWebViewClient(new WebViewClient());
                    WebSettings webs18 = web18.getSettings();
                    webs18.setBuiltInZoomControls(true);
                    webs18.setDisplayZoomControls(false);
                    web18.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web18.setHorizontalScrollBarEnabled(false);
                    web18.setVerticalScrollBarEnabled(false);
                    webs18.setUseWideViewPort(true);
                    webs18.setLoadWithOverviewMode(true);
                    if (static1 == 0) {
                        web18.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='18" + buff1[17] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/18" + buff1[17] + ".html");
                        web18.loadUrl("file:///" + f1);
                    }
                } else if (kk == 19) {
                    rootView = inflater.inflate(R.layout.nineteen, container, false);
                    web19 = (WebView) rootView.findViewById(R.id.web19);
                    web19.setWebViewClient(new WebViewClient());
                    WebSettings webs19 = web19.getSettings();
                    webs19.setBuiltInZoomControls(true);
                    webs19.setDisplayZoomControls(false);
                    web19.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web19.setHorizontalScrollBarEnabled(false);
                    web19.setVerticalScrollBarEnabled(false);
                    webs19.setUseWideViewPort(true);
                    webs19.setLoadWithOverviewMode(true);
                    if (static1 == 0) {
                        web19.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='19" + buff1[18] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/19" + buff1[18] + ".html");
                        web19.loadUrl("file:///" + f1);
                    }
                } else if (kk == 20) {
                    rootView = inflater.inflate(R.layout.twenty, container, false);
                    web20 = (WebView) rootView.findViewById(R.id.web20);
                    web20.setWebViewClient(new WebViewClient());
                    WebSettings webs20 = web20.getSettings();
                    webs20.setBuiltInZoomControls(true);
                    webs20.setDisplayZoomControls(false);
                    web20.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    web20.setHorizontalScrollBarEnabled(false);
                    web20.setVerticalScrollBarEnabled(false);
                    webs20.setUseWideViewPort(true);
                    webs20.setLoadWithOverviewMode(true);
                    if (static1 == 0) {
                        web20.loadDataWithBaseURL("file:///" + staticpath +
                                "/", "<img src='20" + buff1[19] + ".jpg' width='100%' />", "text/html", "utf-8", null);
                    } else {
                        File f1 = new File(staticpath + "/20" + buff1[19] + ".html");
                        web20.loadUrl("file:///" + f1);
                    }
                }
            }
            catch(Exception e)
            {

            }


          /*  View parent =rootView.getRootView();
            if(parent!=null&& parent instanceof ViewPager)
            {
                ((ViewPager)parent).removeView(rootView);
                ((ViewPager)container).addView(rootView);
            }*/
            return rootView;
        }

        @Override
        public void onDetach()
        {
            try
            {
                Field childFragmentManager = android.app.Fragment.class.getDeclaredField("mChildFragmentManager");
                childFragmentManager.setAccessible(true);
                childFragmentManager.set(this, null);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            super.onDetach();
        }

    }
    public class FixedSpeedScroller extends Scroller
    {

        private int mDuration = 220;

        public FixedSpeedScroller(Context context) {
            super(context);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator, boolean flywheel) {
            super(context, interpolator, flywheel);
        }


        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            // Ignore received duration, use fixed one instead
            super.startScroll(startX, startY, dx, dy, mDuration);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy) {
            // Ignore received duration, use fixed one instead
            super.startScroll(startX, startY, dx, dy, mDuration);
        }
    }
    //Called after filling buffer
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }
        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1)
        {
        }
        @Override
        public Fragment getItem(int position)
        {
            try
            {
                return PlaceholderFragment.newInstance(position + 1);
            }
            catch (Exception e)
            {
                return null;
            }
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            try
            {
            container.removeView((View)object);
            }
            catch (Exception e)
            {
            }
        }

        @Override
        public int getCount()
        {
            try
            {
            return noofpapers;
        }
        catch (Exception e)
        {
            return 0;
        }
        }

        @Override
        public String getPageTitle(int position)
        {
            try
            {
            switch (position)
            {
                case 0:
                    return buff1[0];
                case 1:
                    return buff1[1];
                case 2:
                    return buff1[2];
                case 3:
                    return buff1[3];
                case 4:
                    return buff1[4];
                case 5:
                    return buff1[5];
                case 6:
                    return buff1[6];
                case 7:
                    return buff1[7];
                case 8:
                    return buff1[8];
                case 9:
                    return buff1[9];
                case 10:
                    return buff1[10];
                case 11:
                    return buff1[11];
                case 12:
                    return buff1[12];
                case 13:
                    return buff1[13];
                case 14:
                    return buff1[14];
                case 15:
                    return buff1[15];
                case 16:
                    return buff1[16];
                case 17:
                    return buff1[17];
                case 18:
                    return buff1[18];
                case 19:
                    return buff1[19];
            }
            return null;
            }
            catch (Exception e)
            {
                return null;
            }
        }
    }
    private void loop()
    {
        Handler han = new Handler();
        han.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                            tabLayout.setupWithViewPager(mViewPager);
                        try
                        {
                            mViewPager.setAdapter(mSectionsPagerAdapter);
                            String page=getSharedPreferences("PAGE", MODE_PRIVATE).getString("PAGE", "");
                            int page1=Integer.parseInt(page);
                            mViewPager.setCurrentItem(page1-1);
                           // ceck();
                        }
                        catch (Exception e)
                        {
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            mViewPager.setOffscreenPageLimit(noofpapers - 1);
                            mViewPager.setAdapter(mSectionsPagerAdapter);
                            String page=getSharedPreferences("PAGE", MODE_PRIVATE).getString("PAGE", "");
                            int page1=Integer.parseInt(page);
                            mViewPager.setCurrentItem(page1-1);
                         //   ceck();
                        }
                }
        }, 20);
    }
    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent e) {
        if (KeyCode == KeyEvent.KEYCODE_BACK)
        {
            getSharedPreferences("LEN", MODE_PRIVATE).edit().putString("LEN", "").commit();
                finish();
                startActivity(new Intent(papers.this, HighActivity.class));
                overridePendingTransition(R.anim.leftin, R.anim.rightout);

        }
        return false;
    }
}