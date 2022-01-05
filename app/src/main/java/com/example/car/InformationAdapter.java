package com.example.car;

import android.content.ClipData;
import android.content.Context;
import android.icu.text.IDNA;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHolder> {

    private ArrayList<Information> information;
    ItemClicked activity;

    public interface ItemClicked
    {
        void onItemClicked(int index);
    }
    public InformationAdapter(Context context, ArrayList<Information> list)
    {
        information = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivCarLogo;
        TextView tvCarName, tvOwnerName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCarLogo = itemView.findViewById(R.id.ivCarLogo);
            tvCarName = itemView.findViewById(R.id.tvCarName);
            tvOwnerName = itemView.findViewById(R.id.tvOwnerName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(information.indexOf(v.getTag()));
                }
            });
        }
    }
    @NonNull
    @Override
    public InformationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InformationAdapter.ViewHolder holder, int position) {
     holder.itemView.setTag(information.get(position));
     holder.tvOwnerName.setText(information.get(position).getPersonName());
     holder.tvCarName.setText(information.get(position).getCarName());

     if(information.get(position).getCarLogo().equals("Volkswagen"))
     {
         holder.ivCarLogo.setImageResource(R.drawable.volkswagen);
     }
     else if(information.get(position).getCarLogo().equals("Mercedes"))
     {
         holder.ivCarLogo.setImageResource(R.drawable.mercedes);
     }
     else
     {
         holder.ivCarLogo.setImageResource(R.drawable.nissan);
     }

    }

    @Override
    public int getItemCount() {
        return information.size();
    }
}
