package xyz.ulisesprofe.weathergame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import static android.view.Gravity.LEFT;
import static android.view.Gravity.TOP;

public class Game extends AppCompatActivity {
    private TextView moveCounter,feedbackText,feedbackTitleText, chance, Displayname;
    private Button[] buttons;
    private Boolean bad_move=false;
    private static final Integer[] goal = new Integer[] {0,1,2,3,4,5,6,7,8};
    private String[] array=new String[]{"Cuida el agua","No tires basura","Recicla","Apaga las luces"};
    static int cont=3;
    TextView t;
    Bundle b;
    String nombre,mensaje,numero,movimientos1="0";
    private ArrayList<Integer> cells = new ArrayList<Integer>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        //MediaPlayer mp = MediaPlayer.create(this, R.raw.music);
        //float log1=(float)(Math.log(maxVolume-currVolume)/Math.log(maxVolume));
        //mp.setVolume(1-log1);
        //mp.setLooping(true);
        //mp.start();
        buttons=findButtons();
        moveCounter = (TextView) findViewById(R.id.MoveCounter);
        feedbackTitleText= (TextView) findViewById(R.id.FeedbackTitleText);
        chance= (TextView) findViewById(R.id.chance);
        Displayname= (TextView) findViewById(R.id.displayname);

        nombre= getIntent().getExtras().getString("nombre");
        Displayname.setText(nombre);
        for(int i=0;i<9;i++)
        {
            this.cells.add(i);
        }
        Button btn1 = (Button) findViewById(R.id.Shuffle);
        final ImageView zoomImage =(ImageView) findViewById(R.id.zoomImage);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Game.this, Win.class);
                i.putExtra("movimientos",moveCounter.getText());
                startActivity(i);
                //Collections.shuffle(cells); //random cells array
                //fill_grid();
                //moveCounter.setText("0");
                //buttons[0].setBackgroundResource(R.drawable.transparente);
                //zoomImage.setEnabled(true);
                //zoomImage.setBackgroundResource(R.drawable.zoom);
                //cont=3;
                //chance.setText(String.valueOf(cont));

            }
        });

        zoomImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Game.this, Zoom.class);
                startActivity(i);
                cont--;
                chance.setText(String.valueOf(cont));
                Toast.makeText(Game.this, "Gastaste una ayuda, quedan: "+cont, Toast.LENGTH_SHORT).show();
                if(cont==0) {
                    zoomImage.setEnabled(false);
                    zoomImage.setBackgroundResource(R.drawable.zoom2);
                    Toast.makeText(Game.this, "Acabaste tu ayuda", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Collections.shuffle(cells); //random cells array
        fill_grid();


        for (int i = 1; i < 9; i++) {
            buttons[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    makeMove((Button) v);
                }
            });
        }


        moveCounter.setText("0");
        Toast.makeText(Game.this, R.string.game_feedback_text, Toast.LENGTH_SHORT).show();
    }
    public Button[] findButtons() {
        Button[] b = new Button[9];

        b[0] = (Button) findViewById(R.id.Button00);
        b[1] = (Button) findViewById(R.id.Button01);
        b[2] = (Button) findViewById(R.id.Button02);
        b[3] = (Button) findViewById(R.id.Button03);
        b[4] = (Button) findViewById(R.id.Button04);
        b[5] = (Button) findViewById(R.id.Button05);
        b[6] = (Button) findViewById(R.id.Button06);
        b[7] = (Button) findViewById(R.id.Button07);
        b[8] = (Button) findViewById(R.id.Button08);
        return b;
    }


    public void makeMove(final Button b) {
        bad_move=true;
        int b_text,b_pos,zuk_pos;
        b_text=Integer.parseInt((String) b.getText());//toma el texto del boton
        b_pos=find_pos(b_text);//lo busca en el arreglo find
        zuk_pos=find_pos(0);//busca la posicion del 0 en el find
        switch(zuk_pos)
        {
            case(0):
                if(b_pos==1||b_pos==3)
                    bad_move=false;
                break;
            case(1):
                if(b_pos==0||b_pos==2||b_pos==4)
                    bad_move=false;
                break;
            case(2):
                if(b_pos==1||b_pos==5)
                    bad_move=false;
                break;
            case(3):
                if(b_pos==0||b_pos==4||b_pos==6)
                    bad_move=false;
                break;
            case(4):
                if(b_pos==1||b_pos==3||b_pos==5||b_pos==7)
                    bad_move=false;
                break;
            case(5):
                if(b_pos==2||b_pos==4||b_pos==8)
                    bad_move=false;
                break;
            case(6):
                if(b_pos==3||b_pos==7)
                    bad_move=false;
                break;
            case(7):
                if(b_pos==4||b_pos==6||b_pos==8)
                    bad_move=false;
                break;
            case(8):
                if(b_pos==5||b_pos==7)
                    bad_move=false;
                break;
        }

        if(bad_move==true)
        {
          MediaPlayer mal= MediaPlayer.create(this,R.raw.mal);
            mal.start();
            return;
        }
        MediaPlayer ok= MediaPlayer.create(this,R.raw.movimiento);
        ok.start();
        cells.remove(b_pos);
        cells.add(b_pos, 0);
        cells.remove(zuk_pos);
        cells.add(zuk_pos,b_text);


        fill_grid();
        moveCounter.setText(Integer.toString(Integer.parseInt((String) moveCounter.getText())+1));
        int num=Integer.parseInt((String) moveCounter.getText());
        if( num%10==0)
        {
            double aleatorio = Math.floor(Math.random()*(array.length));
            feedbackTitleText.setText(array[(int) aleatorio]);
        }

        for(int i=0;i<9;i++)
        {
            if(cells.get(i)!=goal[i])
            {
                return;
            }
        }
        MediaPlayer win = MediaPlayer.create(this,R.raw.win);
        win.start();
        buttons[0].setBackgroundResource(R.drawable.f0);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                Intent i = new Intent(Game.this, Win.class);
                //i.putExtra("nombre",nombre);
                i.putExtra("movimientos",moveCounter.getText());
                startActivity(i);
            }
        }, 2000);

    }

    public void fill_grid()
    {
        for(int i=0;i<9;i++)
        {
            int text=cells.get(i);
            FrameLayout.LayoutParams absParams =(FrameLayout.LayoutParams)buttons[text].getLayoutParams();
            switch(i)
            {
                case(0):
                    absParams.gravity = Gravity.TOP|Gravity.LEFT ;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(1):
                    absParams.gravity = Gravity.TOP|Gravity.CENTER_HORIZONTAL ;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(2):
                    absParams.gravity= Gravity.TOP|Gravity.RIGHT ;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(3):
                    absParams.gravity = Gravity.LEFT|Gravity.CENTER_VERTICAL ;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(4):
                    absParams.gravity = Gravity.CENTER;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(5):
                    absParams.gravity = Gravity.CENTER_VERTICAL|Gravity.RIGHT;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(6):
                    absParams.gravity = Gravity.LEFT |Gravity.BOTTOM;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(7):
                    absParams.gravity = Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(8):
                    absParams.gravity = Gravity.BOTTOM|Gravity.RIGHT ;
                    buttons[text].setLayoutParams(absParams);
                    break;


            }

        }

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
    public int find_pos(int element)
    {
        int i=0;
        for(i=0;i<9;i++)
        {
            if(cells.get(i)==element)
            {
                break;
            }
        }
        return i;

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent i = new Intent(Game.this,main.class);
            startActivity(i);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //public void nuevo(View view) {
    //    Intent nuevol = new Intent(this, score.class);
    //    mensaje=t.getText().toString();
    //    // movimientos1=moveCounter.getText().toString();
    //    nuevol.putExtra("info",mensaje);
    //    nuevol.putExtra("moviemientos",movimientos1);
    //    startActivity(nuevol);
    //}

}

