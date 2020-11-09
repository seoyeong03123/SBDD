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
    TextView tv_score;
    ImageView iv_ComputerChoice, iv_HumanChoice;

    int HumanScore, ComputerScore = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);
        b_rock = (Button) findViewById(R.id.b_rock);

        iv_ComputerChoice = (ImageView) findViewById(R.id.iv_ComputerChoice);
        iv_HumanChoice = (ImageView) findViewById(R.id.iv_HumanChoice);

        tv_score = (TextView) findViewById(R.id.tv_score);

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_HumanChoice.setImageResource(R.drawable.paper);

            }
        });

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_HumanChoice.setImageResource(R.drawable.rock);
                play_turn("rock");
            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_HumanChoice.setImageResource(R.drawable.scissors);
                play_turn("scissors");
            }
        });
    }

    public void play_turn(String player_choice){
        String computer_choice = "";
        Random r = new Random();

        int computer_choice_number = r.nextInt(3) + 1;

        if(computer_choice_number == 1){
            computer_choice = "rock";
        }
        else if(computer_choice_number == 2){
            computer_choice = "scissors";
        }
        else if(computer_choice_number == 3){
            computer_choice = "paper";
        }

        if(computer_choice == "rock"){
            iv_ComputerChoice.setImageResource(R.drawable.rock);
        }
        else if(computer_choice == "scissors"){
            iv_ComputerChoice.setImageResource(R.drawable.scissors);
        }
        else if(computer_choice == "paper"){
            iv_ComputerChoice.setImageResource(R.drawable.paper);
        }

        if(computer_choice == player_choice){
            System.out.println("Draw.  Nobody won..");
        }
        else if(player_choice == "rock" &&  computer_choice == "scissors"){
            HumanScore++;
            System.out.println("Rock crushes scissors. You win!!");
        }
        else if(player_choice == "rock" && computer_choice == "paper"){
            ComputerScore++;
            System.out.println("Paper covers rock. Computer wins!!");
        }
        else if(player_choice == "scissors" && computer_choice == "rock"){
            ComputerScore++;
            System.out.println("Rock crushes scissors. Computer wins!");
        }
        else if(player_choice == "scissors" && computer_choice == "paper"){
            HumanScore++;
            System.out.println("Scissors cuts paper. You win!");
        }
        else if(player_choice == "paper" && computer_choice == "rock"){
            HumanScore++;
            System.out.println("Paper covers rock. You win!");
        }
        else if(player_choice == "paper" && computer_choice == "scissors"){
            ComputerScore++;
            System.out.println("Scissors cuts paper. Computer wins!");
        }
        else{
            System.out.println("Not sure");
        }

    }
}

