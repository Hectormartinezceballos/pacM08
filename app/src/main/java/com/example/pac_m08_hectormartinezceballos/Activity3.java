package com.example.pac_m08_hectormartinezceballos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Activity3 extends AppCompatActivity {

    EditText usuario_activity3;
    EditText contraseña_activity3;
    Button buttonlogin_activity3;
    BBDDuser bbdDuser=new BBDDuser(this,"usuarios",null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        usuario_activity3=findViewById(R.id.user_activity3);
        contraseña_activity3=findViewById(R.id.password_activity3);
        buttonlogin_activity3=findViewById(R.id.loginbutton_activity3);

        buttonlogin_activity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String us_activity3=usuario_activity3.getText().toString();
                String contr_activity3=contraseña_activity3.getText().toString();
                try {
                    Cursor cursorValidacion = bbdDuser.ConsultaUsuarioContraseña(us_activity3, contr_activity3);
                    if (cursorValidacion.getCount()>0){
                        Intent intent = new Intent(Activity3.this, Activity4.class);
                        intent.putExtra("usuario",us_activity3);
                        startActivity(intent);
                    } else Toast.makeText(getApplicationContext(),"Usuario o Contraseña Incorrecto",Toast.LENGTH_LONG).show();

                }catch (SQLException e){
                    e.printStackTrace();
                }
            };
        });
    }
}
