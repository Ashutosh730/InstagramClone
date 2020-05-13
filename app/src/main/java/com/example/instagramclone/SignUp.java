package com.example.instagramclone;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity {

    private EditText name,power,punch_speed,kick_speed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        power=findViewById(R.id.power);
        punch_speed=findViewById(R.id.punch_speed);
        kick_speed=findViewById(R.id.kick_speed);

    }

    public void tapped(View v)
    {
        ParseObject kickboxer=new ParseObject("KickBoxer");
        kickboxer.put("name",name.getText().toString());
        kickboxer.put("punch_speed",Integer.parseInt(punch_speed.getText().toString()));
        kickboxer.put("kick_speed",Integer.parseInt(kick_speed.getText().toString()));
        kickboxer.put("power",Integer.parseInt(power.getText().toString()));
        kickboxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

                if(e==null)
                {
                    FancyToast.makeText(SignUp.this,"Ur data is saved",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                }
                else
                    FancyToast.makeText(SignUp.this,"Oops not saved,Try again",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
            }
        });
    }
}
