package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.CharacterActivity;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    List<String> name;
    List<Integer> images;
    LayoutInflater layoutInflater;

    public CharacterAdapter( Context context, List<String> name, List<Integer> images) {
        this.name = name;
        this.images = images;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.character_grid_layout,parent,false);
        return new ViewHolder(view);
    }



    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(name.get(position));
        holder.image.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Intent intent = new Intent(v.getContext(), CharacterActivity.class);
                        intent.putExtra("name", name.getText());
                        intent.putExtra("image", images.get(getAdapterPosition()));
                        v.getContext().startActivity(intent);

                }
            });

        }
    }


}


