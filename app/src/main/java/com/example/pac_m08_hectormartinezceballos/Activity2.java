package com.example.pac_m08_hectormartinezceballos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    EditText nombre, apellido, usuario, contrasena, email;//Creamos las variables
    Button aceptarRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        nombre=findViewById(R.id.editText_nombre);//almacenamos las vistas en las variables
        apellido=findViewById(R.id.editText_apellido);
        usuario=findViewById(R.id.editText_Usuario);
        contrasena=findViewById(R.id.editText_Password);
        email=findViewById(R.id.editText_email);
        aceptarRegistro=findViewById(R.id.activity2_boton_registro);

        aceptarRegistro.setOnClickListener(new View.OnClickListener() {//aplicamos un listener boton aceptar
            @Override
            public void onClick(View v) {
                funcionAceptarRegistro(v);
            }
        });
    }

    public void funcionAceptarRegistro(View view){//Creamos la funcion para guardar los datos introducidos en la base de datos SQLite.

        if(nombre.getText().toString().isEmpty() || apellido.getText().toString().isEmpty()|| usuario.getText().toString().isEmpty()||
                contrasena.getText().toString().isEmpty()|| email.getText().toString().isEmpty()){
            Toast.makeText(this,R.string.activity2_toastCamposObligatorios,Toast.LENGTH_LONG).show();
            //si hay algun campo vacío no nos deja avanzar y lo muestra en el dispositivo, los pongo obligatorios todos.
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

            Toast.makeText(this,R.string.activity2_toastRegistroCorrecto,Toast.LENGTH_SHORT).show();
            //muestro mensaje cuando los datos se han introducido y limpio las vistas de la aplicacion.
            nombre.setText("");
            apellido.setText("");
            email.setText("");
            usuario.setText("");
            contrasena.setText("");
            Intent registrar=new Intent(this,Activity3.class);//Cambiamos de actividad con un intent.
            startActivity(registrar);
        }
    }
}
