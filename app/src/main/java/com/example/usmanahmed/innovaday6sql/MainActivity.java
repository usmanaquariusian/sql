package com.example.usmanahmed.innovaday6sql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button signup,getuser,signin;
    EditText id,username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup=(Button) findViewById(R.id.btn1);
        getuser=(Button) findViewById(R.id.btn2);
        signin=(Button) findViewById(R.id.btn3);
        id=(EditText)findViewById(R.id.editText3);
        username=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText4);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strid,struser,strpass;
                strid=id.getText().toString();
                struser=username.getText().toString();
                strpass=password.getText().toString();

                int IdinInteger=Integer.parseInt(strid);
                DatabaseClass databaseObject=new DatabaseClass(MainActivity.this);
                long result= databaseObject.insertData(IdinInteger,struser,strpass);
                if (result>0)
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_SHORT).show();
            }
        });
        getuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //read data from database
                DatabaseClass object=new DatabaseClass(MainActivity.this);
                String alldata=object.getAllUserData();
                Toast.makeText(MainActivity.this, " "+alldata, Toast.LENGTH_LONG).show();
                //object.getAllUserData();
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),signInActivity.class));
            }
        });
    }
}
