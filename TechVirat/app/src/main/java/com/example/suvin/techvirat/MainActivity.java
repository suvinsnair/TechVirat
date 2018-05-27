package com.example.suvin.techvirat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    WebView brow;
    Button forward,back,refresh;

    public void btn_fwdclick(View view){

        if(brow.canGoForward()){
            brow.goForward();
        }
    }

    public void btn_bckclick(View view){

        if(brow.canGoBack()){
            brow.goBack();
        }
    }

    public void btn_refclick(View view){

        brow.reload();;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        brow=(WebView) findViewById(R.id.wv_brow);
        String url="http://www.techvirat.com/";


        WebSettings settings= brow.getSettings();
        settings.setJavaScriptEnabled(true);
        brow.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        brow.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK);
        brow.getSettings().setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);

        brow.loadUrl(url);

        forward=(Button) findViewById(R.id.btn_fwd);
        refresh=(Button) findViewById(R.id.btn_ref);
        back=(Button) findViewById(R.id.btn_bck);

        brow.setWebViewClient(new ourViewClient());











        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return false;
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            brow.loadUrl("http://www.techvirat.com/");

        } else if (id == R.id.nav_gallery) {

            brow.loadUrl("https://twitter.com/techvirat");


        } else if (id == R.id.nav_slideshow) {

            brow.loadUrl("http://www.techvirat.com/category/news/");

        } else if (id == R.id.nav_manage) {

            brow.loadUrl("http://www.techvirat.com/category/tricks/");




        } else if (id == R.id.nav_share) {

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://drive.google.com/open?id=1jwYPrEI596JGZcWyG2Su5ExYxHKCd4T6";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        } else if (id == R.id.nav_send) {
            brow.getSettings().setLoadWithOverviewMode(true);
            brow.getSettings().setUseWideViewPort(true);

            brow.getSettings().setSupportZoom(true);
            brow.getSettings().setBuiltInZoomControls(true);
            brow.getSettings().setDisplayZoomControls(false);

            brow.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            brow.setScrollbarFadingEnabled(false);
            brow.loadUrl("https://techvirat.github.io/");

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }


}
