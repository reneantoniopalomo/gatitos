package com.example.personal.gatitos.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.personal.gatitos.R;

public class Suetersmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suetersmenu);
    }

    public void f(View view) {
        Intent intent1=new Intent(Suetersmenu.this,Sueter1activity.class);
        startActivity(intent1);
    }

    public void j(View view) {
        Intent intent2=new Intent(Suetersmenu.this,Sueter2activity.class);
        startActivity(intent2);

    } public void p(View view) {
        Intent intent3=new Intent(Suetersmenu.this,Sueter3activity.class);
        startActivity(intent3);

    } public void w(View view) {
        Intent intent4=new Intent(Suetersmenu.this,Sueter4activity.class);
        startActivity(intent4);

    }
}
