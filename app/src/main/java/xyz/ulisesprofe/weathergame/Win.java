package xyz.ulisesprofe.weathergame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Win extends AppCompatActivity {
    //String nombre;
    //Bundle b;
    //TextView t;
    TextView puntuacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win);
        puntuacion= (TextView) findViewById(R.id.puntuacion);

        String movimientos= getIntent().getExtras().getString("movimientos");
        puntuacion.setText(movimientos);
       // score();
    }
    //public void score() {
      //  t=(TextView)findViewById(R.id.textView);
       // b=getIntent().getExtras();
        //nombre=b.getString("mov");

        //t.setText(nombre);
    //}
}
