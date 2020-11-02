package com.example.helpick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout go_to_drawing_lots = findViewById(R.id.go_to_DrawingLots);
        LinearLayout go_to_random_number = findViewById(R.id.go_to_RandomNumber);
        LinearLayout go_to_turntable = findViewById(R.id.go_to_Turntable);
        LinearLayout go_to_rock_paper_scissors = findViewById(R.id.go_to_RockPaperScissors);

        go_to_drawing_lots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DrawingLotsActivity.class);
                startActivity(intent);
            }
        });

        go_to_random_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RandomNumberActivity.class);
                startActivity(intent);
            }
        });

        go_to_turntable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TurntableActivity.class);
                startActivity(intent);
             }
        });

        go_to_rock_paper_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RockPaperScissorsActivity.class);
                startActivity(intent);
            }
        });
    }
}