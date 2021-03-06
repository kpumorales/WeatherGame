package xyz.ulisesprofe.weathergame;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class main extends AppCompatActivity {
    String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Button btn1 = (Button) findViewById(R.id.PlayButton);
        final EditText editText=(EditText)findViewById(R.id.editText);
        editText.setText("");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre=editText.getText().toString();
                if (nombre.isEmpty())
                {
                    Toast.makeText(main.this, "Para comenzar escriba un nombre", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(main.this, Game.class);
                    i.putExtra("nombre",nombre);
                    startActivity(i);
                }
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exitmenu:
                finish();
                System.exit(0);
                break;
            case R.id.helpmenu:
                Intent intent = new Intent(getApplicationContext(), Help.class);
                startActivity(intent);
                break;
            case R.id.creditsmenu:
                Intent i = new Intent(getApplicationContext(), Credits.class);
                startActivity(i);
                break;
            case R.id.Scoremenu:
                Intent i2 = new Intent(getApplicationContext(), Score.class);
                startActivity(i2);
        }
        return super.onOptionsItemSelected(item);
    }
}