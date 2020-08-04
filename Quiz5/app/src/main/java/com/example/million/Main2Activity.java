package com.example.million;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.million.R.*;
import static com.example.million.R.drawable.*;

public class Main2Activity extends MainActivity {
    int n=0;
    private int i=-1;
    private TextView  mQuestion;

    private Button mTrueButton, mFalseButton;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
private int degree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main2);



        mQuestion = (TextView)findViewById(id.text1);
        mTrueButton = (Button)findViewById(id.trueButton);
        mFalseButton = (Button)findViewById(id.falseButton);
        updateQuestion();


    }
    public void background(final Button b){
        b.setBackgroundResource(p7);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                b.setBackgroundResource(p3);
            }
        }, 100);
    }
    public void background2(final Button b){
        b.setBackgroundResource(p8);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                b.setBackgroundResource(p3);
            }
        }, 100);
    }

    public void onClick2(View v) {

        Button b = (Button)v;
        String S= b.getText().toString();

        if(Source.answer2[mQuestionNumber-1].equalsIgnoreCase(S)) {
           background(b);
            degree +=10;



            if (mQuestionNumber == Source.questions2.length) {
                Intent myIntent = new Intent(Main2Activity.this, Activity3.class);
                Bundle extras = new Bundle();
                extras.putInt("intVariableName", degree );
                myIntent.putExtras(extras);

                Main2Activity.this.finish();
                startActivity(myIntent);







            }

            else {
                updateQuestion();
            }
        }
        else {

            background2(b);
            if (mQuestionNumber == Source.questions2.length) {
                Intent myIntent = new Intent(Main2Activity.this, Activity3.class);
                Bundle extras = new Bundle();
                extras.putInt("intVariableName", degree );
                myIntent.putExtras(extras);

                Main2Activity.this.finish();
                startActivity(myIntent);
            } else {
                updateQuestion();
            }
        }
    }







    private void updateQuestion() {


        mQuestion.setText(Source.questions2[mQuestionNumber]);
        mAnswer = Source.answer2[mQuestionNumber];
        mQuestionNumber++;

    }







    public void clickExit(View view)
    {
        askToClose();
    }


    @Override
    public void onBackPressed() {

        askToClose();
    }

    private void askToClose (){
        AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
        builder.setMessage("Are you sure you want to quit?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
