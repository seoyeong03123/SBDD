package com.example.helpick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class RockPaperScissorsActivity extends AppCompatActivity {

    Button b_rock, b_scissors, b_paper;
    TextView score;
    ImageView ComputerChoice, HumanChoice;

    int HumanScore, ComputerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);
        b_rock = (Button) findViewById(R.id.b_rock);

        ComputerChoice = (ImageView) findViewById(R.id.ComputerChoice);
        HumanChoice = (ImageView) findViewById(R.id.HumanChoice);

        score = (TextView) findViewById(R.id.score);


        //각각의 버튼 기능
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HumanChoice.setImageResource(R.drawable.paper); //버튼 클릭시 이미지 교체
                String message = play_turn("paper");
                Toast.makeText(RockPaperScissorsActivity.this,message,Toast.LENGTH_SHORT).show();
                score.setText("인간 : " + HumanScore + "  " +  "컴퓨터 : " + ComputerScore); //가위바위보 대결 결과 출력
            }
        });

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HumanChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(RockPaperScissorsActivity.this,message,Toast.LENGTH_SHORT).show();
                score.setText("인간 : " + HumanScore + "  " +  "컴퓨터 : " + ComputerScore);
            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HumanChoice.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(RockPaperScissorsActivity.this,message,Toast.LENGTH_SHORT).show();
                score.setText("인간 : " + HumanScore + "  " +  "컴퓨터 : " + ComputerScore);
            }
        });
    }

    //컴퓨터가 랜덤으로 가위바위보를 할 수 있게 해주는 코드
    public String play_turn(String player_choice){
        String computer_choice = "";
        Random r = new Random();

        int computer_choice_number = r.nextInt(3); //3까지 랜덤 숫자 생성

        if(computer_choice_number == 0){
            computer_choice = "rock";
        }
        else if(computer_choice_number == 1){
            computer_choice = "scissors";
        }
        else if(computer_choice_number == 2){
            computer_choice = "paper";
        }

        //computer_choice의 문자열을 받아와서 ComputerChoice의 이미지를 바꿔주는 부분
        if(computer_choice == "rock"){
            ComputerChoice.setImageResource(R.drawable.rock);
        }
        else if(computer_choice == "scissors"){
            ComputerChoice.setImageResource(R.drawable.scissors);
        }
        else if(computer_choice == "paper"){
            ComputerChoice.setImageResource(R.drawable.paper);
        }

        // 인간과 컴퓨터의 가위바위보 대결 결과를 알려주는 toast 출력 메세지
        if(computer_choice == player_choice){
            return "아무도 이기지 못했어요!";
        }
        else if(player_choice == "rock" &&  computer_choice == "scissors"){
            HumanScore++;
            return "주먹이 가위를 무찔렀어요! 당신이 이겼어요!";
        }
        else if(player_choice == "rock" && computer_choice == "paper"){
            ComputerScore++;
            return "보자기가 바위를 덮었어요! 컴퓨터 승!";
        }
        else if(player_choice == "scissors" && computer_choice == "rock"){
            ComputerScore++;
            return "주먹이 가위를 무찔렀어요! 컴퓨터 승!";
        }
        else if(player_choice == "scissors" && computer_choice == "paper"){
            HumanScore++;
            return "가위가 보자기를 잘랐어요! 당신이 이겼어요!";
        }
        else if(player_choice == "paper" && computer_choice == "rock"){
            HumanScore++;
            return "보자기가 바위를 덮었어요! 당신이 이겼어요!";
        }
        else if(player_choice == "paper" && computer_choice == "scissors"){
            ComputerScore++;
            return "가위가 보자기를 잘랐어요! 컴퓨터 승!";
        }
        else{
            return "확실하지 않아요!";
        }

    }
}
