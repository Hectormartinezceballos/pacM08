package com.example.pac_m08_hectormartinezceballos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int numberCode=0;

    Button botonRegistro;
    Button botonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonLogin=findViewById(R.id.begin_session_button);
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcionLogin(v);
            }
        });

        botonRegistro = findViewById(R.id.register_button);
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcionRegistro(v);
            }
        });
    }

    public void funcionLogin(View view){

        Intent intent =new Intent(this,Activity3.class);
        startActivity(intent);
    }

    public  void funcionRegistro(View v){

        Intent intent= new Intent(this,Activity2.class);
        startActivity(intent);
    }
}
