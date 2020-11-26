package com.example.helpick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DrawingLotsFinalResult extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_lots_final_result);

        layout = findViewById(R.id.drawingLotsResult_layout);

        Intent intent = getIntent();
        int[] pick_result = intent.getIntArrayExtra("result");
        for(int i=0;i<pick_result.length;i++){
            ImageView imageView = new ImageView(getApplicationContext());
            if(pick_result[i] == 1){
                imageView.setImageResource(R.drawable.pick_unfold_lose);
            }
            else{
                imageView.setImageResource(R.drawable.pick_unfold_win);
            }
            addView(imageView,300,300);
        }
    }

    public void addView (ImageView imageView, int width, int height){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
        layoutParams.setMargins(0, 20,0,20);
        imageView.setLayoutParams(layoutParams);
        layout.addView(imageView);

    }
}