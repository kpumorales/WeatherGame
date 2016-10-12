package xyz.ulisesprofe.weathergame;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by jozhema on 12/10/2016.
 */
public class bda extends SQLiteOpenHelper {
    //Sentencia SQL para crear la tabla de Usuarios
            String sqlCreate = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT)";
    public bda(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


    }
}
