package com.example.listview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.listview.R;
import com.example.listview.bean.fruitBean;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<fruitBean> fruitBeanList;
    public ListViewAdapter(Context context,List<fruitBean> fruitBeanList){
        this.mContext=context;
        this.fruitBeanList=fruitBeanList;
    }

    @Override
    public int getCount(){
        return fruitBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view=null;
        if(convertView!=null){
            view=convertView;
        }
        else {
            view=View.inflate(mContext, R.layout.fruit_listview,null);
        }
        fruitBean fruitBean=fruitBeanList.get(position);
        if(fruitBean==null){
            fruitBean=new fruitBean("Noname");
        }
        final TextView nameTextView=(TextView)view.findViewById(R.id.showFruitName);
        nameTextView.setText(fruitBean.getName());
        final int removePosition=position;
        final Button deleteButton=(Button)view.findViewById(R.id.showDeleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteButtonAction(removePosition);
            }
        });
        return view;
    }
    private void deleteButtonAction(int position){
        fruitBeanList.remove(position);
        notifyDataSetChanged();
    }

}
