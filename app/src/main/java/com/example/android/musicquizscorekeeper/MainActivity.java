package com.example.android.musicquizscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreP1 = 0, scoreP2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displaying score for Player 1
     */
    public void displayScoreP1(int score){
        TextView scoreView = (TextView)findViewById(R.id.p1_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displaying score for Player 2
     */
    public void displayScoreP2(int score){
        TextView scoreView2 = (TextView)findViewById(R.id.p2_score);
        scoreView2.setText(String.valueOf(score));
    }

    public void addScoreForP1(View view){
        scoreP1 = scoreP1 + 1;
        displayScoreP1(scoreP1);
    }

    public void addScoreForP2(View view){
        scoreP2 = scoreP2 + 1;
        displayScoreP2(scoreP2);
    }

    public void minusScoreForP1(View view){
        TextView scoreView = (TextView)findViewById(R.id.p1_score);
        int valueScoreView = Integer.valueOf(scoreView.getText().toString());
        if ( valueScoreView == 0){
            displayScoreP1(0);
        }
        else{
            scoreP1 = scoreP1 - 1;
            displayScoreP1(scoreP1);
        }
    }

    public void minusScoreForP2(View view){
        TextView scoreView2 = (TextView)findViewById(R.id.p2_score);
        int valueScoreView2 = Integer.valueOf(scoreView2.getText().toString());
        if ( valueScoreView2 == 0){
            displayScoreP2(0);
        }
        else{
            scoreP2 = scoreP2 - 1;
            displayScoreP2(scoreP2);
        }
    }

    public void resetScore (View view){
        scoreP1 = 0;
        scoreP2 = 0;
        displayScoreP1(0);
        displayScoreP2(0);
    }

    public void finishGame (View view){
        TextView scoreView = (TextView)findViewById(R.id.p1_score);
        TextView scoreView2 = (TextView)findViewById(R.id.p2_score);
        TextView statusView = (TextView)findViewById(R.id.txtstatusP1);
        TextView statusView2 = (TextView)findViewById(R.id.txtstatusP2);
        int valueScoreView = Integer.valueOf(scoreView.getText().toString());
        int valueScoreView2 = Integer.valueOf(scoreView2.getText().toString());
        statusView.setVisibility(View.VISIBLE);
        statusView2.setVisibility(View.VISIBLE);
        if(valueScoreView > valueScoreView2){
            statusView.setText("Winner");
            statusView2.setText("Loser");
        }
        else if (valueScoreView < valueScoreView2){
            statusView.setText("Loser");
            statusView2.setText("Winner");
        }
        else{
            statusView.setText("Draw");
            statusView2.setText("Draw");
        }
    }
}
