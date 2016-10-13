package xyz.ulisesprofe.weathergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static xyz.ulisesprofe.weathergame.R.id.listView;

public class Score extends AppCompatActivity {
    String nombre;
    int movimientos;
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        movimientos= Integer.parseInt(getIntent().getExtras().getString("movimientos"));
        nombre= getIntent().getExtras().getString("nombre");
        lista= (ListView) findViewById(R.id.listView);

    }
}
