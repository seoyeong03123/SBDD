package com.example.helpick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DrawingLotsResult extends AppCompatActivity {

    LinearLayout layout;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_lots_result);

        layout = findViewById(R.id.result_linear_layout);
        btn = findViewById(R.id.drawingLotsResult_check);

        Intent intent = getIntent();
        int[] pick_result = intent.getIntArrayExtra("result");
        for(int i=0;i<pick_result.length;i++){
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(R.drawable.pick_fold);
            addView(imageView,300,300);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DrawingLotsFinalResult.class);
                i.putExtra("result", pick_result);
                startActivity(i);
                finish();
            }
        });
    }

    public void addView (ImageView imageView, int width, int height){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
        layoutParams.setMargins(0, 20,0,20);
        imageView.setLayoutParams(layoutParams);
        layout.addView(imageView);

    }

}