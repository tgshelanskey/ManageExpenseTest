package com.example.jasper.manageexpense;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Techsoft-003 on 3/30/2017.
 */

public class Graph_all_Adapter extends BaseAdapter {
    Context context;
    private List<Graph_all_List> lists;


    public Graph_all_Adapter (Context context, List<Graph_all_List> lists){
        this.context = context;
        this.lists = lists;

    }


    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lists.get(position).getId();
    }

    @Override
    public View getView(final int position, View itemView, ViewGroup parent) {

        View view = View.inflate(context, R.layout.piegraph_list, null);

        TextView txtName = (TextView)view.findViewById(R.id.piegraph_name);
        TextView txtAmount = (TextView) view.findViewById(R.id.piegraph_amount);
        TextView txtPercent = (TextView) view.findViewById(R.id.piegraph_percent);

        txtName.setText(lists.get(position).getName());
        txtAmount.setText(String.valueOf(lists.get(position).getAmount()));

        //Shelanskey - Fix percentage calculation
        if(!txtAmount.toString().equals("")){

            DecimalFormat precision = new DecimalFormat("0.00");
            double amount = Double.parseDouble(txtAmount.getText().toString());
            double res = (amount  / getTotalExpense()) * 100;
            txtPercent.setText(precision.format(res)+"%");
        }else {

        }

        return view;
    }

    private double getTotalExpense() {
        double total = 0;
        for (Graph_all_List list : lists) {
            total += list.getAmount();
        }
        return total;
    }


}
