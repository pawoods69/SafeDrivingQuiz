package com.example.android.safedrivingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.example.android.safedrivingquiz.R.id.checkBox1;
import static com.example.android.safedrivingquiz.R.id.checkBox2;
import static com.example.android.safedrivingquiz.R.id.checkBox4;
import static com.example.android.safedrivingquiz.R.id.radioButton1;
import static com.example.android.safedrivingquiz.R.id.button2;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    String  answerFour;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    private CompoundButton.OnCheckedChangeListener chkCheckedListner;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize the CheckBoxes

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        EditText question4 = (EditText) findViewById(R.id.message1);
        answerFour = question4.getText().toString();

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked question 1
        switch (view.getId()) {
            case radioButton1:
                if (checked)
                    // Safety Answer
                    break;
            case R.id.radioButton2:
                if (checked)
                    // Quality Answer
                    break;
            case R.id.radioButton3:
                if (checked)
                    // Customer Service Answer
                    break;
            case R.id.radioButton4:
                if (checked)
                    // Metrics Answer
                    break;
        }

        // Check which radio button was clicked question 2
        switch (view.getId()) {
            case R.id.button1:
                if (checked)
                    // Your Supervisor Answer
                    break;
            case R.id.button2:
                if (checked)
                    // Me Answer
                    break;
            case R.id.button3:
                if (checked)
                    // Your Family Service Answer
                    break;
            case R.id.button4:
                if (checked)
                    // Your Safety Coordinator Answer
                    break;
        }
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked question 3
        switch (view.getId()) {
            case R.id.checkBox1:
                if (checked)
                    // Avoid Accidents Answer
                    break;
            case R.id.checkBox2:
                if (checked)
                    // Avoid Construction Answer
                    break;
            case R.id.checkBox3:
                if (checked)
                    // Avoid Right Turns  Answer
                    break;
            case R.id.checkBox4:
                if (checked)
                    // Avoid Left Turns Answer
                    break;
        }

    }



    private int calculateScore(boolean radioButton1, boolean button2, boolean checkBox1, boolean checkBox2, boolean checkBox3, boolean checkBox4, String answerFour) {

        score = 100;

        if (radioButton1) {


        } else {

            score = score - 100 / 7;
        }

        if (button2) {


        } else {

            score = score - 100 / 7;
        }


        if (checkBox1) {

        } else {

            score = score - 100 / 7;
        }
        if (checkBox2) {

        } else {

            score = score - 100 / 7;
        }
        if (checkBox3) {
            score = score - 100 / 7;

        } else {

        }
        if (checkBox4) {

        } else {

            score = score - 100 / 7;
        }


        if (answerFour.equalsIgnoreCase("Circle of Safety")) {


        } else {
            score = score - 100 / 7;


        }

        return score;

    }


    public void submitScore(View view) {
        RadioButton answerOne = (RadioButton) findViewById(R.id.radioButton1);
        boolean correctAnswerOne = answerOne.isChecked();

        RadioButton answerTwo = (RadioButton) findViewById(R.id.button2);
        boolean correctAnswerTwo = answerTwo.isChecked();

        CheckBox answerThreeA = (CheckBox) findViewById(R.id.checkBox1);
        Log.d("TAG", String.valueOf(answerThreeA));
        boolean correctAnswerThreeA = answerThreeA.isChecked();
        Log.d("TAG", String.valueOf(correctAnswerThreeA));


        CheckBox answerThreeB = (CheckBox) findViewById(R.id.checkBox2);
        boolean correctAnswerThreeB = answerThreeB.isChecked();

        CheckBox answerThreeD = (CheckBox) findViewById(R.id.checkBox4);
        boolean correctAnswerThreeD = answerThreeD.isChecked();

        CheckBox answerThreeC = (CheckBox) findViewById(R.id.checkBox3);
        boolean incorrectAnswerThreeC = answerThreeC.isChecked();

        EditText question4 = (EditText) findViewById(R.id.message1);
        answerFour = question4.getText().toString();




        int finalScore = calculateScore(correctAnswerOne, correctAnswerTwo,
                correctAnswerThreeA, correctAnswerThreeB, incorrectAnswerThreeC,
                correctAnswerThreeD, answerFour);

        Toast.makeText(this, "Remember. You have people counting on you! You have a score of " + finalScore + " out of " +
                "100", Toast.LENGTH_LONG).show();
    }

}

