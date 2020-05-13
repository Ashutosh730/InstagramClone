package com.example.instagramclone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Signuploginactivity extends AppCompatActivity {

    private EditText signid,signpass,logid,logpass;
    private Button login,signup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signuploginactivity);

        signid=findViewById(R.id.signid);
        signpass=findViewById(R.id.signpass);
        logid=findViewById(R.id.logid);
        logpass=findViewById(R.id.logpass);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ParseUser user=new ParseUser();
                user.setUsername(signid.getText().toString());
                user.setPassword(signpass.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {

                        if(e==null)
                        {
                            FancyToast.makeText(Signuploginactivity.this,user.get("username")+" is signed up successfully",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                        }
                        else
                        {
                            FancyToast.makeText(Signuploginactivity.this,"oops",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();

                        }
                    }
                });
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser .logInInBackground(logid.getText().toString(), logpass.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if(user!=null&&e==null)
                        FancyToast.makeText(Signuploginactivity.this,user.get("username")+" is logged in successfully",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                        else
                        FancyToast.makeText(Signuploginactivity.this,"oops",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();


                    }
                });

            }
        });
    }
}
