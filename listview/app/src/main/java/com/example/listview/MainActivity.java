package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview.adapter.ListViewAdapter;
import com.example.listview.bean.fruitBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private ListView listView;
    private ListViewAdapter listViewAdapter;  //适配器
    private List<fruitBean> fruitBeanList=new ArrayList<fruitBean>();
    //private String[] data={"apple","banana"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mContext=this;

       // ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        //加载listView
        listView=(ListView)findViewById(R.id.listView);
        listViewAdapter=new ListViewAdapter(mContext,fruitBeanList);
        listView.setAdapter(listViewAdapter);

        //保存
        Button saveButton=(Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveFruitMessage();
            }
        });
    }
    private void saveFruitMessage(){
        EditText nameEditText=(EditText)findViewById(R.id.nameEditText);
        if(TextUtils.isEmpty(nameEditText.getText().toString())){
            Toast.makeText(mContext,"水果名称不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        for(fruitBean fruitBean:fruitBeanList){
            if(TextUtils.equals(fruitBean.getName(),nameEditText.getText().toString())){
                Toast.makeText(mContext,nameEditText.getText().toString()+"已经存在",Toast.LENGTH_SHORT).show();
                return;
            }
        }
        fruitBean fruitBean=new fruitBean(nameEditText.getText().toString());
        fruitBeanList.add(fruitBean);

        listViewAdapter.notifyDataSetChanged();
    }
}
