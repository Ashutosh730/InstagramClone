package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity {

    //components;
    private EditText signid,signpass,email;
    private Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ids
        signid=findViewById(R.id.signid);
        signpass=findViewById(R.id.signpass);
        email=findViewById(R.id.email);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent =new Intent(SignUp.this,Loginactivity.class);
                        startActivity(intent);
                    }
                });

                final ParseUser user=new ParseUser();
                user.setEmail(email.getText().toString());
                user.setUsername(signid.getText().toString());
                user.setPassword(signpass.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {

                        if(e==null&&user!=null)
                        {
                            Intent intent=new Intent(SignUp.this,Welcome.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(SignUp.this, e.getMessage()+" Oops Try Again", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

    }

}
