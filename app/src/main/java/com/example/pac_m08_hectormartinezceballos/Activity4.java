package com.example.pac_m08_hectormartinezceballos;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;


public class Activity4 extends AppCompatActivity {

   Button play, stop;
    TextView tvNombre, tvApellido, tvCorreo, tvUsuario, tvContrasena, tvid;
    String usuarioRecibido;
    MediaPlayer mediaPlayer;
    BBDDuser db = new BBDDuser(this, "usuarios", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        play = findViewById(R.id.activity4_play);
        stop = findViewById(R.id.activity4_stop);
        tvNombre = findViewById(R.id.tvNombre);
        tvApellido = findViewById(R.id.tvApellido);
        tvCorreo = findViewById(R.id.tvCorreo);
        tvUsuario = findViewById(R.id.tvUsuario);
        tvContrasena = findViewById(R.id.tvContrasena);
        tvid = findViewById(R.id.tvid);
        mediaPlayer = MediaPlayer.create(this, R.raw.resistire);


        play.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Activity4.this.onClick(v);

            }

        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity4.this.onClick(v);
            }
        });


        Bundle bundle = getIntent().getExtras();//Recuperamos el nombre de usuario para buscar en la BBDD
        usuarioRecibido = bundle.getString("usuario");

        Cursor cursor = db.llenar_datosUsuario(usuarioRecibido);//Con este metodo sacamos los datos del usuario del activity 3.
        if (cursor.moveToFirst()) {
            do {
                tvNombre.setText(cursor.getString(1));
                tvApellido.setText(cursor.getString(2));
                tvCorreo.setText(cursor.getString(3));
                tvUsuario.setText(cursor.getString(4));
                tvContrasena.setText(cursor.getString(5));
                tvid.setText(cursor.getString(0));


            } while (cursor.moveToNext());

        }

        db.cerrarBD();



    }
    public void onClick (View v){
        //Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente
        switch (v.getId()) {
            case R.id.activity4_play:
                //Iniciamos el audio

                mediaPlayer.start();

                break;

            case R.id.activity4_stop:
                //Paramos el audio y volvemos a inicializar
                try {

                    mediaPlayer.stop();
                    mediaPlayer.prepare();
                    mediaPlayer.seekTo(0);

                } catch (IOException e) {
                    e.printStackTrace();
                }


//                break;

        }
    }

}