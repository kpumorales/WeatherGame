package xyz.ulisesprofe.weathergame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static xyz.ulisesprofe.weathergame.R.id.listView;

public class Score extends AppCompatActivity {
    ListView listView1;
    static ArrayList<String> lines;
    static String line;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        listView1 = (ListView) findViewById(R.id.listView);



        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("marcador.txt")));

            lines = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                lines.add(line);

            }

            br.close();
            Collections.sort(lines);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lines);


            listView1.setAdapter(adapter);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent i = new Intent(Score.this,main.class);
            startActivity(i);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }



}
