package com.example.helpick;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class TurntableActivity extends AppCompatActivity {
    private CircleManager circleManager;
    private RelativeLayout layoutRoulette; //룰렛 틀 생성한 xml파일

    Button btnDrawRoulette6; //6개 생성 버튼
    Button btnRotate; // 돌리는 버튼
    EditText ed1, ed2, ed3, ed4, ed5, ed6; //입력한 값들을 담는 변수들

    private ArrayList<String> STRINGS; //룰렛에 랜덤으로 생성되는 숫자들(문자열 객체)
    private float initAngle = 0.0f; // 초기 각도
    private int num_roulette; // 룰렛 개수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turntable);

        btnRotate = findViewById(R.id.btnRotate);
        btnDrawRoulette6 = findViewById(R.id.btnDrawRoulette6);
        layoutRoulette = findViewById(R.id.layoutRoulette);
        ed1 = findViewById(R.id.edittext_1);
        ed2 = findViewById(R.id.edittext_2);
        ed3 = findViewById(R.id.edittext_3);
        ed4 = findViewById(R.id.edittext_4);
        ed5 = findViewById(R.id.edittext_5);
        ed6 = findViewById(R.id.edittext_6);

        //method
        btnDrawRoulette6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num_roulette = 6; //룰렛 개수 6개로 설정
                STRINGS = addString();
                circleManager = new CircleManager(TurntableActivity.this, num_roulette);
                layoutRoulette.addView(circleManager);
            }
        });

        //버튼 클릭시 회전 시켜주는 method 로 이동
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateLayout(layoutRoulette, num_roulette);
            }
        });
    }

    public void rotateLayout(final RelativeLayout layout, final int num) {
        final float fromAngle = getRandom(360) + 3600 + initAngle;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getResult(fromAngle, num); // 애니메이션이 끝나면 run 안에 있는 코드(결과)가 3초후에 실행됨
            }
        }, 3000);

        //룰렛을 회전시키는 함수 (회전을 시작하는 각도, 회전을 끝내는 각도, x축을 설정, 중앙으로 설정, Y축을 설정, 중앙으로 설정)
        RotateAnimation rotateAnimation = new RotateAnimation(initAngle, fromAngle,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //애니메이션 효과들
        rotateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.anim.accelerate_decelerate_interpolator)); // 점점빠르게와 점점느리게를 동시에 해줌
        rotateAnimation.setDuration(3000); //애니메이션 지속시간 설정
        rotateAnimation.setFillEnabled(true); //view 화면을 지속시켜줌(룰렛 돌린 결과)
        rotateAnimation.setFillAfter(true); //애니메이션 종료후 이동한 좌표에 그대로 자리잡는 설정
        layout.startAnimation(rotateAnimation); //애니메이션을 적용한 view 에 애니메이션 작동하게 해줌
    }

    public ArrayList<String> addString() { //입력한 것들을 strings에 넣는 함수
        ArrayList<String> strings = new ArrayList<>();

        strings.add(ed1.getText().toString());
        strings.add(ed2.getText().toString());
        strings.add(ed3.getText().toString());
        strings.add(ed4.getText().toString());
        strings.add(ed5.getText().toString());
        strings.add(ed6.getText().toString());

        return strings;
    }

    // 난수 발생
    private int getRandom(int maxNumber) {
        double r = Math.random();
        return (int)(r * maxNumber);
    }

    //룰렛을 회전시킬시 선택되는 숫자를 나타내는 method
    private void getResult(float angle, int num_roulette) {
        String text = "";
        angle = angle % 360;

        Log.d("roulette", "Result : " + angle);

        if (num_roulette == 6) {           //룰렛이 멈출시 나타낼 결과를 지정해주는 method
            if (angle > 330 || angle <= 30) {
                text = STRINGS.get(4);
                buildAlert(text);
            } else if (angle > 30 && angle <= 90) {
                text = STRINGS.get(3);
                buildAlert(text);
            } else if (angle > 90 && angle <= 150) {
                text = STRINGS.get(2);
                buildAlert(text);
            } else if (angle > 150 && angle <= 210) {
                text = STRINGS.get(1);
                buildAlert(text);
            }
        }
    }

    // AlertDialog를 이용해서 룰렛을 돌리고 얻은 결과를 알려주는 method
    private void buildAlert(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("축하합니다!")
                .setMessage(text+"가 당첨되었습니다!")
                .setPositiveButton("확인", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        layoutRoulette.setRotation(360 - initAngle);
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //룰렛의 색상과 text 속성을 설정하는 부분
    public class CircleManager extends View {
        private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        private int[] COLORS = {Color.rgb(235,139,117), Color.rgb(232,185,143), Color.rgb(222,224,187), Color.rgb(141,196,129), Color.rgb(220,111,116), Color.rgb(232,170,175)};
        private int num;

        public CircleManager(Context context, int num) {
            super(context);
            this.num = num;
        }


        //호를 그리는 다양한 속성을 설정하는 method
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            //부채꼴을 그리기 위해 layout 에서 크기를 가져옴
            int width = layoutRoulette.getWidth();
            int height = layoutRoulette.getHeight();
            int sweepAngle = 360 / num;

            RectF rectF = new RectF(0, 0, width, height); //float형을 받는 직사각형 클래스
            Rect rect = new Rect(0, 0, width, height); //글자를 배치할 때 쓰이는 직사각형 클래스

            int centerX = (rect.left + rect.right) / 2;
            int centerY = (rect.top + rect.bottom) / 2;
            int radius = (rect.right - rect.left) / 2;

            int temp = 0;

            for (int i = 0; i < num; i++) {    //paint 속성으로 부채꼴을 그려줌
                paint.setColor(COLORS[i]);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setAntiAlias(true); //화면 부드럽게 해줌
                paint.setTextAlign(Paint.Align.CENTER);
                canvas.drawArc(rectF, temp, sweepAngle, true, paint);

                float medianAngle = (temp + (sweepAngle / 2f)) * (float) Math.PI / 180f;

                paint.setColor(Color.BLACK);            //룰렛 생성시 나타나는 글자 속성
                paint.setTextSize(70);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);

                float arcCenterX = (float) (centerX + (radius * Math.cos(medianAngle))); // Arc's center X
                float arcCenterY = (float) (centerY + (radius * Math.sin(medianAngle))); // Arc's center Y

                // 호의 중심점과 원의 중심점 중간에 텍스트를 배치하도록 함.
                float textX = (centerX + arcCenterX) / 2;
                float textY = (centerY + arcCenterY) / 2;

                canvas.drawText(STRINGS.get(i), textX, textY, paint); //받은 결과 출력
                temp += sweepAngle; //sweepAngle 만큼 호를 그려나감
            }
        }
    }
}