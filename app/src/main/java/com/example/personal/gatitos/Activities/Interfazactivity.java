package com.example.personal.gatitos.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.personal.gatitos.R;

public class Interfazactivity extends AppCompatActivity {
    Button h;
    Button c;
    Button co;
    Button p;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfazactivity);
    }

    public void h(View view) {
        Intent intent1=new Intent(Interfazactivity.this, Historyactivity.class);
        startActivity(intent1);
    }

    public void c(View view) {
        Intent intent2=new Intent(Interfazactivity.this, Creditsactivity.class);
        startActivity(intent2);
    }

    public void co(View view) {
        Intent intent3=new Intent(Interfazactivity.this, llamada.class);
        startActivity(intent3);
    }

    public void p(View view) {
        Intent intent4=new Intent(Interfazactivity.this, Menuproductos.class);
        startActivity(intent4);
    }
}
