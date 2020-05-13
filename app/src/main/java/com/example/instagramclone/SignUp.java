package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class SignUp extends AppCompatActivity {

    private EditText name,power,punch_speed,kick_speed;
    private TextView data;
    private Button all_data,next;
    private String alldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        all_data=findViewById(R.id.alldata);
        data=findViewById(R.id.data);
        name=findViewById(R.id.name);
        power=findViewById(R.id.power);
        punch_speed=findViewById(R.id.punch_speed);
        kick_speed=findViewById(R.id.kick_speed);
        next=findViewById(R.id.next);

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> parse=ParseQuery.getQuery("KickBoxer");
                parse.getInBackground("vc0gNA4hXo", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {

                        if(object!=null&&e==null)
                        {
                            data.setText(object.get("name")+"");
                        }

                    }
                });
            }
        });

        all_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alldata="";
                ParseQuery<ParseObject> all=ParseQuery.getQuery("KickBoxer");
                all.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {

                        if(e==null)
                        {
                            if(objects.size()>0)
                            {
                                for(ParseObject i:objects)
                                {
                                    alldata=alldata+i.get("name")+"\n";
                                }
                                FancyToast.makeText(SignUp.this,alldata,FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                            }
                            else
                                FancyToast.makeText(SignUp.this,"oops",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                        }

                    }
                });
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SignUp.this,Signuploginactivity.class);
                startActivity(intent);
            }
        });

    }

}
