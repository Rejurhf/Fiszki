package com.example.rejurhf.fiszki.add;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rejurhf.fiszki.R;
import static com.example.rejurhf.fiszki.io.FileHand.addNewWord;

/**
 * Created by Rejurhf on 06.03.2018.
 */

public class AddActivity extends AppCompatActivity {
    private String fileName = "initFile.txt";
    private EditText editTextWord, editTextInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiszki);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            fileName = extras.getString("name");                              //get name of clicked file
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main, new AddWords(fileName)).commit(); //fragment that displays all words
        }
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

    public void addWordButtonClicked(View view) {
        editTextWord = (EditText) findViewById(R.id.editTextAddWord);
        editTextInfo = (EditText) findViewById(R.id.editTextAddInfo);
        String word = editTextWord.getText().toString();
        String info = editTextInfo.getText().toString();
        if(!word.equals("") && !info.equals("")){
            editTextWord.setText("");
            editTextInfo.setText("");
            addNewWord(word, info, fileName);
        }else {
            Toast.makeText(this, "Wprowadź tekst w obu rubrykach", Toast.LENGTH_SHORT).show();
        }
    }
}
