package xyz.ulisesprofe.weathergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class score extends AppCompatActivity {
    ListView lista;

    Bundle b;
    String nombre,puntuacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        b=getIntent().getExtras();
        nombre=b.getString("info");
        puntuacion=b.getString("moviemientos");
        String[] cosas = new String[] {nombre,puntuacion};

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplication(),android.R.layout.simple_list_item_1, cosas);
        ListView lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(arrayAdapter);
    }
}
