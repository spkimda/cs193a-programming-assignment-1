package com.example.simon.homework1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class guessNumber extends AppCompatActivity {

    private int answer;
    private int tries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_number);

        // Personal initialization process
        initialize();
    }

    private void initialize() {
        generateRandomNumber();
        clearField();
        buttonReset();
    }

    private void buttonReset() {
        Button guessBtn = (Button) findViewById(R.id.guessBtn);
        guessBtn.setClickable(true);
        guessBtn.setTextColor(Color.BLACK);
        guessBtn.setText("GUESS");
    }

    private void generateRandomNumber() {
        Random rand = new Random();
        answer = rand.nextInt(1000);
    }

    private void clearField() {
        TextView hint = (TextView) findViewById(R.id.hintText);
        hint.setText("Take a guess!");
    }

    public void takeGuess(View view) {
        EditText guess = (EditText) findViewById(R.id.answerText);
        TextView hint = (TextView) findViewById(R.id.hintText);
        tries++;

        int guessedNumber = Integer.valueOf(guess.getText().toString());
        guess.setText("");

        if (guessedNumber == answer) {
            hint.setText("Congratulations! The answer was " + answer);
            Button guessBtn = (Button) findViewById(R.id.guessBtn);
            guessBtn.setClickable(false);
            guessBtn.setText("FOUND");

        } else if (guessedNumber > answer) {
            hint.setText("Lower than guessed");
        } else {
            hint.setText("Higher than guessed");
        }
    }

    public void resetGuess(View view) {
        initialize();
    }
}
