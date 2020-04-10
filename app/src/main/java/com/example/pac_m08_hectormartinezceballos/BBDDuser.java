package com.example.pac_m08_hectormartinezceballos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BBDDuser extends SQLiteOpenHelper {

    public BBDDuser(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String crerTablA ="CREATE TABLE usuarios(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "email TEXT NOT NULL,"+
                "usuario TEXT NOT NULL,"+
                "contrasena TEXT NOT NULL);";
        db.execSQL(crerTablA);

        /*************************************************************impresion de control por consola*********************************************/
        System.out.println("base de datos creada correctamente");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public void abrirBD(){

        this.getWritableDatabase();
    }
    public void cerrarBD(){

        this.close();
    }


    /*************************FUNCION PARA INSERTAR DATOS EN LA BBDD***************************************************/

    public void insertarDatos(String nombre, String apellido, String email, String usuario, String contrasena){


        ContentValues valoresUsuario=new ContentValues();

        valoresUsuario.put("nombre",nombre);
        valoresUsuario.put("apellido",apellido);
        valoresUsuario.put("email",email);
        valoresUsuario.put("usuario",usuario);
        valoresUsuario.put("contrasena",contrasena);

        //una vez tenemos los valores almacenados en el content value los escribimos en la BD.
        this.getWritableDatabase().insert("usuarios",null,valoresUsuario);
    }

    //Metodo que me permite consultar si son correctos el usuario y la contraseña

    public Cursor ConsultaUsuarioContraseña(String usuario, String contrasena)throws SQLException {
        Cursor cursor = null;
        cursor=this.getReadableDatabase().query
                ("usuarios",new String[]{"id","nombre","apellido","email","usuario","contrasena"},"usuario like '"+usuario+"'"
                + "and contrasena like '"+contrasena+"'",null,null,null,null);

        return cursor;

    }
    //Metodo que permite mostrar los datos del usuario en el activity 4 devolviendo un cursor.

    public Cursor llenar_datosUsuario(String usuario){

        SQLiteDatabase database=this.getReadableDatabase();
        String consulta="select * from usuarios where usuario='" + usuario+"'";

        Cursor registro = database.rawQuery(consulta,null);

        return registro;
    }


}
