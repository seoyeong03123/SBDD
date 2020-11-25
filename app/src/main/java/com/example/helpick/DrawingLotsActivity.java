
package com.example.helpick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class DrawingLotsActivity extends AppCompatActivity {

    TextView people, lose;
    Button peo_min, peo_pl, lose_min, lose_pl, submit;

    int people_amount = 2, lose_amount = 1;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_lots);

        people = findViewById(R.id.people_amount);
        lose = findViewById(R.id.lose_amount);
        peo_pl = findViewById(R.id.people_plus);
        peo_min = findViewById(R.id.people_minus);
        lose_pl = findViewById(R.id.lose_plus);
        lose_min = findViewById(R.id.lose_minus);
        submit = findViewById(R.id.pick_submit);

        peo_pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people_amount += 1;
                people.setText(Integer.toString(people_amount));
            }
        });

        peo_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (people_amount <= 2) {
                    Toast.makeText(getApplicationContext(), "2명 이하로는 설정할 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    people_amount -= 1;
                    people.setText(Integer.toString(people_amount));
                }
            }
        });

        lose_pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lose_amount >= people_amount - 1) {
                    Toast.makeText(getApplicationContext(), "인원 수 이상으로 설정할 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    lose_amount += 1;
                    lose.setText(Integer.toString(lose_amount));
                }
            }
        });

        lose_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lose_amount <= 1) {
                    Toast.makeText(getApplicationContext(), "1개 이하로는 설정할 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    lose_amount -= 1;
                    lose.setText(Integer.toString(lose_amount));
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] rand_num = new int[lose_amount];

                for (int i = 0; i < lose_amount; i++) {
                    rand_num[i] = random.nextInt(lose_amount) + 1;
                }
            }
        });

    }
}