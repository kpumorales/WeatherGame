package xyz.ulisesprofe.weathergame;

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
import java.util.ArrayList;

import static xyz.ulisesprofe.weathergame.R.id.listView;

public class Score extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        text= (TextView) findViewById(R.id.textView6);
        try{
            BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput("marcador.txt")));
            String texto = fin.readLine();
            fin.close();
            text.setText(texto);

        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
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
