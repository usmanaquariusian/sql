package com.example.usmanahmed.innovaday6sql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signInActivity extends Activity {
    EditText username,password;
    TextView warn;
    Button signin;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username=findViewById(R.id.editText2);
        password=findViewById(R.id.editText5);
        signin=findViewById(R.id.button2);
        signup=findViewById(R.id.textView);
        warn=findViewById(R.id.textView2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //the quick brown fox jumps over the lady dog
                Intent main=new Intent(getBaseContext(),MainActivity.class);
                startActivity(main);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strusername,strpassword;
                strusername=username.getText().toString();
                strpassword=password.getText().toString();


                DatabaseClass object=new DatabaseClass(signInActivity.this);
                boolean status= object.checkCredentials(strusername,strpassword);
                if (status)
                {
                    startActivity(new Intent(getBaseContext(),Calculator_Activity.class));

                    Toast.makeText(signInActivity.this, "Accessd", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    warn.setText("Username or password is invalid");
                }
            }
        });
        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                warn.setText("");
                username.setText("");
            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                warn.setText("");
                password.setText("");

            }
        });
    }
}
