package com.example.pac_m08_hectormartinezceballos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    Button botonRegistro,botonLogin;         //Creamos las variables donde almacenar las vistas
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonLogin=findViewById(R.id.begin_session_button);           // almacenamos las vista
        botonLogin.setOnClickListener(new View.OnClickListener() {//aplicamos un listener a los botones
            @Override
            public void onClick(View v) {
                funcionLogin(v);
            }
        });   //funcion listener llamando a la funcionLogin

        botonRegistro = findViewById(R.id.register_button);          // almacenamos la vista
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcionRegistro(v);
            }
        });//funcion listener llamando a funcionRegistro
    }

    public void funcionLogin(View view){       //añadimos funciones al pulsar botones login y registro.

        Intent intent =new Intent(this,Activity3.class);
        startActivity(intent);
    }

    public  void funcionRegistro(View v){

        Intent intent= new Intent(this,Activity2.class);
        startActivity(intent);
    }
}
