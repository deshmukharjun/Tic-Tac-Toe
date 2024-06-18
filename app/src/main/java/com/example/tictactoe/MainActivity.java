package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0 - x, 1 - o, 2 - null
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winPositions = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6} };

    boolean gameActive = true;

    public void playerTap(View view) {
        if (!gameActive) {
            return;
        }
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        if (gameState[tappedImage] == 2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            TextView status = findViewById(R.id.status);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                status.setText("O's Turn - Tap To Play!");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                status.setText("X's Turn - Tap To Play!");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        } else {
            TextView status = findViewById(R.id.status);
            status.setText("Invalid move! Try again.");
        }

        checkGameStatus();
    }

    private void checkGameStatus() {
        // Check for a win
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                gameActive = false;
                String winnerStr = gameState[winPosition[0]] == 0 ? "X has won!" : "O has won!";
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
                findViewById(R.id.restartButton).setVisibility(View.VISIBLE);
                return;
            }
        }

        // Check for a tie
        boolean tie = true;
        for (int state : gameState) {
            if (state == 2) {
                tie = false;
                break;
            }
        }
        if (tie) {
            gameActive = false;
            TextView status = findViewById(R.id.status);
            status.setText("Match Tied!");
            findViewById(R.id.restartButton).setVisibility(View.VISIBLE);
        }
    }

    public void restartGame(View view) {
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

        int[] imageViews = {R.id.imageView1, R.id.imageView2, R.id.imageView3,
                R.id.imageView4, R.id.imageView5, R.id.imageView6,
                R.id.imageView7, R.id.imageView8, R.id.imageView9};

        for (int id : imageViews) {
            ((ImageView)findViewById(id)).setImageResource(0);
        }

        TextView status = findViewById(R.id.status);
        status.setText("Welcome Back! Tap to play.");
        findViewById(R.id.restartButton).setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.restartButton).setVisibility(View.GONE);
    }
}