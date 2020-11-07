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

    Button rock_b, scissors_b, paper_b;
    TextView score;
    ImageView paper,rock;

    int humanScore, computerScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        paper_b = (Button) findViewById(R.id.paper_b);
        scissors_b = (Button) findViewById(R.id.scissors_b);
        rock_b = (Button) findViewById(R.id.rock_b);

        rock = (ImageView) findViewById(R.id.rock);
        paper = (ImageView) findViewById(R.id.paper);

        score = (TextView) findViewById(R.id.score);

        paper_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                rock.setImageResource(R.drawable.pa);
                play_turn("paper");

            }
        });

        scissors_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                rock.setImageResource(R.drawable.s);
                play_turn("scissors");
            }
        });

        rock_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                rock.setImageResource(R.drawable.rock);
                play_turn("rock");
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
            rock.setImageResource(R.drawable.rock);
        }
        else if(computer_choice == "scissors"){
            rock.setImageResource(R.drawable.s);
        }
        else if(computer_choice == "paper"){
            rock.setImageResource(R.drawable.pa);
        }

        if(computer_choice == player_choice){
            System.out.println("Draw.   Nobody won.");
        }
        else if(player_choice == "rock" && computer_choice == "scissors"){
            humanScore++;
            System.out.println("Rock crushes scissors. You win!!");
        }
        else if(player_choice == "rock" && computer_choice == "paper"){
            computerScore++;
            System.out.println("paper covers scissors. Computer wins!");
        }
        else if(player_choice == "scissors" && computer_choice == "rock"){
            computerScore++;
            System.out.println("Rock crushes scissors. Computer wins!");
        }
        else if(player_choice == "scissors" && computer_choice == "paper"){
            humanScore++;
            System.out.println("Scissors cuts paper. You win!");
        }
        else if(player_choice == "paper" && computer_choice == "rock"){
            humanScore++;
            System.out.println("Paper covers rock. You win!");
        }
        else if(player_choice == "paper" && computer_choice == "scissors"){
            computerScore++;
            System.out.println("Scissors cuts paper. Computer wins!");
        }
        else System.out.println("Not sure");



    }

}