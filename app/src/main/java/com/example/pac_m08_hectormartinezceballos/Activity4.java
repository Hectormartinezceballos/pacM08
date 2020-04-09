package com.example.pac_m08_hectormartinezceballos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity4 extends AppCompatActivity {

    Button play, stop;
    TextView tvNombre, tvApellido, tvCorreo, tvUsuario, tvContrasena;

    ArrayList<String> arraylistaDatos;
    ArrayAdapter adaptador;
    String usuarioRecibido;


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

        Boolean bundle=getIntent().getExtras();
        usuarioRecibido=bundle.getString("usuario");
        tvNombre.setText(usuarioRecibido);

//        BBDDuser bbdDuser=new BBDDuser(this,"usuarios",null,1);
//        arraylistaDatos=bbdDuser.llenar_datosUsuario(usuarioRecibido);
//        adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arraylistaDatos);
//        Datos_usuario.setAdapter(adaptador);
//        bbdDuser.cerrarBD();

    }
}
