package com.example.pac_m08_hectormartinezceballos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    EditText nombre, apellido, usuario, contrasena, email;
    Button aceptarRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        nombre=findViewById(R.id.editText_nombre);
        apellido=findViewById(R.id.editText_apellido);
        usuario=findViewById(R.id.editText_Usuario);
        contrasena=findViewById(R.id.editText_Password);
        email=findViewById(R.id.editText_email);
        aceptarRegistro=findViewById(R.id.activity2_boton_registro);
        aceptarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcionAceptarRegistro(v);
            }
        });
    }

    public void funcionAceptarRegistro(View view){

        if(nombre.getText().toString().isEmpty() & apellido.getText().toString().isEmpty()&usuario.getText().toString().isEmpty()&
                contrasena.getText().toString().isEmpty()&email.getText().toString().isEmpty()){
            Toast.makeText(this,"Todos los datos obligatorios",Toast.LENGTH_LONG).show();
        }
        else {
            BBDDuser bbddUser = new BBDDuser(this,"usuarios",null,1);//creamos bbdd

            bbddUser.abrirBD();
            //EJECUTAMOS LA FUNCION INSERT DATA PARA RECOGER LOS DATOS INTRODUCIDOS
            bbddUser.insertarDatos(
                    nombre.getText().toString(),
                    apellido.getText().toString(),
                    email.getText().toString(),
                    usuario.getText().toString(),
                    contrasena.getText().toString());
            bbddUser.cerrarBD();

            Intent registrar=new Intent(this,Activity3.class);
            startActivity(registrar);
        }
    }
}
