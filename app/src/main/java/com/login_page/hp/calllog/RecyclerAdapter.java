package com.login_page.hp.calllog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.RecyclerViewHolder>{

    ArrayList<callLog> calllog;
    Context mcontext;

    public RecyclerAdapter(ArrayList<callLog> calllog, Context applicationContext){
        this.calllog = calllog;
        this.mcontext = applicationContext;
    }
    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main,parent,false);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        callLog call_log = calllog.get(position);
        holder.tv1.setText(call_log.getPhoneNumber());
        holder.tv2.setText(call_log.getCall_type());
        holder.tv3.setText(call_log.getDuration());
        holder.tv4.setText(call_log.getDate());

    }

    @Override
    public int getItemCount() {
        return calllog.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv1,tv2,tv3,tv4;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.phone_number);
            tv2 = itemView.findViewById(R.id.call_type);
            tv3 = itemView.findViewById(R.id.duration);
            tv4 = itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Toast.makeText(mcontext,tv1.getText(), LENGTH_SHORT).show();

        }
    }
}
