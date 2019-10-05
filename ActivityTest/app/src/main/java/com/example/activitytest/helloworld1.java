package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class helloworld1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("helloworld1","Task id is "+getTaskId());
        setContentView(R.layout.first_layout);
        Button button1=(Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(helloworld1.this,helloworld2.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("helloworld1","onRestart");
    }
}
