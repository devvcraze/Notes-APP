package com.example.notepad;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Update extends AppCompatActivity {
    EditText title_input,author_input,pages_input;
    Button btn;
    String id,title,author,pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);
        pages_input=findViewById(R.id.TextText3);
        author_input=findViewById(R.id.TextText2);
        title_input=findViewById(R.id.TextText);
        btn=findViewById(R.id.update_but);
        getAndsetIntentData();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB=new MyDatabaseHelper(Update.this);
                title=title_input.getText().toString().trim();
                author=author_input.getText().toString().trim();
                pages=pages_input.getText().toString().trim();
                myDB.updatedata(id, title,author,pages);

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    void getAndsetIntentData(){
        if (getIntent().hasExtra("id")  && getIntent().hasExtra("title")  &&getIntent().hasExtra("author")  && getIntent().hasExtra("pages") ){
            id=getIntent().getStringExtra("id");
            title=getIntent().getStringExtra("title");
            author=getIntent().getStringExtra("author");
            pages=getIntent().getStringExtra("pages");
            title_input.setText(title);
            author_input.setText(author);
            pages_input.setText(pages);
        }
        else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}