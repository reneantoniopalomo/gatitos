package com.example.personal.gatitos.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.personal.gatitos.R;

public class Camisetasmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camisetasmenu);
    } public void T(View view) {
        Intent intent1=new Intent(Camisetasmenu.this,Camisa1activity .class);
        startActivity(intent1);
    }

    public void v(View view) {
        Intent intent2=new Intent(Camisetasmenu.this,Camisa2activity .class);
        startActivity(intent2);
    }

    public void ñ(View view) {
        Intent intent3=new Intent(Camisetasmenu.this,Camisa3activity .class);
        startActivity(intent3);
    }

    public void k(View view) {
        Intent intent4=new Intent(Camisetasmenu.this,Camisa4activity .class);
        startActivity(intent4);
    }
}
