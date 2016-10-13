package xyz.ulisesprofe.weathergame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Win extends AppCompatActivity {
    String nombre,movimientos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win);
        movimientos= getIntent().getExtras().getString("movimientos");
        nombre= getIntent().getExtras().getString("nombre");
    }

    public void score(View view) {
        Intent i = new Intent(Win.this, Score.class);
        i.putExtra("movimientos",movimientos);
        i.putExtra("nombre",nombre);
        startActivity(i);
    }
}
