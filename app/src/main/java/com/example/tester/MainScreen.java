package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    Button Calculator_nav, Facebook_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Calculator_nav = findViewById(R.id.Calculator_nav);
        Facebook_nav = findViewById(R.id.facebook_nav);
        Calculator_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, CalculatorActivity.class);
                intent.putExtra(CalculatorActivity.calculator_args, "1");
                startActivity(intent);
            }
        });

        Facebook_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, facebook_post.class);
                startActivity(intent);
            }
        });

    }
}