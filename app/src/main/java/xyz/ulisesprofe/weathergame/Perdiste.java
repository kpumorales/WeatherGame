package xyz.ulisesprofe.weathergame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Perdiste extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perdiste);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

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
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent i = new Intent(Perdiste.this,main.class);
            startActivity(i);
            System.exit(0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
