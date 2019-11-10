package com.example.maetv;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.design.internal.NavigationMenuView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {




    private VideoView videoView;
    ImageButton films4;
    private Button menu, films, films2, films3, films5, films6, films7;
    private LinearLayout menubarra;
    private ProgressBar progressBar;
    private RelativeLayout menubarraAbajo, videoRelative;
    private Uri uri, uri2;
    private EditText editText;


    private Button next, prev,logo;

    String html;
    String[] vectorCod2;
    String[] vectorUrl2;



    String[] nombres = {"RU TV", "CANAL 2","CANAL 4","CANAL 6","MULTIMEDIOS","CANAL 11", "CANAL 14","SAN VITO TV",
            "COLOSAL TV", "CACHIPUM TV", "REAL MADRID TV",  "GUAPILES TV", "CB 24","88 STEREO FM","CANAL UCR"
    };

    String[] canales = {
            "https://rutv.gcdn.co/streams/1410_1272/480n/index.m3u8",
            "http://d2f1bbn9v49he.cloudfront.net/cr/canal2/smil:v2.smil/chunklist_b1098304_sles.m3u8",
            "http://d3ha0sloduwpku.cloudfront.net/cr/canal4/smil:v2.smil/chunklist_HD_sles.m3u8",
            "http://d3ha0sloduwpku.cloudfront.net/cr/canal6/smil:v2.smil/chunklist_HD_sles.m3u8",
            "http://mdstrm.com/live-stream-playlist/5a7b1e63a8da282c34d65445.m3u8?ref=http://www.multimedios.com",
            "http://d2p1i9loz7pbh0.cloudfront.net/cr/canal11/smil:v2.smil/chunklist_HD_sles.m3u8",
            "http://205.164.56.130:1935/tvsur81/tvsur81/playlist.m3u8",
            "http://k4.usastreams.com/vitotv/vitotv/chunklist_w1717299044.m3u8",    "http://tv.ticosmedia.com:1935/COLOSAL/COLOSAL/chunklist_w1474049066.m3u8",
            "http://edge1.cl.grupoz.cl/cachipuntv/live/chunklist_w1664416606.m3u8",
            "http://rmtvlive-lh.akamaihd.net/i/rmtv_1@154306/master.m3u8",
            "http://k4.usastreams.com/guapilestv/guapilestv/chunklist_w1942896713.m3u8",
            "http://18.191.91.130:1935/live/CB24/chunklist_w1093096555.m3u8",
            "http://k3.usastreams.com:1935/CableLatino/88stereo/chunklist_w1223558379.m3u8",
            "http://163.178.170.181:1935/envivo/envivo/playlist.m3u8"

    };


    ImageView imageView;
    TextView nameApp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = findViewById(R.id.imageView);
        nameApp = findViewById(R.id.nameApp);
        videoView = findViewById(R.id.videoView);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);
        //lista = findViewById(R.id.list);
        editText = findViewById(R.id.editText);
        videoView = findViewById(R.id.videoView);
        videoRelative = findViewById(R.id.videoRelative);
        menubarra = findViewById(R.id.menuBarra);
        menubarraAbajo = findViewById(R.id.menuBarraAbajo);
        progressBar = (ProgressBar) findViewById(R.id.progrss);
        films = findViewById(R.id.films);
        films2 = findViewById(R.id.films2);
        films3 = findViewById(R.id.films3);
        films4 = findViewById(R.id.films4);


        ocultarBotones();
        reproductor(11);
        GetCanalesDrive();
        //mostrarMenu();


        //Typeface tf = Typeface.createFromAsset(getAssets(), "gran_hotel.ttf");
        //films.setTypeface(tf);
        films.setTextSize(30);
        editText.setTextSize(20);
        films2.setTextSize(16);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //films3
        films.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                //drawer.closeDrawer(GravityCompat.START);
                drawer.openDrawer(GravityCompat.START);

            }
        });
        /*films.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                //drawer.closeDrawer(GravityCompat.START);
                drawer.openDrawer(GravityCompat.START);

            }
        });
        films6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOutPress();
            }
        });
        films7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info();
            }
        });*/

        videoView.setOnTouchListener ( new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent m){
                switch (m.getAction()){
                    case MotionEvent.ACTION_DOWN: {
                        //mostrarBotones();
                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                        //drawer.closeDrawer(GravityCompat.START);
                        drawer.openDrawer(GravityCompat.START);

                        new Handler().postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                //ocultarBotones();
                                hideSystemUI();
                                //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                                //drawer.closeDrawer(GravityCompat.START);
                                //drawer.openDrawer(GravityCompat.START);
                            }
                        }, 5000);
                        break;
                    }

                }
                return false;
            }
        });
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                Toast.makeText(getApplicationContext(),"Canal No Soportado :( ", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        //fin de onCreate
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | videoView.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | videoView.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | videoView.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        //--pantalla inmersa y fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }
    public void ocultarBotones(){
        //menubarra.setBackgroundColor(Color.TRANSPARENT);
        menubarraAbajo.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.INVISIBLE);
        films2.setVisibility(View.INVISIBLE);
        prev.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
    }
    public void mostrarBotones(){
        menubarra.setBackgroundColor(Color.BLACK);
        menubarraAbajo.setVisibility(View.VISIBLE);
        editText.setVisibility(View.VISIBLE);
        films2.setVisibility(View.VISIBLE);
        prev.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
    }
    public void reproductor(int pos){
        videoView = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse(canales[pos]);
        videoView.setVideoURI(uri);
        videoView.start();

        //getSupportActionBar().hide();
        films2.setText("[ "+(pos+1)+" ]  :  [ "+nombres[pos]+" ]");
        //boton.setVisibility(View.INVISIBLE);


        hideSystemUI();
    }

    public void mostrarMenu(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        Menu menu = navigationView.getMenu();

        MenuItem mi;
        //GetCanalesDrive();

        for(int j=0; j<canales.length; j++){

            mi = menu.add(0, j, 0,"[ "+(j+1)+" ]  :  [ "+nombres[j]+" ]");
            mi.setIcon(R.drawable.ic_vol_type_tv_light);
            navigationMenuView.setBackgroundColor(Color.BLACK);
        }


        drawerLayout.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public void onOutPress() {
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu m = navigationView.getMenu();

        for (int i=0;i<m.size();i++) {

            MenuItem mi = m.getItem(i);
            if((mi.getItemId() == item.getItemId())){

                reproductor(i);

            }
            if (!(mi.getItemId() == item.getItemId())) {
                mi.setCheckable(false);
            }
        }

        item.setCheckable(true);
        item.setChecked(true);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public void GetCanalesDrive() {
        try {
            Ion.with(getApplicationContext()).load("https://drive.google.com/uc?id=1j0ToWmRsC8sC-w3OR4PPRByyZr-HkjYf").asString().setCallback(new FutureCallback<String>() {
                @Override
                public void onCompleted(Exception e, String result) {


                    html = result;

                    List<String> listadolinea = new ArrayList<String>();
                    List<String> listadolinea2 = new ArrayList<String>();

                    String v2;
                    String[] data = new String(result).split("\n");

                    if (data.length > 0) {
                        for (int i = 0; i < 101; i++) {

                            v2 = data[i];
                            String[] datalinea2 = new String(v2).split(";");
                            listadolinea.add(datalinea2[0]);
                            listadolinea2.add(datalinea2[1]);
                            //Toast.makeText(getApplicationContext(), "VectorCOD: "+datalinea2[0], Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getApplicationContext(), "VectorURL: "+datalinea2[1], Toast.LENGTH_SHORT).show();

                        }

                    } else {
                        listadolinea.add("Canal Ru TV");
                        listadolinea2.add("https://rutv.gcdn.co/streams/1410_1272/480n/index.m3u8");
                    }

                    for (int i = 1; i <= 100; i++) {


                        listadolinea.add("RU : Canal # " + i);
                        listadolinea2.add("http://ott-cdn.ucom.am/s" + i + "/04.m3u8");
                        //Toast.makeText(getApplicationContext(), "VectorCOD: "+datalinea2[0], Toast.LENGTH_SHORT).show();
                        //Toast.makeText(getApplicationContext(), "VectorURL: "+datalinea2[1], Toast.LENGTH_SHORT).show();
                    }


                    vectorCod2 = listadolinea.toArray(new String[listadolinea.size()]);
                    vectorUrl2 = listadolinea2.toArray(new String[listadolinea2.size()]);

                    nombres = vectorCod2;
                    canales = vectorUrl2;

                    //Toast.makeText(getApplicationContext(), "VectorCod3: " + vectorCod2[3], Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), "VectorCod4: " + nombres[4], Toast.LENGTH_SHORT).show();
                    //ShowAlertDialogWithListview4(vectorCod2, vectorUrl2);

                    mostrarMenu();


                }
            });
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Canales remotos no fueron cargados!", Toast.LENGTH_SHORT).show();
        }



    }
}
