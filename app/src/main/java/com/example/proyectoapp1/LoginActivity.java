package com.example.proyectoapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import java.text.BreakIterator;

public class LoginActivity extends AppCompatActivity {

    private GridView gridView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Iniciarsesion(View view){
        Intent Iniciarsesion  = new Intent(this, AppActivity.class);
        startActivity(Iniciarsesion);
    }

    public void Registro(View view){
        Intent Registro  = new Intent(this, RegisterActivity.class);
        startActivity(Registro);
    }


}