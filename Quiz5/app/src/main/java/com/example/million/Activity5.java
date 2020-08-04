package com.example.million;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity5 extends Activity4 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);



        Bundle extras1 = getIntent().getExtras();
       int result=extras1.getInt("Result");
            displayQuantity(result);
            if(result>=60){
                String message="\n Congratulations!";
                String message1="\n";
                message1+=" You have passed and got "+"\n";
                String message3=result+"/125";
                displayMessage(message);
                displayMessage2(message1);
                displayMessage3(message3);
            }
            else{
                String message="\n Sorry!";
                String message1="\n";message1+=" You have failed ,Your degree is "+"\n";
                String message3=result+"/125";
                displayMessage(message);
                displayMessage2(message1);
                displayMessage3(message3);

            }
        }



    private void displayQuantity(int number){

        TextView quantityTextView = (TextView) findViewById(R.id.grade);
        quantityTextView.setText(""+number);

    }
    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.grade);
        orderSummaryTextView.setText(message);
    }
    private void displayMessage2(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.textView);
        orderSummaryTextView.setText(message);
    }
    private void displayMessage3(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.textView2);
        orderSummaryTextView.setText(message);
    }


}
