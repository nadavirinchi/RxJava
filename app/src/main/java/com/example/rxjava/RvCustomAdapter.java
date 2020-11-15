package com.example.rxjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvCustomAdapter extends RecyclerView.Adapter<RvCustomAdapter.MyViewHolder> {

    private final List<Entry> entries = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(myView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.txtname.setText(stringvalues.get(position));
        Entry entry = entries.get(position);
        holder.setTxtname(entry.getEntryName());
        holder.setTxtprice(entry.getEntryPrice());
        holder.setTxtdate(entry.getEntryDate());
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }
    public void addentrytoList(Entry entry){
        entries.add(entry);
        notifyItemInserted(entries.size()-1);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.txtname)
        TextView txtname;
        @BindView(R.id.txtprice)
        TextView txtprice;
        @BindView(R.id.txtdate)
        TextView txtdate;

        private final NumberFormat Entry_Price_Format = new DecimalFormat("$#0.00");


        public void setTxtname(String entername) {
            this.txtname.setText(entername);
        }

        public void setTxtprice(BigDecimal enterprice) {
            this.txtprice.setText(Entry_Price_Format.format(enterprice.doubleValue()));
        }

        public void setTxtdate(Date enterdate) {
            this.txtdate.setText(android.text.format.DateFormat.format("yyyy-mm-dd hh:mm",enterdate));
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }


    }
}
