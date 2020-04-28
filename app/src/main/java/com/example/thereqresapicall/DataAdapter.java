package com.example.thereqresapicall;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.FileInputStream;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private Context context;
    private List<Structure> structureList;

    public DataAdapter(Context context, List<Structure> structureList) {
        this.context = context;
        this.structureList = structureList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_items,parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataViewHolder holder, int position) {
        final Structure structure = structureList.get(position);
        holder.textView.setText(structure.getFirstName() + " " + structure.getLastName());
        Glide.with(context).load(structure.getAvatar()).into(holder.imageView);
holder.linearLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
            String name = structure.getFirstName()+" "+structure.getLastName();
            String email=  structure.getEmail();
            String avatar = structure.getAvatar();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        bundle.putString("email",email);
        bundle.putString("avatar",avatar);
        Intent intent = new Intent(context,Main2Activity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
});


    }

    @Override
    public int getItemCount() {
        return structureList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    ImageView imageView;
    LinearLayout linearLayout;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            textView = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}