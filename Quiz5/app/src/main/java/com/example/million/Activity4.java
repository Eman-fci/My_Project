package com.example.million;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class Activity4 extends Activity3 {
    private int degree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);


    }

    public int multichoices(boolean haschecked1, boolean haschecked2, boolean haschecked3, boolean haschecked4) {

        if (haschecked1 & haschecked3) {
            degree = degree + 25;
        } else {
            degree = 0;
        }


        return degree;
    }

    public void goToA5(View view) {
        CheckBox checkBox1=(CheckBox)findViewById(R.id.checkBox1);
        CheckBox checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        CheckBox checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        CheckBox checkBox4=(CheckBox)findViewById(R.id.checkBox4);
        boolean haschecked1=checkBox1.isChecked();
        boolean haschecked2=checkBox2.isChecked();
        boolean haschecked3=checkBox3.isChecked();
        boolean haschecked4=checkBox4.isChecked();
        int degree3=multichoices(haschecked1,haschecked2,haschecked3,haschecked4);
        Bundle extras1 = getIntent().getExtras();

        // Intent mIntent = getIntent();
        int degree1 = extras1.getInt("intVariableName", 0);
        int degree2 = extras1.getInt("intVariableName2", 0);



        int result=degree1+degree2+degree3;
    Intent myIntent = new Intent(Activity4.this, Activity5.class);
    Bundle extras = new Bundle();

    extras.putInt("Result", result );

    myIntent.putExtras(extras);

Activity4.this.finish();
    startActivity(myIntent);



            }


}



