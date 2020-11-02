package com.example.helpick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RandomNumberActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number);

        Button btn_plus = findViewById(R.id.btn_plus);
        Button btn_minus = findViewById(R.id.btn_minus);
        TextView tv_counter = findViewById(R.id.tv_counter);
        String string = tv_counter.getText().toString();
        int count = Integer.parseInt(string);


        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}