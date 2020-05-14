package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Loginactivity extends AppCompatActivity {

    private EditText logid,logpass;
    private Button login,signup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        logid=findViewById(R.id.logid);
        logpass=findViewById(R.id.logpass);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(Loginactivity.this,SignUp.class);
                startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser .logInInBackground(logid.getText().toString(), logpass.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if(user!=null&&e==null) {
                            FancyToast.makeText(Loginactivity.this, user.get("username") + " is logged in successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                            Intent intent =new Intent(Loginactivity.this,Welcome.class);
                            startActivity(intent);
                        }
                        else
                        FancyToast.makeText(Loginactivity.this,"Invalid UserId/Password",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();


                    }
                });

            }
        });
    }
}
