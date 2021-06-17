package com.example.vocab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailWordListActivity extends AppCompatActivity {
    TextView textName, textAdjective, textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_word_list);
        //get intent data
        Intent intent = getIntent();
        Word words = (Word) intent.getSerializableExtra("words");

        textName=findViewById(R.id.Name);
        textAdjective=findViewById(R.id.Adjective);
        textDescription=findViewById(R.id.Description);

        textName.setText(words.getName());
        textAdjective.setText(words.getAdjective());
        textDescription.setText(words.getDescription());
    }
}