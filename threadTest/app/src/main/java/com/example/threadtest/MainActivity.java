package com.example.threadtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int UPDATE_TEXT=1;
    private TextView text;
    private Timer timer;

    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:
                    int count=0;
                    count++;
                    text.setText("次数："+count);
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text);
        Button changeText=(Button)findViewById(R.id.change_text);
        changeText.setOnClickListener(this);
        timer=new Timer();
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.change_text:
                TimerTask timerTask=new TimerTask() {
                    @Override
                    public void run() {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Message message=new Message();
                                message.what=UPDATE_TEXT;
                                handler.sendMessage(message);
                            }
                        }).start();
                    }
                };
                timer.schedule(timerTask,1000);
                break;
            default:
                break;
        }
    }
}
