package com.example.ishanpant.skilllearn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ishanpant.skilllearn.model.DataHelper;
import com.example.ishanpant.skilllearn.model.Position;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private ArrayList<DataHelper> dataHelperList;
    private Context context;
    private String longitude;
    DataHelper dataHelper;

    public DataAdapter(Context context , ArrayList<DataHelper> dataHelperList) {
        this.context = context;
        this.dataHelperList = dataHelperList;
    }

    public void setData(ArrayList<DataHelper> list) {
        dataHelperList = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.singlerow, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        dataHelper = dataHelperList.get(position);
        holder.text1.setText(dataHelper.getCityname());
        holder.text2.setText(String.valueOf(dataHelper.getPosition().getLongitde()));
        holder.text3.setText(String.valueOf(dataHelper.getPosition().getLatitude()));
    }

    @Override
    public int getItemCount() {
        return dataHelperList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView text1;
        private TextView text2,text3;

        public MyViewHolder(View itemView) {
            super(itemView);
            text1 = (TextView) itemView.findViewById(R.id.text1);
            text2 = (TextView) itemView.findViewById(R.id.text2);
            text3 = (TextView) itemView.findViewById(R.id.text3);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,MapsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putFloat("longitude",dataHelper.getPosition().getLongitde());
                    bundle.putFloat("latitude",dataHelper.getPosition().getLatitude());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }
}
