package xyz.ulisesprofe.weathergame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Win extends AppCompatActivity {
    String nombre,movimientos,dato,mov;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win);
        //setContentView(R.layout.win);
        movimientos= getIntent().getExtras().getString("movimientos");
        nombre= getIntent().getExtras().getString("nombre");
        if (movimientos.length()==1)
        {
            mov="000"+movimientos;
        }
        else
        if(movimientos.length()==2)
        {
            mov="00"+movimientos;
        }
        else
        {
            if(movimientos.length()==3)
            {
                mov="0"+movimientos;
            }
        }
        dato=mov+" - "+nombre+"\n";
        try {
            OutputStreamWriter fout= new OutputStreamWriter(openFileOutput("marcador.txt", Context.MODE_APPEND));
            //ArrayList String = new ArrayList();
            fout.write(dato);
            fout.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent i = new Intent(Win.this,main.class);
            startActivity(i);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }



    public void score(View view) {
        Intent i = new Intent(Win.this, Score.class);
        //i.putExtra("movimientos",movimientos);
        //i.putExtra("nombre",nombre);
        startActivity(i);

    }
}
