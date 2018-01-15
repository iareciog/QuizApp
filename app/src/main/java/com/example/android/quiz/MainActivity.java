package com.example.android.quiz;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        This function reset points to 0.
        Check all questions
     */
    public void submitQuiz(View view){
        points = 0;
        question1Check();
        question2Check();
        question3Check();
        question4Check();
        question5Check();
        calculatePoints();
        String result = resultText();
        TextView theResult = findViewById(R.id.result);
        theResult.setText(result);
    }

    /**
     *  This function create a return of a string
     *
     *  @return a string
     **/
    private String resultText(){
        String message;
        message = "Name: " + name() + "\n" + "Result: " + calculatePoints();
        return message;
    }

    /**
     *  Check username, if is empty, uses Anonymous as username
     **/
    private String name(){
        EditText name = findViewById(R.id.name);
        String userName = name.getText().toString();

        if(userName.isEmpty()){
            userName = "Anonymous";
        }

        return userName;
    }

    /**
     * This function give the result
     *
     * @return a string with the correct answers and the points
     **/
    private String calculatePoints(){
        String result = "";

        for(int i = 10; i >= 0; i--){
            if (points == i){
                result = i + "/10";
            }
        }
        return result;
    }

    //Check if answer from question 1 are correct
    private void question1Check(){
        RadioButton correctAnswer = findViewById(R.id.q1_answer_3);
        boolean answer_q1 = correctAnswer.isChecked();

        if(answer_q1){ points++; }

    }
    /**
     *   Check if answer from question 2 are correct
     **/
    private void question2Check(){
        RadioButton correctAnswer = findViewById(R.id.q2_answer_1);
        boolean answer_q2 = correctAnswer.isChecked();

        if (answer_q2) { points = points + 2; }
    }
    //Check if answer from question 3 are correct
    private void question3Check(){
        EditText textAnswer = findViewById(R.id.q3_answer);
        String answer_q3 = textAnswer.getText().toString();

        if (answer_q3.matches("String carColor;")){
            points = points + 2;
        } else if (answer_q3.matches("String carColor")){
            points++;
        }
    }
    /**
     *  Check if answer from question 4 are correct
     **/
    private void question4Check(){
        EditText textAnswer = findViewById(R.id.q4_answer);
        String answer_q4 = textAnswer.getText().toString();

        if (answer_q4.matches("int")){
            points = points + 2;
        }
    }
    /*
     *  Check if answers from question 5 are correct
     *
     *  If there any answer wrong, discount 2 points to the total points of the question
     */
    private void question5Check(){
        CheckBox correctAnswer1 = findViewById(R.id.q5_answer_1);
        CheckBox correctAnswer2 = findViewById(R.id.q5_answer_3);
        CheckBox correctAnswer3 = findViewById(R.id.q5_answer_4);
        CheckBox wrongAnswer = findViewById(R.id.q5_answer_2);

        boolean answer_q5_1 = correctAnswer1.isChecked();
        boolean answer_q5_2 = correctAnswer2.isChecked();
        boolean answer_q5_3 = correctAnswer3.isChecked();
        boolean answer_wrong = wrongAnswer.isChecked();

        if (answer_q5_1) { points++; }
        if (answer_q5_2) { points++; }
        if (answer_q5_3) { points++; }
        if (answer_wrong) { points = points - 2; }
    }
}
