package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class helloworld3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("helloworld3","Task id is "+getTaskId());
        setContentView(R.layout.third_layout);
        Button button3=(Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(helloworld3.this,helloworld1.class);
                startActivity(intent);
            }
        });
    }
}
