package com.example.million;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends Main2Activity {
    int n=0;
    private int i=-1;
    private TextView mScoreView, mQuestion;

    private Button mTrueButton, mFalseButton;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
private int degree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Button button1=(Button)findViewById(R.id.Button);
        Button button2=(Button)findViewById(R.id.Button1);
        Button button3=(Button)findViewById(R.id.Button2);
        Button button4=(Button)findViewById(R.id.Button3);


        mQuestion = (TextView)findViewById(R.id.question);
        updateQuestion();

    }
    private void updateButtons(){
        Button button1=(Button)findViewById(R.id.Button);

        Button button2=(Button)findViewById(R.id.Button1);
        Button button3=(Button)findViewById(R.id.Button2);
        Button button4=(Button)findViewById(R.id.Button3);
        i+=1;
        button1.setText(Source.buttonNames[i]);
        i+=1;
        button2.setText(Source.buttonNames[i]);
        i+=1;
        button3.setText(Source.buttonNames[i]);
        i+=1;
        button4.setText(Source.buttonNames[i]);
    }

    @Override
    public void onClick2(View v) {



        Bundle extras1 = getIntent().getExtras();
        // Intent mIntent = getIntent();
        int degree1 = extras1.getInt("intVariableName", 0);

            Button b = (Button) v;
            String S = b.getText().toString();

            if (Source.answer3[mQuestionNumber - 1].equalsIgnoreCase(S)) {

                background(b);
                degree += 15;


                //perform check before you update the question
                if (mQuestionNumber == Source.questions3.length) {
                    Intent myIntent = new Intent(Activity3.this, Activity4.class);
                    Bundle extras = new Bundle();

                    extras.putInt("intVariableName", degree1 );
                    extras.putInt("intVariableName2", degree );
                    myIntent.putExtras(extras);


                    Activity3.this.finish();
                    startActivity(myIntent);
                } else {
                    updateQuestion();
                }
            } else {

                background2(b);
                if (mQuestionNumber == Source.questions3.length) {
                    Intent myIntent = new Intent(Activity3.this, Activity4.class);
                    Bundle extras = new Bundle();

                    extras.putInt("intVariableName", degree1 );
                    extras.putInt("intVariableName2", degree );
                    myIntent.putExtras(extras);


                    Activity3.this.finish();
                    startActivity(myIntent);
                } else {
                    updateQuestion();
                }
            }
        }



    //overriding
    private void updateQuestion() {
        updateButtons();

        mQuestion.setText(Source.questions3[mQuestionNumber]);
        mAnswer = Source.answer3[mQuestionNumber];
        mQuestionNumber++;

    }


}
