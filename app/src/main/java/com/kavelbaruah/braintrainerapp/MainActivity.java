package com.kavelbaruah.braintrainerapp;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timerView, questionView, answerCounter,resultView,viewResult;
    LinearLayout linearLayout,resultLayout;
    GridLayout gridLayout;
    Button option1,option2,option3,option4,goButton,playAginButton;
    int answer;
    int ansCount=0;
    int qCount = 0;
    int[] options = new int[4];

    public void generateQuestion(){

        Random random = new Random();
        int x = random.nextInt(20) + 1;
        int y = random.nextInt(20) + 1;
        answer = x + y;
        questionView.setText(String.valueOf(x) + " + " + String.valueOf(y));
        qCount++;
    }
    public void startTimer(){

        new CountDownTimer(30250, 1000){

            @Override
            public void onTick(long millisUntilFinished) {

                if ((millisUntilFinished / 1000) <= 9) {

                    timerView.setText("0:0" + millisUntilFinished / 1000);
                } else {

                    timerView.setText("0:" + millisUntilFinished / 1000);
                }
            }

            @Override
            public void onFinish() {

                timerView.setText("0:00");
                viewResult.setText("You have answered " + ansCount + " questions correctly from " + (qCount-1) + " questions. ");
                linearLayout.setVisibility(View.INVISIBLE);
                gridLayout.setVisibility(View.INVISIBLE);
                resultLayout.setVisibility(View.VISIBLE);
                resultView.setVisibility(View.INVISIBLE);
            }
        }.start();

    }
    public void setOptions(){

        Random random = new Random();
        int x = random.nextInt(3);
        options[x] = answer;
        for(int i = 0; i<4; i++){

            if(i != x){

                options[i] = random.nextInt((answer + 10)) + (answer - 10);
            }
        }

        option1.setText(Integer.toString(options[0]));
        option2.setText(Integer.toString(options[1]));
        option3.setText(Integer.toString(options[2]));
        option4.setText(Integer.toString(options[3]));

    }
    public void setAnswerCounter(){

        answerCounter.setText(Integer.toString(ansCount) + "/" + Integer.toString(qCount-1));
    }
    public void onClick(View view){

        String checkanswer = String.valueOf(view.getTag());
        if(checkanswer == String.valueOf(option1.getTag())){
                if(options[0] == answer){
                    resultView.setText("Correct!");
                    ansCount++;
                    resultView.setVisibility(View.VISIBLE);
                }
                else {
                    resultView.setText("Wrong!");
                    resultView.setVisibility(View.VISIBLE);
                }
        }
        else if(checkanswer == String.valueOf(option2.getTag())){
            if(options[1] == answer){
                resultView.setText("Correct!");
                ansCount++;
                resultView.setVisibility(View.VISIBLE);
            }
            else {
                resultView.setText("Wrong!");
                resultView.setVisibility(View.VISIBLE);
            }

        }
        else if(checkanswer == String.valueOf(option3.getTag())){
            if(options[2] == answer){
                resultView.setText("Correct!");
                ansCount++;
                resultView.setVisibility(View.VISIBLE);
            }
            else {
                resultView.setText("Wrong!");
                resultView.setVisibility(View.VISIBLE);
            }
        }
        else if(checkanswer == String.valueOf(option4.getTag())){
            if(options[3] == answer){
                resultView.setText("Correct!");
                ansCount++;
                resultView.setVisibility(View.VISIBLE);
            }
            else {
                resultView.setText("Wrong!");
                resultView.setVisibility(View.VISIBLE);
            }
        }
        generateQuestion();
        setOptions();
        setAnswerCounter();
    }
    public void gameStart(View view){

        goButton.setVisibility(View.INVISIBLE);
        linearLayout.setVisibility(View.VISIBLE);
        gridLayout.setVisibility(View.VISIBLE);
        answerCounter.setText("0/0");
        generateQuestion();
        setOptions();
        startTimer();



    }
    public void continue_game(View view){

        resultLayout.setVisibility(View.INVISIBLE);
        playAginButton.setVisibility(View.VISIBLE);
    }
    public void gameEnd(View view){

        recreate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerView = (TextView)findViewById(R.id.TimerView);
        questionView = (TextView)findViewById(R.id.questionView);
        answerCounter = (TextView)findViewById(R.id.AnswerCounter);
        resultView = (TextView)findViewById(R.id.Result);
        viewResult = (TextView)findViewById(R.id.viewResult);
        linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
        resultLayout = (LinearLayout)findViewById(R.id.resultlayout);
        gridLayout = (GridLayout)findViewById(R.id.gridLayout);
        option1 = (Button)findViewById(R.id.option_1);
        option2 = (Button)findViewById(R.id.option_2);
        option3 = (Button)findViewById(R.id.option_3);
        option4 = (Button)findViewById(R.id.option_4);
        goButton = (Button)findViewById(R.id.goButton);
        playAginButton = (Button)findViewById(R.id.playAgain);



    }
}
