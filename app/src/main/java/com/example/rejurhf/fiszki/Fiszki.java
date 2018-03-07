package com.example.rejurhf.fiszki;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.rejurhf.fiszki.add.AddFrag;
import com.example.rejurhf.fiszki.all.AllFrag;
import com.example.rejurhf.fiszki.classic.ClassicFrag;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fiszki extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int curLayoutId;
    private String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/FiszkiApp";
    AddFrag addFrag = new AddFrag();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiszki);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main, new MainFrag()).commit();
        curLayoutId = R.layout.frag_main;
        Initialization();
    }

    private void Initialization() {
        File dir = new File(path);
        if(!dir.mkdir()){
            Toast.makeText(this, "Could not create file", Toast.LENGTH_SHORT).show();
        }

        File file = new File(path + "/initFile.txt");
        if(!file.exists()){
            String[] initText = {"Word", "Information about the word"};
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            try {
                for (String line: initText){
                    fos.write(line.getBytes());
                    fos.write("\n".getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Toast.makeText(this, "File Initialized", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (curLayoutId != R.layout.frag_main) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main,
                    new MainFrag()).commit();
            curLayoutId = R.layout.frag_main;
        }else{
                super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fiszki, menu);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main) {                                                          //panel nawigazyjny odniesienia do fragmentów
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main,
                    new MainFrag()).commit();
            curLayoutId = R.layout.frag_main;
            Toast.makeText(this, "Główny ekran", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_all) {                                                    //wszystkie fiszki
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main,
                    new AllFrag()).commit();
            curLayoutId = R.layout.frag_all;
            Toast.makeText(this, "Wszystko", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_classic) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main,
                    new ClassicFrag()).commit();
            curLayoutId = R.layout.frag_classic;
            Toast.makeText(this, "Klasyczny", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_insert) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main,
                    new InsertFrag()).commit();
            curLayoutId = R.layout.frag_insert;
            Toast.makeText(this, "Wprowadź", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_add) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main,
                    addFrag).commit();
            curLayoutId = R.layout.frag_add;
            Toast.makeText(this, "Dodaj", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_delete) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main,
                    new DeleteFrag()).commit();
            curLayoutId = R.layout.frag_delete;
            Toast.makeText(this, "Usuń", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_change) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main,
                    new ChangeFrag()).commit();
            curLayoutId = R.layout.frag_change;
            Toast.makeText(this, "Zmień", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_about) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main,
                    new AboutFrag()).commit();
            curLayoutId = R.layout.frag_about;
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addButtonClicked(View view){
        addFrag.addNewSet();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            int frag = data.getIntExtra("frag", 0);
            if(frag == 2){
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main,
                        new InsertFrag()).commit();
                curLayoutId = R.layout.frag_insert;
                Toast.makeText(this, "Wprowadź", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
