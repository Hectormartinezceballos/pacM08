package com.example.pac_m08_hectormartinezceballos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity4 extends AppCompatActivity {

    Button play, stop;
    TextView tvNombre, tvApellido, tvCorreo, tvUsuario, tvContrasena,tvid;

    ArrayList<String> arraylistaDatos;
    ArrayAdapter adaptador;
    String usuarioRecibido;

    BBDDuser db = new BBDDuser(this,"usuarios",null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        play=findViewById(R.id.activity4_play);
        stop=findViewById(R.id.activity4_stop);
        tvNombre = findViewById(R.id.tvNombre);
        tvApellido = findViewById(R.id.tvApellido);
        tvCorreo = findViewById(R.id.tvCorreo);
        tvUsuario = findViewById(R.id.tvUsuario);
        tvContrasena = findViewById(R.id.tvContrasena);
        tvid=findViewById(R.id.tvid);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });



        Bundle bundle=getIntent().getExtras();
        usuarioRecibido=bundle.getString("usuario");
        Cursor cursor = db.llenar_datosUsuario(usuarioRecibido);
        if(cursor.moveToFirst()){
            do{
                tvNombre.setText(cursor.getString(1));
                tvApellido.setText(cursor.getString(2));
                tvCorreo.setText(cursor.getString(3));
                tvUsuario.setText(cursor.getString(4));
                tvContrasena.setText(cursor.getString(5));
                tvid.setText(cursor.getString(0));




            }while( cursor.moveToNext());
        }

        //tvNombre.setText(arraylistaDatos.get(1));
//
//        tvUsuario.setText(usuarioRecibido);
//        tvApellido.setText(apellido);

//        BBDDuser bbdDuser=new BBDDuser(this,"usuarios",null,1);
//        arraylistaDatos=bbdDuser.llenar_datosUsuario(usuarioRecibido);
//        adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arraylistaDatos);
//        Datos_usuario.setAdapter(adaptador);
//        bbdDuser.cerrarBD();

    }
}
