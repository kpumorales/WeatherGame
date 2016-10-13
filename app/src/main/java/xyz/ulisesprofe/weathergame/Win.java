package xyz.ulisesprofe.weathergame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.OutputStreamWriter;

public class Win extends AppCompatActivity {
    String nombre,movimientos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win);
        //movimientos= getIntent().getExtras().getString("movimientos");
        nombre= getIntent().getExtras().getString("nombre");

        try {
            OutputStreamWriter fout= new OutputStreamWriter(openFileOutput("marcador.txt", Context.MODE_APPEND));
            fout.write(nombre);
            fout.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
    }




    public void score(View view) {
        Intent i = new Intent(Win.this, Score.class);
        //i.putExtra("movimientos",movimientos);
        //i.putExtra("nombre",nombre);
        startActivity(i);

    }
}
