package com.example.helpick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class RandomNumberActivity extends AppCompatActivity {

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number);

        Button btn_plus = findViewById(R.id.btn_plus);
        Button btn_minus = findViewById(R.id.btn_minus);
        Button btn_submit = findViewById(R.id.play_button);
        TextView tv_counter = findViewById(R.id.tv_counter);
        TextView output = findViewById(R.id.output);



        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_counter.setText(String.valueOf(++counter));
                Toast toast = Toast.makeText(getApplicationContext(), "숫자가 증가되었습니다.", Toast.LENGTH_SHORT);
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter>0) {
                    tv_counter.setText(String.valueOf(--counter));
                    Toast toast = Toast.makeText(getApplicationContext(), "숫자가 감소되었습니다.", Toast.LENGTH_SHORT);
                }
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                if (counter > 0) {
                    int rnum = random.nextInt(counter);
                    output.setText(String.valueOf(rnum));
                }
            }
        });
    }
}