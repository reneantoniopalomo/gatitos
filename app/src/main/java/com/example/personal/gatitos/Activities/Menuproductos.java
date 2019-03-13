package com.example.personal.gatitos.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.personal.gatitos.R;

public class Menuproductos extends AppCompatActivity {
    Button h;
    Button c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuproductos);

    }

    public void c(View view) {
        Intent intent1=new Intent(Menuproductos.this, Suetersmenu.class);
        startActivity(intent1);
    }

    public void n(View view) {
        Intent intent2=new Intent(Menuproductos.this, Camisetasmenu.class);
        startActivity(intent2);
    }



}
