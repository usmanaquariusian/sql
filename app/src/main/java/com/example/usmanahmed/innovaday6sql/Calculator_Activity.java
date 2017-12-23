package com.example.usmanahmed.innovaday6sql;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator_Activity extends Activity {

    Button one,two,three,four,five,six,equal,plus,mult,sub,ac,c;
    EditText screen;
    TextView text;
    String first,second,ans,op;
    int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_);

        one= (Button) findViewById(R.id.button1);
        two= (Button) findViewById(R.id.button2);
        three= (Button) findViewById(R.id.button3);
        four= (Button) findViewById(R.id.button4);
        five= (Button) findViewById(R.id.button5);
        six= (Button) findViewById(R.id.button6);
        equal= (Button) findViewById(R.id.button7);
        sub= (Button) findViewById(R.id.button10);
        mult= (Button) findViewById(R.id.button9);
        plus= (Button) findViewById(R.id.button8);
        ac= (Button) findViewById(R.id.button11);
        c= (Button) findViewById(R.id.button12);

        screen=(EditText) findViewById(R.id.text);
        text=(TextView) findViewById(R.id.text2);



        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String existingtext=screen.getText().toString();
                screen.setText(existingtext+"1");


            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String existingtext=screen.getText().toString();
                screen.setText(existingtext+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String existingtext=screen.getText().toString();
                screen.setText(existingtext+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String existingtext=screen.getText().toString();
                screen.setText(existingtext+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String existingtext=screen.getText().toString();
                screen.setText(existingtext+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String existingtext=screen.getText().toString();
                screen.setText(existingtext+"6");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=screen.getText().toString();
                screen.setText("");
                op="+";
                text.setText(first+"+");

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=screen.getText().toString();
                screen.setText("");
                op="-";
                text.setText(first+"-");


            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=screen.getText().toString();
                screen.setText("");
                op="*";
                text.setText(first+"*");

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                second=screen.getText().toString();
                if(op.equalsIgnoreCase("+"))
                {
                    int f,s;
                    f= Integer.parseInt(first);
                    s=Integer.parseInt(second);
                    int sum=f+s;
                    screen.setText(first+"+"+second+"="+""+sum);
                    text.setText("");
                }
                else if (op.equalsIgnoreCase("-"))
                {
                    int f,s;
                    f= Integer.parseInt(first);
                    s=Integer.parseInt(second);
                    int sub=f-s;
                    screen.setText(first+"-"+second+""+"="+sub);
                    text.setText("");
                }
                else if (op.equalsIgnoreCase("*"))
                {
                    int f,s;
                    f= Integer.parseInt(first);
                    s=Integer.parseInt(second);
                    int mult=f*s;
                    screen.setText(first+"*"+second+""+"="+mult);
                    text.setText("");
                }
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                text.setText("");
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                length=screen.getText().length();
                screen.getText().delete(length-1,length);
            }
        });





    }
}
