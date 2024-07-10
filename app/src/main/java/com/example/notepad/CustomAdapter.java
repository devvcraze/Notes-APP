package com.example.notepad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    Activity activity;
    private ArrayList<String> book_id;
    private ArrayList<String> book_title;
    private ArrayList<String> book_author;
    private ArrayList<String> book_pages;


    CustomAdapter(Activity activity,Context context, ArrayList<String> book_id, ArrayList<String> book_title, ArrayList<String> book_author, ArrayList<String> book_pages){
        this.activity=activity;
        this.context=context;
        this.book_id=book_id;
        this.book_title=book_title;
        this.book_author=book_author;
        this.book_pages=book_pages;
    }
    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {


        holder.book_id_txt.setText(String.valueOf(book_id.get(position)));
        holder.book_title_txt.setText(String.valueOf(book_title.get(position)));
        holder.book_author_txt.setText(String.valueOf(book_author.get(position)));
        holder.book_pages_txt.setText(String.valueOf(book_pages.get(position)));
        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Update.class);
                intent.putExtra("id",String.valueOf(book_id.get(position)));
                intent.putExtra("title",String.valueOf(book_title.get(position)));
                intent.putExtra("author",String.valueOf(book_author.get(position)));
                intent.putExtra("pages",String.valueOf(book_pages.get(position)));
                activity.startActivityForResult(intent,1);

            }
        });

    }

    @Override
    public int getItemCount() {

        return book_id.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView book_id_txt,book_title_txt,book_author_txt,book_pages_txt;
        LinearLayout mainlayout;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            book_id_txt=itemView.findViewById(R.id.book_id);
            book_title_txt=itemView.findViewById(R.id.book_title);
            book_author_txt=itemView.findViewById(R.id.book_author);
            book_pages_txt=itemView.findViewById(R.id.book_pages);
            mainlayout=itemView.findViewById(R.id.main2);
        }
    }
}
